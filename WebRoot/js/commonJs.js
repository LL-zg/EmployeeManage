/*表单非空检验*/
function validNull(aInput,aErrorLb){
    var boolean=true;
    aInput.each(function(index){
        if($(this).val()==''){
            boolean=false;
            aErrorLb.eq(index).show();
        }else{
            aErrorLb.eq(index).hide();
        }
    });
    return boolean;
}

/*QQ号、邮箱及手机号码合法性检验*/
var ValidForm={
    flag:false,
    init: function(email,phoneNum){
        var email=email,
            phoneNum=phoneNum;

        _this=this;
        var flag1=_this.validEmail(email),
            flag2=_this.validPhone(phoneNum);     
        if(flag1&&flag2){
            _this.flag=true;
        }

        return _this.flag;
    },


    validEmail: function(emailEle){
        var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,    //邮箱地址正则
            testStr=emailEle.val();

        if(filter.test(testStr)){
            emailEle.siblings('span').hide();
            return true;
        }
        else {
            emailEle.siblings('span').show();
            return false;
        }
    },

    validPhone:function(phoneEle){
        var phoneFilter=/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i,    //手机号码正则
            testStr=phoneEle.val();

        if(phoneFilter.test(testStr)){
            phoneEle.siblings('span').hide();
            return true;
        }
        else{
            phoneEle.siblings('span').show();
            return false;
        }
    }
    
};
