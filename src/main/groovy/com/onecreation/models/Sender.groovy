package com.onecreation.models

class Sender {
    private String id

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    @Override
     String toString() {
        return "Sender{" +
                "id='" + id + '\'' +
                '}'
    }
}
