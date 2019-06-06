package com.sw.common.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.xml.sax.DocumentHandler;

import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
 
public class WordUtil {


	
	public static InputStream createWPHWord(Map<?, ?> map) {
        InputStream inputStream = null;
        try {
            String templateName = "WPH.ftl";
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            // ftl模板文件
            configuration.setClassLoaderForTemplateLoading(DocumentHandler.class.getClassLoader(),"/templates/");
            // 获取模板
            Template template = configuration.getTemplate(templateName);
            File outFile = File.createTempFile("WPH", ".docx");
            outFile.deleteOnExit();
            // 将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            // 生成文件
            template.process(map,out);
            out.flush();
            out.close();
            inputStream = new FileInputStream(outFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

}
