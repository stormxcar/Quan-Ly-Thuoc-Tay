package Entity;

import java.io.Serializable;

public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tenTK,mk,maNV;
	
	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public TaiKhoan(String tenTK, String mk, String maNV) {
		super();
		this.tenTK = tenTK;
		this.mk = mk;
		this.maNV = maNV;
	}
	public TaiKhoan() {
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTK=" + tenTK + ", mk=" + mk + ", maNV=" + maNV + "]";
	}
}
