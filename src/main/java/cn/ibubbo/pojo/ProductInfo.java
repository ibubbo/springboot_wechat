package cn.ibubbo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品原型
 * @author: uncle
 * @apdateTime: 2017-11-02 10:30
 */
@Entity
@Data
public class ProductInfo {
    @Id
    /** 商品ID. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品库存. */
    private Integer productStock;

    /** 商品描述. */
    private String productDescription;

    /** 商品小图. */
    private String productIcon;

    /** 商品状态: 0 正常  1 下架. */
    private Integer productStatus;

    /** 类目编号(*) . */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;


}