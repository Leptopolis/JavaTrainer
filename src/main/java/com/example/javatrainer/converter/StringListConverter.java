package com.example.javatrainer.converter;

import jakarta.persistence.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String>{
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> attribute){
        try{
            return mapper.writeValueAsString(attribute);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData){
        try{
            return mapper.readValue(dbData, List.class);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}