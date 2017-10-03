package com.onecreation

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties
class ApplicationProperties {
    private String messengerToken
    private String facebookPageAccessToken

    String getMessengerToken() {
        return messengerToken
    }

    void setMessengerToken(String messengerToken) {
        this.messengerToken = messengerToken
    }

    String getFacebookPageAccessToken() {
        return facebookPageAccessToken
    }

    void setFacebookPageAccessToken(String facebookPageAccessToken) {
        this.facebookPageAccessToken = facebookPageAccessToken
    }
}
