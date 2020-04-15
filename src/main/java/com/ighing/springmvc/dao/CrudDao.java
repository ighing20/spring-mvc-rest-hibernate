package com.ighing.springmvc.dao;

import java.util.List;

public interface CrudDao<T, ID> {

	void save(T resourse);

	T get(ID primaryKey);

	List<T> all();

	void delete(ID primaryKey);

}
