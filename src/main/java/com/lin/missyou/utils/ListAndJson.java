package com.lin.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;

import javax.annotation.Resource;
import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
//@Converter
public class ListAndJson implements AttributeConverter<List<Object>,String> {
    @Resource
    ObjectMapper mapper;
    @Override
    public String convertToDatabaseColumn(List<Object> stringObjectList) {
        try {
            String s = mapper.writeValueAsString(stringObjectList);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if (s==null) {
                return null;
            }
            List list = mapper.readValue(s, List.class);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
