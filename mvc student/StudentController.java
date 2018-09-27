package jspbook.ch05;

import java.util.Optional;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentController extends HttpServlet {
	/**
	 * 
	 * 	 */
	private static final long serialVersionUID = 1L;
	
	private StudentService studentService = new StudentService();
	 
    private void processRequest(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
 
        String studentID = request.getParameter("id");
        if (studentID != null) {
            int id = Integer.parseInt(studentID);
            studentService.getStudent(id)
            .ifPresent(s -> request.setAttribute("studentRecord", s));  //메소드 체인
        }
 
        String view = "/student/studentinfo.jsp"; // studentinfo_action.jsp, studentinfo_el.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
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
