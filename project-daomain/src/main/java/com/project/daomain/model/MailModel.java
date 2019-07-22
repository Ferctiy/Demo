package com.project.daomain.model;

import com.sun.org.glassfish.gmbal.Description;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单")
public class MailModel {
    @ApiModelProperty(value = "订单号id(不需要传)",readOnly = true)
    private String to;
    private String subject;
    private String content;
}
