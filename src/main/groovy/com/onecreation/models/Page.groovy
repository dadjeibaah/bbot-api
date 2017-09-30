package com.onecreation.models

class Page {
    private String object
    private List<Entry> entry

    String getObject() {
        return object
    }

    void setObject(String object) {
        this.object = object
    }

    List<Entry> getEntries() {
        return entry
    }

    void setEntries(List<Entry> entry) {
        this.entry = entry
    }


    @Override
    String toString() {
        return "Page{" +
                "object='" + object + '\'' +
                ", entry=" + entry +
                '}'
    }
}
