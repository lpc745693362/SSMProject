<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/macarons.js"></script>
<html>
<head>
    <title>折线图示例</title>
</head>
<body>

<div id="main" style="width:1000px;height:500px;border:1px solid #dddddd;margin:50px auto;"></div>
<div style="text-align: center" style="margin-top: 600px">
    <input type="button" onclick="drawEchart()" value="折线图">
</div>

<script type="text/javascript">

    function drawEchart() {
        var myChart = echarts.init(document.getElementById('main'), 'macarons');
        myChart.showLoading({
            text: "折线图数据正在努力加载..."
        });
        $.ajax({
            url: "/charts/pOption.action",
            type: "post",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                myChart.setOption(data);
                myChart.hideLoading();
            },
            error: function (msg) {
                alert(msg);
            }
        })
    }


    //        var myChart = echarts.init(document.getElementById('main'), 'macarons');
    //        option = {
    //            title: {
    //                text: '未来一周气温变化',
    //                subtext: '纯属虚构'
    //            },
    //            tooltip: {
    //                trigger: 'axis'
    //            },
    //            legend: {
    //                data: ['最高气温', '最低气温']
    //            },
    //            toolbox: {
    //                show: true,
    //                feature: {
    //                    mark: {show: true},
    //                    dataView: {show: true, readOnly: false},
    //                    magicType: {show: true, type: ['line', 'bar']},
    //                    restore: {show: true},
    //                    saveAsImage: {show: true}
    //                }
    //            },
    //            calculable: true,
    //            xAxis: [
    //                {
    //                    type: 'category',
    //                    boundaryGap: false,
    //                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
    //                }
    //            ],
    //            yAxis: [
    //                {
    //                    type: 'value',
    //                    axisLabel: {
    //                        formatter: '{value} °C'
    //                    }
    //                }
    //            ],
    //            series: [
    //                {
    //                    name: '最高气温',
    //                    type: 'line',
    //                    data: [11, 11, 15, 13, 12, 13, 10],
    //                    markPoint: {
    //                        data: [
    //                            {type: 'max', name: '最大值'},
    //                            {type: 'min', name: '最小值'}
    //                        ]
    //                    },
    //                    markLine: {
    //                        data: [
    //                            {type: 'average', name: '平均值'}
    //                        ]
    //                    },
    //                    "coordinateSystem": "cartesian2d"
    //                },
    //                {
    //                    name: '最低气温',
    //                    type: 'line',
    //                    data: [1, -2, 2, 5, 3, 2, 0],
    //                    markPoint: {
    //                        data: [
    //                            {name: '周最低', value: -2, xAxis: 1, yAxis: -2}
    //                        ]
    //                    },
    //                    markLine: {
    //                        data: [
    //                            {type: 'average', name: '平均值'}
    //                        ]
    //                    },
    //                    "coordinateSystem": "cartesian2d"
    //                }
    //            ]
    //        };
    //
    //        myChart.setOption(option);

</script>

</body>
</html>
