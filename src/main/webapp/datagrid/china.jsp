<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/china.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main2" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    option = {
        title : {
            text: '地区分布',
//            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['男','女',]
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
    };
    $.ajax({
        url:"${pageContext.request.contextPath}/user/getDistribution",
        dataType:"json",
        success:function (data) {
            console.log(data.a);
            console.log(data.b);
            myChart.setOption(option);
            myChart.setOption({
                series:[{
                    name: '女',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:data.a
                },{
                    name: '男',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:data.b
                }]
            });
        }
    });

</script>
</body>
</html>
