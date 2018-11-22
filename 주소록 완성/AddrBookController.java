package javaweb.addrbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class AddrBookController
 */
@WebServlet("/addrbook")
public class AddrBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	String view;
	PrintWriter out;
	
	AddrBookDAO dao = new AddrBookH2DAO();
	
    private void processRequest(
    		HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	this.request = request;
    	this.response = response;
    	
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	
    	out = response.getWriter();

    	String action = request.getParameter("action");
    	if(action == null) {
    		action = "list";
    	}

    	switch (action) {
	    	case "list":	    		
	    		listData();
	    		break;
	    	case "insert":
	    		insertData();
	    		break;
	    	case "edit":
	    		viewEdit();
	    		break;
	    	case "update":
	    		updateData();
	    		break;
	    	case "delete":
	    		deleteData();
	    		break;	
    	}
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
    
    public void listData() {
		List<AddrBook> datas = dao.getDBList();
		request.setAttribute("datas", datas);
		view="/addrbook/addrbook_list.jsp";
    }
    
    public void insertData() throws IOException{
    	// Bean mapping 을 편하게 하려면 apache commons BeanUtils를 써야 함.
    	AddrBook addrbook = new AddrBook();
    	try {
			BeanUtils.populate(addrbook, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	/*
    	addrbook.setAb_name(request.getParameter("ab_name"));
    	addrbook.setAb_email(request.getParameter("ab_email"));
    	addrbook.setAb_birth(request.getParameter("ab_birth"));
    	addrbook.setAb_tel(request.getParameter("ab_tel"));
    	addrbook.setAb_comdept(request.getParameter("ab_comdept"));
    	addrbook.setAb_memo(request.getParameter("ab_memo"));
    	*/
    	
		if(dao.insertDB(addrbook)) {
			listData();		
		}
		else
			throw new IOException("AddrBook DB 입력오류");
    }
    
    public void viewEdit() throws ServletException {
		AddrBook abook = dao.getDB(Integer.parseInt(request.getParameter("ab_id")));
		if(!request.getParameter("upasswd").equals("1234")) {
			throw new ServletException("AddrBook 비밀번호가 틀렸습니다.");
		}
		else {
			request.setAttribute("ab",abook);
			view="/addrbook/addrbook_edit_form.jsp";
		}
    }
    
    public void updateData() throws IOException {
    	AddrBook addrbook = new AddrBook();
    	try {
			BeanUtils.populate(addrbook, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	/*
    	addrbook.setAb_id(Integer.parseInt(request.getParameter("ab_id")));
    	addrbook.setAb_name(request.getParameter("ab_name"));
    	addrbook.setAb_email(request.getParameter("ab_email"));
    	addrbook.setAb_birth(request.getParameter("ab_birth"));
    	addrbook.setAb_tel(request.getParameter("ab_tel"));
    	addrbook.setAb_comdept(request.getParameter("ab_comdept"));
    	addrbook.setAb_memo(request.getParameter("ab_memo"));
    	*/

		if(dao.updateDB(addrbook)) {
			listData();
		}
		else
			throw new IOException("AddrBook DB 갱신오류");    	
    }
    
    public void deleteData() throws IOException {
		if(dao.deleteDB(Integer.parseInt(request.getParameter("ab_id")))) {
			listData();
		}
		else
			throw new IOException("AddrBook DB 삭제 오류");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException  {
			processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException{
			processRequest(request, response);
	}

}
