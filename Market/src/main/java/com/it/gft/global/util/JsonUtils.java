package com.it.gft.global.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * 
 * @author TOSS
 *
 */
public class JsonUtils {

    public static ObjectMapper objectMapper() {
	final AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
	ObjectMapper mapper = new ObjectMapper();
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
	mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
	mapper.getDeserializationConfig().withAppendedAnnotationIntrospector(introspector);
	mapper.getSerializationConfig().withAppendedAnnotationIntrospector(introspector);
	return mapper;
    }

	public static String serializeAsJsonString(Object object) throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper mapper = objectMapper();
	mapper.enable(SerializationFeature.INDENT_OUTPUT);
	mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	StringWriter sw = new StringWriter();
	mapper.writeValue(sw, object);
	return sw.toString();
    }

    public static String serializeAsJsonStringIndent(Object object, boolean indent) throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper mapper = objectMapper();
	if (indent == true) {
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	StringWriter sw = new StringWriter();
	mapper.writerWithDefaultPrettyPrinter().writeValue(sw, object);
	return sw.toString();
    }

    public static <T> T jsonStringToObject(String content, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
	T obj = null;
	ObjectMapper mapper = objectMapper();
	obj = mapper.readValue(content, clazz);
	return obj;
    }

    public static <T> T jsonStringToObjectArray(String content) throws JsonParseException, JsonMappingException, IOException {
	T obj = null;
	ObjectMapper mapper = objectMapper();
	obj = mapper.readValue(content, new TypeReference<List>() {
	});
	return obj;
    }

    public static <T> T jsonStringToObjectClassArray(String content, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
	T obj = null;
	ObjectMapper mapper = objectMapper();
	obj = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
	return obj;
    }

}
