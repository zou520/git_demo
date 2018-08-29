package dao;

import java.util.List;
import java.util.Map;

import entity.Pager;
import entity.SmbmsRole;
import entity.SmbmsUser;

public interface UserMapper {
	/**
	 * ��ѯ�û��Ƿ����
	 * @param name
	 * @param pwd
	 * @return
	 */
	public SmbmsUser query1(SmbmsUser smbmsUser);
	/**
	 * ��ѯȫ���û���Ϣ
	 * @return
	 */
	public List<SmbmsUser> query();
	/**
	 * ��������,�û���ɫ��ѯ��Ϣ
	 * @param name
	 * @return
	 */
	public List<SmbmsUser> queryName(Map map);
	/**
	 * ��ѯȫ����ɫ����
	 * @return
	 */
	public List<SmbmsRole> queryRoleName();
	/**
	 * �жϱ����Ƿ����
	 * @param Code
	 * @return
	 */
	public SmbmsUser queryCode(String Code);
	/**
	 * ����û���Ϣ
	 * @param smbmsUser
	 * @return
	 */
	public int addUser(SmbmsUser smbmsUser);
	/**
	 * ����Id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	public SmbmsUser QueryId(String id);
	/**
	 * ����id�޸��û���Ϣ
	 * @param smbmsUser
	 * @return
	 */
	public int add1User(SmbmsUser smbmsUser);
	/**
	 * ɾ���û���Ϣ
	 * @param iite
	 * @return
	 */
	public int DelUser(List<Integer> iitet);
	/**
	 * �����û���Ϣ������
	 * @param pager
	 * @return
	 */
	public int queryCount(Map map);
	/**
	 * �޸��û�����
	 * @param map
	 * @return
	 */
	public int updPwd(Map map);
}
