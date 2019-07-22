package com.project.web.controller;



import com.project.comm.base.BaseController;
import com.project.comm.base.ControllerAction;
import com.project.comm.utils.RestResult;
import com.project.comm.utils.ResultStatus;
import com.project.daomain.model.MailModel;
import com.project.service.ActiveMQProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;


@RestController
@RequestMapping(value = "/Mail/*")
@Api(value="邮件",tags={"邮件测试接口"})
public class MailController  {

    @Autowired
   private ActiveMQProducerService ActiveMQProducerService;

    @PostMapping("sendMessage")
    @ApiOperation (value = "发送邮件")
    @ApiImplicitParam("to")
    public RestResult sendMessage(MailModel mailEntry){
        ActiveMQProducerService.sendTopicMessage (mailEntry);
        return new RestResult (ResultStatus.Success.getValue (), ResultStatus.Success.getMessage (),mailEntry);
    }

    @ApiOperation (value = "测试swagger2",notes = "不需要传值")
    @PostMapping("testSwagger2")
    public RestResult testSwagger2(MailModel mailEntry){
        MailModel model = new MailModel ();
        model.setContent ("测试");
        return new RestResult (ResultStatus.Success.getValue (), ResultStatus.Success.getMessage (),model);
    }
}
