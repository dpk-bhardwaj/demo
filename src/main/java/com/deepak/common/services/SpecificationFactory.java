package com.deepak.common.services;

import com.deepak.service.GroupByService;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emp304 on 4/3/2018.
 */
public class SpecificationFactory {

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
}
