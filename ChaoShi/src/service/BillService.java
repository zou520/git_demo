package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Bill;
import entity.SmbmsBill;
import entity.Smbmsprovider;
import uril.MyBatisUtil;
@Service("Bill")
public class BillService {
	@Autowired
	private Bill bill;
	//@Test
	public List<SmbmsBill> query2(){
		List<SmbmsBill> list = bill.query2();
		return list;
	}
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	//@Test
	public List<SmbmsBill> query(String name,String parment,Integer pagesize,String queryProductName){
		pagesize = (pagesize-1)*5;
		List<SmbmsBill> list = bill.query(queryProductName,name,parment,pagesize);
		return list;
	}
	/**
	 * ��ѯ��Ӧ����Ϣ
	 * @return
	 */
	public List<Smbmsprovider> t1(){
		List<Smbmsprovider> list = bill.query1();
		return list;
	}
	/**
	 * ��ѯ��ҳ��
	 * @return
	 */
	public int t2(String name,String parment,String queryProductName){
		int num =0;
		int num1 = bill.queryCount(name,parment,queryProductName);
			num = num1%5==0?num1/5:(num1/5)+1;
			System.out.println("��С"+num);
		return num;
	} 
	/**
	 * ��ѯ���ж���������
	 */
	public int t3(String name,String parment,String queryProductName){
		int num = bill.queryCount(name,parment,queryProductName);
		System.out.println("����"+num);
		return num;
	}
}
