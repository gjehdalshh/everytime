var btn_join = document.querySelector('#btn_join')

btn_join.onclick = function() {
	var entrance = document.querySelector('.select')
	var university = document.querySelector('.university')
	var user_nm = document.querySelector('.user_nm')
	var user_id = document.querySelector('.user_id')
	var user_pw = document.querySelector('.user_pw')
	var clkPw = document.querySelector('.clkPw')
	var ph = document.querySelector('.ph')
	var gender = document.querySelector('.gender')
	var mail = document.querySelector('.mail')
	
	var param = {
		entrance: entrance.value,
		university: university.value,
		user_nm: user_nm.value,
		user_id: user_id.value,
		user_pw: user_pw.value,
		clkPw: clkPw.value,
		ph: ph.value,
		mail: mail.value,
		gender: gender.value
	}
	
	console.log(param)
	
	fetch(`/user/joinProc`, {
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
					alert('회원가입 성공')
					location.href=`/user/login`
					break;
				case 2:
					alert('비밀번호 확인이 다름')
					break;
				case 3:
					alert('이름이 네글자 이상임')
					break;
				case 4:
					alert('아이디가 이미 존재함')
					break;
				case 5:
					alert('이름이 이미 존재함')
					break;
				case 6:
					alert('전화번호가 이미 존재함')
					break;
				case 7:
					alert('메일이 이미 존재함')
					break;
			}
		})
	
}






