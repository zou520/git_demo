package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Pager;
import entity.SmbmsRole;
import entity.SmbmsUser;
import service.UserImpl;
/**
 * 查询全部用户信息
 */
/**
 * Servlet implementation class QueryUserSerlvet
 */
public class QueryUserSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserSerlvet() {
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
		System.out.println("dopost.................");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		String queryname = request.getParameter("queryname");
//		String queryUserRole = request.getParameter("queryUserRole");
//		Integer ye = 1;
//		String pageIndex = request.getParameter("pageIndex");
//		if(pageIndex!=null){
//			ye = Integer.valueOf(pageIndex);
//		}
//		/*if("".equals(queryname)){
//			queryname=null;
//		}
//		if("".equals(queryUserRole)&&queryUserRole.equals("0")){
//			queryUserRole=null;
//		}*/
//		if(queryUserRole!=null){
//			request.getSession().setAttribute("queryUserRole",queryUserRole);
//		}
//		//queryname = new String(queryname.getBytes("ISO-8859-1"),"UTF-8");
//		//queryUserRole = new String(queryUserRole.getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println("第一个"+queryname+"\t第二个"+queryUserRole+"pageIndex"+pageIndex);
//		//List<SmbmsUser> list = new UserImpl().t2();//查询全部用户信息
//		//request.setAttribute("userList",list);
//		Pager pager = new Pager();
//		int aaw = new UserImpl().t10(queryname,queryUserRole);//查询总条数
//		int aae = new UserImpl().t11(queryname,queryUserRole);//查询总页数
//		if(ye>aae){
//			ye=aae;
//		}
//		pager.setTotalCount(aaw);//总条数
//		request.setAttribute("totalCount",aaw);
//		pager.setTotalPageCount(aae);//总页数
//		request.setAttribute("totalPageCount",aae);
//		pager.setCurrentPageNo(ye);
//		request.setAttribute("currentPageNo",ye);//当前页数
//		//System.out.println(queryname+"111\t"+queryUserRole+"111\t"+pager);
//		List<SmbmsUser> list = new UserImpl().t3(queryname,queryUserRole,pager);//根据条件查询全部信息
//		request.setAttribute("userList",list);
//		List<SmbmsRole> list1 = new UserImpl().t4();//查询角色信息
//		request.setAttribute("roleList",list1);
//		request.getRequestDispatcher("jsp/userlist.jsp").forward(request, response);
	}

}
