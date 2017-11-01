package cn.ibubbo.service;

import cn.ibubbo.pojo.ProductCategory;

import java.util.List;

/**
 * 类目服务接口层
 * @author: uncle
 * @apdateTime: 2017-11-01 19:09
 */
public interface ProductCategoryService {

    /**
     * 查询一条类目
     * @param categoryId 类目ID
     * @return ProductCategory
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     * @return List<ProductCategory>
     */
    List<ProductCategory> findAll();

    /**
     * 获得集合中所包含的类目类型的类目列表
     * @param categoryTypes 类目类型集合
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

    /**
     * 添加一条类目记录，此方法只保存
     * @param categoryName 类目名字
     * @param categoryType 类目类型
     * @return Integer
     */
    Integer saveNotUpdate(String categoryName, Integer categoryType);

    /**
     * 此方法可保存和修改
     * @param productCategory 类目对象，如果是保存，就必须有ID
     * @return ProductCategory
     */
    ProductCategory saveOrUpdate(ProductCategory productCategory);
}
