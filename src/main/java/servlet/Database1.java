package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.INSERT;
import exception.DatabaseException;
import exception.SystemException;

/**
 * Servlet implementation class Database1
 */
@WebServlet("/Database1")
public class Database1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Database1() {
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
		
		try {
			INSERT dao = new INSERT();
			dao.Insert();
			
			
			
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
