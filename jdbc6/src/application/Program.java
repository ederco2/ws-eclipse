package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
	//Transações utilizando jdbc
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st=conn.createStatement();
			
			int rows1 = st.executeUpdate("update seller set BaseSalary =2090 where departmentId=1");
			
			int x =1;
			
			//if(x<2) {
			//	throw new SQLException("Fake error");
		//	}
		
			int rows2 = st.executeUpdate("update seller set BaseSalary =3090 where departmentId=2");
			
			conn.commit();
			
			System.out.println("rows1: "+rows1);
			System.out.println("rows2: "+rows2);
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transactiob rooled back! Baused by: "+e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to roolback: "+e.getMessage());
			}			
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}

