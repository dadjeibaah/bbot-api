package com.onecreation.controllers

import com.onecreation.models.Location
import com.onecreation.models.Page
import com.onecreation.rest.GoogleSearchAPI
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController("/webhook")
class MessengerWebHookController {
    private static final Logger log = LoggerFactory.getLogger(MessengerWebHookController.class)
    @Value('${messenger.verify-token}')
    private String messengerToken

    @Value('${google.api-key}')
    private String googleApiKey

    private GoogleSearchAPI googleSearchAPI


    @Autowired
    MessengerWebHookController(GoogleSearchAPI googleSearchAPI) {
        this.googleSearchAPI = googleSearchAPI
    }


    @PostMapping
    ResponseEntity<List<Location>> webhook(@RequestBody Page pages) {
        log.info("Incoming message: ${pages}")
        //PlacesResponse response = googleSearchAPI.locations(googleApiKey, "-33.8670522,151.1957362", "500", "Urban Barbershops")
        ResponseEntity.ok(Arrays.asList(new Location()))
    }

    @GetMapping
    ResponseEntity<String> subscribe(@RequestParam('hub.verify_token') String verifyToken,
                                     @RequestParam('hub.challenge') String challenge,
                                     @RequestParam('hub.mode') String subscribeMode) {
        if (verifyToken == messengerToken) {
            ResponseEntity.ok(challenge)
        } else {
            ResponseEntity.ok("invalid_token")
        }
    }
}
