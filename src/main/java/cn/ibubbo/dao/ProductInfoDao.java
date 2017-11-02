package cn.ibubbo.dao;

import cn.ibubbo.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 商品持久层
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 10:42
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

//    /**
//     * 查询所有商品
//     * @return 所有商品
//     */
//    @Override
//    @Query(value = "select product_id, product_name, product_price, product_stock, " +
//            "product_description, product_icon, product_status, category_type, create_time, update_time " +
//            "from product_info", nativeQuery = true)
//    List<ProductInfo> findAll();

    /**
     * 根据商品状态查询商品
     *
     * @param productStatus 商品状态
     * @return 返回所有指定状态的商品
     */
    @Query(value = "select product_id, product_name, product_price, product_stock, " +
            "product_description, product_icon, product_status, category_type, create_time, update_time " +
            "from product_info where product_status = ?1", nativeQuery = true)
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据商品ID查询商品
     *
     * @param productId 商品ID
     * @return ID对应的商品
     */
    @Override
    @Query(value = "select product_id, product_name, product_price, product_stock,  " +
            "product_description, product_icon, product_status, category_type, create_time, update_time " +
            "from product_info where product_id = ?1", nativeQuery = true)
    ProductInfo findOne(String productId);
}