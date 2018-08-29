package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SmbmsUser;
import service.UserImpl;

/**
 * 修改用户信息
 * Servlet implementation class Upd1Servlet
 */
public class Upd1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upd1Servlet() {
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
		System.out.println("post.................");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String userRole = request.getParameter("userRole");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());
		
		SmbmsUser sst=(SmbmsUser)request.getSession().getAttribute("userSession");
		//se.setCreatedBy(Integer.valueOf(sst.getId()));//创建人Id
		
		System.out.println(uid+"\t"+userName+"\t"+gender+"\t"+birthday+"\t"+phone+"\t"+address+"\t"+userRole);
		SmbmsUser sbe = new SmbmsUser();
		sbe.setModifyDate(reDate);//创建时间
		sbe.setModifyBy(sst.getId());//创建人id
		sbe.setId(Integer.valueOf(uid));
		sbe.setUserName(userName);
		sbe.setGender(Integer.valueOf(gender));
		sbe.setBirthday(java.sql.Date.valueOf(birthday));
		sbe.setPhone(phone);
		sbe.setAddress(address);
		sbe.setUserRole(Integer.valueOf(userRole));
		System.out.println(sbe.getAddress());
		int num = new UserImpl().t8(sbe);
		if(num>0){
			out.print("<script>alert('修改成功！');location.href='QueryUserSerlvet';</script>");
		}else{
			out.print("<script>alert('修改失败！');location.href='QueryUserSerlvet';</script>");
		}
	}

}
