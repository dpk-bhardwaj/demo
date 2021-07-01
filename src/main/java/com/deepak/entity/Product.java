package com.deepak.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "B2C_PRDCT")
@JsonIgnoreProperties({"brandId" , "colorId" , "catagoryId","hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

	private Integer id;
	private String name;
	private Integer quantity;
	private String size;


	private Brand brandId;

	private Color colorId;

	private ProductCategory catagoryId;

	@Id
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRND_ID")
	public Brand getBrandId() {
		return brandId;
	}

	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLR_ID")
	public Color getColorId() {
		return colorId;
	}

	public void setColorId(Color colorId) {
		this.colorId = colorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRDCT_CTGR_ID")
	public ProductCategory getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(ProductCategory catagoryId) {
		this.catagoryId = catagoryId;
	}

}
