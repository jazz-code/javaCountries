package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
    //localhost:8080/names/all -- Sort Alphabetically
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost:8080/names/start/{letter} -- Sort Alphabetically That Begin with Letter
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getByLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
    ///localhost:2020/names/size/{number}
    //return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping(value = "/size/{number}",
               produces = {"application/json"})
    public ResponseEntity<?> getNameLength(@PathVariable int number)
    {
        ArrayList<Country> rtnNumber = CountriesApplication.ourCountryList
                .findCountries(c -> c.getName().length() >= number);
        rtnNumber.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return  new ResponseEntity<>(rtnNumber, HttpStatus.OK);
    }
}
