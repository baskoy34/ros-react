package ros.services;

import ros.helpers.ErrorHandling;

import java.util.List;

public interface IGenericService <T> {
	
	T findById(long id) throws ErrorHandling;
	
	void deleteById(long id) throws ErrorHandling;
	
	T Update(T entity) throws ErrorHandling;
	
	List<T> findAll(long id) throws ErrorHandling;
	
	T Add(T entity) throws Exception;
	
}
