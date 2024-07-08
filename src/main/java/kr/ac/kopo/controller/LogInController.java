package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.banking.dao.MemberDAO;
import kr.ac.kopo.banking.vo.MemberVO;
import kr.ac.kopo.framework.Controller;

public class LogInController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		
		MemberDAO dao = new MemberDAO();
		member = dao.login(member);
		
		String url = "";
		String msg = "";
		
		if(member == null){
			//로그인 실패
			url = "logIn.jsp";
			msg = "아이디 또는 비밀번호를 잘못 입력하셨습니다.";
		} else {
			//로그인 성공
			url = "/bingo/index.jsp";
			msg = member.getName() + "님 환영합니다.";
			
			//세션 등록
			session.setAttribute("member", member);
			
			request.setAttribute("msg", msg);
			session.setAttribute("member", member);
			
		}
		return "/index.jsp";
	}
}
