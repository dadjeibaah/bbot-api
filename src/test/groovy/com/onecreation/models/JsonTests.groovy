package com.onecreation.models

import com.fasterxml.jackson.databind.ObjectMapper
import com.onecreation.enums.EntityTypeEnum
import org.junit.Test

import java.math.RoundingMode

import static org.assertj.core.api.Assertions.assertThat

class JsonTests {

    @Test
    void loadEntities(){
        String json = Class.getResource("/entities.json").getText("UTF-8")
        NLPEntity first = new NLPEntity(EntityTypeEnum.Location, BigDecimal.valueOf(0.90644).setScale(2, RoundingMode.UP),"Yo")
        NLPEntity second = new NLPEntity(EntityTypeEnum.Greetings, BigDecimal.valueOf(0.99505686768689).setScale(2, RoundingMode.UP),"true")
        List<NLPEntity> entities = new ObjectMapper().readValue(json, NLPEntity.class)
        assertThat(entities.first().confidence).isEqualTo(first.confidence)
        assertThat(entities.first().type).isEqualTo(first.type)
    }
}
