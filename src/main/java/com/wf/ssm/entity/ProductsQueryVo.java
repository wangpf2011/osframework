package com.wf.ssm.entity;

/**
 * <P>商品信息包装对象</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午3:26:30
 */
public class ProductsQueryVo {
	//商品信息
	private Products products;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ProductsCustom productsCustom;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public ProductsCustom getProductsCustom() {
		return productsCustom;
	}

	public void setProductsCustom(ProductsCustom productsCustom) {
		this.productsCustom = productsCustom;
	}
}
