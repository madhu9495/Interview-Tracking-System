package com.wipro.its.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

import com.wipro.its.dao.xyzDAO;
import com.wipro.its.service.Administrator;
import com.wipro.its.service.HRPanel;
import com.wipro.its.service.TechPanel;
import com.wipro.its.util.Authentication;
import com.wipro.its.util.User;

@Controller
public class InterviewController {

	@Autowired(required = true)
	public User user;

	@Autowired(required = true)
	public Administrator administrator;

	@Autowired(required = true)
	public TechPanel techpanel;

	@Autowired(required = true)
	public Authentication authentication;

	@Autowired(required = true)
	xyzDAO xyz;

	String userID;

	@Autowired(required = true)
	public HRPanel hrPanel;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute CredentialsBean credentialsBean) {
		String result = null;
		String userType = user.login(credentialsBean);
		userID = credentialsBean.getUserID();
		if (userType.equals("A")) {
			result = "Administrator";
			authentication.changeLoginStatus(credentialsBean, 1);
		} else if (userType.equals("T")) {
			result = "TechnicalPanel";
			authentication.changeLoginStatus(credentialsBean, 1);
		} else if (userType.equals("H")) {
			result = "HRpanel";
			authentication.changeLoginStatus(credentialsBean, 1);
		} else if (userType.equals("INVALID")) {
			result = "LoginError";
		}
		return result;

	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changepassword(@ModelAttribute CredentialsBean credentialsBean,
			@RequestParam("newpassword") String newPassword) {
		String page = null;
		String result = this.user.changePassword(credentialsBean, newPassword);
		if (result.equals("SUCCESS")) {
			return page = "PaswordChanged";
		} else if (result.equals("INVALID")) {
			return page = "ErrorinChanging";
		} else if (result.equals("FAIL")) {
			return page = "FAIL";
		}
		return page;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		if (user.logout(userID) == true) {
			return "logout";
		} else {
			return "logoutfail";
		}
	}


	@RequestMapping(value = "Adding", method = RequestMethod.POST)
	public String AddCandidate(@ModelAttribute CandidateBean candidateBean, @ModelAttribute ProfileBean profileBean) {
		String result = this.administrator.addCandidate(profileBean, candidateBean);
		if (result.equals("SUCCESS")) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView ViewCandidate(@RequestParam("skills") String skills,
			@RequestParam("experience") float experience, @RequestParam("qualification") String qualification,
			Model m) {
		ModelAndView model = new ModelAndView("view");

		m.addAttribute("candidate", new CandidateBean());
		m.addAttribute("listCandidate", this.administrator.viewCandidate(skills, experience, qualification));

		return model;

	}

	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String ScheduleInfo(@RequestParam("candidateID") String candidateID, @RequestParam("panel") String panel) {
		if (this.administrator.shareCandidateDetails(candidateID, panel) == true) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}
	}

	@RequestMapping(value = "/scheduleTech", method = RequestMethod.POST)
	public String ScheduleTech(@ModelAttribute InterviewScheduleBean interviewBean) {
		String result = this.administrator.scheduleInterviewForTech(interviewBean);
		if (result.equals("SUCCESS")) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}
	}

	@RequestMapping(value = "/seachTech", method = RequestMethod.GET)
	public String ViewinterviewedTech(@RequestParam("techID") String techID,
			@RequestParam("interviewDate") Date interviewDate, Model m) {

		m.addAttribute("candidate", new CandidateBean());
		m.addAttribute("listinterview", this.techpanel.viewCandidates(techID, interviewDate));
		return "viewTech";
	}

	@RequestMapping(value = "/searchHr", method = RequestMethod.GET)
	public String ViewinterviewedHr(@RequestParam("empHRID") String empHRID,
			@RequestParam("empHRInterviewDate") Date empHRInterviewDate, Model m) {

		m.addAttribute("candidate", new InterviewScheduleBean());
		m.addAttribute("listinterview", this.hrPanel.viewCandidatesHr(empHRID, empHRInterviewDate));
		return "viewHr";
	}

	@RequestMapping(value = "/TeckRating", method = RequestMethod.GET)
	public String submitTechRate(@RequestParam("interviewID") String interviewID, @RequestParam("techID") String techID,
			@RequestParam("techRating") float rating) {

		boolean check = this.techpanel.submitRatings(interviewID, techID, rating);
		if (check) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}
	}

	@RequestMapping(value = "/scheduleHR", method = RequestMethod.POST)
	public String ScheduleHR(@ModelAttribute InterviewScheduleBean interviewBean) {
		if (this.administrator.scheduleInterviewForHR(interviewBean)) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}

	}

	@RequestMapping(value = "/HRRating", method = RequestMethod.GET)
	public String submitHRRating(@RequestParam("interviewID") String interviewID,
			@RequestParam("empHRID") String empHRID, @RequestParam("empHRRating") float rating) {
		boolean check = this.hrPanel.submitRatings(interviewID, empHRID, rating);
		if (check) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}
	}

	@RequestMapping(value = "/Viewratings", method = RequestMethod.GET)
	public String viewRatings(@RequestParam("interviewID") String interviewID, Model m) {
		m.addAttribute("view", this.administrator.viewRatings(interviewID));
		return "Viewratings";

	}

	@RequestMapping(value = "/Finalresult", method = RequestMethod.GET)
	public String finalResult(@RequestParam("interviewID") String interviewID, @RequestParam("result") String result) {

		boolean check = this.administrator.finalizeResultDecision(interviewID, result);
		if (check) {
			return "AddSuccess";
		} else {
			return "AddingError";
		}
	}

	@RequestMapping(value = "/Declare", method = RequestMethod.GET)
	public String declareResult(@RequestParam("interviewID") String interviewID,
			@RequestParam("shareResult") int share) {

		if (this.administrator.declareResults(interviewID, share)) {
			return "Declared";
		} else {
			return "NotDeclared";
		}
	}

	@RequestMapping(value = "/viewResultTech", method = RequestMethod.GET)
	public String viewResultbyTech(@RequestParam("interviewID") String interviewID, Model m) {
		if (this.techpanel.viewFinalResults(interviewID) == null) {
			return "ErrorViewFinalResult";
		} else {
			m.addAttribute("viewResult", this.techpanel.viewFinalResults(interviewID));
			return "ViewFinalResult";
		}
	}

	@RequestMapping(value = "/viewResultHR", method = RequestMethod.GET)
	public String viewResultbyHR(@RequestParam("interviewID") String interviewID, Model m) {
		if (this.hrPanel.viewFinalResults(interviewID) == null) {
			return "ErrorViewFinalResult";
		} else {
			m.addAttribute("viewResult", this.hrPanel.viewFinalResults(interviewID));
			return "ViewFinalResult";
		}

	}
}
