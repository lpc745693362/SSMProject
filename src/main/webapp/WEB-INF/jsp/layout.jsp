<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面布局</title>

    <style type="text/css">
        .div1 {
            border: 5px solid #F00; /* 边框 */
            width: 500px;
            /*height: 100px;*/
            margin: 20px; /* 外边距 */
            padding: 20px; /* 内边距 */
            text-align: center;
        }

        .div2 {
            border: 5px solid #F00;
            width: 200px;
            height: 100px;
            margin: 20px;
            float: left;
        }

        .div3 {
            border: 5px solid #F00;
            width: 200px;
            height: 100px;
            margin: 20px;
            float: right;
            text-align: right;
        }

        .position {
            border: 1px solid #F00;
            width: 400px;
            height: 200px;
            position: relative; /* 相对定位 */
            float: left;
        }

        .position-a {
            border: 1px solid #000;
            width: 200px;
            position: absolute; /* 绝对定位 */
            left: 10px;
            top: 20px;
        }

        .position-b {
            border: 1px solid #00F;
            width: 200px;
            position: absolute;
            right: 20px;
            bottom: 30px;
        }

        .clear{
            clear: both; /* 清除浮动 */
        }

        .div4{
            border: 1px solid #FF8800;
            width: 150px;
            padding: 10px;
            margin: 10px;
        }

        .div4 li {
            width: 150px;
            height: 24px;
            line-height: 24px;
            font-size: 12px;
            color: #6699FF;
            overflow: hidden; /* 超出部分隐藏 */
            text-overflow: ellipsis; /* 为本溢出时显示省略号 */
            border-bottom: 1px #FF8000 dashed;
        }

        .div4 li a {
            text-decoration: none; /* 去掉下划线 */
        }

        .div4 li a:hover {
            color: #333;
        }

    </style>

</head>
<body>

<div class="div1">
    <div class="div2">左盒子<span style="display: block">后面会换行</span>我被前面换行了</div>
    <div class="div3"><a style="cursor: pointer">浮动右盒子</a></div>
    <div class="clear"></div>
</div>

<div class="position">
    <div class="position-a">position-a</div>
    <div class="position-b">position-b</div>
</div>

<div class="clear"></div>


<ul class="div4">
    <li><a href="#"><nobr>&#8226; 显示不完显示省略号，第一排测试内容</nobr></a></li>
    <li><a href="#"><nobr>&#8226; 第二排测试内容超出显示啦哈哈</nobr></a></li>
    <li><a href="#"><nobr>&#8226; 可以显示完</nobr></a></li>
</ul>


</body>
</html>
