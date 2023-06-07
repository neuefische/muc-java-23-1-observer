package de.neuefische;

public class Teacher implements TimerObserver{

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void handleUpdate(int elapsedSeconds) {
        System.out.println(name + ": Vergangene Sekunden: " + elapsedSeconds);
    }
}
