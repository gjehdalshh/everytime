var page = location.search
console.log(page)
var result = page.substring(6, 7)
console.log(result)


var pageList = document.querySelectorAll('.pageList')

console.log(pageList)

// 하나의 jsp로 페이지를 구분해서 뿌려줌
for(var i = 0; i < pageList.length; i++) {
	if(i == result-1) {
		pageList[i].style.display = 'block'
	} else {
		pageList[i].style.display = 'none'	
	}
}

