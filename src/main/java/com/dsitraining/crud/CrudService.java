package com.dsitraining.crud;

import java.util.List;

public interface CrudService<T> {
    public List<T> getList();

    public void add(T t);

    public void update(T t, int id);

    public void delete(int id);


    public T getById(int id);
}
