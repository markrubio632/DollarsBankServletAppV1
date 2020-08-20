package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.CRUDRepo;

@Component
public class DaoImpl implements Dao {

	@Autowired
	CRUDRepo repo;

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	private static final String SAVE_USER = "insert into DOLLARSBANK (userName, userPass, userAddress, userContact, userBalance, userAcc) values (?,?,?,?,?,?)";

	private static final String FIND_USER_BY_ID = "select * from DOLLARSBANK where id=?";

	private static final String FIND_ALL_USERS = "select * from DOLLARSBANK";
	
	private static final String UPDATE_USER = "UPDATE dollarsbank SET userBalance = ? WHERE Id = ?";

	List<User> uList = new ArrayList<User>();

	@Override
	public int saveUser(User user) {

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SAVE_USER);

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPass());
			stmt.setString(3, user.getUserAddress());
			stmt.setString(4, user.getUserContact());
			stmt.setDouble(5, user.getUserBalance());
			stmt.setString(6, user.getUserAcc());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		uList.add(user);
		return 0;
	}

	@Override
	public List<User> findAllUsers() {
		
		List<User> uList = (List<User>) repo.findAll();
		return uList;

		/*try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_ALL_USERS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("userName"), rs.getString("userPass"),
						rs.getString("userAddress"), rs.getString("userContact"), rs.getDouble("userbalance"),
						rs.getString("userAcc"));
				uList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;*/
	}

	@Override
	public User findUserById(int id) {

		User user = new User();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_USER_BY_ID);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {

				user = new User(rs.getInt("id"), rs.getString("userName"), rs.getString("userPass"),
						rs.getString("userAddress"), rs.getString("userContact"), rs.getDouble("userbalance"),
						rs.getString("userAcc"));
				uList.add(user);

				/*
				 * rs.getInt(1); rs.getString(2); rs.getString(3); rs.getString(4);
				 * rs.getString(5); rs.getDouble(6); rs.getString(7);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			return conn;

		} catch (Exception e) {

		}
		return conn;
	}

	@Override
	public void deleteUser(User user) {
		
		repo.delete(user);
	}
	
	public int updateUser(User user) {
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(UPDATE_USER);

			stmt.setDouble(1, user.getUserBalance());
			stmt.setInt(2, user.getId());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
