package Datenbank.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Exceptions.NoSuchRowException;
import Game.Items.Weapon;

public class WeaponDao implements DaoInterface<Weapon>{
	private Connection conn;
	private final String getByID = "select id, name, price, attacvalue, defencevalue, enduranceconsumption from Weapon where id = ?";
	private final String getAll = "select id, name, price, attacvalue, defencevalue, enduranceconsumption from Weapon";
	private final String insertString = "insert into Weapon (name, price, attacvalue, defencevalue,enduranceconsumption ) values (?,?,?,?,?)";
	private final String updateString = "update Weapon set name=?, price=?, attacvalue=?, defencevalue=? enduranceconsumption=? where id=?";
	private final String deleteString = "delete from Weapon where id=?";
	private final String lastInsultString = "select id, name, price, attacvalue, defencevalue, enduranceConsumption from Weapon where id = max(id)";

	
	public WeaponDao(Connection conn) {
		this.conn = conn;
	}
	@Override
	public Weapon getByID(int id) {
		Weapon result = null;
		if (id > 0) {
			try {
				
				PreparedStatement stmt = conn.prepareStatement(getByID);
				stmt.setInt(1, id);
				ResultSet rset = stmt.executeQuery();
				if (rset.next())
					result=new Weapon(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6));
				else
					throw new NoSuchRowException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public ArrayList<Weapon> getAll() {
		ArrayList<Weapon> result = new ArrayList<Weapon>();
		try {
			PreparedStatement stmt = conn.prepareStatement(getAll);
			ResultSet rset = stmt.executeQuery();
			while (rset.next())
				result.add(new Weapon(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6)));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public Weapon store(Weapon elem) {
		Weapon results = this.getByID(elem.getId());
		PreparedStatement stmt = null;
		if (results == null) {
			try {
				stmt = conn.prepareStatement(insertString);
				stmt.setString(1, elem.getName());
				stmt.setInt(2, elem.getPrice());
				stmt.setInt(3, elem.getAttacValue());
				stmt.setInt(4, elem.getDefenceValue());
				stmt.setInt(5, elem.getEnduranceConsumption());
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
				stmt.setInt(3, elem.getAttacValue());
				stmt.setInt(4, elem.getDefenceValue());
				stmt.setInt(5, elem.getEnduranceConsumption());
				stmt.setInt(6, elem.getId());
				stmt.executeUpdate();

				return this.getByID(results.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	@Override
	public void delete(Weapon elem) {
		PreparedStatement stmt;
		try {

			stmt = conn.prepareStatement(deleteString);
			stmt.setInt(1, elem.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Weapon getLastInsult() {
		Weapon result = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(lastInsultString);
			ResultSet rset = stmt.executeQuery();
			if (rset.next())
				result=new Weapon(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6));
			else
				throw new NoSuchRowException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	
}
