package org.jgb.citydata.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author jgb
 * @since 12/02/19 19:37
 */
public class CityInfo {

    @Id
    public String id;

    private String city;
    private String cityDestiny;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public CityInfo() {
    }

    public CityInfo(String city, String cityDestiny, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.city = city;
        this.cityDestiny = cityDestiny;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getCity() {
        return city;
    }

    public String getCityDestiny() {
        return cityDestiny;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityInfo)) return false;
        CityInfo cityInfo1 = (CityInfo) o;
        return Objects.equals(city, cityInfo1.city) &&
                Objects.equals(cityDestiny, cityInfo1.cityDestiny) &&
                Objects.equals(departureTime, cityInfo1.departureTime) &&
                Objects.equals(arrivalTime, cityInfo1.arrivalTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(city, cityDestiny, departureTime, arrivalTime);
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "city='" + city + '\'' +
                ", cityDestiny='" + cityDestiny + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
