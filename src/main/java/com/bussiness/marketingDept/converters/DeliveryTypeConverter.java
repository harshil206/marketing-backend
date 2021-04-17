package com.bussiness.marketingDept.converters;

import com.bussiness.marketingDept.model.Sale_Order;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true )
public class DeliveryTypeConverter implements AttributeConverter<Sale_Order.DeliveryType,String> {

    @Override
    public String convertToDatabaseColumn(Sale_Order.DeliveryType deliveryType) {
        if(deliveryType==null)
            return null;
        return deliveryType.getCode();
    }

    @Override
    public Sale_Order.DeliveryType convertToEntityAttribute(String s) {
        if(s==null)
            return null;
        return Stream.of(Sale_Order.DeliveryType.values())
                .filter(d->d.getCode().equals(s))
                .findFirst().get();
    }
}
