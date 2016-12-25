<%--
  Created by IntelliJ IDEA.
  User: SRn
  Date: 2016/8/14
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="js/jquery/jquery-1.11.3.min.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="js/common.js"></script>
</head>
<body>
    <div id="main" style="width: 600px;height:400px;"></div>

    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(function () {
            postEvent("post", "echarts/stat", "json", null, null, null, function (data) {
                showJsonData(data, function () {
                    show(data.arrays)
                });
            }, null);
        });

        var myChart = echarts.init(document.getElementById('main'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '异步数据加载示例'
            },
            tooltip: {},
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        });

        function show(arrays) {
            myChart.setOption({
                title: {
                    text: 'Confidence Band',
                    subtext: 'Example in MetricsGraphics.js',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        animation: false
                    },
                    formatter: function (params) {
                        return params[2].value;
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: arrays.map(function (item) {
                        return item.date;
                    }),
                    axisLabel: {
                        formatter: function (value, idx) {
                            var date = new Date(value);
                            return idx === 0 ? value : [date.getMonth() + 1, date.getDate()].join('-');
                        }
                    },
                    splitLine: {
                        show: false
                    },
                    boundaryGap: false
                },
                yAxis: {},
                series: [{
                    type: 'line',
                    data: arrays.map(function (item) {
                        return item.value;
                    }),
                    hoverAnimation: false,
                    symbolSize: 6,
                    itemStyle: {
                        normal: {
                            color: '#c23531'
                        }
                    },
                    showSymbol: false
                }]
            });
        }
    </script>
</body>
</html>
