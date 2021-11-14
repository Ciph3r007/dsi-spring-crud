package com.dsitraining.crud;

import java.util.List;

public interface CrudService<T> {
    List<T> getList();

    void add(T t);

    void update(T t, int id);

    void delete(int id);

    T getById(int id);
}
