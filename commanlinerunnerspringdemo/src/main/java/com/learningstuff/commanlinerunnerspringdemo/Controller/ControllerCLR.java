package com.learningstuff.commanlinerunnerspringdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerCLR {

    @RequestMapping(value = "")
    @ResponseBody
    public String CommandLineRunnerTest()
    {
        return "OK";
    }
}
