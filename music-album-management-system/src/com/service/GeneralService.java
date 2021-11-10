package com.service;

import java.util.List;

public interface GeneralService<T> {
    void create(T t);

    void delete(String name);

    void update(String name, String newName);

    void findRelativeByName(String name);

    T findByName(String name);

    List<T> displayAll();

    void display();

}
