package com.onecreation.controllers

import com.onecreation.models.Location
import com.onecreation.models.MessageResponse
import com.onecreation.models.Messaging
import com.onecreation.models.Page
import com.onecreation.models.Recipient
import com.onecreation.rest.FacebookMessengerAPI
import com.onecreation.rest.GoogleSearchAPI
import com.onecreation.services.CustomerService
import com.onecreation.services.MessageProcessorService
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

    @Value('${facebook.page-token}')
    private String facebookAccessToken

    private GoogleSearchAPI googleSearchAPI
    private MessageProcessorService messageProcessorService
    private FacebookMessengerAPI facebookMessengerAPI


    @Autowired
    MessengerWebHookController(
            GoogleSearchAPI googleSearchAPI,
            MessageProcessorService messageProcessorService,
            FacebookMessengerAPI facebookMessengerAPI
    ) {
        this.googleSearchAPI = googleSearchAPI
        this.messageProcessorService = messageProcessorService
        this.facebookMessengerAPI = facebookMessengerAPI
    }


    @PostMapping
    ResponseEntity<Page> webhook(@RequestBody Page pages) {
        log.info("Incoming message: ${pages}")
        pages.entry.forEach{e ->
            Messaging response = messageProcessorService.generateResponsesForEntries(e)
            Recipient recipient = new Recipient()
            String receiver = response.sender.id
            recipient.setId(receiver)
            response.setRecipient(recipient)
            facebookMessengerAPI.reply(response, facebookAccessToken)
        }
        //customerService.findByFacebookId()
        //PlacesResponse response = googleSearchAPI.locations(googleApiKey, "-33.8670522,151.1957362", "500", "Urban Barbershops")
        ResponseEntity.ok(pages)
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
