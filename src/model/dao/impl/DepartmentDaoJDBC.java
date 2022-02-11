package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DB.DB;
import model.DB.DBException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES (?);", Statement.RETURN_GENERATED_KEYS
					);
			
			st.setString(1, obj.getName());
			
			int upCheck = st.executeUpdate();
			
			if(upCheck > 0) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				
			}else {
				throw new DBException("Unexpected error! No rows affected");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public void update(Department obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
				"UPDATE department "
				+"SET Name = ? "
				+ "WHERE Id = ?;"
			);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE FROM department WHERE Id = ?"
			);
			
			st.setInt(1, id);
			
			int i = st.executeUpdate();
			
			if(i > 0) {
				
			}
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;	
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
				"SELECT * FROM "
				+ "department "
				+ "WHERE Id = ?"	
					);
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department obj = new Department();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				return obj;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;	
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
				"SELECT * FROM "
				+ "department "
					);

			
			rs = st.executeQuery();
			List<Department> obj = new ArrayList<>();
			while(rs.next()) {
				obj.add(new Department(rs.getInt("Id"), rs.getString("Name")));
			}
			return obj;
		}catch(SQLException e) {
			e.printStackTrace();
		}  
		finally {
			DB.closeResultSet(rs);
			DB.closeResultSet(rs);
		}
		return null;
	}
	

}
