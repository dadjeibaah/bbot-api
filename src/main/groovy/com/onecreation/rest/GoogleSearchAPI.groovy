package com.onecreation.rest

import com.onecreation.models.PlacesResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "google-places-api", url = '${google.places-url}')
interface GoogleSearchAPI {
    @RequestMapping(value = "nearbysearch/json",
            method = RequestMethod.GET)
    PlacesResponse locations(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "radius") String radius,
            @RequestParam(value = "keyword") String keyword
    )
}