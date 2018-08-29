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
 * ÐÞ¸ÄÃÜÂë
 * Servlet implementation class PwdServlet
 */
public class PwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost.................6");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String oldpassword = request.getParameter("oldpassword");
		String method = request.getParameter("method");
		SmbmsUser sb =(SmbmsUser)request.getSession().getAttribute("userSession");
		if("pwdmodify".equals(method)){
			System.out.println("ÅÐ¶ÏÃÜÂë");
			//System.out.println(oldpassword);
			//System.out.println("ÃÜÂë"+sb.getUserPassword());
			int num =0;
			if(sb.getUserPassword().equals(oldpassword)){
				num=1;
			}
			//System.out.println("num"+num);
			out.print(num);
		}else{
			System.out.println("ÐÞ¸Ä");
			String newpassword = request.getParameter("newpassword");
			int numid = sb.getId();
			int num11 = new UserImpl().t12(newpassword, numid);
			if(num11>0){
				out.print("<script>alert('ÐÞ¸Ä³É¹¦£¡');location.href='QueryUserSerlvet';</script>");
			}else{
				out.print("<script>alert('ÐÞ¸ÄÊ§°Ü£¡');location.href='QueryUserSerlvet';</script>");
			}
		}
	}

}
