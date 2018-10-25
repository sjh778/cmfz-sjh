<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">

	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				//alert("自己做");
                this.src='${pageContext.request.contextPath}/defaultKaptcha.do?d='+new Date()*1
			});
			$(".loginButton").click(function(){
                //  form 表单提交
                $("#loginForm").form("submit",{
                    success:function(data){
                        //alert(data);
                        var jsObj = JSON.parse(data);
                        console.log(jsObj);
                        if(jsObj.yzm){
                            if(jsObj.isLogin){
                                window.location.href = "main/main.jsp";
                                //$("#loginBtn").html($("#username").val()+",欢迎您");
                            }else{
                                alert("用户名或密码错误");
                            }
                        }else{
                            alert("验证码输入错误");
                        }
                    },
                });
			})

		});
		/*function doLogin(){
            //  form 表单提交
            $("#loginForm").form("submit",{
                url:"login.do",
                success:function(data){
                    alert(data);
                    var jsObj = JSON.parse(data);
                    console.log(jsObj);
                    if(jsObj.yzm){
                        if(jsObj.isLogin){
                            window.location.href = /main/main.jsp";
                            //$("#loginBtn").html($("#username").val()+",欢迎您");
                        }else{
                            alert("用户名或密码错误");
                        }
					}else{
                        alert("验证码输入错误");
					}
                },
            });
		}*/
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm"  method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="username" class="text" value="xxx" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" value="xxx" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="vrifyCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/defaultKaptcha.do" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value=""><input type="button" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>