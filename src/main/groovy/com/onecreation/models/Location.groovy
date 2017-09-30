package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Location {
    private String id
    private String name
    private BigDecimal rating
    private String vicinity

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    BigDecimal getRating() {
        return rating
    }

    void setRating(BigDecimal rating) {
        this.rating = rating
    }

    String getVicinity() {
        return vicinity
    }

    void setVicinity(String vicinity) {
        this.vicinity = vicinity
    }
}
