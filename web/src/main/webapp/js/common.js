/**
 * @Description:动态事件函数
 * @param method:请求方法 (必须)
 * @param url:请求链接 (必须)
 * @param dataType:请求数据类型 (必须)
 * @param params:请求参数 (必须)
 * @param callback:回调函数(必须)
 * @param timeout:超时时间 (可选)
 * @param showId:节点Id(可选)
 * @param isAsync:是否同步【true:异步;false:同步】 (可选)
 */
function postEvent(method,url,dataType,params,timeout,showId,callBack,isAsync) {
	if(!url){
		return;
	}
	if(isAsync){
		isAsync = true;
	}else if(isAsync !=false){
		isAsync = true;
	}
	$.ajax({
		type: method || "post",
		url: url,
		data: params || {},
		cache: false,
		async:isAsync,
		dataType: dataType || "text", 
		timeout: timeout || 30000,
		success:function(data){
			if(data==='noLogin'){
  				//未登陆
	  			window.location.href="index";
	  			return;
  			}
  			if(dataType == "JSON" || dataType == "json"){
  				if(callBack){
  					callBack(data);
  				}
  			}else{
  				if(showId){
  					$(showId).html("");
  					$(showId).html(data);
  				}
  				if(callBack){
  					callBack(data);
  				}
  			}
		},
		error:function(response, textStatus, errorThrown){
			if(response.responseText==='noLogin'){
				//未登陆
				window.location.href="index";
				return;
			}else if(response.status==408 || response.status== 504){
				jqAlert("业务处理超时");
			}else if(response.status==500){
				jqAlert("业务处理异常");
			}
		}
	});
}

/**
 * 弹出警告框
 * @param content 警告框内容
 * @param title  警告框标题
 * @param confirm 警告框关闭回调
 */
function jqAlert(content, title, confirm) {
	$.alert({
		title: title || '',
		animation: 'RotateX',
		content: content,
		confirmButtonClass: 'btn-primary',
		confirm: function(){
			if (confirm != null) {
				confirm();
			}
		}
	});
}

function showJsonData(data, succFunc, failFunc, excepFunc, 
		succTitle, failTitle, excepTitle, succComfirm, failComfirm, excepComfirm) {
	if (data) {
		if (data.code===0) {
			if (succFunc) {
				succFunc(data);
			} else {
				jqAlert(data.desp, succTitle, succComfirm);
			}
		} else if (data.code===1) {
			window.location.href="index";
		} else {
			if (failFunc) {
				failFunc(data);
			} else {
				jqAlert(data.desp, failTitle, failComfirm);
			}
		}
	} else {
		if (excepFunc) {
			excepFunc(data);
		} else {
			jqAlert("出现异常", excepTitle, excepComfirm);
		}
	}
}

function showModel(modelId, heightId, percent) {
	var pct;
	if (percent) {
		pct = percent;
	} else {
		pct = 1.0;
	}
	$(modelId + " .selectListBox").slideUp();
	$(modelId + " input[type=text]").val("");
	$(modelId).modal().css({
		"margin-top": - ($(heightId).height()*pct),
		"top": "50%"
    });
}

function showModelWithOutClean(modelId, heightId, percent) {
	var pct;
	if (percent) {
		pct = percent;
	} else {
		pct = 1.0;
	}
	$(modelId + " .selectListBox").slideUp();
	$(modelId).modal().css({
		"margin-top": - ($(heightId).height()*pct),
		"top": "50%"
	});
}

function postForm(url,dataType,formId,timeout,showId,callBack,isAsync) {
	if(!url){
		return;
	}
	if(isAsync){
		isAsync = true;
	}else if(isAsync !=false){
		isAsync = true;
	}
	$.ajax({
		type: method || "post",
		url: url,
		contentType: "multipart/form-data",
		data:$(formId).serialize(),
		cache: false,
		async:isAsync,
		dataType: dataType || "text",
		timeout: timeout || 30000,
		success:function(data){
			if(data==='noLogin'){
				//未登陆
				window.location.href="index";
				return;
			}
			if(dataType == "JSON" || dataType == "json"){
				if(callBack){
					callBack(data);
				}
			}else{
				if(showId){
					$(showId).html("");
					$(showId).html(data);
				}
				if(callBack){
					callBack(data);
				}
			}
		},
		error:function(response, textStatus, errorThrown){
			if(response.responseText==='noLogin'){
				//未登陆
				window.location.href="index";
				return;
			}else if(response.status==408 || response.status== 504){
				jqAlert("业务处理超时");
			}else if(response.status==500){
				jqAlert("业务处理异常");
			}
		}
	});
}

