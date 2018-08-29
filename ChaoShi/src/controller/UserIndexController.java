package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Pager;
import entity.SmbmsRole;
import entity.SmbmsUser;
import service.UserImpl;

@Controller
public class UserIndexController {
	@Autowired
	@Qualifier("UserMapper")
	private UserImpl userImpl;
	@RequestMapping("/query1")
	/**
	 * 判断用户是否存在
	 * @param request
	 * @return
	 */
	public String query1(HttpServletRequest request){
		String userCode=request.getParameter("userCode");
		String userPassword=request.getParameter("userPassword");
		SmbmsUser st = new SmbmsUser();
		st.setUserCode(userCode);
		st.setUserPassword(userPassword);
		SmbmsUser sb = userImpl.query1(st);
		if(sb!=null){
			System.out.println(sb.getUserName());
			request.getSession().setAttribute("userSession",sb);
			return"jsp/frame";
		}else{
			request.setAttribute("error","账号或密码有误！");
			return "login";
		}
	}
	/**
	 * 退出系统
	 * @param request
	 * @return
	 */
	@RequestMapping("/DelServlet1")
	public String DelServlet1(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "login";
	}
	/**
	 * 查询全部用户信息
	 */
	@RequestMapping("/QueryUserSerlvet1")
	public String QueryUserSerlvet1(HttpServletRequest request){
		String queryname = request.getParameter("queryname");
		String queryUserRole = request.getParameter("queryUserRole");
		Integer ye = 1;
		String pageIndex = request.getParameter("pageIndex");
		if(pageIndex!=null){
			ye = Integer.valueOf(pageIndex);
		}
		/*if("".equals(queryname)){
			queryname=null;
		}
		if("".equals(queryUserRole)&&queryUserRole.equals("0")){
			queryUserRole=null;
		}*/
		if(queryUserRole!=null){
			request.setAttribute("queryUserRole",queryUserRole);
		}
		//queryname = new String(queryname.getBytes("ISO-8859-1"),"UTF-8");
		//queryUserRole = new String(queryUserRole.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("第一个"+queryname+"\t第二个"+queryUserRole+"pageIndex"+pageIndex);
		System.out.println("第一个"+queryname+"\t第二个"+queryUserRole+"ye"+ye);
		//List<SmbmsUser> list = new UserImpl().t2();//查询全部用户信息
		//request.setAttribute("userList",list);
		Pager pager = new Pager();
		int aaw =  userImpl.t10(queryname,queryUserRole);//查询总条数
		int aae = userImpl.t11(queryname,queryUserRole);//查询总页数
		if(ye>aae){
			ye=aae;
		}
		pager.setTotalCount(aaw);//总条数
		request.setAttribute("totalCount",aaw);
		pager.setTotalPageCount(aae);//总页数
		request.setAttribute("totalPageCount",aae);
		pager.setCurrentPageNo(ye);
		request.setAttribute("currentPageNo",ye);//当前页数
		//System.out.println(queryname+"111\t"+queryUserRole+"111\t"+pager);
		List<SmbmsUser> list = userImpl.t3(queryname,queryUserRole,pager);//根据条件查询全部信息
		request.setAttribute("userList",list);
		List<SmbmsRole> list1 = userImpl.t4();//查询角色信息
		request.setAttribute("roleList",list1);
		//request.getRequestDispatcher("jsp/userlist.jsp").forward(request, response);
		return "jsp/userlist";
	}
	/**
	 * 添加用户信息
	 * @throws IOException 
	 */
	@RequestMapping("/QueryCodeServlet1")
	public void QueryCodeServlet1(HttpServletRequest request,HttpServletResponse response) throws IOException{
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
			SmbmsUser sb = userImpl.t5(userCode);
			System.out.println(sb);
			if(sb!=null){
				num=10;
			}
			out.print(num);
		}else if("getrolelist".equals(method)){
			List<SmbmsRole> list = new ArrayList<SmbmsRole>();
			list = userImpl.t4();
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
			num = userImpl.t6(se);
			if(num>0){
				out.print("<script>alert('添加成功！');location.href='QueryUserSerlvet';</script>");
			}else{
				out.print("<script>alert('添加失败！');location.href='QueryUserSerlvet';</script>");
			}
		}
	}
	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/Upd1Servlet1")
	public void Upd1Servlet1(HttpServletRequest request, HttpServletResponse response)throws IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("userid");
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
		int num = userImpl.t8(sbe);
		if(num>0){
			out.print("<script>alert('修改成功！');location.href='QueryUserSerlvet1';</script>");
		}else{
			out.print("<script>alert('修改失败！');location.href='QueryUserSerlvet1';</script>");
		}
	}
	/**
	 * 根据id查询用户信息，传递到查询页面与修改页面
	 */
	@RequestMapping("/QueryIdUser")
	public String UpdServlet1(HttpServletRequest request, HttpServletResponse response)throws IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		System.out.println("method"+method);
		String userid = request.getParameter("uid");
		System.out.println("ddd"+userid);
		SmbmsUser ste = userImpl.t7(userid);
		//System.out.println("dddd"+ste.getUserName());
		request.setAttribute("user",ste);
		if("view".equals(method)){
			System.out.println("查看");
		return "jsp/userview";	//查看
		}
		if("xiu".equals(method)){
		return "jsp/usermodify";
		}
		return null;
	}
	/**
	 * 修改用户信息
	 */
//	@RequestMapping("Upd1Servlet")
//	public String Upd1Servlet(HttpServletRequest request, HttpServletResponse response)throws IOException{
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		return "QueryUserSerlvet1";
//	}
}
