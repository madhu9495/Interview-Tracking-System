package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.xyzDAO;

@Service
@Transactional
public class HRPanelImpl implements HRPanel {

	@Autowired(required = true)
	public xyzDAO xyzdao;

	@Override
	public ArrayList<CandidateBean> viewCandidatesHr(String empHRID, Date empHRInterviewDate) {

		return this.xyzdao.viewCandidatesHr(empHRID, empHRInterviewDate);
	}

	@Override
	public boolean submitRatings(String interviewID, String empHRID, float rating) {
		return this.xyzdao.submitRatingsHR(interviewID, empHRID, rating);

	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {

		return this.xyzdao.viewFinalResultsHR(interviewID);
	}

}
