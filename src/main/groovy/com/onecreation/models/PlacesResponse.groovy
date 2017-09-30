package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PlacesResponse {
    private String nextPagetoken
    private List<Location> results
    private String status

    String getNextPagetoken() {
        return nextPagetoken
    }

    void setNextPagetoken(String nextPagetoken) {
        this.nextPagetoken = nextPagetoken
    }

    List<Location> getResults() {
        return results
    }

    void setResults(List<Location> results) {
        this.results = results
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }
}
