package com.deepak.common.services;

import com.deepak.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emp304 on 4/3/2018.
 */
public class SpecificationFactory {

    private ProductGroupByBrand brandService;

    private ProductGroupByColor colorService;

    private ProductGroupByCategory productCategoryService;

    private ProductServiceImpl productService;

   /* public static ProductSpecificationService getSpecification(String groupBySpecification) {
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
    }*/

    private static final Map<String, Class<? extends GroupByService>> instances = new HashMap<>();

    public static void register(String loggerMedium, Class<? extends GroupByService> instance) {
        if (loggerMedium != null && instance != null) {
            instances.put(loggerMedium, instance);
        }
    }

    public static GroupByService getInstance(ApplicationContext context, String loggerMedium) {
        if (instances.containsKey(loggerMedium)) {
            return context.getBean(instances.get(loggerMedium));
        }
        return null;
    }


    @Autowired
    public void setBrandService(@Qualifier("BrandService") ProductGroupByBrand brandService) {
        this.brandService = brandService;
    }

    @Autowired
    public void setColorService(@Qualifier("ColorService") ProductGroupByColor colorService) {
        this.colorService = colorService;
    }

    @Autowired
    public void setProductCategoryService(@Qualifier("ProductCategoryService") ProductGroupByCategory productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Autowired
    public void setProductService(@Qualifier("ProductService") ProductServiceImpl productService) {
        this.productService = productService;
    }
}
