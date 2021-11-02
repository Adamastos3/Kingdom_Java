package Datenbank.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Exceptions.NoSuchRowException;
import Game.Items.Potions;
import Game.Items.Weapon;

public class PotionsDao implements DaoInterface<Potions>{

	private Connection conn;
	private PotionsCategoryDao categorieDao;
	private final String getByID = "select id, name, price, effectiveness, category from Potions where id = ?";
	private final String getAll = "select id, name, price, effectiveness, category from Potions";
	private final String insertString = "insert into Potions (id, name, price, effectiveness, category ) values (?,?,?,?,?)";
	private final String updateString = "update Potions set name=?, price=?, effectiveness=?, category=?  where id=?";
	private final String deleteString = "delete from Potions where id=?";
	private final String lastInsultString = "select id, name, price, effectiveness, category from Potions where id = max(id)";

	public PotionsDao(Connection conn) {
		this.conn=conn;
		this.categorieDao = new PotionsCategoryDao(conn);
	}
	
	
	@Override
	public Potions getByID(int id) {
		Potions result = null;
		if (id > 0) {
			try {
				
				PreparedStatement stmt = conn.prepareStatement(getByID);
				stmt.setInt(1, id);
				ResultSet rset = stmt.executeQuery();
				if (rset.next())
					result=new Potions(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), categorieDao.getByID(rset.getInt(5)));
				else
					throw new NoSuchRowException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public ArrayList<Potions> getAll() {
		ArrayList<Potions> result = new ArrayList<Potions>();
		try {
			PreparedStatement stmt = conn.prepareStatement(getAll);
			ResultSet rset = stmt.executeQuery();
			while (rset.next())
				result.add(new Potions(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), categorieDao.getByID(rset.getInt(5))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Potions getLastInsult() {
		Potions result = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(lastInsultString);
			ResultSet rset = stmt.executeQuery();
			if (rset.next())
				result=new Potions(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), categorieDao.getByID(rset.getInt(5)));
			else
				throw new NoSuchRowException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Potions store(Potions elem) {
		Potions results = this.getByID(elem.getId());
		PreparedStatement stmt = null;
		if (results == null) {
			try {
				stmt = conn.prepareStatement(insertString);
				stmt.setString(1, elem.getName());
				stmt.setInt(2, elem.getPrice());
				stmt.setInt(3, elem.getEffectiveness());
				stmt.setInt(4, elem.getCategory().getId());
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
				stmt.setString(1, elem.getName());
				stmt.setInt(2, elem.getPrice());
				stmt.setInt(3, elem.getEffectiveness());
				stmt.setInt(4, elem.getCategory().getId());
				stmt.setInt(5, elem.getId());
				stmt.executeUpdate();

				return this.getByID(results.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public void delete(Potions elem) {
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
