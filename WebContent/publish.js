function titleChange(obj) {
	var height = obj.scrollHeight;
	obj.style.height = height+'px';
}

function publish() {
	var ti = document.getElementById("title").value;
	var co = document.getElementById("content").value;

	$.ajax({
		url: "publish.action",
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"title":ti,"content":co,"time":new Date().toLocaleDateString()},
		datatype : "text",
		async: false,
		success:function(data) {
			if(data == "req")
				alert("请先登录");
		}

	});

}
