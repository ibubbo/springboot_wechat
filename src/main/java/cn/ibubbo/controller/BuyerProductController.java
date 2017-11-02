package cn.ibubbo.controller;

import cn.ibubbo.pojo.ProductCategory;
import cn.ibubbo.pojo.ProductInfo;
import cn.ibubbo.service.ProductCategoryService;
import cn.ibubbo.service.ProductInfoService;
import cn.ibubbo.vo.ProductInfoVo;
import cn.ibubbo.vo.ProductVo;
import cn.ibubbo.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: uncle
 * @apdateTime: 2017-11-02 13:26
 */
@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    @Resource
    private ProductCategoryService categoryService;

    @Resource
    private ProductInfoService infoService;

    /**
     * 返回商品详情
     */
    @GetMapping("/list")
    public ResultVo list() {

        List<ProductVo> totalList = new ArrayList<>();
        ProductVo productVo = null;
        ProductInfoVo productInfoVo = null;

        // 1. 查询所有的上架商品
        List<ProductInfo> infoList = infoService.findByProductStatus();
        // 2. 查询类目(一次性查询)
        List<Integer> categoryTypeList = infoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        for(ProductCategory category : categoryList) {
            productVo = new ProductVo();
            productVo.setCategoryName(category.getCategoryName());
            productVo.setCategoryType(category.getCategoryType());

            List<ProductInfoVo> productInfoList = new ArrayList<>();
            for (ProductInfo productInfo : infoList) {
                if (category.getCategoryType().equals(productInfo.getCategoryType())) {
                    productInfoVo = new ProductInfoVo();
                    // 可以把一个对象的属性值copy到指定对象上，这里是把 productInfo 的值拷贝到对应的 productInfoVo
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoList.add(productInfoVo);
                    break;
                }
                continue;
            }
            productVo.setProductInfoVoList(productInfoList);
            totalList.add(productVo);
        }

        return ResultVo.success(totalList);
    }

}
