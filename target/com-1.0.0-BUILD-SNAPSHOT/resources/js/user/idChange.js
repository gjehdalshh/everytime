var i_user = document.querySelector('#i_user')

// 아이디 변경
var user_nm = document.querySelector('.user_nm')
var user_id = document.querySelector('.user_id')
var user_pw = document.querySelector('.user_pw')
var user_chkId = document.querySelector('.user_chkId')
var idChangeBtn = document.querySelector('.idChangeBtn')

// 비밀번호 변경
var pwChangeBtn = document.querySelector('.pwChangeBtn')
var new_pw = document.querySelector('.new_pw')
var new_chkPw = document.querySelector('.new_chkPw')
var user_changePw = document.querySelector('.user_changePw')

// 이름 설정
var user_changeNm = document.querySelector('.user_changeNm')
var nmChangeBtn = document.querySelector('.nmChangeBtn')



var div1 = document.querySelector('.div1')
var div2 = document.querySelector('.div2')
var div3 = document.querySelector('.div3')

// url에 받은 파라미터 값 사용하기
var page = location.search
console.log(page)
var result = page.substring(6,7)
console.log(result)

if (result == 1) {
	div1.style.display = 'block'
	div2.style.display = 'none'
	div3.style.display = 'none'
}
if (result == 2) {
	div1.style.display = 'none'
	div2.style.display = 'block'
	div3.style.display = 'none'
}
if (result == 3) {
	div1.style.display = 'none'
	div2.style.display = 'none'
	div3.style.display = 'block'
}

// 아이디 변경
idChangeBtn.onclick = function() {

	var param = {
		i_user: i_user.value,
		user_nm: user_nm.value,
		user_id: user_id.value,
		user_chkId: user_chkId.value,
		user_pw: user_pw.value
	}
	console.log(param)

	fetch(`/user/idChange`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		switch (data.result) {
			case 1:
				alert('아이디 변경이 성공하였습니다')
				location.href=`/user/myProfile`
				break;
			case 2:
				alert('이름을 입력해주세요')
				break;
			case 3:
				alert('아이디를 입력해주세요')
				break;
			case 4:
				alert('패스워드를 입력해주세요')
				break;
			case 5:
				alert('이름이 일치하지 않습니다')
				break;
			case 6:
				alert('아이디가 일치하지 않습니다')
				break;
			case 7:
				alert('패스워드가 일치하지 않습니다')
				break;
		}
	})
}

//비밀변호 변경
pwChangeBtn.onclick = function() {

	var param = {
		i_user: i_user.value,
		user_pw: user_changePw.value,
		new_pw: new_pw.value,
		new_chkPw: new_chkPw.value
	}
	console.log(param)

	fetch(`/user/pwChange`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		switch (data.result) {
			case 1:
				alert('비밀번호 변경이 성공하였습니다')
				location.href=`/user/myProfile`
				break;
			case 2:
				alert('현재 비밀번호를 입력해주세요')
				break;
			case 3:
				alert('변경할 비밀번호를 입력해주세요')
				break;
			case 4:
				alert('변경할 비밀번호 확인을 입력해주세요')
				break;
			case 5:
				alert('현재 사용중인 비밀번호가 일치하지 않습니다')
				break;
			case 6:
				alert('변경할 비밀번호가 일치하지 않습니다')
				break;
		}
	})
}


// 이름 설정
nmChangeBtn.onclick = function() {
	var param = {
		i_user: i_user.value,
		user_nm: user_changeNm.value
	}
	console.log(param)

	fetch(`/user/nmChange`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		switch (data.result) {
			case 1:
				alert('이름 변경이 성공하였습니다')
				location.href=`/user/myProfile`
				break;
			case 2:
				alert('변경하려는 이름이 같습니다')
				break;
			case 3:
				alert('변경 가능 기간이 남았습니다')
				break;
		}
	})
}