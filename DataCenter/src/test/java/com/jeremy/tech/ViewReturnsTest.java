package com.jeremy.tech;

import com.jeremy.tech.utils.DateUtil;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeremysong on 5/21/2017.
 */
public class ViewReturnsTest {

    private String resourcePath = "F:\\github\\SpringBootLearn\\src\\main\\resources\\templates";
    private VelocityEngine velocityEngine = new VelocityEngine();
    private Configuration configuration = new Configuration(); //freeMarker configuration

    @Test
    public void velocityTest() {

        // TODO 此处一直没有调用成功
        Map<String, Object> model = new HashMap<>();
        model.put("time", DateUtil.getInstance().getNowFullString());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");

        System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "welcome.vm", "UTF-8", model));
    }

    @Test
    public void freeMarkerTest() throws Exception {

        Map<String, Object> model = new HashMap<>();
        model.put("time", new Date());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");

        TemplateLoader loader = new FileTemplateLoader(new File(resourcePath));
        configuration.setTemplateLoader(loader);

        Template t = configuration.getTemplate("welcome.ftl"); // freeMarker template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        System.out.println(content);
    }
}
