$(function(){
    	layui.use('table', function(){
          var table=layui.table

          
          //渲染表格，执行一个table实例
          table.render({
            elem:'#table1',
            height:472,
            url:'readAllSalary',//数据接口
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
                {field:'sid',title:'SID',width:60,align:"center"},
                {field:'basePay',title:'基本工资',minWidth:100,align:"center"},
                {field:'subsidy',title:'津贴',minWidth:110,align:"center"},
                {field:'acFuncd',title:'公积金',minWidth:60,align:"center"},
                {field:'socialSec',title:'保险费',minWidth:100,align:"center"},
                {field:'misc',title:'水电杂费',minWidth:130,align:"center"}, 
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
         				location.href="toAddSalaryPage.action";
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
         				           url:"deleteSalary",
         				           data:{//设置数据源
         				               	'sid':data.sid,								
         									
         							},
         							dataType:"json",//设置需要返回的数据类型
         							success:function(data){
         								
         							
         							},
         							error:function(){
         								alert("系统异常，请稍后重试！");
         							}//这里不要加","
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
                  layer.msg('点击了查看操作');
              }
              else if(layEvent=='edit'){
                  layer.msg('点击了编辑操作');
              }
              else if(layEvent=='del'){
                  layer.confirm('确定要删除嘛',function(index){
                    obj.del();//删除对应行(tr)的DOM结构
                    layer.close(index);
                    //向服务器发送删除指令
                    $.ajax({			
					   type:"post",
			           url:"deleteSalary",
			           data:{//设置数据源
			               	'sid':data.sid,								
								
						},
						dataType:"json",//设置需要返回的数据类型
						success:function(data){
							
						
						},
						error:function(){
							alert("系统异常，请稍后重试！");
						}//这里不要加","
					});
      
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
        					  sid:username
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