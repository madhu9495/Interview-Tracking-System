package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface TechPanel

{
	public ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate);

	public boolean submitRatings(String interviewID, String techID, float rating);

	public InterviewScheduleBean viewFinalResults(String interviewID);

}