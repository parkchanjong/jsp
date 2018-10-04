package jspbook.exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsController
 */
@WebServlet(urlPatterns = "/news.nhn")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NewsService newsService = new NewsService();
	HttpServletRequest request;
	HttpServletResponse response;
	String view;
	 
    private void processRequest(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    	this.request = request;
    	this.response = response;
    	
    	String action = request.getParameter("action");
    	if(action == null) {
    		action = "list";
    	}
    	
    	switch (action) {
	    	case "list":	    		
	    		listNews();
	    		break;
	    	case "view":
	    		viewNews();
	    		break;
    	}
 
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
    
    public void listNews() {
    	List<News> list = newsService.getNewsList();
    	request.setAttribute("newslist", list);
    	view = "/exam/newslist.jsp";
    }
    
    public void viewNews() {
        String aid = request.getParameter("aid");

        if (aid != null) {
            newsService.getNews(aid)
            .ifPresent(s -> request.setAttribute("news", s));
        }
    	view =  "/exam/newsview.jsp";
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
