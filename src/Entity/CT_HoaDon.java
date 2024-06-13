package Entity;

public class CT_HoaDon {
	private String maHD,maThuoc;
	private double donGia;
	private int soLuong;
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public CT_HoaDon(String maHD, String maThuoc, double donGia, int soLuong) {
		super();
		this.maHD = maHD;
		this.maThuoc = maThuoc;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	public CT_HoaDon() {
		super();
	}
	@Override
	public String toString() {
		return "CT_HoaDon [maHD=" + maHD + ", maThuoc=" + maThuoc + ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
	}
	
	
}
