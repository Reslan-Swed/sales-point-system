package com.management.salessystem.extra

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.management.salessystem.domain.SaleEntry

/**
 * @author Mhd Reslan Swed
 * Created on 03/04/2022
 */
class SaleEntrySerializer extends StdSerializer<List<SaleEntry>> {
    SaleEntrySerializer() {
        this(null)
    }

    SaleEntrySerializer(Class<List<SaleEntry>> t) {
        super(t)
    }

    @Override
    void serialize(List<SaleEntry> entries, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.tap {
            writeStartArray()
            entries.forEach({ entry ->
                writeStartObject()
                writeNumberField('id', entry.id)
                writeObjectField('product', entry.product)
                writeNumberField('quantity', entry.quantity)
                writeNumberField('price', entry.price)
                writeEndObject()
            })
            writeEndArray()
        }
    }
}
