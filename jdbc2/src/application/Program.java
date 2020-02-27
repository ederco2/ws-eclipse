package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"insert into seller "
					+"(Name, Email, BirthDate, BaseSalary, DepartmentID)"
					+"values"
					+"(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
		
			st.setString(1, "Carl Purple");
			st.setString(2, "carlpurple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("31/03/1985").getTime()));
			st.setDouble(4, 2300.0);
			st.setInt(5, 4);
			int rowsAffected = st.executeUpdate();
			
			//System.out.println("Done! Rows Affected: "+rowsAffected);
			
			if (rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id=rs.getInt(1);
					System.out.println("Done! ID= "+id);
				}
			}else {
				System.out.println("No Rows Affected: ");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}

