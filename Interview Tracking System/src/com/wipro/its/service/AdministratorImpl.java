package com.wipro.its.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CandidateBean;

import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

import com.wipro.its.dao.xyzDAO;

@Service
@Transactional
public class AdministratorImpl implements Administrator {
	@Autowired(required = true)
	public xyzDAO xyzdao;
	String check;

	CandidateBean CandidateBean;

	@Transactional
	public String addCandidate(ProfileBean profileBean, CandidateBean candidateBean) {

		check = xyzdao.createXYZ(candidateBean, profileBean);
		if (check.equals("SUCCESS")) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}

	}

	@Transactional
	@Override
	public ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification) {

		return this.xyzdao.viewCandidate(skills, experience, qualification);
	}

	@Override
	public boolean shareCandidateDetails(String candidateID, String panel) {
		return this.xyzdao.shareCandidateDetails(candidateID, panel);
	}

	@Transactional
	@Override
	public String scheduleInterviewForTech(InterviewScheduleBean interviewBean) {

		return this.xyzdao.scheduleInterviewForTech(interviewBean);
	}

	@Override
	public boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean) {

		return this.xyzdao.scheduleInterviewForHR(interviewBean);

	}

	@Override
	public InterviewScheduleBean viewRatings(String interviewID) {

		return this.xyzdao.viewRatings(interviewID);
	}

	@Override
	public boolean finalizeResultDecision(String interviewID, String result) {

		return this.xyzdao.finalizeResultDecision(interviewID, result);
	}

	@Override
	public boolean declareResults(String interviewID, int share) {

		return this.xyzdao.declareResults(interviewID, share);
	}

}
