package kr.ac.kopo.banking.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.banking.vo.MemberVO;

public class MemberDAO {

	public SqlSession session; 
	
	public MemberDAO() {
		session = new MyBatisConfig().getInstance();
	}

	public MemberVO login(MemberVO member) {

		MemberVO logInMember = session.selectOne("member.dao.MemberDAO.logIn", member);
		
		return logInMember;
		
	}

}