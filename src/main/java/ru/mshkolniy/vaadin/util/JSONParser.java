package ru.mshkolniy.vaadin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.mshkolniy.vaadin.model.Response;

import java.io.IOException;
import java.io.StringWriter;

public class JSONParser {

    public static String getJson(Response response) {
        StringWriter stringWriter = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(stringWriter, response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }
}
