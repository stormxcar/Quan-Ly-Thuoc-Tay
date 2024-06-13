package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.nhaCungCap;
import ConnectDB.ConnectDB;
public class Dao_nhaCungCap {
	private Connection con;
	private nhaCungCap ncc;

 public Dao_nhaCungCap() {
		// TODO Auto-generated constructor stub
		con = ConnectDB.getInstance().getConnection();

	}

	public ArrayList<nhaCungCap> getallNhaCungCap() {
		ArrayList<nhaCungCap> ds = new ArrayList<nhaCungCap>();
		try {

			String sql = "select * from NhaCungCap";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				ncc = new nhaCungCap();
				ncc.setMaNCC(rs.getString("maNCC"));
				ncc.setTenNCC(rs.getString("tenNCC"));
				ncc.setSoDienThoai(rs.getString("soDienThoai"));
				ncc.setDiaChi(rs.getString("DiaChi"));
				ncc.setEmail(rs.getString("email"));
				ds.add(ncc);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}

	public nhaCungCap getNCCtheoMa(String maNCC) {
		try {

			String sql = "select * from NhaCungCap where maNCC =?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNCC);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
			 	ncc = new nhaCungCap();
				ncc.setMaNCC(rs.getString("maNCC"));
				ncc.setTenNCC(rs.getString("tenNCC"));
				ncc.setSoDienThoai(rs.getString("soDienThoai"));
				ncc.setDiaChi(rs.getString("DiaChi"));
				ncc.setEmail(rs.getString("email"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ncc;

	}
	public nhaCungCap getNhaCCTheoMa(String id) {
		nhaCungCap ncc = new nhaCungCap();
		try {

			String sql = "select * from NhaCungCap where maNCC=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ncc.setMaNCC(rs.getString("maNCC"));
				ncc.setTenNCC(rs.getString("tenNCC"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ncc;

	}
	public nhaCungCap getNhaCCTheoTen(String id) {
		nhaCungCap ncc = new nhaCungCap();
		try {

			String sql = "select * from NhaCungCap where tenNCC=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ncc.setMaNCC(rs.getString("maNCC"));
				ncc.setTenNCC(rs.getString("tenNCC"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ncc;

	}


}
