
function back(param) {
	if(param == null) {
		return location.href="/main/home"
	}
	location.href="/main/board?i_board_type="+param
}

function detail(i_board_type, i_board, i_user) {
	location.href = `/board/detail?i_board_type=` + i_board_type 
	+ `&i_board=` + i_board + `&i_user=`+i_user
}
