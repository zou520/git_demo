package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SmbmsUser;
import entity.Smbmsprovider;
import service.SmbmsproviderImpl;

/**
 * 添加,查询供应商信息
 * Servlet implementation class AddProviderServlet
 */
public class AddProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProviderServlet() {
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
		String method = request.getParameter("method");
		if("dit".equals(method)){
		String proCode = request.getParameter("proCode");//编号
		String proName = request.getParameter("proName");//名称
		String proContact = request.getParameter("proContact");//联系人
		String proPhone = request.getParameter("proPhone");//电话号码
		String proAddress = request.getParameter("proAddress");//地址
		String proFax = request.getParameter("proFax");//传真
		String proDesc = request.getParameter("proDesc");//描述
		SmbmsUser sb = (SmbmsUser) request.getSession().getAttribute("userSession");
		int createdBy =sb.getId();
		System.out.println(proCode+"\t"+proName+"\t"+proContact+"\t"+proPhone+"\t"+proAddress+"\t"+proFax+"\t"+proDesc+"\t"+createdBy);
		Smbmsprovider sm = new Smbmsprovider();
		sm.setCreatedBy(createdBy);
		sm.setCreationDate(new Date());
		sm.setProAddress(proAddress);
		sm.setProCode(proCode);
		sm.setProContact(proContact);
		sm.setProDesc(proDesc);
		sm.setProFax(proFax);
		sm.setProName(proName);
		sm.setProPhone(proPhone);
		int num = new SmbmsproviderImpl().t2(sm);
		if(num>0){
				out.print("<script>alert('添加成功！');location.href='QueryproNameServlet';</script>");
			}else{
				out.print("<script>alert('添加失败！');location.href='QueryproNameServlet';</script>");
			}
		}
	}

}
