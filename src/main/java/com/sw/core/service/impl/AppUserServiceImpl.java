package com.sw.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sw.core.entity.AppUser;
import com.sw.core.mapper.AppUserMapper;
import com.sw.core.service.IAppUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaoyang123
 * @since 2019-05-29
 */
@Service
@Transactional
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements IAppUserService {


    @Override
    public AppUser findByUsername(String username) {
    	if(StringUtils.isBlank(username)) return null;
        return this.selectOne(new EntityWrapper<AppUser>()
        		.eq("username",username)
        		.eq("is_del", "0"));
    }

	@Override
	public AppUser findByMobile(String mobile) {
		if(StringUtils.isBlank(mobile)) return null;
		return this.selectOne(new EntityWrapper<AppUser>()
				.eq("mobile", mobile)
				.eq("is_del", "0"));
	}

	
	
	@Override
	public AppUser smsCodeLogin(String code, String mobile) {
		
		return null;
	}
	
	
		
    
    
}
