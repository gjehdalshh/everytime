var i_user = document.querySelector('#i_user')
var i_board = document.querySelector('#i_board')
var i_board_type = document.querySelector('#i_board_type')
var submit = document.querySelector('#submit')
var title = document.querySelector('.title')
var ctnt = document.querySelector('.ctnt')
var secret = document.querySelector('.secret')


function board(i_board_type) {
	location.href =`/main/board?i_board_type=`+i_board_type
}


submit.onclick = function() {
	updAjax()
}

function updAjax() {
	
	var param = {
		i_user : i_user.value,
		i_board : i_board.value,
		board_nm: title.value,
		board_ctnt: ctnt.value,
		i_board_type: i_board_type.value,
		secret: secret.value
	}
	console.log(param)
	
	fetch(`/updBoardProc`, {
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
					alert('게시글이 수정되었습니다')
					location.href = `/board/detail?i_board_type=` + 
					i_board_type.value + `&i_board=` + i_board.value
					+ `&i_user=`+i_user.value
					break;
			}
		})
	
}

