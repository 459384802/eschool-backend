package com.eschool.common.base;


public class DataResponse<D> extends BaseResponse {
	
    public DataResponse(int status, String message) {
		super(status, message);
	}

	public DataResponse(String message) {
		super(message);
	}

	private D t;

    public D getData() {
        return t;
    }

    public void setData(D t) {
        this.t = t;
    }

    public DataResponse() {
    }

    public DataResponse(int code) {
        super(code);
    }

    public DataResponse(int code, D data) {
        super(code);
        this.setData(data);
    }

    public DataResponse(String message, D data) {
        super(message);
        this.setData(data);
    }

    public DataResponse(int code, String message, D data) {
        super(code, message);
        this.setData(data);
    }
}
