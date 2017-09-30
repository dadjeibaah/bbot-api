package com.onecreation.controllers

import com.onecreation.ApplicationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.ws.rs.core.Response

@RestController("/webhook")
class MessengerWebHookController {

    @Value('${messenger.verify-token}')
    private String messengerToken



    @GetMapping
    ResponseEntity<String> subscribe(@RequestParam('hub.verify_token') String verifyToken,
                                     @RequestParam('hub.challenge') String challenge,
                                     @RequestParam('hub.subscribe') String subscribeMode) {
        if (verifyToken == messengerToken) {
            ResponseEntity.ok(challenge)
        } else {
            ResponseEntity.ok("invalid_token")
        }
    }
}
