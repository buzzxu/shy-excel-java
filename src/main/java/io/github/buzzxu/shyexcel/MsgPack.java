package io.github.buzzxu.shyexcel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.text.SimpleDateFormat;

/**
 * @author xux
 * @date 2023年10月15日 22:03:58
 */
enum MsgPack {
    INSTANCE;
    private final ObjectMapper instance;

    MsgPack() {
        instance = newObjectMapper();
    }
    private  ObjectMapper newObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        return configure(mapper);
    }
    public static ObjectMapper of() {
        return INSTANCE.instance;
    }

    public static <T> byte[] serialize(T obj) throws JsonProcessingException {
        return INSTANCE.instance.writeValueAsBytes(obj);
    }

    private ObjectMapper configure(ObjectMapper mapper) {
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
}
