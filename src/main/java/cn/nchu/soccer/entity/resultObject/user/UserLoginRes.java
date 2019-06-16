package cn.nchu.soccer.entity.resultObject.user;

import cn.nchu.soccer.entity.resultObject.Result;

public class UserLoginRes extends Result {
    private String redirect;

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }


}
