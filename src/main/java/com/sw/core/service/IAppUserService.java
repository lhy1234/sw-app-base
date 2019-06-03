package com.sw.core.service;

import com.sw.core.entity.AppUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaoyang123
 * @since 2019-05-29
 */
public interface IAppUserService extends IService<AppUser> {

	/**
	 * 通过用户名查询
	 * @param username
	 * @return
	 */
    AppUser findByUsername(String username);

    /**
              * 通过手机号查询
     * @param mobile
     * @return
     */
	AppUser findByMobile(String mobile);

	
	/**
	   * 短信验证码登录
	 * @param code
	 * @param mobile
	 * @return
	 */
	AppUser smsCodeLogin(String code, String mobile);

}
