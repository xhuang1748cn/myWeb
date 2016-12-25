package cn.srn.controllers;

import cn.srn.respson.EchartsData;
import cn.srn.respson.EchartsInfo;
import cn.srn.respson.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRn on 2016/8/14.
 */
@Controller
@RequestMapping("/echarts")
public class EChartsControler {


    @RequestMapping(value = {"", "/"})
    public String echarts() {
        return "echarts";
    }

    @RequestMapping(value = "stat")
    @ResponseBody
    public ResponseInfo stat() {
        EchartsInfo echartsInfo = new EchartsInfo();
        echartsInfo.setCode(0);
        echartsInfo.setMessage("成功");
        List<EchartsData> datas = new ArrayList<>();
        datas.add(new EchartsData(10, "2016-08-01"));
        datas.add(new EchartsData(11, "2016-08-02"));
        datas.add(new EchartsData(21, "2016-08-03"));
        datas.add(new EchartsData(50, "2016-08-04"));
        datas.add(new EchartsData(35, "2016-08-05"));
        datas.add(new EchartsData(100, "2016-08-06"));
        datas.add(new EchartsData(49, "2016-08-07"));
        datas.add(new EchartsData(82, "2016-08-08"));
        datas.add(new EchartsData(23, "2016-08-09"));
        echartsInfo.setArrays(datas);
        return echartsInfo;
    }
}
