package com.wf.ssm.entity;

import java.util.Date;
import com.wf.ssm.common.persistence.DataEntity;

/**
 * <P>商品信息</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午3:26:10
 */
public class Products extends DataEntity<Products> {
	private static final long serialVersionUID = -3453104973828470265L;

	private String name;

    private Float price;

    private String pic;

    private Date createtime;

    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}