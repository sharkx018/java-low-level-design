package DesignPattern.iterator;

interface Itr<T>{
    boolean hasNext();
    T next();
}