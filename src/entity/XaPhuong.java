package entity;

public class XaPhuong {
	private String ID, tenXaPhuong, quanHuyenID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTenXaPhuong() {
		return tenXaPhuong;
	}

	public void setTenXaPhuong(String tenXaPhuong) {
		this.tenXaPhuong = tenXaPhuong;
	}

	public String getQuanHuyenID() {
		return quanHuyenID;
	}

	public void setQuanHuyenID(String quanHuyenID) {
		this.quanHuyenID = quanHuyenID;
	}

	public XaPhuong(String iD, String tenXaPhuong, String quanHuyenID) {
		super();
		ID = iD;
		this.tenXaPhuong = tenXaPhuong;
		this.quanHuyenID = quanHuyenID;
	}
	
}
