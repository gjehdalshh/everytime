var i_user = document.querySelector('#i_user')

function idChange(page) {
	location.href=`/user/idChange?page=`+page + `&i_user=`+i_user.value
}