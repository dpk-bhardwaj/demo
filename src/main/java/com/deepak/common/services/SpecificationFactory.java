package com.deepak.common.services;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by emp304 on 4/3/2018.
 */
@Service
public class SpecificationFactory {

    private BrandServiceImpl brandService;

    private ColorServiceImpl colorService;

    private ProductCategoryServiceImpl productCategoryService;

    private ProductServiceImpl productService;

    public ProductSpecificationService getSpecification(String groupBySpecification) {
        GroupSpecification groupSpecification;
        groupSpecification = GroupSpecification.getValue(groupBySpecification);
        switch (groupSpecification) {
            case BRAND: {
                return brandService;
            }
            case COLOR: {
                return colorService;
            }
            case CATEGORY: {
                return productCategoryService;
            }
            default: {
                return productService;
            }
        }
    }

    @Autowired
    public void setBrandService(@Qualifier("BrandService") BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @Autowired
    public void setColorService(@Qualifier("ColorService") ColorServiceImpl colorService) {
        this.colorService = colorService;
    }

    @Autowired
    public void setProductCategoryService(@Qualifier("ProductCategoryService") ProductCategoryServiceImpl productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Autowired
    public void setProductService(@Qualifier("ProductService") ProductServiceImpl productService) {
        this.productService = productService;
    }
}
