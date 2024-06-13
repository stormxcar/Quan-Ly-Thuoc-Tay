package Dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.TaiKhoan;
public class Dao_TaiKhoan {
		private Connection con;
		public Dao_TaiKhoan() {
			
			con = ConnectDB.getInstance().getConnection();
		}

		public ArrayList<TaiKhoan> getalltbTaiKhoan() {
			TaiKhoan tk = null;
			ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
			try {
				String sql = "select * from TaiKhoan";
				PreparedStatement statement = con.prepareStatement(sql);

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					tk = new TaiKhoan(); 
					tk.setTenTK(rs.getString("tenTK").trim());
					tk.setMk(rs.getString("matKhau").trim());
					tk.setMaNV(rs.getString("maNV").trim());
					dstk.add(tk);

				}
				

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dstk;
		}
		public TaiKhoan gettaiKhoan(String ten) {
			try {
				TaiKhoan tk = new TaiKhoan();
				String sql = "select * from TaiKhoan where tenTK = ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, ten);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					tk.setTenTK(rs.getString("tenTK").trim());
					tk.setMk(rs.getString("matKhau").trim());
					tk.setMaNV(rs.getString("maNhanVien").trim());
				}
				if(tk.getTenTK() == null) {
					return null;
				}
				return tk;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
	 // xóa & thêm tài khoản
		public boolean createTK(TaiKhoan tk) {
			
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				if(gettaiKhoan(tk.getTenTK()) != null) {
					return false;
				}else {
					stmt = con.prepareStatement("insert into TaiKhoan(tenTK , matKhau , maNhanVien) values(? , ? , ? )");
					stmt.setString(1, tk.getTenTK());
					stmt.setString(2, tk.getMk());
					stmt.setString(3 ,tk.getMaNV());
					
					n = stmt.executeUpdate();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		
		public boolean deleteTK(String maTK) {
		
			Connection con = 	ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("delete from TaiKhoan where maNhanVien = ?");
				stmt.setString(1, maTK);
				
				stmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
