package cn.ibubbo.dao;

import cn.ibubbo.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author: uncle
 * @apdateTime: 2017-11-01 15:29
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /**
     * 添加一条类目记录
     *
     * @param categoryName 类目名字
     * @param categoryType 类目类型
     * @return Integer
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "insert into product_category (category_name, category_type) values (?1, ?2)",
            nativeQuery = true)
    Integer saveNotUpdate(String categoryName, Integer categoryType);

    /**
     * 获得所有类目列表
     * @return List<ProductCategory>
     */
    @Override
    @Query(value = "select category_id, category_name, category_type, create_time, update_time " +
            "from product_category", nativeQuery = true)
    List<ProductCategory> findAll();

    /**
     * 根据类目ID获得类目列表
     * @param categoryId 类目ID
     * @return ProductCategory
     */
    @Override
    @Query(value = "select category_id, category_name, category_type, create_time, update_time " +
            "from product_category where category_id = ?1", nativeQuery = true)
    ProductCategory findOne(Integer categoryId);

    /**
     * 获得in条件所包含的类目类型的类目列表
     * @param CategoryTypes 类目类型集合
     * @return List<ProductCategory>
     */
    @Query(value = "select category_id, category_name, category_type, create_time, update_time " +
            "from product_category where category_id in (?1)", nativeQuery = true)
    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryTypes);

}
