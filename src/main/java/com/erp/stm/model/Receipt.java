package com.erp.stm.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@SuppressWarnings("serial")
@Alias("Receipt")
public class Receipt implements Serializable{
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.depot_id
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String depotId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.receipt_no
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String receiptNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.type
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.status
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.registrant
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String registrant;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.auditor
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String auditor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.supplier
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String supplier;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.write_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private Date writeDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.confirm_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private Date confirmDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_receipt.remark
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.depot_id
	 * @return  the value of tb_receipt.depot_id
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getDepotId() {
		return depotId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.depot_id
	 * @param depotId  the value for tb_receipt.depot_id
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.receipt_no
	 * @return  the value of tb_receipt.receipt_no
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getReceiptNo() {
		return receiptNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.receipt_no
	 * @param receiptNo  the value for tb_receipt.receipt_no
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.type
	 * @return  the value of tb_receipt.type
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.type
	 * @param type  the value for tb_receipt.type
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.status
	 * @return  the value of tb_receipt.status
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.status
	 * @param status  the value for tb_receipt.status
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.registrant
	 * @return  the value of tb_receipt.registrant
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getRegistrant() {
		return registrant;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.registrant
	 * @param registrant  the value for tb_receipt.registrant
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.auditor
	 * @return  the value of tb_receipt.auditor
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getAuditor() {
		return auditor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.auditor
	 * @param auditor  the value for tb_receipt.auditor
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.supplier
	 * @return  the value of tb_receipt.supplier
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.supplier
	 * @param supplier  the value for tb_receipt.supplier
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.write_date
	 * @return  the value of tb_receipt.write_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public Date getWriteDate() {
		return writeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.write_date
	 * @param writeDate  the value for tb_receipt.write_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.confirm_date
	 * @return  the value of tb_receipt.confirm_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public Date getConfirmDate() {
		return confirmDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.confirm_date
	 * @param confirmDate  the value for tb_receipt.confirm_date
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_receipt.remark
	 * @return  the value of tb_receipt.remark
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_receipt.remark
	 * @param remark  the value for tb_receipt.remark
	 * @mbggenerated  Mon Feb 22 16:44:29 CST 2016
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
