package org.jgb.citydata.repository;

import org.jgb.citydata.model.CityInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author jgb
 * @since 12/02/19 19:41
 */
public interface CitiesRepository  extends MongoRepository<CityInfo, String> {

    List<CityInfo> findByCity(String city);

}
