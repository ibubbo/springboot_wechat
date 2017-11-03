package cn.ibubbo.service.impl;

import cn.ibubbo.dao.ProductInfoDao;
import cn.ibubbo.enums.ProductStatusEnum;
import cn.ibubbo.pojo.ProductInfo;
import cn.ibubbo.service.ProductInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务实现层
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 12:00
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findByProductStatus() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
