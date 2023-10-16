package com.github.buzzxu.shyexcel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.text.SimpleDateFormat;

/**
 * @author xux
 * @date 2023年10月15日 20:56:26
 */
enum JSON {
    INSTANCE;
    private final ObjectMapper instance;
    JSON(){
        instance = newObjectMapper();
    }
    private  ObjectMapper newObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        return configure(mapper);
    }
    private ObjectMapper configure(ObjectMapper mapper) {
        SimpleModule xssModule = new SimpleModule();
        mapper.registerModule(xssModule);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), true);
        mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        return mapper;
    }
    public static ObjectMapper of(){
        return INSTANCE.instance;
    }

    public static String toString(Object object) throws JsonProcessingException {
        return INSTANCE.instance.writeValueAsString(object);
    }
    public static byte[] toBytes(Object object) throws JsonProcessingException {
        return INSTANCE.instance.writeValueAsBytes(object);
    }
}
