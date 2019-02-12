package org.jgb.citydata.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jgb
 * @since 11/02/19 17:05
 */
@RefreshScope
@RestController
@RequestMapping(path = "/api/v1/cities")
class CitiesController {

    @GetMapping()
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Value("${config1:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

    @GetMapping("/{city}")
    String getCityInfo(@PathVariable("city") String city) {
        return this.message + " / " + city;
    }

}
