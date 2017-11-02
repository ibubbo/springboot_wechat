package cn.ibubbo.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 12:03
 */
@Getter
public enum ProductStatusEnum {

    /** 商品状态枚举. */
    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    /** 商品状态. */
    private Integer code;

    /** 商品状态详情. */
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
