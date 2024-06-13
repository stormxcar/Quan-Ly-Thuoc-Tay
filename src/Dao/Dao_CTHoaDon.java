package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.CT_HoaDon;
import ConnectDB.ConnectDB;
public class Dao_CTHoaDon {
	private Connection con;

	public Dao_CTHoaDon() {
		con = 	ConnectDB.getInstance().getConnection();

	}

	public ArrayList<CT_HoaDon> getallCTHoaDon() {
		CT_HoaDon hd = null;
		ArrayList<CT_HoaDon> ds = new ArrayList<CT_HoaDon>();
		try {

			String sql = "select * from CT_HoaDon";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				hd = new CT_HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setMaThuoc(rs.getString("maThuoc"));
				hd.setDonGia(rs.getDouble("donGia"));
				hd.setSoLuong(rs.getInt("soLuong"));
				ds.add(hd);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public String getTenThuoc(String maThuoc) {
	    String tenThuoc = null;
	    try {
	        String sql = "SELECT tenThuoc FROM Thuoc WHERE maThuoc = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, maThuoc);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	            tenThuoc = rs.getString("tenThuoc");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return tenThuoc;
	}
	public ArrayList<CT_HoaDon> getallCTHoaDontheoMa(String Ma) {
		CT_HoaDon hd = null;
		ArrayList<CT_HoaDon> ds = new ArrayList<CT_HoaDon>();
		try {

			String sql = "select * from CT_HoaDon where maHoaDon =?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Ma);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				hd = new CT_HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setMaThuoc(rs.getString("maThuoc"));
				hd.setDonGia(rs.getDouble("donGia"));
				hd.setSoLuong(rs.getInt("soLuong"));
				ds.add(hd);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public double gettienHoaDontheoMa(String Ma) {
		double tien =0;
		try {

			String sql = "select * from CT_HoaDon where maHoaDon =?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Ma);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {		
				tien = tien +(rs.getDouble("donGia")*rs.getInt("soLuong"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return tien;

	}
	public boolean creat(CT_HoaDon cthd) {
		try {
			String sql = "insert into  CT_HoaDon values(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, cthd.getMaHD());
			statement.setString(2, cthd.getMaThuoc());
			statement.setDouble(3, cthd.getDonGia());
			statement.setInt(4, cthd.getSoLuong());

			return statement.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;

	}
	public ArrayList<CT_HoaDon> getallCTHoaDonTheoMaHoaDon(String maHD) {
		CT_HoaDon hd = null;
		ArrayList<CT_HoaDon> ds = new ArrayList<CT_HoaDon>();
		try {

			String sql = "select * from CT_HoaDon where maHoaDon = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1,maHD );
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				hd = new CT_HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setMaThuoc(rs.getString("maThuoc"));
				hd.setDonGia(rs.getDouble("donGia"));
				hd.setSoLuong(rs.getInt("soLuong"));
				
				ds.add(hd);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

}
