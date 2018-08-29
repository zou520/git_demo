package dao;

import java.util.List;
import java.util.Map;

import entity.Smbmsprovider;


public interface ProviderMapper {
	/**
	 * 根据供应商编号，名称查询
	 * @return
	 */
	public List<Smbmsprovider> query(Map map);
	/**
	 * 添加供应商信息
	 * @param sm
	 * @return
	 */
	public int addSmbmsprovider(Smbmsprovider sm);
}
