package cn.ibubbo.service;

import cn.ibubbo.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品服务接口层
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 11:47
 */
public interface ProductInfoService {

    /**
     * 保存商品
     * @param productInfo 商品对象
     * @return 添加成功的商品对象
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 查询所有商品并分页显示
     * @param pageable 分页条件
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 根据商品ID查询商品
     *
     * @param productId 商品ID
     * @return ID对应的商品
     */
    ProductInfo findOne(String productId);

    /**
     * 查询上架的商品列表
     *
     * @return 上架状态的商品集合
     */
    List<ProductInfo> findByProductStatus();

    // 加库存

    // 减库存
}
