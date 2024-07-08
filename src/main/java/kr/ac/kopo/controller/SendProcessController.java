package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.banking.dao.AccountDAO;
import kr.ac.kopo.banking.dao.AccountHistoryDAO;
import kr.ac.kopo.banking.vo.AccountHistoryVO;
import kr.ac.kopo.banking.vo.AccountVO;
import kr.ac.kopo.framework.Controller;

public class SendProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String accNum = request.getParameter("account_num");
		String yourAccNum = request.getParameter("your_account_num");
		long money = Long.parseLong(request.getParameter("money"));
		String pwd = request.getParameter("password");
		
		AccountDAO accountDAO = new AccountDAO();
		
		AccountVO accountVO = new AccountVO();
		accountVO.setAccount_num(accNum);
		accountVO.setPwd(pwd);
		
		// 비밀번호 확인
		AccountVO getAccountVO = accountDAO.checkPwd(accountVO);
		if (getAccountVO == null) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			return "/bingo/controlError.jsp";
		}
		
		//출금 계좌에 있는 돈보다 적은 돈인지 확인
		if (getAccountVO.getBalance() < money) {
			request.setAttribute("msg", "잔액이 부족합니다.");
			return "/bingo/controlError.jsp";
		}
		
		getAccountVO.setBalance(getAccountVO.getBalance()-money);
		accountDAO.updateBalance(getAccountVO);
		
		AccountVO receiveVO=new AccountVO();
		receiveVO.setAccount_num(yourAccNum);
		receiveVO.setBalance(money);
		accountDAO.increaseBalance(receiveVO);
		
		AccountHistoryVO accountHistoryVO = new AccountHistoryVO();
		
		accountHistoryVO.setAccount_num(accNum);
		accountHistoryVO.setYour_account_num(yourAccNum);
		accountHistoryVO.setMoney(money);
		accountHistoryVO.setHistory_type("3");
		
		AccountHistoryDAO accountHistoryDao = new AccountHistoryDAO();
		accountHistoryDao.insert(accountHistoryVO);
		
		return "/bingo/sendForm.do";
	}

}
