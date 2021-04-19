package com.bussiness.marketingDept.converters;

import com.bussiness.marketingDept.model.SaleOrder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true )
public class DeliveryTypeConverter implements AttributeConverter<SaleOrder.DeliveryType,String> {

    @Override
    public String convertToDatabaseColumn(SaleOrder.DeliveryType deliveryType) {
        if(deliveryType==null)
            return null;
        return deliveryType.getCode();
    }

    @Override
    public SaleOrder.DeliveryType convertToEntityAttribute(String s) {
        if(s==null)
            return null;
        return Stream.of(SaleOrder.DeliveryType.values())
                .filter(d->d.getCode().equals(s))
                .findFirst().get();
    }
}
