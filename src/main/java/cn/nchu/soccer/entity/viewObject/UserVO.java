package cn.nchu.soccer.entity.viewObject;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class UserVO implements Serializable {

    @NotEmpty(message = "用户类型不能为空")
    private int type;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
