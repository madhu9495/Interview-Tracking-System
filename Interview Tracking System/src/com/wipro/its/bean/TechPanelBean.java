package com.wipro.its.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_TBL_TECHPANEL")
public class TechPanelBean {

	@Id
	@Column(name = "TECHID")
	private String techID;

	@Column(name = "TECHNAME")
	private String techName;

	@Column(name = "SUBJECTS")
	private String subjects;

	public String getTechID() {
		return techID;
	}

	public void setTechID(String techID) {
		this.techID = techID;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

}
