package com.onecreation.models

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.onecreation.enums.EntityTypeEnum


@JsonDeserialize(using = NLPDeserializer.class)
class NLPEntity {
    EntityTypeEnum type
    BigDecimal confidence
    String value

    NLPEntity(EntityTypeEnum typeEnum, BigDecimal confidence, String value) {
        this.type = typeEnum
        this.confidence = confidence
        this.value = value
    }


    @Override
    String toString() {
        return "NLPEntity{" +
                "type=" + type +
                ", confidence=" + confidence +
                ", value='" + value + '\'' +
                '}';
    }
}