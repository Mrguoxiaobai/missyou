package com.lin.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
@Component
public class GenericAndJson {
    private static ObjectMapper mapper;
    @Resource
    public void setMapper(ObjectMapper mapper){
        GenericAndJson.mapper=mapper;
    }
    public static <T> String objectToJson(T o){
        try {
            String s = GenericAndJson.mapper.writeValueAsString(o);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
    public static <T> T JsonToObject(String s, TypeReference<T> tr){
            try {
                if (s==null) {
                    return null;
                }
                T t = GenericAndJson.mapper.readValue(s, tr);
                return t;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new ServerErrorException(9999);
            }
        }

}
