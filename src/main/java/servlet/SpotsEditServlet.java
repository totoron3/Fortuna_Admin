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
 * Servlet implementation class SpotsEditServlet
 */
@WebServlet("/SpotsEditServlet")
public class SpotsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotsEditServlet() {
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
			
			SpotsUpdateBean selectBean = (SpotsUpdateBean)session.getAttribute("selectBean");
			
			String updateValue = request.getParameter("updateValue");
			String db = request.getParameter("db");
			String column = request.getParameter("column");
			String id = selectBean.getNo();
			String img = request.getParameter("img");
			System.out.println("////////////////");
			System.out.println(updateValue);
			System.out.println(db);
			System.out.println(column);
			System.out.println(id);
			System.out.println("////////////////");
			
			if(updateValue == null) {
				String season = null;
				String all = request.getParameter("all");
				
				if(all != null) {
					season = "all";
					updateValue = season;
				}else{
					season = (request.getParameter("Spring")+","+request.getParameter("Summer")+","+request.getParameter("Autumn")+","+request.getParameter("Winter"));
					System.out.println(season);
					updateValue = season;
				}
			}
			
			try {
				SpotsUpdateDAO dao = new SpotsUpdateDAO();
				
				if(img != null) {
					int num = Integer.parseInt(request.getParameter("num"));
					System.out.println("イメージ");
					dao.SpotsUpdateImage(id, img, num);
				}else {
					System.out.println("変更");
					dao.SpotsUpdateValue(id, updateValue, db, column);
				}
				selectBean = new SpotsUpdateBean();
				selectBean = dao.SelectSpots(id);
				
				session.setAttribute("selectBean", selectBean);

				getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdateComplete.jsp").forward(request, response);

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
