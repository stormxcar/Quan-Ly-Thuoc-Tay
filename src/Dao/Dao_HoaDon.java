package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.HoaDon;
import ConnectDB.ConnectDB;
public class Dao_HoaDon {
	private Connection con;
	public Dao_HoaDon() {
		con = ConnectDB.getInstance().getConnection();

	}

	public ArrayList<HoaDon> getallHoaDon() {
		HoaDon hd = null;
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {

			String sql = "select * from HoaDon";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				hd = new HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setNgayLap(rs.getDate("ngayLap"));
				hd.setMaNV(rs.getString("maNhanVien"));
				hd.setMaKH(rs.getString("maKhachHang"));
				ds.add(hd);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public ArrayList<HoaDon> getallHoaDontheoNgay(String Date) {
		HoaDon hd = null;
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			String sql = "select * from HoaDon where ngayLap> ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				hd = new HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setNgayLap(rs.getDate("ngayLap"));
				hd.setMaNV(rs.getString("maNhanVien"));
				hd.setMaKH(rs.getString("maKhachHang"));
				ds.add(hd);			
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public ArrayList<HoaDon> getallHoaDonTheoMaNhanVien(String maNV) {
		HoaDon hd = null;
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {

			String sql = "select * from HoaDon where maNhanVien = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				hd = new HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setNgayLap(rs.getDate("ngayLap"));
				hd.setMaNV(rs.getString("maNhanVien"));
				hd.setMaKH(rs.getString("maKhachHang"));
				
				ds.add(hd);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public ArrayList<HoaDon> getallHoaDonTheoMaKhachHang(String maKH) {
		HoaDon hd = null;
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {

			String sql = "select * from HoaDon where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				hd = new HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setNgayLap(rs.getDate("ngayLap"));
				hd.setMaNV(rs.getString("maNhanVien"));
				hd.setMaKH(rs.getString("maKhachHang"));
				
				ds.add(hd);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public ArrayList<HoaDon> getallHoaDonTheoMaHoaDon(String maHD) {
		HoaDon hd = null;
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {

			String sql = "select * from HoaDon where maHoaDon = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				hd = new HoaDon();
				hd.setMaHD(rs.getString("maHoaDon"));
				hd.setNgayLap(rs.getDate("ngayLap"));
				hd.setMaNV(rs.getString("maNhanVien"));
				hd.setMaKH(rs.getString("maKhachHang"));
				
				ds.add(hd);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public boolean creat(HoaDon hd) {

		try {

			String sql = "insert into  HoaDon values(?,getdate(),?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, hd.getMaHD());
			statement.setString(2, hd.getMaNV());
			statement.setString(3, hd.getMaKH());

			return statement.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;

	}
	public int getsoDong() {
		int so =0;
		try {

			String sql = "select count(*) from HoaDon";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
			    so = rs.getInt(1);
			}
			return so;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return 0;
	}

}
