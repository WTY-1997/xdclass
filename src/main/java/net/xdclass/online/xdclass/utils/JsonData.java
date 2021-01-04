package net.xdclass.online.xdclass.utils;

public class JsonData {
    /**
     * 状态码
     * 0表示成功 1表示处理中 -1表示失败
     */
    private Integer code;

    /**
     * 业务数据
     */
    private Object data;

    /**
     * 信息描述
     */
    private String msg;


    /**
     * 成功  不用返回数据
     *
     * @return
     */
    public static JsonData bulidSucccess() {
        return new JsonData(0, null, null);
    }


    /**
     * 成功  返回数据
     *
     * @param data
     * @return
     */
    public static JsonData bulidSucccess(Object data) {
        return new JsonData(0, data, null);
    }


    /**
     * 失败  返回错误信息
     *
     * @param msg
     * @return
     */
    public static JsonData bulidError(String msg) {
        return new JsonData(-1, null, msg);
    }


    /**
     * 失败  返回自定义状态码和错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static JsonData bulidError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }


    /**
     * 无参构造
     */
    public JsonData() {
    }

    /**
     * 全残构造
     *
     * @param code
     * @param data
     * @param msg
     */
    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getDate() {
        return data;
    }

    public void setDate(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
