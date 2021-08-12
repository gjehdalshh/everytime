


function insBoard(i_board_type) {
	location.href =`/board/insBoard?i_board_type=`+i_board_type
}

function detail(i_board_type, i_board, i_user) {
	location.href = `/board/detail?i_board_type=` + i_board_type 
	+ `&i_board=` + i_board + `&i_user=`+i_user
}

var mw_temp = document.querySelector('#mw_temp')

// 모달창 띄우기
function window_open() {
	mw_temp.style.display = 'block'
}
function window_close() {
	mw_temp.style.display = 'none'
}

