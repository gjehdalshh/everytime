


function insBoard(i_board_type, pageNow, pageFirst) {
	location.href =`/board/insBoard?i_board_type=`+i_board_type + '&pageNow='+pageNow
	+ '&pageFirst='+pageFirst
}

function detail(i_board_type, i_board, i_user, pageNow, pageFirst) {
	location.href = `/board/detail?i_board_type=` + i_board_type
	+ `&i_board=` + i_board + `&i_user=`+i_user + '&pageNow=' + pageNow
	+ `&pageFirst=`+pageFirst
}

var mw_temp = document.querySelector('#mw_temp')

// 모달창 띄우기
function window_open() {
	mw_temp.style.display = 'block'
}
function window_close() {
	mw_temp.style.display = 'none'
}

function moveSearch(i_board_type, pageNow, pageFirst) {
	location.href="/main/selectBoard?i_board_type="+i_board_type
	+ '&pageNow='+pageNow + '&pageFirst='+pageFirst
}

function pageMove(i_board_type, pageNow, pageFirst, pageLast) {
	location.href =`/main/board?i_board_type=`+i_board_type + '&pageNow=' + pageNow
	+ '&pageFirst='+pageFirst
}

