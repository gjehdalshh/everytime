
// 주소 이동 i_board_type과 같이 보냄 board로
function board(i_board_type, pageNow, pageFirst, pageLast) {
	location.href =`/main/board?i_board_type=`+i_board_type + '&pageNow=' + pageNow
	+ '&pageFirst='+pageFirst
}

function boardTypeMove() {
	location.href = '/main/boardType'
}

// 핫 게시글로 이동
function hotBoardMove(i_board, i_user, i_board_type, pageNow, pageFirst) {
	location.href = '/board/detail?i_board_type=' + i_board_type
	+ '&i_board=' + i_board + '&i_user=' + i_user + '&pageNow=' + pageNow
	+ '&pageFirst='+pageFirst
}