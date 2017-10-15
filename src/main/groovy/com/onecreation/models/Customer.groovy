package com.onecreation.models

import org.springframework.data.annotation.Id


class Customer {
    @Id String id
    String name
    String facebookId
    Preferences preferences

    Customer(String id, String name, String facebookId, Preferences preferences) {
        this.id = id
        this.name = name
        this.facebookId = facebookId
        this.preferences = preferences
    }
}
