$(function(){
    	layui.use('table', function(){
          var table=layui.table

          
          //渲染表格，执行一个table实例
          table.render({
            elem:'#table1',
            height:472,
            url:'readAllEmployee',//数据接口
            method:"post",
            page:true,//开启分页
            id:'tabReload',
            curr:1,
            limit:9,
            limits:[5,7,9],
            toolbar:'default',//开启工具栏
            
            parseData:function(res){
            	
            	res=$.parseJSON(res);
            	return res;	
            },

            cols:[[
                {type:'checkbox',fixed:'left',width:50},
                {field:'id',title:'ID',width:60,align:"center"},
                {field:'username',title:'用户名',minWidth:100,align:"center"},
                {field:'password',title:'密码',width:110,align:"center"},
                {field:'sex',title:'性别',width:60,align:"center"},
                {field:'department.idd',title:'所属部门',width:60,align:"center"},
                {field:'email',title:'用户邮箱',minWidth:130,align:"center"},
                {field:'phone',title:'电话号码',width:145,align:"center"}, 
                {fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}
            ]],
            
          });
          
          
         //监听头工具行
         
         table.on('toolbar(test)',function(obj){
         	var checkStatus =table.checkStatus(obj.config.id),
         		data=checkStatus.data;//获得选中行的数据
         		switch(obj.event){
         			case 'add':
         				layer.msg('添加');
         				location.href="toAddPage.action";
         			break;
         			
         			case 'update':
         				if(data.length==0){
         					layer.msg('请选择一行');
         					
         				}else if(data.length>1){
         					layer.msg('一次只能编辑一行');
         					
         				}else{
         					layer.alert('编辑[id]'+checkStatus.data[0].id);
         				}
         			break;
         			
         			case 'delete':
         				if(data.length==0){
         					layer.msg('请选择一行');
         				}
         				else{
         					layer.confirm('确定要删除嘛',function(index){
         	                    obj.del();//删除对应行(tr)的DOM结构
         	                    layer.close(index);
         	                    //向服务器发送删除指令
         	                    $.ajax({			
         						   type:"post",
         				           url:"deleteEmployee",
         				           data:{//设置数据源
         				               	'id':data.id,								
         									
         							},
         							dataType:"json"//设置需要返回的数据类型
         	                    });
         	      
         	                  });
         					
         				}
         			break;
         		};
         });
         
          
		//监听行工具条
          table.on('tool(test)',function(obj){
              var data=obj.data//获得当前行数据
              ,layEvent =obj.event;//获得lay-event的值

              if(layEvent=='detail'){
            	  parent.layer.open({
              	  	type:2,
              	  	area:['700px','450px'],
              	  	fixed:false,
              	  	maxmin:true,
              	  	content:'index.jsp'
              	  
                });
              }
              else if(layEvent=='edit'){
                  parent.layer.open({
                	  	type:2,
                	  	area:['700px','450px'],
                	  	fixed:false,
                	  	maxmin:true,
                	  	content:'modifyInfo.jsp'
                	  
                  });
              }
              else if(layEvent=='del'){
                  layer.confirm('确定要删除嘛',function(index){
                    obj.del();//删除对应行(tr)的DOM结构
                    layer.close(index);
                    //向服务器发送删除指令
                    $.ajax({			
					   type:"post",
			           url:"deleteEmployee",
			           data:{//设置数据源
			               	'id':data.id,								
								
						},
						dataType:"json"//设置需要返回的数据类型
/*						success:function(data){
							
						
						},
						error:function(){
							alert("系统异常，请稍后重试！");
						}//这里不要加","
*/					});
      
                  });
              }
          });  
          
         var $ =layui.$,active={
        		  search:function(){
        			  var username=$('#username').val();
        			  table.reload('tabReload',{
        				  page:{
        					  curr:1
        				  },
        				  
        				  where:{
        					  username:username
        				  }
        			  });
        			  
        		  }
        		  
          };
          
          $('.layui-btn').on('click',function(){
        	  var type=$(this).data('type');
        	  active[type]? active[type].call(this):'';
          });
          table.init();
        });
    
    });