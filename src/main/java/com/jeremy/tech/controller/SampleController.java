package com.jeremy.tech.controller;

import com.jeremy.tech.entity.Robot;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeremysong on 5/21/2017.
 */
@RestController
@RequestMapping("/public")
public class SampleController {

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "this is a plain text returns!";
    }

    @RequestMapping("/getRobot")
    @ResponseBody
    public Robot getRobot(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "id", required = false) String id) {
        return new Robot(type, id);
    }

    @RequestMapping("/{who}/submit")
    public String submit(
            @PathVariable("who") String who) {
        return String.format("user %s", who);
    }
}
