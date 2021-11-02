package Datenbank.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datenbank.Models.PotionsCategory;
import Exceptions.NoSuchRowException;

public class PotionsCategoryDao implements DaoInterface<PotionsCategory>{
	
	private Connection conn;
	private final String getByID = "select id, description from PotionCategorie where id = ?";
	private final String getAll = "select id, description from PotionCategorie";
	private final String insertString = "insert into PotionCategorie (id, description ) values (?,?)";
	private final String updateString = "update PotionCategorie set description=? where id=?";
	private final String deleteString = "delete from PotionCategorie where id=?";
	private final String lastInsultString = "select id, description from PotionCategorie where id = max(id)";

	public PotionsCategoryDao(Connection conn) {
		this.conn=conn;
	}

	@Override
	public PotionsCategory getByID(int id) {
		PotionsCategory result = null;
		if (id > 0) {
			try {
				
				PreparedStatement stmt = conn.prepareStatement(getByID);
				stmt.setInt(1, id);
				ResultSet rset = stmt.executeQuery();
				if (rset.next())
					result=new PotionsCategory(rset.getInt(1), rset.getString(2));
				else
					throw new NoSuchRowException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public ArrayList<PotionsCategory> getAll() {
		ArrayList<PotionsCategory> result = new ArrayList<PotionsCategory>();
		try {
			PreparedStatement stmt = conn.prepareStatement(getAll);
			ResultSet rset = stmt.executeQuery();
			while (rset.next())
				result.add(new PotionsCategory(rset.getInt(1), rset.getString(2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PotionsCategory getLastInsult() {
		PotionsCategory result = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(lastInsultString);
			ResultSet rset = stmt.executeQuery();
			if (rset.next())
				result=new PotionsCategory(rset.getInt(1), rset.getString(2));
			else
				throw new NoSuchRowException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public PotionsCategory store(PotionsCategory elem) {
		PotionsCategory results = this.getByID(elem.getId());
		PreparedStatement stmt = null;
		if (results == null) {
			try {
				stmt = conn.prepareStatement(insertString);
				stmt.setString(1, elem.getDescription());
				stmt.setInt(2, elem.getId());
				int result = stmt.executeUpdate();

				if (result == 1) {
					return this.getLastInsult();
				} else {
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			try {
				stmt = conn.prepareStatement(updateString);
				stmt.setString(1, elem.getDescription());
				stmt.setInt(2, elem.getId());
				stmt.executeUpdate();

				return this.getByID(results.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public void delete(PotionsCategory elem) {
		PreparedStatement stmt;
		try {

			stmt = conn.prepareStatement(deleteString);
			stmt.setInt(1, elem.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
