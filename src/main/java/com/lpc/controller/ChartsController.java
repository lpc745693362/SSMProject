package com.lpc.controller;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.feature.Mark;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Series;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 组装折线图模版
 */
@Controller
@RequestMapping("/charts")
public class ChartsController {

    @RequestMapping("/pOption")
    @ResponseBody
    public String pOption() {

        try {
            Option option = new Option();
            option.title().text("未来一周气温变化");
            option.title().subtext("纯属虚构");

            option.tooltip().trigger(Trigger.axis);

            String data[] = {"最高气温", "最低气温"};
            option.legend().data(Arrays.asList(data));

            option.toolbox().show(true);
            option.toolbox().feature(new Feature().dataView.show(true).readOnly(false));
            option.toolbox().feature(new Feature().magicType.show(true).type(new String[]{"line", "bar"}));
            option.toolbox().feature(new Feature().restore.show(true));
            option.toolbox().feature(new Feature().saveAsImage.show(true));

            Map<String, Integer[]> map = new HashMap<String, Integer[]>();
            map.put("最高气温", new Integer[]{11, 12, 15, 13, 10, 13, 11});
            map.put("最低气温", new Integer[]{0, -2, 2, 5, 3, 2, -1});

            option.calculable(true);

            // X坐标
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.type(AxisType.category);
            xAxis.boundaryGap(false);
            List<String> list = new ArrayList<String>();
            String str[] = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
            xAxis.data(str);
            option.xAxis(xAxis);

            // Y坐标
            ValueAxis yAxis = new ValueAxis();
            yAxis.type(AxisType.value);
            yAxis.axisLabel().formatter("{value} °C"); // 温度格式化
            option.yAxis(yAxis);

            List<Series> seriesList = new ArrayList<Series>();
            for (int i = 0; i < data.length; i++) {
                MarkPoint markPoint = new MarkPoint();
                String name = data[i];
                if ("最高气温".equals(name)) {
                    markPoint.data(new Data().type(MarkType.max).name("最大值"), new Data().type(MarkType.min).name("最小值"));
                } else {
                    markPoint.data(new Data().name("周最低").value(-2).xAxis(1).yAxis(-2));
                }

                MarkLine markLine = new MarkLine();
                markLine.data(new Data().type(MarkType.average).name("平均值"));

                Line line = new Line();
                line.name(data[i]);
                line.type(SeriesType.line);
                line.data(map.get(data[i]));
                line.markPoint(markPoint);
                line.markLine(markLine);

                seriesList.add(line);
            }
            option.series(seriesList);

            ObjectMapper mapper = new ObjectMapper();
            // 为空则不进行序列化输出
            mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            String outJson = mapper.writeValueAsString(option);
            System.out.println("outJson is ========= " + outJson);
            return outJson;
        } catch (Exception e) {
            System.out.println("e is ========= " + e);
        }

        return null;
    }


}
