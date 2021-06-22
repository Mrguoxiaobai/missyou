package com.lin.missyou.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * The type Order address dto.
 *
 * @ClassName: OrderAddressDTO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-2215:47
 * @Version: 1.0
 */
@Getter
@Setter
public class OrderAddressDTO {
    private String userName;
    private String province;
    private String city;
    private String county;
    private String mobile;
    private String nationalCode;
    private String postalCode;
    private String detail;
}

