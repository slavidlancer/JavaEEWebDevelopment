package com.jeewd.ejbs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class CurrencyConversionImpl implements CurrencyConversion {
    private Date getDateAndTimeAsObject(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm");
        Date dateObject = null;
        
        try {
            dateObject = simpleDateFormat.parse(date);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }
        
        return dateObject;
    }

    @Override
    public BigDecimal convertFromCurrencyToAnother(BigDecimal fromValue,
            BigDecimal exchangeRate) {
        BigDecimal toValue = fromValue.multiply(exchangeRate);
        
        return toValue;
    }
}
