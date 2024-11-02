package com.example.demo.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.example.demo.entity.CustomerReceiveAlertPrice;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.format.DateTimeFormatter;

@org.springframework.context.annotation.Configuration
public class Configuration {
//        @Bean
//    public ModelMapper initModelMapper() {
//        return new ModelMapper();
//    }
    @Bean
    public ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(CustomerReceiveAlertPriceCreateForm.class, CustomerReceiveAlertPrice.class)
            .addMappings(mapping -> mapping.skip(CustomerReceiveAlertPrice::setId));
        return modelMapper;
    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> {

            // formatter
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // deserializers
            builder.deserializers(new LocalDateDeserializer(dateFormatter));
            builder.deserializers(new LocalDateTimeDeserializer(dateTimeFormatter));

            // serializers
            builder.serializers(new LocalDateSerializer(dateFormatter));
            builder.serializers(new LocalDateTimeSerializer(dateTimeFormatter));
        };
    }
}
