package service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import entity.Smbmsprovider;
import uril.MyBatisUtil;

public class SmbmsproviderImpl {
	/**
	 * ����������ѯ��Ӧ����Ϣ
	 */
	@Test
	public List<Smbmsprovider> t1(String proCode,String proName) {
		SqlSession sqlSession = null;
		Map<String,Object> map = new HashMap<>();
		map.put("proCode",proCode);
		map.put("proName",proName);
		List<Smbmsprovider> list = new ArrayList<>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			list = sqlSession.getMapper(dao.ProviderMapper.class).query(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return list;
	}
	/**
	 * ��ӹ�Ӧ����Ϣ
	 * @param sm
	 * @return
	 */
	@Test
	public int t2(Smbmsprovider sm){
		SqlSession sqlSession = null;
		int num =0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			num = sqlSession.getMapper(dao.ProviderMapper.class).addSmbmsprovider(sm);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return num;
	}
}
