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
		String pagesize = request.getParameter("pageIndex");//�ڼ�ҳ
		String name = request.getParameter("queryProviderId");//��Ӧ������
		String parment = request.getParameter("queryIsPayment");//�Ƿ񸶿�
		
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
		System.out.println("��һ��"+name+"\t�ڶ���"+parment+"\tpageIndex"+pagesize+"\tqueryProductName"+queryProductName);
		System.out.println("��һ��"+name+"\t�ڶ���"+parment+"\tqueryProductName"+queryProductName+"\tye"+ye);
//		List<SmbmsBill> list = ba.query2();
		List<SmbmsBill> list = ba.query(name,parment,ye,queryProductName);//ģ����ѯ������Ϣ
		//request.setAttribute("userList",list);
		Pager pager = new Pager();
		int aaw =  ba.t3(name,parment,queryProductName);//��ѯ������
		int aae =ba.t2(name, parment,queryProductName);//��ѯ��ҳ��
		if(ye>aae){
			ye=aae;
		}
		pager.setTotalCount(aaw);//������
		request.setAttribute("totalCount",aaw);
		pager.setTotalPageCount(aae);//��ҳ��
		request.setAttribute("totalPageCount",aae);
		pager.setCurrentPageNo(ye);
		request.setAttribute("currentPageNo",ye);//��ǰҳ��
		request.setAttribute("billList",list);//��ѯȫ��������Ϣ
		List<Smbmsprovider> list1 = ba.t1();//��ѯ��Ӧ����Ϣ
		request.setAttribute("providerList",list1);
		return "jsp/billlist";
	}
}
