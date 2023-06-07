package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class Timer {

    private List<TimerObserver> observerList;
    private boolean isRunning;
    private int elapsedSeconds;

    public Timer() {
        observerList = new ArrayList<>();
        isRunning = false;
        elapsedSeconds = 0;
    }

    public void start() throws InterruptedException {
        if (!isRunning) {
            isRunning = true;
            Thread timerThread = new Thread(() -> {
                while (isRunning) {
                    try {
                        Thread.sleep(1000);
                        elapsedSeconds++;
                        notifyObserver();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
            timerThread.start();
        }
    }

    public void stop() {
        isRunning = false;
    }

    public void attachObserver(TimerObserver observer) {
        observerList.add(observer);
    }

    public void detachObserver(TimerObserver observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        for (TimerObserver observer : observerList) {
            observer.handleUpdate(elapsedSeconds);
        }
    }
}
