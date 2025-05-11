package co.com.design_patterns.behavioral.iterator;

public interface Iterator {
    boolean hasNext();

    Object next();

    Object currentItem();
}
