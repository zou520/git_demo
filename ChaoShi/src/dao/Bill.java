package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.Smbmsprovider;

public interface Bill {
	public List<SmbmsBill> query2();
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	public List<SmbmsBill> query(@Param("queryProductName") String queryProductName,@Param("name") String name,@Param("parment") String parment,@Param("pagesize")Integer pagesize);
	/**
	 * ����������ѯ��Ϣ����
	 * @return
	 */                            
	public int queryCount(@Param("name") String name,@Param("parment") String parment,@Param("queryProductName") String queryProductName);
	/**
	 * ��ѯ��Ӧ������
	 * @return
	 */
	public List<Smbmsprovider> query1();
	
}
