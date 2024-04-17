package com.example.demo.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private static SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Logger LOGGER = LoggerFactory.getLogger(CustomDateDeserializer.class);

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        String date = jsonparser.getText();

        Date date2 = null;
        try {
            long epochTimeMillis = jsonparser.getLongValue() * 1000; // Multiply with 1000
            Instant instant = Instant.ofEpochMilli(epochTimeMillis);
            ZonedDateTime istTime = instant.atZone(ZoneId.of("Asia/Kolkata")); // Convert to IST
            date2 = Date.from(istTime.toInstant());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date2;
    }
}
