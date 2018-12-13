package javaweb.twitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**;[['['
 * Servlet implementation class TwitterController
 */
@WebServlet("/twitter")
public class TwitterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    ServletContext application;
    
	String view;
	TwitterService service;
	
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	this.request = request;
    	this.response = response;
    	session = request.getSession();
    	application = request.getServletContext();
    	
    	// 데이터 서비스 선택 지정.
    	service = new FirebaseService();
    	    	
    	String action = request.getParameter("action");
    	if(action == null) {
    		session.invalidate();
    		response.sendRedirect("/javaweb/twitter/twitter_login.jsp");
    		return;
    	}
        	switch (action) {
	        	case "login":	    		
	        		login();
	        		break;
	        	case "tweet":
	        		tweet();
        	}        	
          RequestDispatcher dispatcher = request.getRequestDispatcher(view);
          dispatcher.forward(request, response);
    }

    public void login() {
    	// HTML 폼에서 username으로 전달된 값을 가지고 옴 
    	String username = request.getParameter("username");    	
    	// username이 null 이 아닌 경우 세션에 값을 저장
    	if(username != null) {
    		session.setAttribute("user",username);
    	}
    	list();
    }

    public void list() {	
    	List<String> tweetlist = new ArrayList<String>();
    	tweetlist = service.getList();
    	request.setAttribute("tweetlist", tweetlist);
    	view = "/twitter/tweet_list.jsp";
    }
    
    public void tweet() throws IOException {
    	// HTML 폼에서 전달된 msg 값을 가지고 옴
    	String msg = request.getParameter("msg");
    	
    	// 세션에 저장된 로그인 사용자 이름을 가지고 옴
    	String username = (String)session.getAttribute("user");
    	
    	// 사용자 이름, 메시지, 날짜 정보를 포함하여 ArrayList에 추가
    	LocalDateTime date = LocalDateTime.now();
    	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	msg = username+" :: "+msg+" , "+ date.format(f);
    	
		service.write(msg);
		
    	// 톰캣 콘솔을 통한 로깅
    	application.log(msg+"추가됨");
    	
    	// 목록 화면 데이터 로딩
    	list();
    }
    		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
}