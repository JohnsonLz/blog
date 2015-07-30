function zan (obj) {
	var id = obj.id.toString();
	var articleId = id.substring(3,id.length);
	var zanspan = document.getElementById("zanNumber"+articleId);
	var number = zanspan.innerHTML.toString();
	var inner = number.substring(0,number.length-1);

	var className = obj.className.toString();
	var zanNumber;
	if(className=="glyphicon glyphicon-heart-empty") {
		obj.className = "glyphicon glyphicon-heart";
		zanNumber = Number(inner)+1;
		$.ajax({
			url: "addZan.action",
			type:"POST",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {"id":articleId},
			datatype : "text",
			async: true,
			success:function(data) {
				if(data == "req")
					alert("请先登录");
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}

		});
	} else {
		obj.className = "glyphicon glyphicon-heart-empty";
		zanNumber = Number(inner)-1;
		$.ajax({
			url: "desZan.action",
			type:"POST",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {"id":articleId},
			datatype : "text",
			async: true,
			success:function(data) {
				if(data == "req")
					alert("请先登录");
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}

		});
	}
	zanspan.innerHTML=zanNumber.toString()+"赞";
}

function loadArticle(){
		$.ajax({
		url: "loadArticle.action",
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"key":"value"},
		datatype : "text",
		async: true,
		success:function(data) {
			$('#articleContainer').append(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}

	});
}

function showAll(obj) {
	var articleId = obj.parentNode.id;
	
	$.ajax({
		url: "showArticle.action",
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"id":articleId},
		datatype : "text",
		async: true,
		success:function(data) {
			document.getElementById(articleId).innerHTML = data;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}

	});
}

function hidePart(obj) {
	var articleId = obj.parentNode.id;
	
	$.ajax({
		url: "hidePart.action",
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"id":articleId},
		datatype : "text",
		async: true,
		success:function(data) {
			document.getElementById(articleId).innerHTML = data;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}

	});
}

function editChange(obj) {
	var height = obj.scrollHeight;
	obj.style.height = height+'px';
}

function showView(obj) {
	var id = obj.id.toString();
	var articleId = id.substring(2,id.length);
	var value = obj.innerHTML;
	
	if(value=="收起评论") {
		document.getElementById("review"+articleId).innerHTML = "";
		$.ajax({
			url: "reviewNumber.action",
			type:"POST",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {"id":articleId},
			datatype : "text",
			async: true,
			success:function(data) {
				obj.innerHTML= data+"条评论";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}

		});
	
	}
	else {
	
		$.ajax({
			url: "showView.action",
			type:"POST",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {"id":articleId},
			datatype : "text",
			async: true,
			success:function(data) {
				var tmp = "review" +articleId;
				document.getElementById(tmp).innerHTML = data;
				obj.innerHTML = "收起评论";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}

		});
	}
}

function publishReview(obj) {
	var id = obj.id.toString();
	var articleId = id.substring(2,id.length);
	var content = document.getElementById("rt"+articleId).value;

	$.ajax({
		url: "publishView.action",
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"id":articleId,"value":content,"time":new Date().toLocaleString()},
		datatype : "text",
		async: true,
		success:function(data) {
			if(data == "req")
				alert("请先登录");
			else {
				document.getElementById("rt"+articleId).value='';
				$('#rl'+articleId).prepend(data);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}

	});

}

