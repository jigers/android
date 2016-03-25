package ru.technotrack.hw1;

import android.util.Log;

public class Timer implements Runnable {
    private long time;
    private StartActivity listener;

    public Timer (long time, StartActivity listener) {
        this.time = time;
        this.listener = listener;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Log.d("HW1.logs", "error on sleep call");
            e.printStackTrace();
        }
        listener.onMessage();
    }
}
