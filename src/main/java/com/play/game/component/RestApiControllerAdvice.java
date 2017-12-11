package com.play.game.component;

import com.alibaba.fastjson.JSONObject;
import com.play.game.code.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
@ControllerAdvice
public class RestApiControllerAdvice {
    private final static Logger logger = LoggerFactory.getLogger(RestApiControllerAdvice.class);

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handler(BizException e) {
        logger.error("运行时抛出的异常信息：",e);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", e.getCode());
        jsonObject.put("message", e.getMessage());
        return jsonObject.toJSONString();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle(Exception e) {
        logger.error("未捕获异常信息：",e);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "");
        jsonObject.put("message", e.getMessage());
        return jsonObject.toJSONString();

    }
}
