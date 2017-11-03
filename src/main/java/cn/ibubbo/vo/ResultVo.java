package cn.ibubbo.vo;

import lombok.Data;

/**
 * http 请求返回的最外层对象
 *
 * @author: uncle
 * @apdateTime: 2017-11-02 13:32
 */
@Data
public class ResultVo {
    /** 状态码 .*/
    private Integer code;

    /** 消息 .*/
    private String msg;

    /** 数据 .*/
    private Object data;

    /**
     * 返回指定格式
     * @param code 状态码
     * @param msg 消息
     * @param data 数据
     */
    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功
     * @param data 数据
     */
    public ResultVo(Object data) {
        this.code = 0;
        this.msg = "成功";
        this.data = data;
    }

    public ResultVo() {}

    public static ResultVo success(Object obj) {
        return new ResultVo(obj);
    }

    public static ResultVo error(Integer code, String msg) {
        return new ResultVo(code, msg, null);
    }

    public static ResultVo success() {
        return new ResultVo(null);
    }
}
