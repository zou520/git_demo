package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.SmbmsBill;
import entity.Smbmsprovider;

public interface Bill {
	public List<SmbmsBill> query2();
	/**
	 * 查询订单信息
	 * @return
	 */
	public List<SmbmsBill> query(@Param("queryProductName") String queryProductName,@Param("name") String name,@Param("parment") String parment,@Param("pagesize")Integer pagesize);
	/**
	 * 根据条件查询信息条数
	 * @return
	 */                            
	public int queryCount(@Param("name") String name,@Param("parment") String parment,@Param("queryProductName") String queryProductName);
	/**
	 * 查询供应商名称
	 * @return
	 */
	public List<Smbmsprovider> query1();
	
}
