package com.example.administrator.netcenter.data;

/**
 * Created by Administrator on 2015/11/11.
 */
public class ServerData {
    private String Desc,position,username,password,unit;
    private int[] ip;
    private int type,optype;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int[] getIp() {
        return ip;
    }

    public void setIp(int[] ip) {
        this.ip = ip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOptype() {
        return optype;
    }

    public void setOptype(int optype) {
        this.optype = optype;
    }
}
