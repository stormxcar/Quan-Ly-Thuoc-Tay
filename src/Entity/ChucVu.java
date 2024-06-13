package Entity;

public class ChucVu {
	private String maChucVu;
	private String tenChucVu;
	
	public ChucVu(String maChucVu) {
		super();
		// TODO Auto-generated constructor stub
		this.maChucVu = maChucVu;
	}
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maChucVu;
	}
}
