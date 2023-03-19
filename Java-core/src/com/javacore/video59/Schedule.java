package com.javacore.video59;

public class Schedule {
//	Thoi khoa bieu
	private Day thu;
	private String cacMonHoc;
	
	public Schedule(Day thu, String cacMonHoc) {
		super();
		this.thu = thu;
		this.cacMonHoc = cacMonHoc;
	}

	public Day getThu() {
		return thu;
	}

	public void setThu(Day thu) {
		this.thu = thu;
	}

	public String getCacMonHoc() {
		return cacMonHoc;
	}

	public void setCacMonHoc(String cacMonHoc) {
		this.cacMonHoc = cacMonHoc;
	}

	@Override
	public String toString() {
		return "Schedule [thu=" + thu + ", cacMonHoc=" + cacMonHoc + "]";
	}

	
	
}
