package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.nhaCungCap;
import Entity.Thuoc;
import Entity.loaiThuoc;
import ConnectDB.ConnectDB;

public class Dao_Thuoc {
		private Connection con;
		private Thuoc thuoc;
	 public Dao_Thuoc() {
			// TODO Auto-generated constructor stub
			con = ConnectDB.getInstance().getConnection();
		}
		
		public ArrayList<Thuoc> getalltbThuoc() {
			ArrayList<Thuoc>dsthuoc = new ArrayList<Thuoc>();
			try {

				String sql = "select * from Thuoc";
				PreparedStatement statement = con.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;
		}
		public ArrayList<Thuoc> getalltbThuocSapHet() {
			ArrayList<Thuoc>dsthuoc = new ArrayList<Thuoc>();
			try {

				String sql = "select * from Thuoc where soLuongTon< 50";
				PreparedStatement statement = con.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;
		}
		public ArrayList<Thuoc> getalltbThuocSapHetHan() {
			ArrayList<Thuoc>dsthuoc = new ArrayList<Thuoc>();
			try {

				String sql = "select * from Thuoc where ngayHH < getdate()+90  and  ngayHH >getdate() ";
				PreparedStatement statement = con.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;
		}
		public ArrayList<Thuoc> getalltbThuocMoi(String date) {
			ArrayList<Thuoc>dsthuoc = new ArrayList<Thuoc>();
			try {
				String sql = "select * from Thuoc where ngayNhap  >?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, date);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;
		}
		public ArrayList<Thuoc> getalltbThuoctheoMa(String ma) {
			ArrayList<Thuoc>dsthuoc = new ArrayList<Thuoc>();
			try {
				String sql = "select * from Thuoc where maThuoc = ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, ma);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;
		}
		public Thuoc getThuoctheoMa(String ma) {
			try {
				String sql = "select * from Thuoc where maThuoc  =?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, ma);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return thuoc;
		}
		public boolean updatesoThuoc(int so, String ma) {
			try {
				String sql = "UPDATE Thuoc SET soluongTon= (soluongTon - ?) where maThuoc = ? ";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, so);
				statement.setString(2, ma);	
				
				return statement.executeUpdate()>0;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return false;
		}
		public ArrayList<Thuoc> getThuocTheoMa(String id) {
			ArrayList<Thuoc> dsthuoc = new ArrayList<Thuoc>();
			try {
				
				Connection con = ConnectDB.getInstance().getConnection();
				String sql = "select * from thuoc where maThuoc=?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, id);
				ResultSet rs = statement.executeQuery();
				Thuoc thuoc = null;
				while (rs.next()) {
					thuoc = new Thuoc();
					thuoc.setMa(rs.getString("maThuoc").trim());
					thuoc.setTen(rs.getString("tenThuoc"));
					thuoc.setGiaNhap(rs.getDouble("giaNhap"));
					thuoc.setNgayNhap(rs.getDate("ngayNhap"));
					thuoc.setNsx(rs.getDate("ngaySX"));
					thuoc.setNhh(rs.getDate("ngayHH"));
					thuoc.setSoLuongNhap(rs.getInt("soLuongNhap"));
					thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
					thuoc.setLoaiThuoc(new loaiThuoc(rs.getString("maLoai")));
					thuoc.setTenNCC(new nhaCungCap(rs.getString("maNCC")));
					thuoc.setHienthi(rs.getBoolean("hienThi"));
					dsthuoc.add(thuoc);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dsthuoc;

		}

		public boolean createThuoc(Thuoc t) {
			
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement(
						"insert into Thuoc(maThuoc , tenThuoc,giaNhap,ngayNhap,ngaySX,ngayHH,soLuongNhap,soLuongTon ,maLoai,maNCC, hienThi) "
								+ " " + "values(? , ? , ? , ? , ? , ? , ? , ? , ?,?,? )");
				stmt.setString(1, t.getMa());
				stmt.setString(2, t.getTen());
				stmt.setDouble(3, t.getGiaNhap());
				stmt.setDate(4, new java.sql.Date(t.getNgayNhap().getTime()));
				stmt.setDate(5, new java.sql.Date(t.getNsx().getTime()));
				stmt.setDate(6, new java.sql.Date(t.getNhh().getTime()));
				stmt.setInt(7, t.getSoLuongNhap());
				stmt.setInt(8, t.getSoLuongTon());
				stmt.setString(9, t.getLoaiThuoc().getMaLoai());
				stmt.setString(10, t.getTenNCC().getMaNCC());
				stmt.setBoolean(11, t.isHienthi());

				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}

		public boolean updateThuoc(Thuoc t) {
			
			Connection con = ConnectDB.getInstance().getConnection();
			System.out.println(t);
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("update Thuoc set tenThuoc = ? , giaNhap = ? , ngayNhap = ? , ngaySX = ? , ngayHH = ? , soLuongNhap = ? , soLuongTon = ?,hienThi = ? where maThuoc = ? ");
				stmt.setString(1, t.getTen());
				stmt.setDouble(2, t.getGiaNhap());
				stmt.setDate(3, new java.sql.Date(t.getNgayNhap().getTime()));
				stmt.setDate(4, new java.sql.Date(t.getNsx().getTime()));
				stmt.setDate(5, new java.sql.Date(t.getNhh().getTime()));
				stmt.setInt(6, t.getSoLuongNhap());
				stmt.setInt(7, t.getSoLuongTon());
				stmt.setInt(8, 1);
				stmt.setString(9, t.getMa());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}

		public boolean deleteThuoc(String maThuoc) {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;

			int n = 0;
			try {
				stmt = con.prepareStatement("UPDATE thuoc SET hienThi = 0 where maThuoc = ?");
				stmt.setString(1, maThuoc);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}

	
}
