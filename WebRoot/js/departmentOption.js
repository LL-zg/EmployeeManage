$(function(){
    	layui.use('table', function(){
          var table=layui.table

          
          //渲染表格，执行一个table实例
          table.render({
            elem:'#table1',
            height:472,
            url:'readAllDepartment',//数据接口
            method:"post",
            page:true,//开启分页
            limit:9,
            limits:[4,7,9],
            toolbar:'default',//开启工具栏
            
            parseData:function(res){
            	
            	res=$.parseJSON(res);
            	return res;	
            },

            cols:[[
                {type:'checkbox',fixed:'left',width:50},
                {field:'idd',title:'DID',width:60,align:"center"},
                {field:'dname',title:'部门名称',width:100,align:"center"},
                {field:'dmanager',title:'部门经理',width:110,align:"center"},
                {field:'dnumber',title:'人数',width:60,align:"center"},
                {field:'ddesc',title:'部门介绍',minWidth:100,align:"center"},
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
         				location.href="admin/addDepartment.jsp";
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
         				           url:"deleteDepartment",
         				           data:{//设置数据源
         				               	'idd':data.idd,								
         									
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
			           url:"deleteDepartment",
			           data:{//设置数据源
			               	'idd':data.idd,								
								
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
        });
    
    });