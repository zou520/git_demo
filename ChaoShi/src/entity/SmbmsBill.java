package entity;
import java.util.Date;
/**
 * 订单表
 * @author Administrator
 *
 */
public class SmbmsBill {
	private Integer id;//主键
	private String billCode;//订单编码
	private	String productName;//商品名称
	private	String productDesc;//商品描述
	private	String productUnit;//商品单位
	private	double productCount;//商品数量
	private double totalPrice;//商品总额
	private Integer isPayment;   //是否支付（1表示未支付，2表示已支付）
	private Integer providerId; //供应商ID 
	private	Integer createdBy;//创建者ID
	private	Date creationDate;//创建时间
	private	Integer modifyBy;//更新者ID
	private	Date modifyDate;//更新时间
	private String providerName;//供应商名称
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	//private Smbmsprovider smbmsprovider;//供应商表
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
