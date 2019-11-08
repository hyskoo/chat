package kr.ac.chat.service;

import kr.ac.chat.model.Member;

public interface MemberService {

	void signup(Member member);

	Member login(Member member);

	
}
