package Dao;

import java.sql.Statement;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChucVu;
import Entity.NhanVien;

public class Dao_NhanVien {
	ArrayList<NhanVien> dsNV;
	NhanVien nv ;
	public Dao_NhanVien(){
		dsNV = new ArrayList<NhanVien>();
	}
	
	public ArrayList<NhanVien> docTuBang(){
		try {
			
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maNhanVien");
				String cv = rs.getString("maChucVu");
				String ho = rs.getString("Ho");
				String ten = rs.getString("Ten");
			    Date ngaySinh = rs.getDate("ngaySinh");
			    String gt = rs.getString("gioiTinh");
				String CCCD = rs.getString("CCCD");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String email = rs.getString("email");
				boolean hienThi = rs.getBoolean("hienThi");
				
				NhanVien Nv = new NhanVien(ma, ho, ten, sdt, email, CCCD, diachi, new ChucVu(cv), gt, ngaySinh,hienThi);
				dsNV.add(Nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public boolean createNV(NhanVien nv) {
		
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien(maNhanVien , maChucVu , Ho , Ten , ngaySinh , gioiTinh , CCCD , soDienThoai , diaChi , email , hienThi) "+" "
					+ "values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,?)");
			stmt.setString(1, nv.getMaNhanVien() );
			stmt.setString(2, nv.getChucVu().getMaChucVu());
			stmt.setString(3 ,nv.getHo());
			stmt.setString(4, nv.getTen());
			stmt.setDate(5, new java.sql.Date(nv.getNgaySinh().getTime()));
			stmt.setString(6, nv.getGioiTinh());
			stmt.setString(7, nv.getCCCD());
			stmt.setString(8, nv.getSDT());
			stmt.setString(9, nv.getDiaChi());
			stmt.setString(10,nv.getEmail());
			stmt.setBoolean(11,nv.isHienThi());
			
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean updateNV(NhanVien nv) {
		
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set Ho = ? , Ten = ? , maChucVu = ? , ngaySinh = ? , gioiTinh = ? , CCCD = ? ,"
					+ "soDienThoai = ? , diaChi = ? , email = ? , hienThi = ? where maNhanVien = ? ");
			stmt.setString(1, nv.getHo());
			stmt.setString(2, nv.getTen());
			stmt.setString(3, nv.getChucVu().getMaChucVu());
			stmt.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
			stmt.setString(5, nv.getGioiTinh());
			stmt.setString(6, nv.getCCCD());
			stmt.setString(7, nv.getSDT());
			stmt.setString(8, nv.getDiaChi());
			stmt.setString(9,nv.getEmail());
			stmt.setBoolean(10, true);
			stmt.setString(11, nv.getMaNhanVien());
			
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteNV(String maNhanVien) {
		
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set hienThi = 0 where maNhanVien = ?");
			stmt.setString(1, maNhanVien);
			
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return n<0;
		}
		return n > 0;
	}
	
	public NhanVien getNhanVientheoMa(String maNV) {
	    NhanVien nv = null;
	  
		Connection con =   ConnectDB.getInstance().getConnection(); // Thêm kiểu dữ liệu và khởi tạo biến Connection
	    try {
	        String sql = "select * from NhanVien where maNhanVien = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, maNV);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            nv = new NhanVien();
	            nv.setMaNhanVien(rs.getString("maNhanVien")); 
	            nv.setChucVu(new ChucVu(rs.getString("maChucVu")));
	            nv.setCCCD(rs.getString("CCCD"));
	            nv.setHo(rs.getString("Ho"));
	            nv.setTen(rs.getString("Ten"));
	            nv.setSDT(rs.getString("soDienThoai"));
	            nv.setGioiTinh(rs.getString("gioiTinh"));
	            nv.setDiaChi(rs.getString("diaChi"));
	            nv.setEmail(rs.getString("email")); 
	           
	            nv.setNgaySinh(rs.getDate("ngaySinh"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nv;
	}

}
