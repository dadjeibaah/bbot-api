package com.onecreation.rest

import com.onecreation.models.Messaging
import com.onecreation.models.ReplyResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "facebook-messenger-api", url = '${facebook.messenger-url}')
interface FacebookMessengerAPI {
    @RequestMapping(value = "messages", method = RequestMethod.POST)
    ReplyResponse reply(@RequestBody Messaging messageToBeSent,
                        @RequestParam(value = "access_token") String pageAccessToken)
}