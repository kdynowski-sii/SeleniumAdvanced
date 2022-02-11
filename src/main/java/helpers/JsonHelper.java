package helpers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonHelper {
    private final ObjectMapper objectMapper;

    public JsonHelper() {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public <T> T deserializeJson(String path, Class<T> valueType) throws IOException {
        return objectMapper.readValue(new File(path), valueType);
    }

    public void serializeJson(String path, Object object) throws IOException {
        objectMapper.writeValue(new File(path), object);
    }
}
