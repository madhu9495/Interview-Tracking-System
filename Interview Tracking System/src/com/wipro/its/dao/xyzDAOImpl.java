package com.wipro.its.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.service.AdministratorImpl;

@Repository
public class xyzDAOImpl implements xyzDAO {
	@Autowired
	public SessionFactory sessionFactory;
	Session session;
	Query query;

	CandidateBean CandidateBean;
	AdministratorImpl ai = new AdministratorImpl();

	@Override
	public String createXYZ(CandidateBean candidateBean, ProfileBean profileBean) {
		if (candidateBean == null) {
			return "FAIL";
		} else {
			session = sessionFactory.getCurrentSession();
			try {
				query = session.createSQLQuery("select ITS_SEQ_CANDIDATEID.nextval from dual");
				BigDecimal seq = (BigDecimal) query.uniqueResult();
				seq.longValue();
				String id = profileBean.getFirstName().substring(0, 2).toUpperCase() + seq;

				candidateBean.setCandidateID(id);
				profileBean.setCandidateID(id);
				session.persist(candidateBean);
				session.persist(profileBean);

				return "SUCCESS";
			} catch (Exception e) {
				return "FAIL";
			}
		}
	}

	@Override
	public int deleteXYZ(ArrayList<String> a) {

		return 0;
	}

	@Override
	public boolean updateXYZ(CandidateBean candidateBean) {

		return false;
	}

	@Override
	public CandidateBean findByID(String candidateID) {
		session = sessionFactory.getCurrentSession();
		CandidateBean C = (CandidateBean) session.load(CandidateBean.class, candidateID);
		return C;
	}

	@Override
	public ArrayList<CandidateBean> findAll() {
		return ai.viewCandidate(CandidateBean.getPrimarySkills(), CandidateBean.getExperience(),
				CandidateBean.getQualification());
	}

	public ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification) {

		session = sessionFactory.getCurrentSession();
		try {
			query = session.createQuery(
					"from CandidateBean c where primarySkills = :p and experience <= :e and qualification = :q");
			query.setParameter("p", skills);
			query.setParameter("e", experience);
			query.setParameter("q", qualification);
			@SuppressWarnings("unchecked")
			ArrayList<CandidateBean> a = (ArrayList<CandidateBean>) query.list();
			return a;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean shareCandidateDetails(String candidateID, String panel) {
		session = sessionFactory.getCurrentSession();
		try
		{
		CandidateBean C = (CandidateBean) session.load(CandidateBean.class, candidateID);
		if (panel.equals("Tech")) {
			C.setShareDetails(1);
			return true;
		} else if (panel.equals("HR")) {
			C.setShareDetails(2);
			return true;
		} else if (panel.equals("All")) {
			C.setShareDetails(3);
			return true;
		} else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public String scheduleInterviewForTech(InterviewScheduleBean interviewBean) {

		session = sessionFactory.getCurrentSession();
		try
		{
		query = session.createSQLQuery("select ITS_SEQ_INTERVIEWID.nextval from dual");
		BigDecimal seq = (BigDecimal) query.uniqueResult();
		seq.longValue();
		String id = interviewBean.getSubject().substring(0, 2).toUpperCase() + seq;
		interviewBean.setInterviewID(id);
		session.persist(interviewBean);

		return "SUCCESS";
		}
		catch(Exception e)
		{
			return "FAIL";
		}
	}

	public boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean) {
		session = sessionFactory.getCurrentSession();
        try
        {
		InterviewScheduleBean s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class,
				interviewBean.getInterviewID());
		if (s.getTechRating() >= 2.5) {
			s.setEmpHRID(interviewBean.getEmpHRID());
			s.setEmpHRInterviewDate(interviewBean.getEmpHRInterviewDate());
			s.setEmpHRInterviewTime(interviewBean.getEmpHRInterviewTime());
			return true;
		} else {
			return false;
		}
        }
        catch(Exception e)
        {
        	return false;
        }
	}

	public ArrayList<CandidateBean> viewCandidatesTech(String techID, Date interviewDate) {
		Session session = sessionFactory.getCurrentSession();
		Query query;
		try
		{
		query = sessionFactory.getCurrentSession().createQuery(
				"select candidateID from InterviewScheduleBean i where i.techID like :t and i.interviewDate=:d and i.techRating=0");
		query.setParameter("t", techID);
		query.setParameter("d", interviewDate);

		@SuppressWarnings("unchecked")
		ArrayList<String> al = (ArrayList<String>) query.list();
		ArrayList<CandidateBean> s = new ArrayList<CandidateBean>();
		Iterator<String> i1 = al.iterator();
		while (i1.hasNext()) {

			CandidateBean cb = (CandidateBean) session.get(CandidateBean.class, i1.next());
			if (cb.getShareDetails() == 1 || cb.getShareDetails() == 3)
				s.add(cb);
		}

		return s;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public boolean submitRatingsTech(String interviewID, String techID, float rating) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);

		if (s.getTechID().equals(techID)) {
			s.setTechRating(rating);
			return true;
		} else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public ArrayList<CandidateBean> viewCandidatesHr(String empHRID, Date empHRInterviewDate) {
		Session session = sessionFactory.getCurrentSession();
		Query query;
		try
		{
		query = sessionFactory.getCurrentSession().createQuery(
				"select candidateID from InterviewScheduleBean i where i.empHRID like :t and i.empHRInterviewDate=:d and i.empHRRating=0");
		query.setParameter("t", empHRID);
		query.setParameter("d", empHRInterviewDate);

		@SuppressWarnings("unchecked")
		ArrayList<String> a = (ArrayList<String>) query.list();
		ArrayList<CandidateBean> s = new ArrayList<CandidateBean>();
		Iterator<String> i1 = a.iterator();
		while (i1.hasNext()) {

			CandidateBean cb = (CandidateBean) session.get(CandidateBean.class, i1.next());
			if (cb.getShareDetails() == 2 || cb.getShareDetails() == 3)
				s.add(cb);

		}

		return s;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean submitRatingsHR(String interviewID, String empHRID, float rating) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		if (s.getEmpHRID().equals(empHRID)) {
			s.setEmpHRRating(rating);
			return true;
		} else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public boolean finalizeResultDecision(String interviewID, String result) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		if (s.getEmpHRRating() != 1) {
			s.setResult(result);
			return true;
		} else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public InterviewScheduleBean viewRatings(String interviewID) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		return s;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean declareResults(String interviewID, int share) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		if (s.getResult().equalsIgnoreCase("Selected") || s.getResult().equalsIgnoreCase("Not Selected")) {
			s.setShareResult(share);
			return true;
		} else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		if (s.getShareResult() == 1 || s.getShareResult() == 3) {
			return s;
		} else {
			return null;
		}
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public InterviewScheduleBean viewFinalResultsHR(String interviewID) {
		session = sessionFactory.getCurrentSession();
		try
		{
		InterviewScheduleBean s = new InterviewScheduleBean();
		s = (InterviewScheduleBean) session.get(InterviewScheduleBean.class, interviewID);
		if (s.getShareResult() == 2 || s.getShareResult() == 3) {
			return s;
		} else {
			return null;
		}
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
