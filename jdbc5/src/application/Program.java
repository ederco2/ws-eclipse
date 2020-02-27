package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"delete from department "
					+"where "
					+"Id=?"
					);
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: "+rowsAffected);
		}
		catch(SQLException e) {
			//e.printStackTrace();
			throw new DbIntegrityException(e.getMessage()); //exceção personalizada
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}

