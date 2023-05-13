package com.example.my_framework;

import java.util.Date;

public class LoopFW implements Runnable {
    private final float FPS = 60;
    private final float SECONDS = 1000000000;
    private final float UPDATE_TIME = SECONDS / FPS;

    private boolean running = false;

    Thread gameThread = null;

    float updates = 0;
    float drawing = 0;
    long timer = 0;

    @Override
    public void run() {
        float lastTime = System.nanoTime();
        float delta = 0;
        timer = System.currentTimeMillis();

        while (running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime/UPDATE_TIME;
            if(delta > 1) {
                updateGame();
                drawingGame();
                delta--;
            }
            if(System.currentTimeMillis() - timer > 1000) {
                Date date = new Date();
                System.out.println("UPDATES = " + updates + " DRAWING " + drawing + " " + date.toString());
                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }
    }

    public void startGame() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() throws InterruptedException {
        if (!running) {
            return;
        }
        running = false;
        gameThread.join();
    }

    private void updateGame() {
        updates++;
    }

    private void drawingGame() {
        drawing++;
    }
}