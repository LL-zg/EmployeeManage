
/*验证提交的表单*/
function checkValid(){
	var bool=true;
	
	$('.type-text').each(function(index){
		if($(this).val()==''){
			bool=false;
		}
	});
	
	if(bool){
		$('#errorPrompt').hide();
		
	}else{
		$('#errorPrompt').text("用户名或密码不能为空");
		$('#errorPrompt').show();
	}
	return bool;
	
}


/*登录操作action*/
function loginUser(){
	if(checkValid()){
		$.ajax({
			type:"post",
			url:"loginUser",
			data:{//设置数据
				'username':$("input[name=username]").val(),
				'password':$("input[name=password]").val(),
			},
			dataType:"json",//设置需要返回的数据类型为json
			
			success:function(data){
				var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
				
				if(d.msg==0){
					window.location.href="./index.jsp";     
				}
				else{
					if(d.msg==2){
						$("#errorPrompt").text("密码错误，请检查密码");
					}
					else{
						$("#errorPrompt").text("用户名不存在，请检查用户名");
					}
					$("#errorPrompt").show();
					
				}
				//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
			
			},
			error:function(){
				alert("系统异常，请稍后重试！");
			}
			
		});
	}
}

//管理员的登录操作
function adminLogin(){
	$.ajax({
		type:"post",
		url:"adminLoginUser",
		data:{//设置数据
			'username':$("input[name=username]").val(),
			'password':$("input[name=password]").val(),
		},
		dataType:"json",//设置需要返回的数据类型为json
		
		success:function(data){
			var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			
			if(d.msg==0){
				window.location.href="./adminEp.jsp";
			}
			else{
				if(d.msg==2||d.msg==null){
					$("#errorPrompt").text("密码错误或者你并不是管理员");
				}
				else{
					$("#errorPrompt").text("用户名不存在，请检查用户名");
				}
				$("#errorPrompt").show();
				
			}
			//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
		
		},
		error:function(){
			alert("系统异常，请稍后重试！");
		}
		
	});
	
}





























