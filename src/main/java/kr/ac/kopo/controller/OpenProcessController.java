package kr.ac.kopo.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.banking.dao.AccountDAO;
import kr.ac.kopo.banking.dao.AccountHistoryDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.AccountHistoryVO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

public class OpenProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		String account_type=request.getParameter("account_type");
		
		String type="001";
		
		if(account_type.endsWith("plusAccount.png") || account_type.endsWith("oneAccount.png")){
			type = "001";
		}else {
			type = "002";
		}
		
		Random random = new Random();
		
		String account_num = "101" + type;
		String random1 = Integer.toString(random.nextInt(2));
		String random2 = Integer.toString(random.nextInt(7));
		
		String accNum = account_num + "-" + random1 + "-" + random2;
		String pwd = request.getParameter("pwd");
		long initialMoney = Long.parseLong(request.getParameter("initialMoney"));
		
		AccountVO accountVO = new AccountVO();
		accountVO.setAccount_type("001");
		accountVO.setAccount_num(accNum);
		accountVO.setAccount_pwd(pwd);
		accountVO.setBalance(initialMoney);
		accountVO.setMember_id(member.getId());
		AccountDAO accountDao = new AccountDAO();
		accountDao.insert(accountVO);

		AccountHistoryVO historyVO = new AccountHistoryVO();
		historyVO.setAccount_num(accNum);
		historyVO.setYour_account_num("최초 입금 금액");
		historyVO.setMoney(initialMoney);
		historyVO.setHistory_type("4");
		AccountHistoryDAO historyDao = new AccountHistoryDAO();
		historyDao.insert(historyVO);

		return "/bingo/accountOpen.jsp";
	}

}
