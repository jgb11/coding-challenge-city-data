package org.jgb.citydata.controller;

import org.jgb.citydata.model.CityInfo;
import org.jgb.citydata.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author jgb
 * @since 11/02/19 17:05
 */
@RefreshScope
@RestController
@RequestMapping(path = "/api/v1/cities")
class CitiesController {

    @Autowired
    private CitiesRepository repository;

    @GetMapping(value = "/{city}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<CityInfo> getCityInfo(@PathVariable("city") String city) {
        final Optional<CityInfo> cityInfo = Optional.ofNullable(repository.findByCity(city));
        return cityInfo
                .map(ci -> new ResponseEntity<>(ci, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
