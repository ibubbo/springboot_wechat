package cn.ibubbo.service.impl;

import cn.ibubbo.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: uncle
 * @apdateTime: 2017-11-01 20:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Resource
    private ProductCategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory category = categoryService.findOne(1);
        // assert (category.getCategoryId() == 1) : "查询失败...";
        // 1 是期待的值  category.getCategoryId() 是实际的值，如果不相等则报错，跟CAS很像
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }

    @Test
    public void saveNotUpdate() throws Exception {
        ProductCategory category = categoryService.saveOrUpdate(new ProductCategory("曾小晨", 0));
        Assert.assertNotNull(category);
    }

    @Test
    public void saveOrUpdate() throws Exception {
        Integer integer = categoryService.saveNotUpdate("007", 22);
        Assert.assertEquals(new Integer(1), integer);
    }

}