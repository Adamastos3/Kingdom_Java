package Datenbank.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Exceptions.NoSuchRowException;
import Game.Items.Armor;

public class ArmorDao implements DaoInterface<Armor> {
	private Connection conn;
	private final String getByID = "select id, name, price, defencevalue from Armor where id = ?";
	private final String getAll = "select id, name, price, defencevalue from Armor";
	private final String insertString = "insert into Armor (name, price, defencevalue ) values (?,?,?)";
	private final String updateString = "update Armor set name=?, price=?, defencevalue=? where id=?";
	private final String deleteString = "delete from Armor where id=?";
	private final String lastInsultString = "select id,name, price, defencevalue from Armor where id = max(id)";

	public ArmorDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Armor getByID(int id) {
		Armor result = null;
		if (id > 0) {
			try {
				
				PreparedStatement stmt = conn.prepareStatement(getByID);
				stmt.setInt(1, id);
				ResultSet rset = stmt.executeQuery();
				if (rset.next())
					result=new Armor(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4));
				else
					throw new NoSuchRowException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public ArrayList<Armor> getAll() {
		ArrayList<Armor> result = new ArrayList<Armor>();
		try {
			PreparedStatement stmt = conn.prepareStatement(getAll);
			ResultSet rset = stmt.executeQuery();
			while (rset.next())
				result.add(new Armor(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Armor getLastInsult() {
		Armor result = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(lastInsultString);
			ResultSet rset = stmt.executeQuery();
			if (rset.next())
				result=new Armor(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4));
			else
				throw new NoSuchRowException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Armor store(Armor elem) {
		Armor results = this.getByID(elem.getId());
		PreparedStatement stmt = null;
		if (results == null) {
			try {
				stmt = conn.prepareStatement(insertString);
				stmt.setString(1, elem.getName());
				stmt.setInt(2, elem.getPrice());
				stmt.setInt(3, elem.getDefenceValue());
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
				stmt.setInt(3, elem.getDefenceValue());
				stmt.setInt(4, elem.getId());
				stmt.executeUpdate();

				return this.getByID(results.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public void delete(Armor elem) {
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
