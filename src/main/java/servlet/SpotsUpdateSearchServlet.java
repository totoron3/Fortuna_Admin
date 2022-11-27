package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SpotsUpdateArrayBean;
import dao.SpotsUpdateDAO;
import exception.DatabaseException;
import exception.SystemException;

/**
 * Servlet implementation class SpotsUpdateSearchServlet
 */
@WebServlet("/SpotsUpdateSearchServlet")
public class SpotsUpdateSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotsUpdateSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SpotsUpdateArrayBean suArray = new SpotsUpdateArrayBean();
		
		String s = request.getParameter("search");
		
		System.out.println(s);
		
		if(request.getParameter("way").equals("id")) {
			try {
				SpotsUpdateDAO dao = new SpotsUpdateDAO();
				suArray = dao.SpotsUpdateIDSearch(s);
				
				session.setAttribute("suArray", suArray);
				
				getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdateSelect.jsp").forward(request, response);
				
			}catch(SystemException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}catch(DatabaseException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}
		}
		
		if(request.getParameter("way").equals("name")) {
			try {
				SpotsUpdateDAO dao = new SpotsUpdateDAO();
				suArray = dao.SpotsUpdateNameSearch(s);
				
				session.setAttribute("suArray", suArray);
				
				getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdateSelect.jsp").forward(request, response);	
				
			}catch(SystemException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}catch(DatabaseException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}			
		}
	}
}
