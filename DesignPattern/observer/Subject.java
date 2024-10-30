package DesignPattern.observer;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}