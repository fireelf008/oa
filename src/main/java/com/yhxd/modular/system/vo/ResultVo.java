package com.yhxd.modular.system.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResultVo implements Serializable {

    private Integer status = HttpStatus.OK.value();
    private String message = "请求成功";
    private Object dataSet;
    private Date systemTime = new Date();

    public static ResultVo success(Object dataSet) {
        ResultVo resultVo = new ResultVo();
        resultVo.setDataSet(dataSet);
        return resultVo;
    }

    public static ResultVo error(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultVo.setMessage(message);
        return resultVo;
    }
}
