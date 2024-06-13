package Entity;

import java.sql.Date;

public class HoaDon {
	private String maHD;
	private Date ngayLap;
	private String maNV,maKH;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public HoaDon(String maHD, Date ngayLap, String maNV, String maKH) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.maNV = maNV;
		this.maKH = maKH;
	}
	public HoaDon() {
		super();
	}
	public HoaDon(String maHD, String maNV, String maKH) {
		// TODO Auto-generated constructor stub
		super();
		this.maHD = maHD;
		this.ngayLap = Date.valueOf("2000-2-2");
		this.maNV = maNV;
		this.maKH = maKH;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", maNV=" + maNV + ", maKH=" + maKH + "]";
	}
	
	
}
