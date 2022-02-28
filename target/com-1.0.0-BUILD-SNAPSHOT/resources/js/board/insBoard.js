var i_user = document.querySelector('#i_user')
var i_board_type = document.querySelector('#i_board_type')
var title = document.querySelector('.title')
var ctnt = document.querySelector('.ctnt')
var secret = document.querySelector('.secret')
var submit = document.querySelector('#submit')
var pageNow = document.querySelector('.pageNow')
var pageFirst = document.querySelector('.pageFirst')

function board(i_board_type, pageNow, pageFirst) {
	location.href =`/main/board?i_board_type=`+i_board_type
	+ '&pageNow='+pageNow + '&pageFirst='+pageFirst
}

submit.onclick = function() {
	insBoard()
}

function insBoard() {
	
	var param = {
		i_user: i_user.value,
		i_board_type: i_board_type.value,
		board_nm: title.value,
		board_ctnt: ctnt.value,
		secret: secret.value,
		pageNow: pageNow.value,
		pageFirst: pageFirst.value
	}
	console.log(param)
	
	fetch(`/insBoardProc`, {
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
					alert('게시글이 작성되었습니다')
					location.href = `/main/board?i_board_type=` + i_board_type.value
					+ `&pageNow=` + pageNow.value + `&pageFirst=`+ pageFirst.value
					
					break;
			}
		})
	
}








