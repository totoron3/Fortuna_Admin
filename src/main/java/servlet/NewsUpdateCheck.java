package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NewsBean;
import dao.AddNewsDAO;
import exception.DatabaseException;
import exception.SystemException;
import token.TokenBean;
import token.TokenIDGenerate;
import util.NowDate;

/**
 * Servlet implementation class NewsUpdateCheck
 */
@WebServlet("/NewsUpdateCheck")
public class NewsUpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsUpdateCheck() {
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
		
		NewsBean selectNews = (NewsBean)session.getAttribute("selectNews");
		
		NewsBean cNews = new NewsBean();
		int id;
		NowDate nd = new NowDate();
		
		String str = nd.getNowDate00();
		
		str+=request.getParameter("cmain");
		
		cNews.setCategory(selectNews.getCategory());
		cNews.setCat(selectNews.getCat());
		cNews.setTitle(request.getParameter("ctitle"));
		cNews.setMain(str);
		cNews.setDate(selectNews.getDate());
		
		try {
			AddNewsDAO dao = new AddNewsDAO();
			id = dao.getID();
			id = id + 1;
			System.out.println(id);
			cNews.setId(id);
			
			session.setAttribute("cNews", cNews);
			
			getServletContext().getRequestDispatcher("/WEB-INF/NewsUpdateCheck.jsp").forward(request, response);
			
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
