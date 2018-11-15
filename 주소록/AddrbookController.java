package addrbook;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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
public class AddrbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpServletRequest request;
    HttpServletResponse response;
    String view;
    
    AddrBookDAO dao = new AddrBookH2DAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddrbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.request = request;
		this.response = response;
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action == null) {
			action = "list";
		}
		
		switch(action) {
			case "list":listData();break;
			case "insert":insertData();break;
			case "edit":viewEdit();break;
			case "update":updateData();break;
			case "delete":deleteData();break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	private void deleteData() {								//hw
		// TODO Auto-generated method stub
		
	}

	private void updateData() {								//hw
		// TODO Auto-generated method stub
		
	}

	public void listData() {
		List<AddrBook> datas = dao.getAll();
		request.setAttribute("datas", datas);
		view="/addrbook/addrbook_list.jsp";
	}
	
	public void insertData() {
		AddrBook addrbook = new AddrBook();					//개선사항이 잇음  -- 하나하나 입력
		try {
			BeanUtils.populate(addrbook, request.getParameterMap());				//한줄로 처리 가능
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		addrbook.setAb_name(request.getParameter("ab_name"));
		addrbook.setAb_email(request.getParameter("ab_email"));
		addrbook.setAb_tel(request.getParameter("ab_tel"));
		addrbook.setAb_birth(request.getParameter("ab_birth"));
		addrbook.setAb_comdept(request.getParameter("ab_comdept"));
		addrbook.setAb_memo(request.getParameter("ab_memo"));
		*/
		dao.insertDB(addrbook);
		listData();
	}
	
	public void viewEdit() {
		AddrBook addrbook = dao.getDB(Integer.parseInt(request.getParameter("ab_id")));
		request.setAttribute("ab", addrbook);
		view = "/addrbook/addrbook_edit_form.jsp";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
