package ros.services;

import java.util.List;

public interface IGenericService <T> {
	
	T findById(long id);
	
	Boolean delete(T entity);
	
	Boolean deleteById(long id);
	
	T Update(T entity);
	
	List<T> findAll();
	
	T Add(T entity);
	
}
