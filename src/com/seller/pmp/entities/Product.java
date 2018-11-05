package com.seller.pmp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "pmp")
public class Product {

	@Id
	@Column(name = "product_id")
	private int product_id;

	@Column(name = "name")
	private String name;

	@Column(name = "short_description")
	private String short_description;

	@Column(name = "long_description")
	private String long_description;

	@Column(name = "dimensions")
	private String dimensions;

	@Column(name = "categories")
	private String categories;

	@Column(name = "mrp")
	private double mrp;

	@Column(name = "ssp")
	private double ssp;

	@Column(name = "ymp")
	private double ymp;

	@Column(name = "usage_inst_file")
	private String usage_inst_file;

	@Column(name = "image_dir")
	private String image_dir;

	@Column(name = "primary_image")
	private String primary_image;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Seller seller;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getSsp() {
		return ssp;
	}

	public void setSsp(double ssp) {
		this.ssp = ssp;
	}

	public double getYmp() {
		return ymp;
	}

	public void setYmp(double ymp) {
		this.ymp = ymp;
	}

	public String getUsage_inst_file() {
		return usage_inst_file;
	}

	public void setUsage_inst_file(String usage_inst_file) {
		this.usage_inst_file = usage_inst_file;
	}

	public String getImage_dir() {
		return image_dir;
	}

	public void setImage_dir(String image_dir) {
		this.image_dir = image_dir;
	}

	public String getPrimary_image() {
		return primary_image;
	}

	public void setPrimary_image(String primary_image) {
		this.primary_image = primary_image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	
}
