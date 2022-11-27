package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SpotsUpdateBean;
import dao.SpotsUpdateDAO;
import exception.DatabaseException;
import exception.SystemException;
import token.TokenBean;
import token.TokenIDGenerate;

/**
 * Servlet implementation class SpotsUpdateSelectedServlet
 */
@WebServlet("/SpotsUpdateSelectedServlet")
public class SpotsUpdateSelectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotsUpdateSelectedServlet() {
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

		TokenBean tokenBean = new TokenBean();
		TokenIDGenerate token = new TokenIDGenerate();

		String tokenID = token.tokenID();

		tokenBean.setsToken(tokenID);
		tokenBean.setToken(tokenID);
		session.setAttribute("tokenBean", tokenBean);
		
		SpotsUpdateBean selectBean = new SpotsUpdateBean();
		
		String id = request.getParameter("id");
		
		try {
			SpotsUpdateDAO dao = new SpotsUpdateDAO();
			selectBean = dao.SelectSpots(id);
			
			session.setAttribute("selectBean", selectBean);
			
			getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdateSelectEdit.jsp").forward(request, response);
			
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
