package Entity;

import java.util.Date;


import java.util.Objects;

public class NhanVien {
	private String MaNhanVien;
	private String Ho;
	private String Ten;
	private String SDT;
	private String email;
	private String CCCD;
	private String DiaChi;
	private ChucVu chucvu;
	private String GioiTinh;
	private Date ngaySinh;
	private boolean hienThi;
	
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String MaNhanVien) {
		super();
		// TODO Auto-generated constructor stub
		this.MaNhanVien = MaNhanVien;
	}
	public NhanVien(ChucVu chucvu) {
		super();
		this.chucvu = chucvu;
	}

	public NhanVien(String maNhanVien, String ho, String ten, String sDT, String email, String cCCD, String diaChi,
			ChucVu chucvu, String gioiTinh, Date ngaySinh , boolean hienThi) {
		super();
		MaNhanVien = maNhanVien;
		Ho = ho;
		Ten = ten;
		SDT = sDT;
		this.email = email;
		CCCD = cCCD;
		DiaChi = diaChi;
		this.chucvu = chucvu;
		GioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.hienThi = hienThi;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getHo() {
		return Ho;
	}

	public void setHo(String ho) {
		Ho = ho;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public ChucVu getChucVu() {
		return chucvu;
	}

	public void setChucVu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isHienThi() {
		return hienThi;
	}
	public void setHienThi(boolean hienThi) {
		this.hienThi = hienThi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaNhanVien);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(MaNhanVien, other.MaNhanVien);
	}
}
