package entity;

public class QuanHuyen {
private String ID, tenQuanHuyen, IDTinhThanhPho;

public QuanHuyen(String iD, String tenQuanHuyen, String iDTinhThanhPho) {
	super();
	ID = iD;
	this.tenQuanHuyen = tenQuanHuyen;
	IDTinhThanhPho = iDTinhThanhPho;
}

public String getID() {
	return ID;
}

public void setID(String iD) {
	ID = iD;
}

public String getTenQuanHuyen() {
	return tenQuanHuyen;
}

public void setTenQuanHuyen(String tenQuanHuyen) {
	this.tenQuanHuyen = tenQuanHuyen;
}

public String getIDTinhThanhPho() {
	return IDTinhThanhPho;
}

public void setIDTinhThanhPho(String iDTinhThanhPho) {
	IDTinhThanhPho = iDTinhThanhPho;
}
}
