package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddNewsBean;
import dao.AddNewsDAO;
import exception.DatabaseException;
import exception.SystemException;
import token.TokenBean;
import token.TokenIDGenerate;
import util.NowDate;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
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
		
		AddNewsBean anBean = new AddNewsBean();
		int id;
		
		NowDate nd = new NowDate();
		
		anBean.setCategory(Integer.parseInt(request.getParameter("category")));
		anBean.setTitle(request.getParameter("title"));
		anBean.setMain(request.getParameter("main"));
		anBean.setDate(nd.getNowDate());
		
		if(anBean.getCategory() == 1) {
			anBean.setCat("新規観光地");
		}else if(anBean.getCategory() == 2) {
			anBean.setCat("アップデート");
		}else if(anBean.getCategory() == 3) {
			anBean.setCat("障害不具合");
		}else if(anBean.getCategory() == 4) {
			anBean.setCat("その他");
		}
		
		try {
			AddNewsDAO dao = new AddNewsDAO();
			id = dao.getID();
			id = id + 1;
			System.out.println(id);
			anBean.setId(id);
			
			session.setAttribute("anBean", anBean);
			
			getServletContext().getRequestDispatcher("/WEB-INF/AddNewsVeri.jsp").forward(request, response);
			
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
