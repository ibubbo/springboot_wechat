package cn.ibubbo.service.impl;

import cn.ibubbo.dao.ProductCategoryDao;
import cn.ibubbo.pojo.ProductCategory;
import cn.ibubbo.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类目服务实现层
 * @author: uncle
 * @apdateTime: 2017-11-01 20:33
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypes);
    }

    @Override
    public Integer saveNotUpdate(String categoryName, Integer categoryType) {
        return productCategoryDao.saveNotUpdate(categoryName, categoryType);
    }

    @Override
    public ProductCategory saveOrUpdate(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
