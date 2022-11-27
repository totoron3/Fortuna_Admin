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
 * Servlet implementation class SpotsDeleteFinalServlet
 */
@WebServlet("/SpotsDeleteFinalServlet")
public class SpotsDeleteFinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotsDeleteFinalServlet() {
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
			
			String way = request.getParameter("way");
			System.out.println(way);
			
			if(way.equals("キャンセル")) {
				getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdate.jsp").forward(request, response);
			}else {
				
				SpotsUpdateBean selectBean = (SpotsUpdateBean)session.getAttribute("selectBean");
				
				try {
					SpotsUpdateDAO dao = new SpotsUpdateDAO();
					dao.SpotsDelete(selectBean.getNo());
					
					System.out.println("観光地削除完了");
				
					getServletContext().getRequestDispatcher("/WEB-INF/SpotsDeleteComplete.jsp").forward(request, response);
			
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
		}else {
			getServletContext().getRequestDispatcher("/WEB-INF/SessionError.jsp").forward(request, response);
		}
	}

}
