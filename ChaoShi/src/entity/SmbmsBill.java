package entity;
import java.util.Date;
/**
 * ������
 * @author Administrator
 *
 */
public class SmbmsBill {
	private Integer id;//����
	private String billCode;//��������
	private	String productName;//��Ʒ����
	private	String productDesc;//��Ʒ����
	private	String productUnit;//��Ʒ��λ
	private	double productCount;//��Ʒ����
	private double totalPrice;//��Ʒ�ܶ�
	private Integer isPayment;   //�Ƿ�֧����1��ʾδ֧����2��ʾ��֧����
	private Integer providerId; //��Ӧ��ID 
	private	Integer createdBy;//������ID
	private	Date creationDate;//����ʱ��
	private	Integer modifyBy;//������ID
	private	Date modifyDate;//����ʱ��
	private String providerName;//��Ӧ������
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	//private Smbmsprovider smbmsprovider;//��Ӧ�̱�
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public double getProductCount() {
		return productCount;
	}
	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
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
//	public Smbmsprovider getSmbmsprovider() {
//		return smbmsprovider;
//	}
//	public void setSmbmsprovider(Smbmsprovider smbmsprovider) {
//		this.smbmsprovider = smbmsprovider;
//	}
}
