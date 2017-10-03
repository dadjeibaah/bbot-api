package com.onecreation.models

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Customer {
    @GraphId Long id
    String name
    String facebookId

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getFacebookId() {
        return facebookId
    }

    void setFacebookId(String facebookId) {
        this.facebookId = facebookId
    }
}
