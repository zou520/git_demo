package dao;

import java.util.List;
import java.util.Map;

import entity.Smbmsprovider;


public interface ProviderMapper {
	/**
	 * ���ݹ�Ӧ�̱�ţ����Ʋ�ѯ
	 * @return
	 */
	public List<Smbmsprovider> query(Map map);
	/**
	 * ��ӹ�Ӧ����Ϣ
	 * @param sm
	 * @return
	 */
	public int addSmbmsprovider(Smbmsprovider sm);
}
