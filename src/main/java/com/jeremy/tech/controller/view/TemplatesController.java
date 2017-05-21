package com.jeremy.tech.controller.view;

import com.jeremy.tech.utils.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by jeremysong on 5/21/2017.
 */
@Controller
@RequestMapping("/views")
public class TemplatesController {

    @RequestMapping("/email")
    public String hi(Map<String, Object> model) {
        model.put("time", DateUtil.getDataString(DateUtil.DATE_FORMAT_DATA_TIME));
        // model.put("time", DateUtil.getDataString(DateUtil.DATE_FORMAT_TIME));
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");
        return "welcome"; //自动寻找resources/templates中名字为welcome的文件作为模板，拼装后返回
    }

}
