package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SmbmsRole;
import entity.SmbmsUser;
import service.UserImpl;

/**
 * 异步查询用户编码是否存在，异步查询全部角色信息,添加用户信息
 * Servlet implementation class QueryCodeServlet
 */
public class QueryCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCodeServlet() {
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
		System.out.println("dopost******************************");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		String userCode = request.getParameter("userCode");//用户编码
		String userName = request.getParameter("userName");//用户名称
		String userPassword = request.getParameter("userPassword");//用户密码
		String gender = request.getParameter("gender");//性别
		String birthday = request.getParameter("birthday");//出生日期
		String phone = request.getParameter("phone");//电话号码
		String address = request.getParameter("address");//用户地址
		String userRole = request.getParameter("userRole");//用户角色
		int num =0;
		if("ucexist".equals(method)){
			System.out.println("1111");
			SmbmsUser sb = new UserImpl().t5(userCode);
			System.out.println(sb);
			if(sb!=null){
				num=10;
			}
			out.print(num);
		}else if("getrolelist".equals(method)){
			List<SmbmsRole> list = new ArrayList<SmbmsRole>();
			list = new UserImpl().t4();
			StringBuffer newsJSON = new StringBuffer("[");
				SmbmsRole sb = null;
				for(int i =0;;){
					sb = list.get(i);
					newsJSON.append("{\"id\":"+sb.getId()+",");
					newsJSON.append("\"roleName\":\""+sb.getRoleName().replace("\"","&quot;")+"\"}");
					if((++i)==list.size()){
						newsJSON.append("]");
						break;
					}else{
						newsJSON.append(",");
					}
				}
				System.out.println(newsJSON);
				out.print(newsJSON);
		}else{
			SmbmsUser se = new SmbmsUser();
//			String userCode = request.getParameter("userCode");//用户编码
//			String userName = request.getParameter("userName");//用户名称
//			String userPassword = request.getParameter("userPassword");//用户密码
//			String gender = request.getParameter("gender");//性别
//			String birthday = request.getParameter("birthday");//出生日期
//			String phone = request.getParameter("phone");//电话号码
//			String address = request.getParameter("address");//用户地址
//			String userRole = request.getParameter("userRole");//用户角色
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Timestamp dateNow=new Timestamp(System.currentTimeMillis());
			Date reDate=new Date(System.currentTimeMillis());
			se.setCreationDate(reDate);//创建时间
			SmbmsUser sst=(SmbmsUser)request.getSession().getAttribute("userSession");
			//se.setCreatedBy(Integer.valueOf(sst.getId()));//创建人Id
			se.setCreatedBy(sst.getId());
			System.out.println(se.getCreatedBy());
			se.setUserCode(userCode);//用户编号
			se.setUserName(userName);//用户名称
			se.setUserPassword(userPassword);//密码
			se.setGender(Integer.valueOf(gender));//性别
			se.setBirthday(java.sql.Date.valueOf(birthday));//出生日期
			se.setAddress(address);//地址
			se.setUserRole(Integer.valueOf(userRole));//角色
			se.setPhone(phone);
			num = new UserImpl().t6(se);
			if(num>0){
				out.print("<script>alert('添加成功！');location.href='QueryUserSerlvet';</script>");
			}else{
				out.print("<script>alert('添加失败！');location.href='QueryUserSerlvet';</script>");
			}
		}
		out.flush();
		out.close();
	}

}
