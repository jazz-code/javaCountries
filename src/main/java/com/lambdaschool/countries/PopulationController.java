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
                .findCountries(c -> c.getPopulation() <= people);
        rtnPop.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnPop, HttpStatus.OK);
    }

    //localhost:2020/population/min
    //return the country with the smallest population
    @RequestMapping(value = "/min")
    public Country rtnMin()

}
