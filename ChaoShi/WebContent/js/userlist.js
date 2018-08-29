var userObj;
/**
 * 全选事件
 */
$(function(){
	$("#cct").click(function(){
		var aat = $("#cct").attr("checked");
		if(aat){
			$("input[name='ccte']").attr("checked","true");
		}else{
			$("input[name='ccte']").removeAttr("checked");
		}
	})
	$("#delt").click(function(){
		if($(".tte:checked").length==0){
			alert("请勾选用户！");
		}else{
			if(confirm("确定要删除吗？")){
				var aac = "";
				var aact =$(".tte:checked");
				aact.each(function(i){
					aac+=$(this).val();
					if((i+1)!==aact.length){
						aac+=",";
					}
				});
				$.post(path+"/DelUserServlet",{
					"uid":aac,
				},function(data){
					if(data>0){
						alert("删除成功!");
						//aact.parent().parent().remove();
						//loction.href=path"/QueryUserSerlvet";
						location.reload();
					}else{
						alert("删除失败！");
					}
				})
			}
		}
		
	})
})
//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
	$.ajax({
		type:"post",
		url:path+"/DelUserServlet",
		data:{method:"deluser",uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data> 0){//删除成功：移除删除行
				changeDLGContent("删除用户【"+obj.attr("username")+"】成功！");
				location.reload();
				/*cancleBtn();
				obj.parents("tr").remove();*/
			}else if(data<0){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}/*else if(data.delResult == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}*/
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/QueryIdUser?method=view&uid="+ obj.attr("userid");
	});
	
	$(".modifyUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=modify&uid="+ obj.attr("userid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteUser(userObj);
	});

	$(".deleteUser").on("click",function(){
		userObj = $(this);
		changeDLGContent("你确定要删除用户【"+userObj.attr("username")+"】吗？");
		openYesOrNoDLG();
	});
	
	/*$(".deleteUser").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/user.do",
				data:{method:"deluser",uid:obj.attr("userid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除用户【"+obj.attr("username")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，用户【"+obj.attr("username")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});