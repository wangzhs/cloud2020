package com.wzs.spring.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResult success(T data) {
        return new CommonResult(200, "success", data);
    }

    public static CommonResult error(String message) {
        return new CommonResult(500, message);
    }
}

