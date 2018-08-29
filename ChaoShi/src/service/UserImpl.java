package service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMapper;
import entity.Pager;
import entity.SmbmsRole;
import entity.SmbmsUser;
import uril.MyBatisUtil;
@Service("UserMapper")
public class UserImpl {
	@Autowired
	private UserMapper userMapper;
	//Logger logger = Logger.getLogger("UserImpl");
	/**
	 * ��ѯ�û��Ƿ����
	 * @param name
	 * @param pwd
	 * @return
	 */
	public SmbmsUser query1(SmbmsUser smbmsUser) {
		SmbmsUser sb= userMapper.query1(smbmsUser);
		return sb;
//		//return userMapper.query1(smbmsUser);
//		SqlSession sqlSession = null;
//		SmbmsUser sb = null;
//		try {
//			//��������
//			sqlSession = MyBatisUtil.createSqlSession();
//			SmbmsUser sbs = new SmbmsUser();
//			sbs.setUserCode(name);
//			sbs.setUserPassword(pwd);
//			//���÷�����ѯ����
//			sb = sqlSession.getMapper(dao.UserMapper.class).query1(sbs);
//			System.out.println("sb="+sb);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			//�ر�����1
//			MyBatisUtil.closeSqlSession(sqlSession);
//		}
//		return sb;
	}
	/**
	 * ��ѯȫ���û�
	 * @return
	 */
	//@Test
	public List<SmbmsUser> t2(){
		List<SmbmsUser> list = userMapper.query();
		return list;
//		List<SmbmsUser> list = new ArrayList<SmbmsUser>();
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			list = session.getMapper(dao.UserMapper.class).query();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
//		return list;
	}
	/**
	 * ����������ѯȫ���û�
	 * @param name
	 * @param rolgname
	 * @return
	 */
	//@Test
	public List<SmbmsUser> t3(String name,String rolgname,Pager pager){
		//List<SmbmsUser> list = new ArrayList<SmbmsUser>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name",name);
		map.put("rolgname",rolgname);
		map.put("currentPageNo",(pager.getCurrentPageNo()-1)*5);
		List<SmbmsUser> list = userMapper.queryName(map);
//		System.out.println(name+"\t"+rolgname+"\t"+(pager.getCurrentPageNo()-1)*5);
//		System.out.println("1name="+name+"1rolgname="+rolgname+"1pager="+pager.getCurrentPageNo());
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			list = session.getMapper(dao.UserMapper.class).queryName(map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return list;
	}
	/**
	 * ��ѯ��ɫ��Ϣ
	 * @return
	 */
	//@Test
	public List<SmbmsRole> t4(){
		List<SmbmsRole> list = null;
		SqlSession session = null;
		list = userMapper.queryRoleName();
//		try {
//			session = MyBatisUtil.createSqlSession();
//			list = session.getMapper(dao.UserMapper.class).queryRoleName();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return list;
	}
	/**
	 * ��ѯ�����Ƿ����
	 * @return
	 */
	//@Test
	public SmbmsUser t5(String Code){
		SmbmsUser li = null;
		li = userMapper.queryCode(Code);
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			li = session.getMapper(dao.UserMapper.class).queryCode(Code);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return li;
	}
	/**
	 * ����û���Ϣ
	 * @param Code
	 * @return
	 */
	//@Test
	public int t6(SmbmsUser smbmsUser){
		int num =0;
		num = userMapper.addUser(smbmsUser);
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			num = session.getMapper(dao.UserMapper.class).addUser(smbmsUser);
//			session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.rollback();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return num;
	}
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param Code
	 * @return
	 */
	//@Test
	public SmbmsUser t7(String id){
		SmbmsUser sb =null;
		sb = userMapper.QueryId(id);
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			sb = session.getMapper(dao.UserMapper.class).QueryId(id);
//			//session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			//session.rollback();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return sb;
	}
	/**
	 * ����id�޸��û���Ϣ
	 * @param Code
	 * @return
	 */
	//@Test
	public int t8(SmbmsUser smbmsUser){
		int num =0;
		num = userMapper.add1User(smbmsUser);
//		SqlSession session = null;
//		try {
//			System.out.println(smbmsUser.getAddress());
//			session = MyBatisUtil.createSqlSession();
//			System.out.println(smbmsUser.getModifyBy());
//			System.out.println(smbmsUser.getModifyDate());
//			num = session.getMapper(dao.UserMapper.class).add1User(smbmsUser);
//			session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.rollback();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return num;
	}
	/**
	 * ɾ���û���Ϣ
	 * @param smbmsUser
	 * @return
	 */
	//@Test
	public int t9(List<Integer> iitet){
		int num =0;
		num = userMapper.DelUser(iitet);
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			num = session.getMapper(dao.UserMapper.class).DelUser(iitet);
//			//session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			//session.rollback();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		return num;
	}
		/**
		 * ���㹲�ж���������
		 * @return
		 */
		//@Test
		public int t10(String name,String rolgname){
		int num =0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name",name);
		map.put("rolgname",rolgname);
		num = userMapper.queryCount(map);
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.createSqlSession();
//			num = session.getMapper(dao.UserMapper.class).queryCount(map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			MyBatisUtil.closeSqlSession(session);
//		}
		System.out.println("������="+num);
		return num;
	}
		/**
		 * ��ѯ��ҳ��
		 * @return
		 */
		//@Test
		public int t11(String name,String rolgname){
			int num =0;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name",name);
			map.put("rolgname",rolgname);
			System.out.println(name+"name\trolgname"+rolgname);
//			SqlSession session = null;
//			try {
//				session = MyBatisUtil.createSqlSession();
//				int num1 = session.getMapper(dao.UserMapper.class).queryCount(map);
			int num1 = userMapper.queryCount(map);
				num = num1%5==0?num1/5:(num1/5)+1;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally{
//				MyBatisUtil.closeSqlSession(session);
//			}
			System.out.println("��ҳ��="+num);
			return num;
		}
		/**
		 * ����Id�޸��û�����
		 * @param userPassword
		 * @param id
		 * @return
		 */
		//@Test
		public int t12(String userPassword,Integer id){
			int num =0;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userPassword",userPassword);
			map.put("id",id);
			num = userMapper.updPwd(map);
//			SqlSession sqlSession = null;
//			try {
//				sqlSession = MyBatisUtil.createSqlSession();
//				num = sqlSession.getMapper(dao.UserMapper.class).updPwd(map);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally{
//				MyBatisUtil.closeSqlSession(sqlSession);
//			}
			return num;
		}
}
