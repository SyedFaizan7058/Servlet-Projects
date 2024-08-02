package com.test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookBean implements Serializable {

	private String code, name, author;
	private Float price;
	private Integer qty;

	public BookBean() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "BookBean [code=" + code + ", name=" + name + ", author=" + author + ", price=" + price + ", qty=" + qty
				+ "]";
	}

}
