package com.deepak.rest;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("Test")
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ModuleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @DisplayName("Test case for saveModule controller method for saving a module : Success")
    @Test
    public void getProductWithOutFilterExceptionTest() throws Exception {

        when(productService.getProducts(any(), any())).thenReturn(new HashMap<>());

        this.mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @DisplayName("Test case for saveModule controller method for saving a module : Success")
    @Test
    public void getProductWithFilterExceptionTest() throws Exception {

        when(productService.getProducts(any(), any())).thenReturn(new HashMap<>());

        this.mockMvc.perform(get("/api/products?filter=" + GroupSpecification.BRAND + "&value=test")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }




}
