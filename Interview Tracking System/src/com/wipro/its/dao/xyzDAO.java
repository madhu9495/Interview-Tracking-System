package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface xyzDAO {

	public String createXYZ(CandidateBean candidateBean, ProfileBean profileBean);

	public int deleteXYZ(ArrayList<String> a);

	public boolean updateXYZ(CandidateBean candidateBean);

	public CandidateBean findByID(String candidateID);

	public ArrayList<CandidateBean> findAll();

	public ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification);

	public String scheduleInterviewForTech(InterviewScheduleBean interviewBean);

	public boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean);

	public ArrayList<CandidateBean> viewCandidatesTech(String techID, Date interviewDate);

	public ArrayList<CandidateBean> viewCandidatesHr(String empHRID, Date interviewDate);

	public boolean submitRatingsTech(String interviewID, String techID, float rating);

	public boolean submitRatingsHR(String interviewID, String empHRID, float rating);

	public boolean finalizeResultDecision(String interviewID, String result);

	public InterviewScheduleBean viewRatings(String interviewID);

	public boolean declareResults(String interviewID, int share);

	public InterviewScheduleBean viewFinalResults(String interviewID);

	public InterviewScheduleBean viewFinalResultsHR(String interviewID);

	public boolean shareCandidateDetails(String candidateID, String panel);
}
