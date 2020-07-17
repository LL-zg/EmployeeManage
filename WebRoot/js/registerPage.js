var flg=false;
$(function(){
	
	
    var aErrorSpan=$('.error-con');     //错误提示消息

   

    /*表单得失焦点时进行验证*/
    $('.reg-col-2').find('input').bind('blur',function(){    
        var promptLab=$(this).siblings('label');
        var index=$(this).index('.reg-col-2 input'); 
        
	        if(index==1||index==4){
	            promptLab.hide();
	         }       
            if($(this).val()==''){
                if(index==1||index==4){
                    promptLab.show();
                    if(index==4){
                    	$("#getValidNum").hide();
                    }
                }
                aErrorSpan.eq(index).show();
            }else{ 
                aErrorSpan.eq(index).hide();
            	if(index==0){
            		checkUserNameIsValid($(this).val());
            	}else if(index==1){            			
            		if($(this).val().length<6){
            			 aErrorSpan.eq(index).show();         
            		}
            	}else if(index==2){
            		
            		checkPasswordIsSame();
            		
            	}else if(index==3){
            		
            		ValidForm.validEmail($(this)); 
            		
            	}else if(index==6){
            		
            		if(ValidForm.validPhone($(this))){
            			$("#getValidNum").show();
            		}else{
            			$("#getValidNum").hide();
            		}
            	}else if(index==7){
            		
            		if(ValidForm.validPhone($('#phone'))){
              		$.post( {code:$(this).val(),phone:$('#phone').val()},function(data){
                			if(data.success){
                				aErrorSpan.eq(index).hide();
                			}else{
                				aErrorSpan.eq(index).show();
                			}
                		});
            		}else{
            			aErrorSpan.eq(index).show();
            		}
            	}
            }
        });
 
    
   var checkPasswordIsSame=function(){
	   if($('#password').val()!=$('#confirmPwd').val()){
			$('.error-con').eq(2).show();
	   }
   };
   
   var checkUserNameIsValid=function(userName){
    	$.ajax( {
    		type : "POST", 
    		url : 'judgeEmployee?employee.username='+encodeURI(userName),
            data:'',
    		dataType: "json",
    		success : function(msg) {
    			if(msg!='2'){    
    				$('.error-con').eq(0).html("<span style='color:green'>该用户名未被注册,可以使用</span>");
    				$('.error-con').eq(0).show();
    			}
    			else{
    				$('.error-con').eq(0).html("<span style='color:red'>该用户名已经被注册,请重新输入用户名</span>");
    				$('.error-con').eq(0).show();
    			}
    		},
    		errors:function(msg){
    			alert(msg.msg);			
    		}
    	}); 
   }

    
    /*同意用户注册协议*/
    $('.agree-lab').click(function(){
        if($('#agreement').prop('checked')){
            $('#selected').css('background','#ea8010');
            flg=true;
        }
        else{
            $('#selected').css('background','#fff');
            flg=false;
        }
    });

    /*获取验证码*/
    $('#getValidNum').click(getValidNum);
    
   var submitvali=function (){
    	var test1=validNull($('.reg-col-2').find('input'),aErrorSpan);
        var test2=ValidForm.init($('#email'),$('#phone'));
        return test1&&test2&&flg;
    }
});

function check(){
	var aErrorSpan=$('.error-con');     //错误提示消息
	var test1 = validNull($('.reg-col-2').find('input'),aErrorSpan);
	var test2=ValidForm.init($('#email'),$('#phone'));
	console.debug(test2);
	return test1&&test2&&flg;
}

/*获取验证码
function getValidNum(){
	
	$.post('getValidateCode',{phone:$('#phone').val()},function(data){
		
	});
	
    var t=59,
        ele='<i>'+t+'</i>s 后可重新获取验证码';

    var _this=$(this),
        timer=null;

    _this.html(ele);
    tEle=_this.find('i');

    timer=setInterval(function(){
        t--;
        tEle.text(t);

        if(t<=0){
            _this.html('获取验证码');
            clearInterval(timer);
        }
    },1000);
}*/

function registerUser(){
	if(check()){
		$.ajax( {
    		type : "POST", 
    		url : 'registerUser',
            data:$('#registerForm').serialize(),
    		dataType: "json",
    		success : function(data) {
				data = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
    			if(data.success){    
    				alert("注册成功");
    				location.href="login.jsp";
    			}
    			else{
    				alert("注册失败");
    			}
    		},
    		errors:function(msg){
    			alert("未知异常");			
    		}
    	}); 
		
	}
	
	
}