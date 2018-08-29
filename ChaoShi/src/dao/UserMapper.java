package dao;

import java.util.List;
import java.util.Map;

import entity.Pager;
import entity.SmbmsRole;
import entity.SmbmsUser;

public interface UserMapper {
	/**
	 * 查询用户是否存在
	 * @param name
	 * @param pwd
	 * @return
	 */
	public SmbmsUser query1(SmbmsUser smbmsUser);
	/**
	 * 查询全部用户信息
	 * @return
	 */
	public List<SmbmsUser> query();
	/**
	 * 根据名称,用户角色查询信息
	 * @param name
	 * @return
	 */
	public List<SmbmsUser> queryName(Map map);
	/**
	 * 查询全部角色名称
	 * @return
	 */
	public List<SmbmsRole> queryRoleName();
	/**
	 * 判断编码是否存在
	 * @param Code
	 * @return
	 */
	public SmbmsUser queryCode(String Code);
	/**
	 * 添加用户信息
	 * @param smbmsUser
	 * @return
	 */
	public int addUser(SmbmsUser smbmsUser);
	/**
	 * 根据Id查询用户信息
	 * @param id
	 * @return
	 */
	public SmbmsUser QueryId(String id);
	/**
	 * 根据id修改用户信息
	 * @param smbmsUser
	 * @return
	 */
	public int add1User(SmbmsUser smbmsUser);
	/**
	 * 删除用户信息
	 * @param iite
	 * @return
	 */
	public int DelUser(List<Integer> iitet);
	/**
	 * 计算用户信息总数量
	 * @param pager
	 * @return
	 */
	public int queryCount(Map map);
	/**
	 * 修改用户密码
	 * @param map
	 * @return
	 */
	public int updPwd(Map map);
}
