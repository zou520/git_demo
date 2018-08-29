package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SmbmsUser;
import service.UserImpl;

/**
 * 登录系统
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("dopost.................");
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		String userCode=request.getParameter("userCode");
//		String userPassword=request.getParameter("userPassword");
//		SmbmsUser sb = new UserImpl().t1(userCode,userPassword);
//		if(sb!=null){
//			System.out.println(sb.getUserName());
//			request.getSession().setAttribute("userSession",sb);
//			request.getRequestDispatcher("jsp/frame.jsp").forward(request, response);
//		}else{
//			out.print("<script>alert('用户名或密码错误！');location.href='login.jsp';</script>");
//		}
	}

}
