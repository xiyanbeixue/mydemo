package com.xiyan.mydemo.vo.user;

import com.xiyan.mydemo.common.utils.RegexUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author xiyan
 * @Date 2020/6/11
 * @Version 1.0
 */
@ApiModel("新增用户VO")
@Data
public class UserInfoInsertVO implements Serializable {
    private static final long SerialVersionUID=1l;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = RegexUtils.REGEX_USERNAME,message = RegexUtils.REGEX_USERNAME_ERROR)
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    @Pattern(regexp = RegexUtils.REGEX_PASSWORD,message = RegexUtils.REGEX_PASSWORD_ERROR)
    private String password;
}
