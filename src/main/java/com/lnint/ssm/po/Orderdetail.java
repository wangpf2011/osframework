package com.lnint.ssm.po;

import com.lnint.ssm.common.persistence.DataEntity;

public class Orderdetail extends DataEntity<Orderdetail> {
	private static final long serialVersionUID = -6033296603649634626L;

	private String ordersId;

    private String itemsId;

    private Integer itemsNum;
    
    //明细对应的商品信息
    private Items items;

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
    
    public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
}