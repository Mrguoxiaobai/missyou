package com.lin.missyou.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The type Exception code configuration.
 * @author GM
 */
@Setter
@ConfigurationProperties(prefix = "lin")
@PropertySource(value = "classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {
    private Map<Integer,String> codes;

    /**
     * Get message string.
     *
     * @param code the code
     * @return the string
     */
    public String getMessage(int code){
        String message = this.codes.get(code);
        return message;
    }
}
