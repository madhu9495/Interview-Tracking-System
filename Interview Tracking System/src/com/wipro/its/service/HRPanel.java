package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface HRPanel {
	public ArrayList<CandidateBean> viewCandidatesHr(String empHRID, Date empHRInterviewDate);

	public boolean submitRatings(String interviewID, String empHRID, float rating);

	public InterviewScheduleBean viewFinalResults(String interviewID);

}
