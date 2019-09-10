package com.lambdaschool.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    ///localhost:2020/population/size/{people}
    //return the countries that have a population equal to or greater than the given population

    @RequestMapping(value = "/size/{people}",
                    produces = {"application/json"})
    public ResponseEntity<?> popCheck(@PathVariable long people)
    {
        int length = String.valueOf(people).length();
        ArrayList<Country> rtnPop = CountriesApplication.ourCountryList
                .findCountries(c -> c.getPopulation() >= people);
        rtnPop.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnPop, HttpStatus.OK);
    }

    //localhost:2020/population/min
    //return the country with the smallest population
    @RequestMapping(value = "/min")
    public ResponseEntity<?> rtnMin()
    {
        ArrayList<Country> tempCountry = new ArrayList<>(CountriesApplication.ourCountryList.countryList);
                tempCountry.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

//        ArrayList<Country> findMin = CountriesApplication.ourCountryList.countryList
//                .sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(tempCountry.get(0), HttpStatus.OK);

    }
    ///localhost:2020/population/max
    //return the country with the largest population
    @RequestMapping(value = "/max")
    public ResponseEntity<?> rtnMax()
    {
        ArrayList<Country> maxCountry = new ArrayList<>(CountriesApplication.ourCountryList.countryList);
        maxCountry.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        return new ResponseEntity<>(maxCountry.get(0), HttpStatus.OK);

    }
}
