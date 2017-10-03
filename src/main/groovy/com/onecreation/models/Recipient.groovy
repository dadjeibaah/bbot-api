package com.onecreation.models

class Recipient {
    private String id

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }


    @Override
    public String toString() {
        return "Recipient{" +
                "id='" + id + '\'' +
                '}';
    }
}
