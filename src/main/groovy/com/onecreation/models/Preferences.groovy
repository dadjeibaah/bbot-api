package com.onecreation.models

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Preferences {
    String favoriteHairstyle
    String phoneNumber

    Preferences(String favoriteHairstyle, String phoneNumber) {
        this.favoriteHairstyle = favoriteHairstyle
        this.phoneNumber = phoneNumber
    }
}
