package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfoBean;
import dao.UserDAO;
import exception.DatabaseException;
import exception.SystemException;
import token.TokenBean;
import token.TokenIDGenerate;

/**
 * Servlet implementation class UserInfoUpdateFinalServlet
 */
@WebServlet("/UserInfoUpdateFinalServlet")
public class UserInfoUpdateFinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateFinalServlet() {
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
		HttpSession  session = request.getSession();

		TokenBean tokenBean = (TokenBean)session.getAttribute("tokenBean");

		if(tokenBean.getsToken().equals(tokenBean.getToken())) {
			TokenIDGenerate token = new TokenIDGenerate();
			tokenBean.setsToken(token.tokenID());
			session.setAttribute("tokenBean", tokenBean);
			
			UserInfoBean selectUser = new UserInfoBean();
			
			String  updateValue = request.getParameter("updateValue");
			String	column = request.getParameter("column");
			String	id = request.getParameter("id");
			
			try {
				UserDAO dao = new UserDAO();
				dao.UserInfoUpdate(id, updateValue, column);
				
				selectUser = dao.UserIdSearch(id);
				
				session.setAttribute("selectUser", selectUser);
				
				getServletContext().getRequestDispatcher("/WEB-INF/UserUpdateComplete.jsp").forward(request, response);
					
			}catch(SystemException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}catch(DatabaseException e) {
				e.printStackTrace();
				session.setAttribute("Except", e);
				getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			}	
		}else {
			getServletContext().getRequestDispatcher("/WEB-INF/SessionError.jsp").forward(request, response);
		}	
	}
}
