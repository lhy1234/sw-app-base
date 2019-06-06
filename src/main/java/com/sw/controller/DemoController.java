package com.sw.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.xml.sax.DocumentHandler;

import com.sw.common.utils.WordUtil;

import freemarker.template.Template;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaoyang123
 * @since 2019-05-29
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping(value = "/index")
    public ModelAndView index() {
		ModelAndView mav  = new ModelAndView();
		mav.setViewName("hello");
        mav.addObject("title", "hello");
        return mav;
    }
	
	@Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
	
    private Base64 b64Encoder = new Base64();
	
    

    
	@RequestMapping(value = "/WPH")
    public void WPH(HttpServletRequest request,HttpServletResponse response) throws  Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/force-download");//应用程序强制下载
        try {
        	Map<String,Object> dataMap = new HashMap<>();
        	dataMap.put("title", "沈阳军区总院I期临床研究室");
        	dataMap.put("smoCompanyName","北京中兴正远科技有限公司" );
        	dataMap.put("smoCompanyNameSimple", "中兴正远");
        	dataMap.put("sponsorName", "浙江海正药业股份有限公司");
        	dataMap.put("trialName", "塞来昔布胶囊在健康受试者中单中心、随机、开放、三周期、三序列、半重复空腹及餐后状态下生物等效性试验");

            //map----------------------------------------------------------end
            InputStream inputStream = WordUtil.createWPHWord(dataMap);
            response.setContentType("application/zip");
            OutputStream out = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment; filename="+"schoolReport"+".doc");
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if(b!=-1) out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
           
        }


    }
}

