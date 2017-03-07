<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.js"></script>
<script type="text/javascript" src="//cdn.bootcss.com/vue-resource/1.2.0/vue-resource.common.js"></script>
<html>
<head>
    <title>Vue</title>
</head>
<body>

<div id="app" style="text-align: center; margin-top: 10px">
    {{message}}
</div>

<div id="app2" style="text-align: center; margin-top: 20px">
    <!-- 将标签的title属性和message绑定 -->
    <span v-bind:title="message">
        Hover your mouse over me for a few seconds to see my dynamically bound title!
    </span>
</div>

<!-- 条件 -->
<div id="app3" style="text-align: center; margin-top: 30px">
    <p v-if="seen">Now you see me</p>
</div>

<!-- 循环 -->
<div id="app4">
    <ol>
        <li v-for="todo in todos">
            {{todo.text}}
        </li>
    </ol>
</div>

<!-- 监听 -->
<div id="app5" style="text-align: center; margin-top: 40px">
    <p>{{message}}</p>
    <button v-on:click="reverseMessage()">Reverse Message</button>
</div>


<div id="app6" style="text-align: center; margin-top: 60px">
    <p>{{message}}</p>
    <input v-model="message">
</div>

<!-- 组件 -->
<div id="app7" style="margin-top: 30px">
    <ol>
        <todo-item v-for="item in items" v-bind:todo="item"></todo-item>
    </ol>
</div>

<!-- ajax-vue -->
<div id="app8" style="text-align: center; margin-top: 30px">
    <table align="center" style="width: 300px">
        <thead>
        <tr>
            <th style="width: 25%">编号</th>
            <th style="width: 25%">用户名</th>
            <th style="width: 25%">密码</th>
            <th style="width: 25%">积分</th>
        </tr>
        </thead>
        <tr v-for="user in userList">
            <td style="text-align: center">{{user.userId}}</td>
            <td style="text-align: center">{{user.userName}}</td>
            <td style="text-align: center">{{user.password}}</td>
            <td style="text-align: center">{{user.credits}}</td>
        </tr>
    </table>
    <button @click="getUser()" style="margin-top: 10px">查询所有用户</button>
</div>


<script type="text/javascript">
    var app = new Vue({
        el: "#app",
        data: {
            message: "Hello World"
        }
    })

    var app2 = new Vue({
        el: "#app2",
        data: {
            message: "You load this page on " + new Date()
        }
    })

    var app3 = new Vue({
        el: "#app3",
        data: {
            seen: true
        }
    })

    var app4 = new Vue({
        el: "#app4",
        data: {
            todos: [
                {text: "Learn JavaScript"},
                {text: "Learn Vue"}
            ]
        }
    })

    var app5 = new Vue({
        el: "#app5",
        data: {
            message: "Hello Vue.js"
        },
        methods: {
            reverseMessage: function () {
                this.message = this.message.split("").reverse().join("")
            }
        }
    })

    var app6 = new Vue({
        el: "#app6",
        data: {
            message: "Hello Vue!"
        }
    })


    Vue.component('todo-item', {
        props: ['todo'],
        template: "<li>{{todo.text}}</li>"
    })

    var app7 = new Vue({
        el: "#app7",
        data: {
            items: [
                {text: 'Vegetables'},
                {text: 'Cheese'},
                {text: 'Whatever else humans are supposed to eat'}
            ]
        }
    })

    var userVue = new Vue({
        el: "#app8",
        data: {
            userList: ""
        },
        methods: {
            getUser: function () {
                var url = "/vue/getUser.action";
                var _self = this;
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    data:"userName=root",
                    success: function (data) {
                        _self.userList = data;

                    },
                    error: function (errMsg) {
                        alert(JSON.stringify(errMsg));
                    }
                })
            }
        }
    })


</script>

</body>
</html>
