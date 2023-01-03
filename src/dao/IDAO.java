package dao;

import java.util.List;

public interface IDAO<T>{
	boolean create(T o);
	boolean update(T o);
	boolean delete(T o);
	List<T> findAll();
	T findById(int id);
}
