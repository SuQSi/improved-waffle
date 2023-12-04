package cugb.xg.javaee.jdbc.bean;

import java.sql.Timestamp;

public class Student {
	int stuid;
	String sname;
	int sage;
	String sgender;
	Timestamp sbirth;
	String saddress;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public Timestamp getSbirth() {
		return sbirth;
	}
	public void setSbirth(Timestamp sbirth) {
		this.sbirth = sbirth;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", sname=" + sname + ", sage=" + sage + ", sgender=" + sgender + ", sbirth="
				+ sbirth + ", saddress=" + saddress + "]";
	}
	
	
}
