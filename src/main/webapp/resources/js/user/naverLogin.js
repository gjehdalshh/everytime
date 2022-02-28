var pw = document.querySelector('.user_pw')
var clkPw = document.querySelector('.clkPw')
var btn = document.querySelector('.btn')
var ph = document.querySelector('.ph')
var mail = document.querySelector('.mail')
var user_nm = document.querySelector('.user_nm')
var gender = document.querySelector('.gender')
var entrance = document.querySelector('.entrance')

btn.onclick = function() {
	param = {
		user_pw:pw.value,
		clkPw: clkPw.value,
		ph: ph.value,
		mail: mail.value,
		user_nm: user_nm.value,
		gender: gender.value,
		entrance: entrance.value
	}
	
	console.log(param)
	fetch(`/user/naverLogin`, {
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
					location.href='/main/home'
					break;
				case 2:
					alert('비밀번호 확인이 다름')
					break;
			}
		})
}