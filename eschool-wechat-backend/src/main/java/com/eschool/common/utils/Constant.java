package com.eschool.common.utils;

/**
 * 常量
 */
public class Constant {
	/**
	 * 微信小程序登录凭证校验
	 */
	public static final String URL_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session";
	
	/**
	 * 删除状态：0-正常
	 */
	public static final Integer DELETE_STATUS_NORMAL = 0;
	/**
	 * 删除状态：1-已逻辑删除
	 */
	public static final Integer DELETE_STATUS_DELETED = 1;
	/**
	 * 有效状态：0-无效
	 */
	public static final Integer VALID_STATUS_INVALID = 0;
	/**
	 * 有效状态：1-有效
	 */
	public static final Integer VALID_STATUS_VALID = 1;

	/**
	 * 任务状态：0-待接单
	 */
	public static final Integer TASK_STATUS_WAIT = 0;
	/**
	 * 任务状态：1-进行中
	 */
	public static final Integer TASK_STATUS_DOING = 1;
	/**
	 * 任务状态：2-已完成
	 */
	public static final Integer TASK_STATUS_FINISHED = 2;
	/**
	 * 任务状态：3-已确认
	 */
	public static final Integer TASK_STATUS_CONFIRMED = 3;
}
