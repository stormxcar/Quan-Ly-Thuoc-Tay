package Entity;

public class loaiThuoc {

	 private String maLoai,tenLoai;

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public loaiThuoc(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	public loaiThuoc() {
		super();
	}
	public loaiThuoc(String ma) {
		this(ma,"");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
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
		loaiThuoc other = (loaiThuoc) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}
	public loaiThuoc loaiThuoctheoten(String tenLoai) {
		return new loaiThuoc("",tenLoai);
	}
	@Override
	public String toString() {
		return "LoaiThuoc [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
	
	
}
