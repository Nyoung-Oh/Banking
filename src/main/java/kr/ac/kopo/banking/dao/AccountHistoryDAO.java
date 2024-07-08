package kr.ac.kopo.banking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.banking.vo.AccountHistoryVO;
import kr.ac.kopo.banking.vo.AccountVO;

public class AccountHistoryDAO {

	private SqlSession session;
	
	public AccountHistoryDAO() {
	
		session = new MyBatisConfig().getInstance();
		System.out.println("session : " + session);
	
	}
	
	
	// 계좌 이체 시 거래 내역 테이블에 삽입
	public void insert(AccountHistoryVO accountHistoryVO) {
		
		session.insert("history.dao.AccountHistoryDAO.insert",accountHistoryVO);
		session.commit();
	
	}
	
	
	// 로그인한 id의 계좌 번호 중 거래 내역 조회(잔액 조회는 아래에서 함)
	public List<AccountHistoryVO> selectHistory(AccountHistoryVO historyVO) {
		
		List<AccountHistoryVO> historyInfo = session.selectList("history.dao.AccountHistoryDAO.selectHistory", historyVO);
		return historyInfo;
		
	}
	
	
	// 로그인한 id의 계좌 번호 중 잔액 내역 조회	
	public List<AccountHistoryVO> selectBalance(AccountHistoryVO historyVO) {
		
		List<AccountHistoryVO> balanceInfo = session.selectList("history.dao.AccountHistoryDAO.selectBalance", historyVO);
		return balanceInfo;
	
		
	}
	
	
	// 거래 내역 전체 갯수 조회
	public int count (String account_num) {
	
		return session.selectOne("history.dao.AccountHistoryDAO.count", account_num);
	
	}
	
	
	// 거래 내역 페이지 별로 저장
	public List<AccountHistoryVO> historyPage(AccountHistoryVO historyVo) {
		return session.selectList("history.dao.AccountHistoryDAO.selectBalancePage", historyVo);
	}
}