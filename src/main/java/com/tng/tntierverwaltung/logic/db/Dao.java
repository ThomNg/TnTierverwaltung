package com.tng.tntierverwaltung.logic.db;

import java.util.List;

public interface Dao <T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    List<T> readAll();
}
