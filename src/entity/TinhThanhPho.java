package entity;

public class TinhThanhPho {
private String iD, tenTinhThanhPho;

public String getiD() {
	return iD;
}

public void setiD(String iD) {
	this.iD = iD;
}

public String getTenTinhThanhPho() {
	return tenTinhThanhPho;
}

public void setTenTinhThanhPho(String tenTinhThanhPho) {
	this.tenTinhThanhPho = tenTinhThanhPho;
}

public TinhThanhPho(String iD, String tenTinhThanhPho) {
	super();
	this.iD = iD;
	this.tenTinhThanhPho = tenTinhThanhPho;
}

}
