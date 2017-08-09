package com.crud.product.model;

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
@Table(name = "Product")
public class ProductModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String stock;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date createdOn;
	@Transient
	private List<String> offerList;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return the offerList
	 */
	public List<String> getOfferList() {
		return offerList;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @param offerList
	 *            the offerList to set
	 */
	public void setOfferList(List<String> offerList) {
		this.offerList = offerList;
	}

}