package com.wipro.its.service;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface Administrator {

	public String addCandidate(ProfileBean profileBean, CandidateBean candidateBean);

	public ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification);

	public boolean shareCandidateDetails(String candidateID, String panel);

	public String scheduleInterviewForTech(InterviewScheduleBean interviewBean);

	public boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean);

	public InterviewScheduleBean viewRatings(String interviewID);

	public boolean finalizeResultDecision(String interviewID, String result);

	public boolean declareResults(String interviewID, int share);

}
