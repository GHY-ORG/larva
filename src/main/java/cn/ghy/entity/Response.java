package cn.ghy.entity;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 使用REST框架实现前后端分离架构，我们需要首先确定返回的JSON响应结构是统一的，也就是说，每个REST请求将返回相同结构的JSON响应结构。不妨定义一个相对通用的JSON响应结构，其中包含三部分：code，message，
 * data。 code: http的status code与返回值；message：对应的文字描述信息；data： 对应数据的json字符串。
 *
 * { "code": "404", "message": "ok", "data": ... }
 * @since 2018/8/26 23:38
 */
public class Response {

    private Integer code;
    private String message;
    private Object data;

    public Response() {
        this.setCode(200);
        this.setMessage("Successful.");
    }

    public Response(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public Response(Integer code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
