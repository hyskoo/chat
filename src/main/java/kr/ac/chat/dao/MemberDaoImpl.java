package kr.ac.chat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.chat.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void signup(Member member) {

		sql.insert("member.signup", member);
	}

	@Override
	public Member login(Member member) {

		return sql.selectOne("member.login", member);
	}

}
