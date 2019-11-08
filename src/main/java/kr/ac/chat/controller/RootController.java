package kr.ac.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.chat.model.Member;
import kr.ac.chat.service.MemberService;

@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	MemberService service;
	

	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	/**
 	 * @param Member
 	 * @return index.jsp
 	 * @brief 사용자의 정보를 DB에 저장하기위한 기능. Model이 필요가 없다. 
 	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	String signupGET() {
		return "signup";
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	String signupPOST(Member member) {
		
		service.signup(member);
		
		return "redirect:/";
	}
	
	/**
 	 * @param 
 	 * @return login.jsp
 	 * @brief 
 	 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	String loginGET() {
		return "login";
	}
	
	/**
 	 * @param HttpSession, Member
 	 * @return login.jsp
 	 * @brief @responsbody를 사용하여 ajax의 값을 보내줌 
 	 */
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	String loginPOST(HttpSession session, Member member) {
		
		Member login = service.login(member);
		
		if(login != null) {
			
			session.setAttribute("login_id", member.getmId());
			session.setAttribute("login_pw", member.getmPw());
			session.setAttribute("login_auth", member.getmAuth());
		
			return "1";
			
		} else {
			return "0";
		}
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
}
