package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import dao.AdminDAO;
import exception.DatabaseException;
import exception.SystemException;
import filter.Sanitizing;
import token.TokenBean;
import token.TokenIDGenerate;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		
		TokenBean loginToken = new TokenBean();
		TokenIDGenerate token = new TokenIDGenerate();
		TokenBean menuToken = new TokenBean();
		
		loginToken.setToken(token.tokenID());
		menuToken.setToken(loginToken.getToken());
		session.setAttribute("loginToken", loginToken);
		session.setAttribute("menuToken", menuToken);
		
		Sanitizing s = new Sanitizing();
		
		AdminBean adBean = new AdminBean();
		
		String id = s.getEncodingString(request.getParameter("id"));            
		
		try {
			AdminDAO dao = new AdminDAO();
			adBean = dao.AdminLogin(id);
			
			if(s.getEncodingString(request.getParameter("id")).equals(adBean.getId())){
				//IDが一致
				if(s.getEncodingString(request.getParameter("pass")).equals(adBean.getPasswd())) {
					//パスワードが一致
					getServletContext().getRequestDispatcher("/WEB-INF/AdminMenu.jsp").forward(request, response);
				}else {
					//パスワードが不一致
					getServletContext().getRequestDispatcher("/WEB-INF/LoginError.jsp").forward(request, response);
				}
			}else{
				//IDが不一致
				getServletContext().getRequestDispatcher("/WEB-INF/LoginError.jsp").forward(request, response);
			}
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
