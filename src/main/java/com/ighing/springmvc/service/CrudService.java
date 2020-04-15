package com.ighing.springmvc.service;

import java.util.List;

public interface CrudService<T, ID> {

	T create(T t);

	T get(ID id);

	List<T> getAll();

	T update(T t);

	void delete(ID id);

}
