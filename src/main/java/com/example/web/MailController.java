package com.example.web;

import com.alibaba.fastjson.JSON;
import com.example.base.BaseController;
import com.example.base.ControllerAction;
import com.example.base.RequestModel;
import com.example.model.MailModel;
import com.example.utils.RestResult;
import com.example.utils.ResultStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Mail")
public class MailController extends BaseController {

    @ControllerAction(route = "sendMessage")
    public RestResult sendMessage(RequestModel<MailModel> mailEntry){
        logger.info (JSON.toJSONString (mailEntry));
        return new RestResult (ResultStatus.Success.getValue (), ResultStatus.Success.getMessage (),mailEntry);
    }
}
