/**
 * 使用ajax加载数据字典，生成select
 * 参数1：数据字典类型（dict_type_code)
 * 参数2：将下拉选放入的标签id
 * 参数3：生成下拉时，select标签的name属性值
 * 参数4：需要回显时，选择哪个option
 * 
 */

function loadSelect(typecode,positionId,selectname,selectedId){
	//创建select对象，将name属性指定
	var $select = $("<select name="+selectname+"></select>");
	//添加提示选项
	$select.append($("<option value=''>---请选择---</option>"));
	//使用jquery的ajax方法，访问后台Action
	$.post("${pageContext.request.contextPath}/BaseDictAction",{dict_type_code:typecode},
		function(data){
			//返回json数组对象，对其变量
			$.each(data,function(i,json){
				//每次遍历创建一个option对象
				var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
				if(json['dict_id'] == selectedId){
					//判断是否需要回显，如果需要使其被选中
						$option.attr("selected","selected");
				}
				//并添加到select对象
						$select.append($option);
			});
	},"json");
	
	//将组装好的select对象放入页面指定位置
	$("#"+positionId).append($select);
}