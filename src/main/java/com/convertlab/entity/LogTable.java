package com.convertlab.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author limei
 * @since 2021-03-04
 */
@Data
@ApiModel(value="LogTable对象", description="")
@TableName("log_table")
public class LogTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "请求体")
    private String requestBody;

    @ApiModelProperty(value = "返回结果")
    private String returnResult;

    @ApiModelProperty(value = "是否异常")
    private String isException;

    @ApiModelProperty(value = "异常信息")
    private String exceptionInformation;


}
