package co.com.design_patterns.creational.abstracfactory;

//Interfaza para la creación de objetos de productos abstractos
public interface AbstractFactory<T> {
    T create(String type);
}
