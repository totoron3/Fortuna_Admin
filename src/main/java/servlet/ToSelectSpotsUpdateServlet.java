package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import token.TokenBean;
import token.TokenIDGenerate;

/**
 * Servlet implementation class ToSelectSpotsUpdateServlet
 */
@WebServlet("/ToSelectSpotsUpdateServlet")
public class ToSelectSpotsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToSelectSpotsUpdateServlet() {
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

		getServletContext().getRequestDispatcher("/WEB-INF/SpotsUpdateSelectEdit.jsp").forward(request, response);
		
	}

}
