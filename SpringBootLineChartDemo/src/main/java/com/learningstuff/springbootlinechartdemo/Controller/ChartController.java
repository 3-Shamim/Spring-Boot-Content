package com.learningstuff.springbootlinechartdemo.Controller;

import com.learningstuff.springbootlinechartdemo.DataProvider.DummyData;
import com.learningstuff.springbootlinechartdemo.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "line_chart")
public class ChartController {

    private DummyData dummyData = new DummyData();

    @RequestMapping(value = "")
    private String LineChartData(Model model)
    {
        model.addAttribute("title","Line Chart");
        return "Template/LineChart";
    }

    @RequestMapping(value = "linechartapi")
    @ResponseBody
    private List<User> AllDetailsApi()
    {

        return dummyData.getUserList();
    }

}
