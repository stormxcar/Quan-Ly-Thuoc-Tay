package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.KhachHang;
import ConnectDB.ConnectDB;
public class Dao_KhachHang {
	private Connection con;
	public Dao_KhachHang() {
		con = ConnectDB.getInstance().getConnection();

	}

	public ArrayList<KhachHang> getallKhachHang() {
		KhachHang kh = null;
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		try {

			String sql = "select * from KhachHang";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				kh = new KhachHang();
				kh.setTenKH(rs.getString("tenKH"));
				kh.setDiaChi(rs.getString("diaChi"));
				kh.setEmail(rs.getString("diaChi"));
				kh.setSdt(rs.getString("soDienThoai"));
				kh.setMaKH(rs.getString("maKhachHang"));
				ds.add(kh);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;

	}
	public KhachHang getKhachHangtheoMa(String sdt) {
		KhachHang kh = null;
		
		try {

			String sql = "select * from KhachHang where soDienThoai =?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				kh = new KhachHang();
				kh.setTenKH(rs.getString("tenKH"));
				kh.setDiaChi(rs.getString("diaChi"));
				kh.setEmail(rs.getString("diaChi"));
				kh.setSdt(rs.getString("soDienThoai"));
				kh.setMaKH(rs.getString("maKhachHang"));
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return kh;

	}
	
	public boolean creat(KhachHang kh) {

		try {

			String sql = "insert into  KhachHang values(?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getSdt());
			statement.setString(4, kh.getDiaChi());
			statement.setString(5, kh.getEmail());

			return statement.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;

	}
	public Integer getsoKhachHang() {
		int i =0;
		try {

			String sql = "select * from KhachHang";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				i++;
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return i;

	}
	
}
