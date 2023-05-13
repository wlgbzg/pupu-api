package utils;

import lombok.Data;

@Data
public class Result {
    private String msg;
    private int code;
    private Object data;

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}