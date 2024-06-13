package Entity;

public class nhaCungCap {
	private String maNCC,tenNCC,DiaChi,email;
	private String soDienThoai;
	
	public nhaCungCap(String maNCC,String tenNCC, String diaChi, String email, String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.DiaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenNCC=tenNCC;
	}
	public nhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhaCungCap(String maNCC) {
		
		this(maNCC,"","","","");
	}
	/**
	 * @return the maNCC
	 */
	public String getMaNCC() {
		return maNCC;
	}
	/**
	 * @param maNCC the maNCC to set
	 */
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return DiaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}
	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	/**
	 * @return the tenNCC
	 */
	public String getTenNCC() {
		return tenNCC;
	}
	/**
	 * @param tenNCC the tenNCC to set
	 */
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	
	@Override
	public String toString() {
		return "nhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", DiaChi=" + DiaChi + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + "]";
	}
	public nhaCungCap loaiNCCtheoten(String tenNCC) {
		return new nhaCungCap("",tenNCC,"","","");
	}
	
	
}
