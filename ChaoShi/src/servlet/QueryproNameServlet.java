package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Smbmsprovider;
import service.SmbmsproviderImpl;

/**
 * 根据条件查询供应商信息
 * Servlet implementation class QueryproNameServlet
 */
public class QueryproNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryproNameServlet() {
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
		String proCode = request.getParameter("queryProCode");
		String proName = request.getParameter("queryProName");
		List<Smbmsprovider> list = new SmbmsproviderImpl().t1(proCode,proName);
		request.setAttribute("providerList",list);
		request.getRequestDispatcher("jsp/providerlist.jsp").forward(request, response);
	}

}
