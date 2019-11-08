package kr.ac.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.chat.dao.MemberDao;
import kr.ac.chat.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public void signup(Member member) {
		
		dao.signup(member);
	}

	@Override
	public Member login(Member member) {

		return dao.login(member);
	}
	

}
