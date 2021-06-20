package com.lin.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;

import javax.annotation.Resource;
import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
//@Converter
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {
    @Resource
    ObjectMapper mapper;
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            String s = mapper.writeValueAsString(stringObjectMap);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            HashMap map = mapper.readValue(s, HashMap.class);
            return map;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
