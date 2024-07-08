package kr.ac.kopo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.ac.kopo.banking.dao.AccountHistoryDAO;
import kr.ac.kopo.banking.vo.AccountHistoryVO;
import kr.ac.kopo.framework.PageUtil;

/**
 * Servlet implementation class ViewHistory
 */
@WebServlet("/bingo/view_history.check")
public class ViewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHistory() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account_num = request.getParameter("account_num");
		
		String page = request.getParameter("page");
		
		if(page == null || page.equals("") ) {
			page = "1";
		}
		
		
		AccountHistoryDAO historyDao = new AccountHistoryDAO();
		AccountHistoryVO historyVo = new AccountHistoryVO();
		
		int count = historyDao.count(account_num);
		String pageTag = PageUtil.generate(Integer.parseInt(page), count, 10, "");
		
		historyVo.setPage(page);
		
		// 거래 내역에 계좌 번호 선택
		historyVo.setAccount_num(account_num);
		
		// DAO에 있는 잔액 조회 메소드에 위 계좌 번호를 선택한 VO를 넘겨 거래 내역 배열을 리스트로 받아 변수명 historyList에 저장
		List<AccountHistoryVO> historyList = historyDao.historyPage(historyVo);
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		result.put("historyList",historyList);
		result.put("pageTag",pageTag);
		
		// 비동기식으로 jsp에 전달하기 위해 gson 라이브러리를 사용해 json 형태로 한번에 변환 후 jsp의 콜백 함수에서 response로 받음
		Gson gson = new Gson();
		//String json = gson.toJson(historyList);
		String json = gson.toJson(result);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(json);
		out.flush();
	
	}

}
