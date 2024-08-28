package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.util.RedisUtil;
import kr.ac.kopo.vo.MemberVO;

public class BankingMainController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		RedisUtil redisUtil = new RedisUtil("172.31.9.182", 6379);
	
		MemberVO redisMember = (MemberVO)redisUtil.getObject("loginUser");
		
		HttpSession session = request.getSession();
		if (redisMember != null) {
			session.setAttribute("member", redisMember);
		} else {
			session.invalidate();
		}
		
		// 메인 화면 출력
		return "/index.jsp";
	}
}
