package cn.ibubbo.vo;

import cn.ibubbo.pojo.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 13:50
 */
@Data
public class ProductVo {

    /** 类目名 .*/
    @JsonProperty(value = "name")
    private String categoryName;

    /** 类目编号 .*/
    @JsonProperty(value = "type")
    private Integer categoryType;

    /** 商品详情 .*/
    @JsonProperty(value = "foods")
    private List<ProductInfoVo> productInfoVoList;

    /**
     * 返回商品(包含类目)
     *
     * @param categoryName 类目名称
     * @param categoryType 类目编号
     * @param productInfoVoList 商品
     */
    public ProductVo(String categoryName, Integer categoryType, List<ProductInfoVo> productInfoVoList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVoList = productInfoVoList;
    }

    public ProductVo() {}
}
