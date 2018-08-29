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
 * ���,��ѯ��Ӧ����Ϣ
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
		String proCode = request.getParameter("proCode");//���
		String proName = request.getParameter("proName");//����
		String proContact = request.getParameter("proContact");//��ϵ��
		String proPhone = request.getParameter("proPhone");//�绰����
		String proAddress = request.getParameter("proAddress");//��ַ
		String proFax = request.getParameter("proFax");//����
		String proDesc = request.getParameter("proDesc");//����
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
				out.print("<script>alert('��ӳɹ���');location.href='QueryproNameServlet';</script>");
			}else{
				out.print("<script>alert('���ʧ�ܣ�');location.href='QueryproNameServlet';</script>");
			}
		}
	}

}
