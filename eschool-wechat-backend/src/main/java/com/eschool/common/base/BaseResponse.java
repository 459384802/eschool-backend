package com.eschool.common.base;

import com.eschool.common.utils.ResponseCode;


public class BaseResponse {

    private int status;
    private String desc;

    public BaseResponse() {
    }

    public BaseResponse(int status) {
        this.setStatus(status);
    }

    public BaseResponse(String message) {
        this.setStatus(ResponseCode.OK);
        this.setDesc(message);
    }

    public BaseResponse(int status, String message) {
        this.setStatus(status);
        this.setDesc(message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


}
