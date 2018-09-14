package cn.lsd.angular.utils;


import cn.lsd.angular.model.ResultModel;

public class ResultModelUtil {

    public static ResultModel success() {
        return success(null);
    }

    public static ResultModel success(Object object) {
        ResultModel ResultModel = new ResultModel();
        ResultModel.setData(object);
        ResultModel.setCode(0);
        ResultModel.setMsg("成功");
        return ResultModel;
    }

    public static ResultModel error(Integer code, String msg) {
        ResultModel ResultModel = new ResultModel();
        ResultModel.setCode(code);
        ResultModel.setMsg(msg);
        return ResultModel;
    }
}
