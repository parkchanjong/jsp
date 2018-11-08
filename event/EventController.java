package jspbook.pevent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventServlet", urlPatterns = "/event")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    	
		request.setCharacterEncoding("utf-8");
		
    	EventDAO dao = new EventDAO();		//dao 객체 생성 -- 디비 처리
    	if(request.getParameter("name") != null) {
    		Event event = new Event();
    		event.setName(request.getParameter("name"));
    		event.setEmail(request.getParameter("email"));
    		dao.register(event);
    	}
    	
    	List<Event> eventlist = dao.getAll();	//데이터를 받아옴
    	request.setAttribute("eventlist", eventlist);  //eventlist를 "eventlist"이름으로 저장
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pevent/event.jsp");		//포워딩
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
 
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
 
        processRequest(request, response);
    }
}
