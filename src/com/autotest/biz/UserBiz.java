package com.autotest.biz;

import com.autotest.entity.User;

/**
 * �û�Biz��ӿ�
 * @author emanon
 *
 */
public interface UserBiz {
	public boolean userLogin(String loginName, String loginPassword);
	public int getId(String loginName, String loginPassword);
}
