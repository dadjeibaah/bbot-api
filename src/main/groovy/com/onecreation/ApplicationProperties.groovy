package com.onecreation

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties
class ApplicationProperties {
    private String messengerToken

    String getMessengerToken() {
        return messengerToken
    }

    void setMessengerToken(String messengerToken) {
        this.messengerToken = messengerToken
    }
}
