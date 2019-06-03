package com.sw.core.service.impl;

import com.sw.core.entity.Demo;
import com.sw.core.mapper.DemoMapper;
import com.sw.core.service.IDemoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaoyang123
 * @since 2019-05-29
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}
