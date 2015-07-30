function check() {
	var u = document.getElementById("inputID").value;
	var statue  =false;
	$.ajax({
		url: "checkID.action",
		data : {"userID":u},
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		datatype : "json",
		async: false,
		success:function(data) {
			if(data.p=="false") {
				document.getElementById("inputID").setCustomValidity("该用户名已经存在");
				document.getElementById("inoutID").focus();
			}
			else {
				document.getElementById("inputID").setCustomValidity("");
				statue= checkPassword();
			}
		}

	});
	
	return statue;
}


function login() {
	var u = document.getElementById("userID").value;
	var p = document.getElementById("userPassword").value;
	var statue  =false;
	$.ajax({
		url: "login.action",
		data : {"userID":u,"password":p},
		type:"POST",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		datatype : "json",
		async: false,
		success:function(data) {
			if(data.p=="id") {
				document.getElementById("userPassword").setCustomValidity("");
				document.getElementById("userID").setCustomValidity("该账号不存在");
				document.getElementById("inoutID").focus();
			}
			if(data.p=="password"){
				document.getElementById("userID").setCustomValidity("");
				document.getElementById("userPassword").setCustomValidity("密码错误");
				document.getElementById("inoutID").focus();
			}
			if(data.p=="pass") {
				document.getElementById("userID").setCustomValidity("");
				document.getElementById("userPassword").setCustomValidity("");
				statue = true;
			}
		}

	});
	return statue;
}

function checkPassword() 
{ 

		var pass1 = document.getElementById("inputPassword");
        var pass2 = document.getElementById("inputPasswordAgain");
 
        if (pass1.value != pass2.value) {
        	document.getElementById("inputPasswordAgain").setCustomValidity("两次密码不一致");
        	document.getElementById("inputPasswordAgain").setCustomValidity.focus();
        	return false;
	}

        else {
            pass2.setCustomValidity("");
            return true;
	}
}