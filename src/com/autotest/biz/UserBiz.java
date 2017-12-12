package com.autotest.biz;

import com.autotest.entity.User;

/**
 * 用户Biz层接口
 * @author emanon
 *
 */
public interface UserBiz {
	public boolean userLogin(String loginName, String loginPassword);
	public int getId(String loginName, String loginPassword);
}
