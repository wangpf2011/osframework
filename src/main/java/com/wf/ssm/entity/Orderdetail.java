package com.wf.ssm.entity;

import com.wf.ssm.common.persistence.DataEntity;

/**
 * <P>订单详情</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午3:49:41
 */
public class Orderdetail extends DataEntity<Orderdetail> {
	private static final long serialVersionUID = -6033296603649634626L;

	private String ordersId;

    private String productsId;

    private Integer productsNum;
    
    //明细对应的商品信息
    private Products products;

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

	public String getProductsId() {
		return productsId;
	}

	public void setProductsId(String productsId) {
		this.productsId = productsId;
	}

	public Integer getProductsNum() {
		return productsNum;
	}

	public void setProductsNum(Integer productsNum) {
		this.productsNum = productsNum;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
}