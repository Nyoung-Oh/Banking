package kr.ac.kopo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.banking.dao.AccountDAO;
import kr.ac.kopo.banking.vo.AccountVO;

/**
 * Servlet implementation class ViewBalance
 */
@WebServlet("/bingo/view_balance.check")
public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// 계좌 번호 저장
		String account_num =request.getParameter("account_num");
	
		AccountDAO accountDao = new AccountDAO();
		AccountVO accountVo = new AccountVO();
		
		// 계좌 정보에 계좌 번호 저장
		accountVo.setAccount_num(account_num);
		accountVo = accountDao.selectBalance(accountVo);
		
		PrintWriter out=response.getWriter();
		out.println(accountVo.getBalance());
		out.flush();
	}

}
