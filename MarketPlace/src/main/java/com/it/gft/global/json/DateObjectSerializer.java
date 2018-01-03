package com.it.gft.global.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateObjectSerializer extends StdSerializer<Date> {

    private static final long serialVersionUID = 8567843218837572679L;

    public DateObjectSerializer(Class<Date> dateTime) {
	super(dateTime);
    }

    public DateObjectSerializer() {
	this(Date.class);
    }

    public static final String DATE_FORMAT = "yyyyMMddHHmmss";

    @Override
    public void serialize(Date date, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
	SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	String formattedDate = dateFormat.format(date);
	arg1.writeString(formattedDate);
    }

}