package com.project.comm.base;


import com.project.comm.utils.RestResult;
import com.project.comm.utils.ResultStatus;
import com.project.comm.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class BaseController<TModel> {
    /**
     * 日志
     */
    protected Logger logger;

    public BaseController() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value = "{actionName}")
    public RestResult<Object> genericAction(@PathVariable String actionName, @RequestBody RequestModel<TModel> reqModel) {
        if (StringUtils.isEmpty(actionName)) {
            return new RestResult<> (ResultStatus.NotFound.getValue(), ResultStatus.NotFound.getMessage());
        }
        AtomicReference<RestResult<Object>> resultRef = new AtomicReference<>();
        Arrays.stream (getClass ().getMethods ()).filter (method -> {
            ControllerAction action;
            return (action = method.getDeclaredAnnotation(ControllerAction.class)) != null && StringUtils.equalsIgnoreCase(actionName, action.value(), action.route());
        }).findFirst ().ifPresent (method -> {
            try {
                Object result = method.invoke(this, reqModel);

                if (result instanceof RestResult) {
                    resultRef.set((RestResult) result);
                } else {
                    logger.warn(String.format("自定义路由返回结果异常; Controller:%s, Method:%s.", getClass().getName(), method.getName()));
                }
            } catch (Exception e) {
                logger.error(String.format("自定义路由处理出错; Controller:%s, Method:%s.", getClass().getName(), method.getName()), e);
            }
        });
        RestResult<Object> result;
        if ((result = resultRef.get()) != null) {
            return result;
        }
        return null;
    }
}
