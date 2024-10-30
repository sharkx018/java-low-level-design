package DesignPattern.iterator;


interface Container<T>{
    Itr<T> getIterator();
}