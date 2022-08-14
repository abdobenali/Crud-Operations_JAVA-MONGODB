package com.DAO;

import java.util.List;

import com.models.Documents;

public interface DataAccess <E> {
	// connection with database
	void save(E e);
    void update(E e,E e1);
    void delete(E e);
    List<E> findAll();
    boolean find(E e);

}
