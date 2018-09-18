package com.wipro.its.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_TBL_CANDIDATE")
public class CandidateBean {

	@Id
	@Column(name = "CANDIDATEID")
	private String candidateID;

	@Column(name = "PRIMARYSKILLS")
	private String primarySkills;

	@Column(name = "SECONDARYSKILLS")
	private String secondarySkills;

	@Column(name = "EXPERIENCE")
	private float experience;

	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "NOTICEPERIOD")
	private int noticePeriod;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "SHAREDETAILS")
	private int shareDetails;

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getShareDetails() {
		return shareDetails;
	}

	public void setShareDetails(int shareDetails) {
		this.shareDetails = shareDetails;
	}

}
