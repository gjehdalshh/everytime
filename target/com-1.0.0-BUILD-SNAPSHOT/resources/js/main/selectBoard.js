var pageNow = document.querySelector('.pageNow')
var pageFirst = document.querySelector('.pageFirst')

function back(i_board_type) {
	if(i_board_type == null) {
		return location.href="/main/home"
	}
	location.href="/main/board?i_board_type="+i_board_type
	+ '&pageNow='+pageNow.value + '&pageFirst='+pageFirst.value
}

function detail(i_board_type, i_board, i_user, pageNow, pageFirst) {
	location.href = `/board/detail?i_board_type=` + i_board_type
	+ `&i_board=` + i_board + `&i_user=`+i_user + '&pageNow='+pageNow
	+ '&pageFirst='+pageFirst
}
