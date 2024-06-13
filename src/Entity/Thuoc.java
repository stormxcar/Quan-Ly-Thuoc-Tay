package Entity;

import java.util.Date;


public class Thuoc {
	private String ma,ten,maLoai;
	private Date nsx,nhh,ngayNhap;
	private double giaNhap;
	private loaiThuoc  loaiThuoc;
	private nhaCungCap tenNCC;
	private boolean hienthi;
	private int soLuongTon,soLuongNhap;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public Date getNsx() {
		return nsx;
	}
	public void setNsx(Date nsx) {
		this.nsx = nsx;
	}
	public Date getNhh() {
		return nhh;
	}
	public void setNhh(Date nhh) {
		this.nhh = nhh;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(Double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public loaiThuoc getLoaiThuoc() {
		return loaiThuoc;
	}
	public void setLoaiThuoc(loaiThuoc loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}
	public nhaCungCap getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(nhaCungCap tenNCC) {
		this.tenNCC = tenNCC;
	}
	public boolean isHienthi() {
		return hienthi;
	}
	public void setHienthi(boolean hienthi) {
		this.hienthi = hienthi;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public int getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public Thuoc(String ma, String ten, String maLoai, Date nsx, Date nhh, Date ngayNhap, Double giaNhap,
			Entity.loaiThuoc loaiThuoc, nhaCungCap tenNCC, boolean hienthi, int soLuongTon, int soLuongNhap) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.maLoai = maLoai;
		this.nsx = nsx;
		this.nhh = nhh;
		this.ngayNhap = ngayNhap;
		this.giaNhap = giaNhap;
		this.loaiThuoc = loaiThuoc;
		this.tenNCC = tenNCC;
		this.hienthi = hienthi;
		this.soLuongTon = soLuongTon;
		this.soLuongNhap = soLuongNhap;
	}
	public Thuoc(String ma, String ten, Date ngaySX, Date ngayHH, Date ngayNhap2, double giaNhap, loaiThuoc loaiThuoc,
			nhaCungCap tenNCC, boolean hienthi, int soLuongTon, int soLuongNhap) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.nsx = ngaySX;
		this.nhh = ngayHH;
		this.ngayNhap = ngayNhap2;
		this.giaNhap = giaNhap;
		this.loaiThuoc = loaiThuoc;
		this.tenNCC = tenNCC;
		this.hienthi = hienthi;
		this.soLuongTon = soLuongTon;
		this.soLuongNhap = soLuongNhap;
	}
	public Thuoc() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "thuoc [ma=" + ma + ", ten=" + ten + ", maLoai=" + maLoai + ", nsx=" + nsx + ", nhh=" + nhh
				+ ", ngayNhap=" + ngayNhap + ", giaNhap=" + giaNhap + ", loaiThuoc=" + loaiThuoc + ", tenNCC=" + tenNCC
				+ ", hienthi=" + hienthi + ", soLuongTon=" + soLuongTon + ", soLuongNhap=" + soLuongNhap + "]";
	}
	public double giaBan() {
		return giaNhap*1.4;
	}
	
//	private String sinhMa(int i) {
//		if(i<10&&i>0)
//			return "TT000"+i;
//		else if(i>=10&&i<100)
//			return "TT00"+i;
//		else if(i>=100&&i<1000)
//			return "TT0"+i;
//		else if(i>=1000&&i<10000)
//			return "TT"+i;
//		else return null;
//	}
}
