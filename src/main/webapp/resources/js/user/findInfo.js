var mail = document.querySelector('.mail')
var id = document.querySelector('.user_id')

function pageMove(page) {
	location.href='/user/findInfo?page='+page
}

function btn_find(page) {

	if (page == 1) {
		var param = {
			mail: mail.value
		}
	} else {
		var param = {
			mail: mail.value,
			user_id: id.value
		}
	}

	fetch(`/user/findInfoProc`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		console.log(data)
		 if(data.result != null) {
			alert('이메일로 발송되었습니다.')
		} else if(data.result == null) {
			alert('이메일로 발송이 실패하였습니다.')
		}
	})

}

