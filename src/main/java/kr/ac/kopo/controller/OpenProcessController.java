package kr.ac.kopo.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.banking.dao.AccountDAO;
import kr.ac.kopo.banking.vo.AccountVO;
import kr.ac.kopo.banking.vo.MemberVO;
import kr.ac.kopo.framework.Controller;

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
		accountVO.setAccount_type(type);
		accountVO.setAccount_num(accNum);
		accountVO.setPwd(pwd);
		accountVO.setBalance(initialMoney);
		accountVO.setId(member.getId());
		AccountDAO accountDao = new AccountDAO();
		accountDao.insert(accountVO);

		return "/bingo/accountOpen.jsp";
	}

}
