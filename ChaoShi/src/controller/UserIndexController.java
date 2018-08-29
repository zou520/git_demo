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
	 * �ж��û��Ƿ����
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
			request.setAttribute("error","�˺Ż���������");
			return "login";
		}
	}
	/**
	 * �˳�ϵͳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/DelServlet1")
	public String DelServlet1(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "login";
	}
	/**
	 * ��ѯȫ���û���Ϣ
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
		System.out.println("��һ��"+queryname+"\t�ڶ���"+queryUserRole+"pageIndex"+pageIndex);
		System.out.println("��һ��"+queryname+"\t�ڶ���"+queryUserRole+"ye"+ye);
		//List<SmbmsUser> list = new UserImpl().t2();//��ѯȫ���û���Ϣ
		//request.setAttribute("userList",list);
		Pager pager = new Pager();
		int aaw =  userImpl.t10(queryname,queryUserRole);//��ѯ������
		int aae = userImpl.t11(queryname,queryUserRole);//��ѯ��ҳ��
		if(ye>aae){
			ye=aae;
		}
		pager.setTotalCount(aaw);//������
		request.setAttribute("totalCount",aaw);
		pager.setTotalPageCount(aae);//��ҳ��
		request.setAttribute("totalPageCount",aae);
		pager.setCurrentPageNo(ye);
		request.setAttribute("currentPageNo",ye);//��ǰҳ��
		//System.out.println(queryname+"111\t"+queryUserRole+"111\t"+pager);
		List<SmbmsUser> list = userImpl.t3(queryname,queryUserRole,pager);//����������ѯȫ����Ϣ
		request.setAttribute("userList",list);
		List<SmbmsRole> list1 = userImpl.t4();//��ѯ��ɫ��Ϣ
		request.setAttribute("roleList",list1);
		//request.getRequestDispatcher("jsp/userlist.jsp").forward(request, response);
		return "jsp/userlist";
	}
	/**
	 * ����û���Ϣ
	 * @throws IOException 
	 */
	@RequestMapping("/QueryCodeServlet1")
	public void QueryCodeServlet1(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		String userCode = request.getParameter("userCode");//�û�����
		String userName = request.getParameter("userName");//�û�����
		String userPassword = request.getParameter("userPassword");//�û�����
		String gender = request.getParameter("gender");//�Ա�
		String birthday = request.getParameter("birthday");//��������
		String phone = request.getParameter("phone");//�绰����
		String address = request.getParameter("address");//�û���ַ
		String userRole = request.getParameter("userRole");//�û���ɫ
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
//			String userCode = request.getParameter("userCode");//�û�����
//			String userName = request.getParameter("userName");//�û�����
//			String userPassword = request.getParameter("userPassword");//�û�����
//			String gender = request.getParameter("gender");//�Ա�
//			String birthday = request.getParameter("birthday");//��������
//			String phone = request.getParameter("phone");//�绰����
//			String address = request.getParameter("address");//�û���ַ
//			String userRole = request.getParameter("userRole");//�û���ɫ
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Timestamp dateNow=new Timestamp(System.currentTimeMillis());
			Date reDate=new Date(System.currentTimeMillis());
			se.setCreationDate(reDate);//����ʱ��
			SmbmsUser sst=(SmbmsUser)request.getSession().getAttribute("userSession");
			//se.setCreatedBy(Integer.valueOf(sst.getId()));//������Id
			se.setCreatedBy(sst.getId());
			System.out.println(se.getCreatedBy());
			se.setUserCode(userCode);//�û����
			se.setUserName(userName);//�û�����
			se.setUserPassword(userPassword);//����
			se.setGender(Integer.valueOf(gender));//�Ա�
			se.setBirthday(java.sql.Date.valueOf(birthday));//��������
			se.setAddress(address);//��ַ
			se.setUserRole(Integer.valueOf(userRole));//��ɫ
			se.setPhone(phone);
			num = userImpl.t6(se);
			if(num>0){
				out.print("<script>alert('��ӳɹ���');location.href='QueryUserSerlvet';</script>");
			}else{
				out.print("<script>alert('���ʧ�ܣ�');location.href='QueryUserSerlvet';</script>");
			}
		}
	}
	/**
	 * �޸��û���Ϣ
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
		//se.setCreatedBy(Integer.valueOf(sst.getId()));//������Id
		
		System.out.println(uid+"\t"+userName+"\t"+gender+"\t"+birthday+"\t"+phone+"\t"+address+"\t"+userRole);
		SmbmsUser sbe = new SmbmsUser();
		sbe.setModifyDate(reDate);//����ʱ��
		sbe.setModifyBy(sst.getId());//������id
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
			out.print("<script>alert('�޸ĳɹ���');location.href='QueryUserSerlvet1';</script>");
		}else{
			out.print("<script>alert('�޸�ʧ�ܣ�');location.href='QueryUserSerlvet1';</script>");
		}
	}
	/**
	 * ����id��ѯ�û���Ϣ�����ݵ���ѯҳ�����޸�ҳ��
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
			System.out.println("�鿴");
		return "jsp/userview";	//�鿴
		}
		if("xiu".equals(method)){
		return "jsp/usermodify";
		}
		return null;
	}
	/**
	 * �޸��û���Ϣ
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
