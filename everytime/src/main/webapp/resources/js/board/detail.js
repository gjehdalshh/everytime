var i_board = document.querySelector('#i_board')
var i_board_type = document.querySelector('#i_board_type')
var cmt_ins = document.querySelector('.cmt_ins')
var cmt_ins_imgDiv = document.querySelector('.cmt_ins_imgDiv')
var i_user = document.querySelector('.i_user')
var cmtIuser = document.querySelector('.cmtIuser')
var cmt_ins_div = document.querySelector('.cmt_ins_div')

function board(i_board_type) {
	location.href = `/main/board?i_board_type=` + i_board_type
}

// 모달창 띄우기 디테일페이지
var mw_temp = document.querySelector('#mw_temp')

function window_open() {
	mw_temp.style.display = 'block'
	cmt_ins_div.style.display = 'none'
}
function window_close() {
	mw_temp.style.display = 'none'
	cmt_ins_div.style.display = 'block'
}

// 모달창 띄우기 댓글
var mw_temp_cmt = document.querySelector('#mw_temp_cmt')

function cmtWindow_open(loginI_user, cmtI_user) {
	mw_temp_cmt.style.display = 'block'
	cmt_ins_div.style.display = 'none'
	checkUser(loginI_user, cmtI_user)
}
function cmtWindow_close() {
	mw_temp_cmt.style.display = 'none'
	cmt_ins_div.style.display = 'block'
}

function checkUser(loginI_user, cmtI_user) {
	var fg_cmt = document.querySelector('.fg_cmt')
	var div = document.createElement('div')
	fg_cmt.appendChild(div)
	
	var modal_title = `<div class="modal_title">댓글 메뉴</div>`
	
	var close = `<div onclick="cmtWindow_close()" class="window_close">취소</div>`
	
	if(loginI_user == cmtI_user) {
		var remove = `<div class="remove" onclick="delBoard(${i_board_type.value})">
				글 삭제
			</div>`
		}
		div.innerHTML = 
		`
			${modal_title}
			${remove}
			${close}
		`
		fg_cmt.style.height = "300px"
	if(loginI_user != cmtI_user) {
		var write = `<div class="write">쪽지 보내기</div>`
		var danger = `<div class="danger">신고</div>`
		div.innerHTML = 
		`
			${modal_title}
			${write}
			${danger}
			${close}
		`
		fg_cmt.style.height = "400px"
	}
}





// 글 삭제 ajax
function delBoard(i_board_type) {

	var param = {
		i_board: i_board.value,
	}

	fetch(`/board/delBoard`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		console.log(data)
		switch (data.result) {
			case 1:
				// 삭제 성공
				alert('게시글을 삭제하였습니다')
				location.href = `/main/board?i_board_type=` + i_board_type
				break;
			case 2:
				// 삭제 실패
				alert('게시글을 삭제하지 못하였습니다')
				break;
		}
	})
}

// 글 수정
function updBoardMove(i_user, i_board, i_board_type) {
	location.href = '/board/updBoard?i_board_type=' + i_board_type
		+ `&i_board=` + i_board + `&i_user` + i_user
}


// 댓글 작성
cmt_ins_imgDiv.onclick = function() {

	var param = {
		i_user: i_user.value,
		i_board: i_board.value,
		ctnt: cmt_ins.value
	}

	fetch(`/insCmtProc`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		console.log(data)
		switch (data.result) {
			case 1:
				// 댓글 등록
				alert('댓글이 등록되었습니다')
				location.reload();
				break;
			case 2:
				// 삭제 실패
				alert('댓글이 등록되지 않았습니다, 로그인 후 사용해주세요')
				break;
		}
	})
}


//좋아요
function insFavorite(i_board, i_user) {
	
	var param = {
		i_user: i_user,
		i_board: i_board,
		i_board_type: i_board_type.value
	}

	fetch(`/main/insFavorite`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		console.log(data)
		switch (data.result) {
			case 1:
				alert('이 게시글에 공감하였습니다')
				location.reload();
				break;
			case 2:
				alert('이미 공감하였습니다')
				break;
		}
	})
}



