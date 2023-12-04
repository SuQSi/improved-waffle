package cugb.xg.javaee.jdbc.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cugb.xg.javaee.jdbc.bean.Dish;
import cugb.xg.javaee.jdbc.biz.IDishService;
import cugb.xg.javaee.jdbc.biz.IUsersService;
import cugb.xg.javaee.jdbc.dao.IDishDAO;
//import cugb.xg.javaee.jdbc.biz.IDishService;
//import cugb.xg.javaee.jdbc.biz.IUserService;
import cugb.xg.javaee.jdbc.utils.DAOFactory;
import cugb.xg.javaee.jdbc.utils.PageModel;
import cugb.xg.javaee.jdbc.biz.IUsersService;

/**
 * Servlet implementation class LoginCtrol
 */
@WebServlet("/loginctrl")
public class LoginCtrol extends HttpServlet {
	protected Logger logger = Logger.getLogger(getClass());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case ("logon"):
			logon(request, response);
			break;
		case ("pagelist"):
			pagelist(request, response);
			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void goPage(HttpServletRequest request, HttpServletResponse response, int PageNO, IDishService dishserv)
			throws ServletException, IOException {
		int PageSize = 6;
		PageModel<Dish> pagemodel = dishserv.queryDish4PageList(PageNO, PageSize);
		request.setAttribute("pagemodel", pagemodel);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	private void pagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��ǰҳ��PageNO
		//��ȡ�ܵļ�¼��totalrecords
		String reqPageNO = request.getParameter("pageNO");
		int PageNO = 0;
		if(reqPageNO != null){
			PageNO = Integer.valueOf(reqPageNO).intValue();
		}
		IDishService dishserv = (IDishService) DAOFactory.newInstance("IDishService");
		goPage(request, response, PageNO, dishserv);

	}
	
	private void logon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPass");
		// logger.debug(request.getParameterMap().get("loginName"));
		// IUsersDAO usersdao = (IUsersDAO)
		// DAOFactory.newInstance("IUsersDAO");
		// String sql = "select * from users where username=? and
		// password=?";
		// Object[] params = {username,password};
		// if(usersdao.queryUsersBy(sql, params).size() > 0 ){
		IUsersService userserv = (IUsersService) DAOFactory.newInstance("IUsersService");
		if (userserv.validateUser(username, password)) {
			// IDishDAO dishdao = (IDishDAO)
			// DAOFactory.newInstance("IDishDAO");
			// ArrayList<Dish> dishlist = dishdao.queryDishes();
			IDishService dishserv = (IDishService) DAOFactory.newInstance("IDishService");
			goPage(request, response, 1, dishserv);
		} else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}

	}
}
