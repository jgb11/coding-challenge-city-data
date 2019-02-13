package org.jgb.citydata.controller;

import org.jgb.citydata.Application;
import org.jgb.citydata.config.TestSecurityConfiguration;
import org.jgb.citydata.model.CityInfo;
import org.jgb.citydata.repository.CitiesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jgb
 * @since 11/02/19 17:17
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CitiesController.class)
@TestPropertySource(locations = "classpath:bootstrap-tests.yml")
@ContextConfiguration(classes = {Application.class, TestSecurityConfiguration.class, RefreshAutoConfiguration.class})
public class CitiesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CitiesRepository repository;

    @Test
    public void testControllerReturnsCorrectCityInfo() throws Exception {
        when(repository.findByCity(anyString())).thenReturn(new CityInfo("Zaragoza", "Madrid", LocalDateTime.MIN, LocalDateTime.MAX));
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/cities/Zaragoza").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testControllerReturnsNotFound() throws Exception {
        when(repository.findByCity(anyString())).thenReturn(null);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/cities/Honolulu").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

}