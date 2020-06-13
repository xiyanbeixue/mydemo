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
@ApiModel("更新用户VO")
@Data
public class UserInfoUpdateVO implements Serializable {
    private static final long SerialVersionUID=1l;
    @ApiModelProperty("用户Id")
    @NotNull(message = "userId不能为空")
    private Long userId;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = RegexUtils.REGEX_USERNAME,message = RegexUtils.REGEX_USERNAME_ERROR)
    private String username;

    @ApiModelProperty("原密码")
    @NotBlank(message = "原密码不能为空")
    private String password;

    @ApiModelProperty("新密码")
    @NotNull(message = "新密码不能为空")
    @Pattern(regexp = RegexUtils.REGEX_PASSWORD,message = RegexUtils.REGEX_PASSWORD_ERROR)
    private String newPassword;
}
