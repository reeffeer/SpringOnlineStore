package my.project.armorer.s.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class JwtRequest {
    @ApiModelProperty(notes = "Username", required = true, position = 1, example = "reef1")
    private String username;
    @ApiModelProperty(notes = "Users password ", required = true, position = 2, example = "123")
    private String password;
}
