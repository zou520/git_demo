package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �û���
 * @author Administrator
 *
 */
public class SmbmsUser {
	
		private Integer id;//id
		private String userCode;//�û�����
		private String userName;//�û�����
		private String userPassword;//�û�����
		private Integer gender;//�Ա�
		private Date birthday;//��������
		private String phone;//�绰
		private String address;//��ַ
		private Integer userRole;//�û���ɫ
		private Integer createdBy;//������
		private Date creationDate;//����ʱ��
		private Integer modifyBy;//������
		private Date modifyDate;//����ʱ��
		private Integer age;//����
		private String userRoleName;//�û���ɫ
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getUserRoleName() {
			return userRoleName;
		}
		public void setUserRoleName(String userRoleName) {
			this.userRoleName = userRoleName;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserCode() {
			return userCode;
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public Integer getGender() {
			return gender;
		}
		public void setGender(Integer gender) {
			this.gender = gender;
		}
		public String getBirthday() {
			return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Integer getUserRole() {
			return userRole;
		}
		public void setUserRole(Integer userRole) {
			this.userRole = userRole;
		}
		public Integer getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(Integer createdBy) {
			this.createdBy = createdBy;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Integer getModifyBy() {
			return modifyBy;
		}
		public void setModifyBy(Integer modifyBy) {
			this.modifyBy = modifyBy;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}
}
