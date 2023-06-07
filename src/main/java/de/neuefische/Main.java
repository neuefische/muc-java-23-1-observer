package de.neuefische;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        Teacher harald = new Teacher("Harald");
        Teacher sabine = new Teacher("Sabine");

        timer.attachObserver(harald);
        timer.attachObserver(sabine);

        timer.start();

        Thread.sleep(10000);

        timer.stop();
    }
}