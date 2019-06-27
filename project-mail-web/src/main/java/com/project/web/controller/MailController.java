package com.project.web.controller;


import com.alibaba.fastjson.JSON;
import com.project.comm.base.BaseController;
import com.project.comm.base.ControllerAction;
import com.project.comm.base.RequestModel;
import com.project.comm.utils.RestResult;
import com.project.comm.utils.ResultStatus;
import com.project.daomain.model.MailModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "Mail")
public class MailController extends BaseController {

    @ControllerAction(route = "sendMessage")
    public RestResult sendMessage(RequestModel<MailModel> mailEntry){
        JSON.toJSONString (mailEntry);
        return new RestResult (ResultStatus.Success.getValue (), ResultStatus.Success.getMessage (),mailEntry);
    }
}
