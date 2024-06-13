package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.loaiThuoc;
import ConnectDB.ConnectDB;
public class Dao_LoaiThuoc {
	private Connection con;
	private loaiThuoc lt;

	public Dao_LoaiThuoc() {
		con = ConnectDB.getInstance().getConnection();

	}

	public ArrayList<loaiThuoc> getallLoaiThuoc() {
		ArrayList<loaiThuoc> dslt = new ArrayList<loaiThuoc>();
		try {

			String sql = "select * from LoaiThuoc";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				lt = new loaiThuoc();
				lt.setMaLoai(rs.getString("maLoai"));
				lt.setTenLoai(rs.getString("tenLoai"));
				dslt.add(lt);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return dslt;

	}
	public loaiThuoc gettheoMa(String ma) {
		try {

			String sql = "select * from LoaiThuoc where maLoai =?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				lt = new loaiThuoc();
				lt.setMaLoai(rs.getString("maLoai"));
				lt.setTenLoai(rs.getString("tenLoai"));				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return lt;

	}
	public loaiThuoc getLoaiThuocTheoMa(String id) {
		loaiThuoc lt = new loaiThuoc();
		try {

			String sql = "select * from LoaiThuoc where maLoai=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				lt.setMaLoai(rs.getString("maLoai"));
				lt.setTenLoai(rs.getString("tenLoai"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return lt;

	}
	public loaiThuoc getLoaiThuocTheoTen(String id) {
		loaiThuoc lt = new loaiThuoc();
		try {

			String sql = "select * from LoaiThuoc where tenLoai = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				lt.setMaLoai(rs.getString("maLoai"));
				lt.setTenLoai(rs.getString("tenLoai"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return lt;

	}


}
