package Dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChucVu;

public class Dao_ChucVu {
	private Connection con;
	public Dao_ChucVu() {
		// TODO Auto-generated constructor stub
			//connectDB.getInstance();
			 con = ConnectDB.getInstance().getConnection();
	}
	
	public ArrayList<ChucVu> DocTuBang(){
		ChucVu cv =null;
		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		try {
			String sql = "Select * from ChucVu ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maChucVu");
				String ten = rs.getString(2);
				
				cv = new ChucVu(ma , ten);
				dsCV.add(cv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCV;
	}
}
