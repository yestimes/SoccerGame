package cn.nchu.soccer.entity.resultObject;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Result implements Serializable {
    private int status;
    private String msg;

    public void givenSuccess(String msg){
        setStatus(200);
        this.msg = msg;
    }

    public void givenFailure(String msg){
        setStatus(400);
        setMsg(msg);
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
