package twitter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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



/**
 * Servlet implementation class TwitterController
 */
@WebServlet("/twitter")
public class TwitterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request;
	HttpServletResponse response;					//특정 메서드 글로벌하게
	HttpSession session;
	ServletContext application;
	
	String view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    protected void doGet(
    	      HttpServletRequest request, HttpServletResponse response) 
    	      throws ServletException, IOException {
    	 
    	        processRequest(request, response);
    	    }
    	 
    	    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	    	request.setCharacterEncoding("utf-8");			//컨트롤러 구조 설정
    	    	this.request = request;
    	    	this.response = response;
    	    	session = request.getSession();
    	    	application = request.getServletContext();
    	    	
    	    	String action = request.getParameter("action");
    	    	if(action == null) {
    	    		session.invalidate();
    	    		response.sendRedirect("/twitter/twitter_login.jsp");
    	    		return;
    	    	}
    	    	switch (action) {
    	    	case "login":	    		
    	    		login();
    	    		break;
    	    	case "tweet":
    	    		tweet();
    	    		break;
        	}
    	    	
    	    	RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    	        dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		
	}

    	    
    	    public void login() {
    	    	String username =  request.getParameter("username");
    	    	if (username != null) {
    	    		session.setAttribute("user", username);
    	    	}
    	    	view =  "/twitter/twitter_list.jsp";
    	    }
    	    public void tweet() {
    	    	String msg =  request.getParameter("msg");
    	    	String username =  (String)session.getAttribute("user");
    	    	
    	    	List<String> msgs = (List<String>) application.getAttribute("msgs");
    	    	if (msgs != null) {
    	    		msgs = new ArrayList<String>();
    	    		application.setAttribute("msgs", msgs);
    	    	}
    	    	LocalDateTime date = LocalDateTime.now();  //시간관련된 일을할때 사용  			시간이 필요 없으면 LocalDate
    	    	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	    	
    	    	msgs.add(username+" :: "+msg+" , "+date.format(f));
    	    	application.log(msg+"추가됨");
    	    	
    	    	view =  "/twitter/twitter_list.jsp";
    	    }
    	    
			@Override
    protected void doPost(
    	      HttpServletRequest request, HttpServletResponse response) 
    	      throws ServletException, IOException {
    	 
    	        processRequest(request, response);
    	    }

}
