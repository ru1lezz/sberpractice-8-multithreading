package com.serzhan.thread;

import android.os.Handler;
import android.os.Message;

import java.util.Random;

public class CustomThread extends Thread {
    static final int MESSAGE_SEND = 0;
    static final int MESSAGE_DELETE = 1;

    private Random random = new Random();
    private final Handler handler;


    public CustomThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            sleep(1000);
            sendMessage();
        }
    }

    private void sendMessage() {
        switch (random.nextInt(2)) {
            case 0:
                sendValue();
                break;
            case 1:
                removeValue();
                break;
        }
    }

    private void sendValue() {
        String value = "value# " + random.nextInt(1000);
        Message message = handler.obtainMessage(MESSAGE_SEND, value);
        message.sendToTarget();
    }

    private void removeValue() {
        Message message = handler.obtainMessage(MESSAGE_DELETE);
        message.sendToTarget();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
