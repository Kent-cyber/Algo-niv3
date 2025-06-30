const canvas = document.getElementById('pong');
const ctx = canvas.getContext('2d');

// Game constants
const PADDLE_WIDTH = 12;
const PADDLE_HEIGHT = 80;
const BALL_SIZE = 16;
const PLAYER_X = 10;
const AI_X = canvas.width - PADDLE_WIDTH - 10;
const PADDLE_SPEED = 7;
const BALL_SPEED = 5;

// Game state
let playerY = (canvas.height - PADDLE_HEIGHT) / 2;
let aiY = (canvas.height - PADDLE_HEIGHT) / 2;
let ballX = (canvas.width - BALL_SIZE) / 2;
let ballY = (canvas.height - BALL_SIZE) / 2;
let ballVX = BALL_SPEED * (Math.random() > 0.5 ? 1 : -1);
let ballVY = BALL_SPEED * (Math.random() * 2 - 1);

function drawRect(x, y, w, h, color = '#fff') {
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);
}

function drawCircle(x, y, r, color = '#fff') {
    ctx.fillStyle = color;
    ctx.beginPath();
    ctx.arc(x, y, r, 0, Math.PI * 2);
    ctx.closePath();
    ctx.fill();
}

function draw() {
    // Clear
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Draw center line
    for(let i = 0; i < canvas.height; i += 30) {
        drawRect(canvas.width/2 - 2, i, 4, 20, '#444');
    }

    // Draw paddles
    drawRect(PLAYER_X, playerY, PADDLE_WIDTH, PADDLE_HEIGHT, '#0ff');
    drawRect(AI_X, aiY, PADDLE_WIDTH, PADDLE_HEIGHT, '#f00');

    // Draw ball
    drawCircle(ballX + BALL_SIZE/2, ballY + BALL_SIZE/2, BALL_SIZE/2, '#fff');
}

function clamp(val, min, max) {
    return Math.max(min, Math.min(val, max));
}

// Mouse control for player paddle
canvas.addEventListener('mousemove', (e) => {
    const rect = canvas.getBoundingClientRect();
    const mouseY = e.clientY - rect.top;
    playerY = clamp(mouseY - PADDLE_HEIGHT/2, 0, canvas.height - PADDLE_HEIGHT);
});

// Simple AI control for right paddle
function updateAI() {
    const aiCenter = aiY + PADDLE_HEIGHT/2;
    const ballCenter = ballY + BALL_SIZE/2;
    if (Math.abs(aiCenter - ballCenter) > 10) {
        aiY += (ballCenter > aiCenter ? PADDLE_SPEED : -PADDLE_SPEED) * 0.6;
    }
    aiY = clamp(aiY, 0, canvas.height - PADDLE_HEIGHT);
}

// Ball movement and collision
function updateBall() {
    ballX += ballVX;
    ballY += ballVY;

    // Top/bottom wall collision
    if (ballY <= 0 || ballY + BALL_SIZE >= canvas.height) {
        ballVY *= -1;
        ballY = clamp(ballY, 0, canvas.height - BALL_SIZE);
    }

    // Paddle collision (player)
    if (
        ballX <= PLAYER_X + PADDLE_WIDTH &&
        ballY + BALL_SIZE > playerY &&
        ballY < playerY + PADDLE_HEIGHT
    ) {
        ballVX = Math.abs(ballVX);
        // Add a bit of "spin" based on collision point
        let collidePoint = (ballY + BALL_SIZE/2) - (playerY + PADDLE_HEIGHT/2);
        collidePoint = collidePoint / (PADDLE_HEIGHT/2);
        ballVY = BALL_SPEED * collidePoint;
    }

    // Paddle collision (AI)
    if (
        ballX + BALL_SIZE >= AI_X &&
        ballY + BALL_SIZE > aiY &&
        ballY < aiY + PADDLE_HEIGHT
    ) {
        ballVX = -Math.abs(ballVX);
        let collidePoint = (ballY + BALL_SIZE/2) - (aiY + PADDLE_HEIGHT/2);
        collidePoint = collidePoint / (PADDLE_HEIGHT/2);
        ballVY = BALL_SPEED * collidePoint;
    }

    // Left/right wall (reset ball)
    if (ballX < 0 || ballX + BALL_SIZE > canvas.width) {
        resetBall();
    }
}

function resetBall() {
    ballX = (canvas.width - BALL_SIZE) / 2;
    ballY = (canvas.height - BALL_SIZE) / 2;
    ballVX = BALL_SPEED * (Math.random() > 0.5 ? 1 : -1);
    ballVY = BALL_SPEED * (Math.random() * 2 - 1);
}

function gameLoop() {
    updateAI();
    updateBall();
    draw();
    requestAnimationFrame(gameLoop);
}

draw(); // Initial draw
gameLoop();