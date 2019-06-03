package com.sw.interceptor;

//import com.alibaba.fastjson.JSONObject;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sw.common.constants.AppConstants;
//import com.sw.common.response.ErrorEnum;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;

/**
 * 登录拦截器
 */

public class LoginHandlerInterceptor /*implements HandlerInterceptor*/ {

   /* private static Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        String token  =  request.getHeader("token");
        if(StringUtils.isBlank(token)){
            logger.info("[登录拦截器]未获取到用户token, 登录失败，请求Url：{} ",url);

            response.getWriter().write(objectMapper.writeValueAsString(buildNotLoginMap()));
            return false;
        }
        boolean isLogin = redisTemplate.hasKey(AppConstants.KEY_USER_INFO+token);
        if(!isLogin){
            logger.info("[登录拦截器]:请求URL: {} 获取到token {} , redis没有用户信息",url,token);
            response.getWriter().write(JSONObject.toJSONString(buildTokenInvalid()));
            return false;
        }
        return true;
    }

    //token为空
    private Map<String,Object> buildNotLoginMap(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status", ErrorEnum.NO_TOKEN.status());
        resultMap.put("msg",ErrorEnum.NO_TOKEN.msg());
        return resultMap;
    }
    //token不合法
    private Map<String,Object> buildTokenInvalid(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status", ErrorEnum.INVALID_TOKEN.status());
        resultMap.put("msg",ErrorEnum.INVALID_TOKEN.msg());
        return resultMap;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }*/
}
