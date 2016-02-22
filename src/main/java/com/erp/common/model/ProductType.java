package com.erp.common.model;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

@Alias("ProductType")
public class ProductType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.group_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private String groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.type_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private String typeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.name
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.unit
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.ref_in_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private BigDecimal refInPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.ref_out_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private BigDecimal refOutPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.dec_no
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private Short decNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_product_type.remark
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private String remark;
    
    private String norm;

    /**
     * 
     *  类别记录
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    private ProductGroup productGroup;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.group_id
     *
     * @return the value of tb_product_type.group_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.group_id
     *
     * @param groupId the value for tb_product_type.group_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.type_id
     *
     * @return the value of tb_product_type.type_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.type_id
     *
     * @param typeId the value for tb_product_type.type_id
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.name
     *
     * @return the value of tb_product_type.name
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.name
     *
     * @param name the value for tb_product_type.name
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.unit
     *
     * @return the value of tb_product_type.unit
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.unit
     *
     * @param unit the value for tb_product_type.unit
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.ref_in_price
     *
     * @return the value of tb_product_type.ref_in_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public BigDecimal getRefInPrice() {
        return refInPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.ref_in_price
     *
     * @param refInPrice the value for tb_product_type.ref_in_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setRefInPrice(BigDecimal refInPrice) {
        this.refInPrice = refInPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.ref_out_price
     *
     * @return the value of tb_product_type.ref_out_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public BigDecimal getRefOutPrice() {
        return refOutPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.ref_out_price
     *
     * @param refOutPrice the value for tb_product_type.ref_out_price
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setRefOutPrice(BigDecimal refOutPrice) {
        this.refOutPrice = refOutPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.dec_no
     *
     * @return the value of tb_product_type.dec_no
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public Short getDecNo() {
        return decNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.dec_no
     *
     * @param decNo the value for tb_product_type.dec_no
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setDecNo(Short decNo) {
        this.decNo = decNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_product_type.remark
     *
     * @return the value of tb_product_type.remark
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_product_type.remark
     *
     * @param remark the value for tb_product_type.remark
     *
     * @mbggenerated Fri Feb 19 11:42:38 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_product_type.norm
	 * @return  the value of tb_product_type.norm
	 * @mbggenerated  Sat Feb 20 11:00:37 CST 2016
	 */
	public String getNorm() {
		return norm;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_product_type.norm
	 * @param norm  the value for tb_product_type.norm
	 * @mbggenerated  Sat Feb 20 11:00:37 CST 2016
	 */
	public void setNorm(String norm) {
		this.norm = norm;
	}
	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}
}