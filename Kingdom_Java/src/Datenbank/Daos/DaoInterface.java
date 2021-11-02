package Datenbank.Daos;


import java.util.ArrayList;

public interface DaoInterface<T> {
	
	
	public  T getByID(int id );

	public ArrayList<T> getAll();
	
	public T getLastInsult();

	public T store( T elem);
	
	public void delete(T elem);
		
}
