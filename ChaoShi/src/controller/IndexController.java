package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Pager;
import entity.SmbmsBill;
import entity.Smbmsprovider;
import service.BillService;
import service.UserImpl;
@Controller
public class IndexController {
	@Autowired
	@Qualifier("Bill")
	private BillService ba;
	@RequestMapping("/bill")
	public String bill(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String queryProductName = request.getParameter("queryProductName");
		String pagesize = request.getParameter("pageIndex");//第几页
		String name = request.getParameter("queryProviderId");//供应商名称
		String parment = request.getParameter("queryIsPayment");//是否付款
		
		Integer ye =1;
		if(pagesize!=null){
			ye=Integer.valueOf(pagesize);
		}
		System.out.println("***********************************");
		if(queryProductName!=null){
			//System.out.println("fdsf"+queryProductName);
			request.getSession().setAttribute("queryProductName",queryProductName);
		}
		/*if("0".equals(queryProductName)){
			queryProductName="";
		}*/
		if(name!=null){
			//request.getSession().setAttribute("queryProviderId",name);
			request.setAttribute("queryProviderId",name);
		}if(parment!=null){
			//request.getSession().setAttribute("queryIsPayment",parment);
			request.setAttribute("queryIsPayment",parment);
		}
		System.out.println("第一个"+name+"\t第二个"+parment+"\tpageIndex"+pagesize+"\tqueryProductName"+queryProductName);
		System.out.println("第一个"+name+"\t第二个"+parment+"\tqueryProductName"+queryProductName+"\tye"+ye);
//		List<SmbmsBill> list = ba.query2();
		List<SmbmsBill> list = ba.query(name,parment,ye,queryProductName);//模糊查询订单信息
		//request.setAttribute("userList",list);
		Pager pager = new Pager();
		int aaw =  ba.t3(name,parment,queryProductName);//查询总条数
		int aae =ba.t2(name, parment,queryProductName);//查询总页数
		if(ye>aae){
			ye=aae;
		}
		pager.setTotalCount(aaw);//总条数
		request.setAttribute("totalCount",aaw);
		pager.setTotalPageCount(aae);//总页数
		request.setAttribute("totalPageCount",aae);
		pager.setCurrentPageNo(ye);
		request.setAttribute("currentPageNo",ye);//当前页数
		request.setAttribute("billList",list);//查询全部订单信息
		List<Smbmsprovider> list1 = ba.t1();//查询供应商信息
		request.setAttribute("providerList",list1);
		return "jsp/billlist";
	}
}
