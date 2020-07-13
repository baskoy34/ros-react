package ros.services;

import java.util.List;

public interface IGenericService <T> {
	
	T findById(long id);
	
	void deleteById(long id);
	
	T Update(T entity);
	
	List<T> findAll(long id);
	
	T Add(T entity) throws Exception;
	
}
