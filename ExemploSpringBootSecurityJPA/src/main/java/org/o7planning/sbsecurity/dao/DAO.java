package org.o7planning.sbsecurity.dao;
import java.util.List;

public interface DAO <T> {
	
	void insert (T inserido);
	
	T delete (int ID);
	
	T update (int ID, T update);
	
	T select (int ID);
	
	List<T> selectAll ();
	
	List<T> selectNOme (String nome);
	
	
}
