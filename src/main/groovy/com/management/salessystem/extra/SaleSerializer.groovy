package com.management.salessystem.extra

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.management.salessystem.domain.Sale

/**
 * @author Mhd Reslan Swed
 * Created on 03/05/2022
 */
class SaleSerializer extends StdSerializer<Sale> {
    SaleSerializer() {
        this(null)
    }

    SaleSerializer(Class<Sale> t) {
        super(t)
    }

    @Override
    void serialize(Sale sale, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.tap {
            writeStartObject()
            writeNumberField('id', sale.id)
            writeObjectField('createDate', sale.createDate)
            writeObjectField('seller', sale.seller)
            writeObjectField('client', sale.client)
            writeNumberField('total', sale.total)
            writeEndObject()
        }
    }
}
