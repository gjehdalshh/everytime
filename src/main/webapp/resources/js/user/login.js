var login_form = document.querySelector('#login_form')
var btn_login = document.querySelector('#btn_login')
var id = document.querySelector('.input_id')
var pw = document.querySelector('.input_pw')


btn_login.onclick = function () {
	loginProc()
}

function loginEnter() {
	if(event.keyCode ==  13) {
		loginProc()
	}
}

function loginProc() {
	
		var param = {
			user_id: id.value,
			clkPw: pw.value
		}
		
		console.log(param)
		
		fetch(`/user/loginProc`, {
			method: 'POST',
			headers: {
		'Content-Type': 'application/json'
			},
			body:JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			console.log(data)
			switch(data.result) {
				case 1:
					alert('로그인 성공')
					location.href=`/main/home`
					break;
				case 2:
					alert('아이디 없음')
					break;
				case 3:
					alert('비밀번호 틀림')
					break;
			}
		})
}





