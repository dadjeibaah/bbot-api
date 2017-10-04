package com.onecreation.models

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.onecreation.enums.EntityTypeEnum

import java.math.RoundingMode

class NLPDeserializer extends StdDeserializer<List<NLPEntity>> {

    NLPDeserializer() {
        this(null)
    }

    NLPDeserializer(Class<?> vc) {
        super(vc)
    }

    @Override
    List<NLPEntity> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p)
        List<NLPEntity> nlpEntities = node.get("entities").fields().collect { n ->
            JsonNode innerNode = n.value.first()
            new NLPEntity(
                    Enum.valueOf(EntityTypeEnum.class, n.key.toString().toUpperCase()),
                    BigDecimal.valueOf(innerNode.get("confidence").asDouble(0)).setScale(2, RoundingMode.UP),
                    innerNode.get("value").asText("")
            )
        }
        return nlpEntities
    }
}
