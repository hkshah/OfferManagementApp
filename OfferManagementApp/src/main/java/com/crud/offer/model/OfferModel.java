package com.crud.offer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Hardik Shah
 *
 */
@Entity
@Table(name = "Offer")
public class OfferModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	private String type;
	private float discount;
	private String product;
	@Transient
	private List<String> productList;

	/**
	 * @author Hardik Shah
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param product
	 *            the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the productList
	 */

	public List<String> getProductList() {
		return productList;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param productList
	 *            the productList to set
	 */
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}

}
