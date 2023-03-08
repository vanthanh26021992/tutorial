package com.javacore.video38;

public class Manufacturer {
	private String companyName;
	private Nation nation;
	
	public Manufacturer(String companyName, Nation nation) {
		this.companyName = companyName;
		this.nation = nation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}
	
}
