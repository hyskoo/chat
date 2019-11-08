package kr.ac.chat.dao;

import kr.ac.chat.model.Member;

public interface MemberDao {

	void signup(Member member);

	Member login(Member member);

	

}
