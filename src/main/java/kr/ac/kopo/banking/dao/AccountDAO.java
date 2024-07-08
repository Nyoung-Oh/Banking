package kr.ac.kopo.banking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.banking.vo.AccountHistoryVO;
import kr.ac.kopo.banking.vo.AccountVO;
import kr.ac.kopo.banking.vo.MemberVO;

public class AccountDAO {

	private SqlSession session;

	public AccountDAO() {

		session = new MyBatisConfig().getInstance();
		System.out.println("session : " + session);

	}

	
	// 보낸 계좌의 잔액 업데이트
	public void updateBalance(AccountVO account) {
		session.update("account.dao.AccountDAO.updateBalance", account);
		session.commit();
		System.out.println("수정 완료");
	}
	
	
	// 받는 계좌의 잔액 업데이트
	public void increaseBalance(AccountVO account) {
		session.update("account.dao.AccountDAO.increaseBalance", account);
		session.commit();
		System.out.println("수정 완료");
	}

	
	// 로그인 한 id의 계좌 정보 조회
	public List<AccountVO> selectAccount(MemberVO member) {

		List<AccountVO> accountInfo = session.selectList("account.dao.AccountDAO.selectAccount", member);
		return accountInfo;
	}
	
	
	// id의 계좌 중 하나의 계좌 잔액 조회
	public AccountVO selectBalance(AccountVO account) {
		
		AccountVO accountBalance = session.selectOne("account.dao.AccountDAO.selectBalance", account);
		return accountBalance;
	}

	
	// 계좌 이체 시 입력한 비밀번호와 저장한 비밀번호 확인
	public AccountVO checkPwd(AccountVO accountVO) {

		AccountVO getAccountVO = session.selectOne("account.dao.AccountDAO.checkPwd", accountVO);
		return getAccountVO;
	}

	
	// 계좌 개설	
	public void insert(AccountVO accountVO) {

		session.insert("account.dao.AccountDAO.openAccount", accountVO);
		session.commit();
		System.out.println("삽입 완료");
	}

}