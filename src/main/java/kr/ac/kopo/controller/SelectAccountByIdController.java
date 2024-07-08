package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.banking.dao.AccountDAO;
import kr.ac.kopo.banking.vo.AccountVO;
import kr.ac.kopo.banking.vo.MemberVO;
import kr.ac.kopo.framework.Controller;

public class SelectAccountByIdController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		HttpSession session=request.getSession();
		
		MemberVO member=(MemberVO)session.getAttribute("member");
		
		AccountDAO accountDao = new AccountDAO();
		
		List<AccountVO> accountInfo = accountDao.selectAccount(member); 
		
		request.setAttribute("accountInfo", accountInfo);
		
		return "view.jsp";
	}
}
