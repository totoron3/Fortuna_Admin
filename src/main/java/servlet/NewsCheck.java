package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NewsArrayBean;
import dao.NewsDAO;
import exception.DatabaseException;
import exception.SystemException;

/**
 * Servlet implementation class NewsCheck
 */
@WebServlet("/NewsCheck")
public class NewsCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCheck() {
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
		NewsArrayBean nArray = new NewsArrayBean();
		
		
		try {
			NewsDAO dao = new NewsDAO();
			nArray = dao.getNews();
			
			session.setAttribute("nArray", nArray);
			
			getServletContext().getRequestDispatcher("/WEB-INF/NewsCheck.jsp").forward(request, response);
			
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
