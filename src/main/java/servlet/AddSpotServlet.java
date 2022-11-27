package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddSpotBean;
import dao.AddSpotsDAO;
import exception.DatabaseException;
import exception.SystemException;
import token.TokenBean;
import token.TokenIDGenerate;

/**
 * Servlet implementation class AddSpotServlet
 */
@WebServlet("/AddSpotServlet")
public class AddSpotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpotServlet() {
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
		//セッション管理用
		HttpSession session = request.getSession();

		TokenBean tokenBean = new TokenBean();
		TokenIDGenerate token = new TokenIDGenerate();

		String tokenID = token.tokenID();

		tokenBean.setsToken(tokenID);
		tokenBean.setToken(tokenID);
		session.setAttribute("tokenBean", tokenBean);
		//セッション管理(終わり)
		
		AddSpotBean asBean = new AddSpotBean();
		
		asBean.setNo(request.getParameter("no"));
		asBean.setGenre(request.getParameter("genre"));
		asBean.setSubGenre(request.getParameter("subgenre"));
		asBean.setName(request.getParameter("spotname"));
		asBean.setCity(request.getParameter("city"));
		asBean.setAddress(request.getParameter("location"));
		asBean.setRest(request.getParameter("rest"));
		asBean.setHours(request.getParameter("businessHours"));
		asBean.setAccess1(request.getParameter("access1"));
		asBean.setAccess2(request.getParameter("access2"));
		asBean.setMapURL(request.getParameter("mapURL"));
		asBean.setPage1(request.getParameter("page1"));
		asBean.setPage2(request.getParameter("page2"));
		asBean.setIntro(request.getParameter("intro"));
		asBean.setFeel(request.getParameter("feeling"));
		asBean.setFamily(request.getParameter("family"));
		asBean.setFriend(request.getParameter("friend"));
		asBean.setCupple(request.getParameter("lover"));
		asBean.setInout(request.getParameter("inout"));
		asBean.setFamous(request.getParameter("pop"));
		asBean.setArea(request.getParameter("area"));
		asBean.setImg1(request.getParameter("img1"));
		asBean.setImg2(request.getParameter("img2"));
		asBean.setImg3(request.getParameter("img3"));
		asBean.setImg4(request.getParameter("img4"));
		asBean.setImg5(request.getParameter("img5"));
		
		String season = null;
		String all = request.getParameter("all");
		
		if(all != null) {
			season = "all";
		}else {
			season = (request.getParameter("Spring")+","+request.getParameter("Summer")+","+request.getParameter("Autumn")+","+request.getParameter("Winter"));
		}
		
		int id = Integer.parseInt(request.getParameter("no"));
		System.out.println(id);
		int dup = 0;
		
		try {
			AddSpotsDAO dao = new AddSpotsDAO();
			dup = dao.SpotDup(id);
			
			if(dup == 0) {
				asBean.setSeason(season);

				session.setAttribute("asBean", asBean);
				
				getServletContext().getRequestDispatcher("/WEB-INF/AddSpotsVeri.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/WEB-INF/AddSpotsDup.jsp").forward(request, response);
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
