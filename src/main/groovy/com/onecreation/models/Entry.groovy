package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Entry {
    private String id
    private long time
    private List<Messaging> messaging
}
