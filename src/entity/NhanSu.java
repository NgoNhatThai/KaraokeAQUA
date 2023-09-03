package entity;

import java.util.Date;

public class NhanSu {
	private String MaNV, HoNV, TenNV;
	protected String DiaChi, SDT, tenTaiKhoan;
	protected Boolean GioiTinh, trangThai;
	protected Date NgaySinh;
	protected int tuoi;

	public NhanSu() {
		super();
		// TODO Auto-generated constructor stub
	}



	public NhanSu(String maNV, String hoNV, String tenNV,Boolean gioiTinh,Date ngaySinh, int tuoi,  String sDT, String diaChi, String tenTaiKhoan, Boolean trangThai) {
		super();
		MaNV = maNV;
		HoNV = hoNV;
		TenNV = tenNV;
		DiaChi = diaChi;
		SDT = sDT;
		this.tenTaiKhoan = tenTaiKhoan;
		GioiTinh = gioiTinh;
		this.trangThai = trangThai;
		NgaySinh = ngaySinh;
		this.tuoi = tuoi;
	}



	public Boolean getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}



	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoNV() {
		return HoNV;
	}

	public void setHoNV(String hoNV) {
		HoNV = hoNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public Boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
}
