package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserImpl;

/**
 * 删除用户信息
 * Servlet implementation class DelUserServlet
 */
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
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
		System.out.println("dopost.................5");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String[] ii = request.getParameter("uid").split(",");
		//Integer[] iit = new Integer[ii.length];
		List<Integer> iite =new ArrayList<>();
		for (String str : ii) {
			iite.add(Integer.valueOf(str));
		}
		/*for (int i = 0; i < ii.length; i++) {
			System.out.println("ii[i]="+ii[i]);
			iit[i]=Integer.valueOf(ii[i]);
			System.out.println("iit[i]="+iit[i]);
		}*/
		int num = new UserImpl().t9(iite);
		out.print(num);
	}

}
