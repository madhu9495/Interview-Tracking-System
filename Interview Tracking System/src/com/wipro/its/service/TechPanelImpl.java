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
public class TechPanelImpl implements TechPanel {
	@Autowired(required = true)
	public xyzDAO xyzdao;

	@Override
	public ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate) {

		return this.xyzdao.viewCandidatesTech(techID, interviewDate);
	}

	@Override
	public boolean submitRatings(String interviewID, String techID, float rating) {

		return this.xyzdao.submitRatingsTech(interviewID, techID, rating);
	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {

		return this.xyzdao.viewFinalResults(interviewID);
	}

}
