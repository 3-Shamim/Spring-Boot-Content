package com.learningstuff.computershopadminpanel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "CMS")
public class IndexController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(){

        return "Ok";
    }
}
