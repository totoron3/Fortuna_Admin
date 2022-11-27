package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NewsArrayBean;
import bean.NewsBean;

/**
 * Servlet implementation class NewsDetail
 */
@WebServlet("/NewsDetail")
public class NewsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDetail() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		NewsArrayBean nArray = (NewsArrayBean)session.getAttribute("nArray");
		NewsBean selectNews = new NewsBean(); 
		
		ArrayList<NewsBean> array = nArray.getNewsArray();
		
		for(NewsBean record : array) {
			if(record.getId() == id ){
				selectNews.setId(record.getId());
				selectNews.setTitle(record.getTitle());
				selectNews.setMain(record.getMain());
				selectNews.setDate(record.getDate());
				selectNews.setCategory(record.getCategory());
				selectNews.setCat(record.getCat());
			}
		}
		session.setAttribute("selectNews", selectNews);
		
		getServletContext().getRequestDispatcher("/WEB-INF/NewsDetail.jsp").forward(request, response);	
	}
}
