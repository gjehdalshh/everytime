<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/main/boardType.css?ver=2">
<c:if test="${loginUser == null}">
	<script>
		alert('로그인 후 이용해주세요')
		location.href="/user/login"
	</script>
</c:if>
<div>
	<div class="div1">
		<div class="flex">
			<div class="back_img">
				<a href="/main/home"><img alt="" src="/res/img/left.png"></a>
			</div>
			<div class="every_board">전체 게시판</div>
		</div>
		<c:forEach var="list" items="${board_type_sub}" begin="0" end="4">
			<div class="div_1">
			<a href="/main/subBoard?i_board_type=${list.i_board_type}&i_user=${loginUser.i_user}">
				<img alt="" src="/res/img/type/${list.i_board_type}.png">${list.type_title}
			</a>
			</div>
		</c:forEach>
	</div>

	<div class="div1">
		<c:forEach var="list" items="${board_type}" begin="0" end="7">
			<div class="div_1">
				<a href="/main/board?i_board_type=${list.i_board_type}&pageNow=1&pageFirst=1"><img
					alt="" src="/res/img/type/sharp.png">${list.type_title}</a>
			</div>
		</c:forEach>
	</div>

	<div class="div1">
		<c:forEach var="list" items="${board_type_sub}" begin="5" end="8">
			<div class="div_1">
				<a><img alt="" src="/res/img/type/${list.i_board_type}.png">${list.type_title}</a>
			</div>
		</c:forEach>
	</div>

	<div class="div1">
		<div class="div_2">정보</div>
		<div class="div_1">
			<a><img alt="" src="/res/img/type/sharp.png">정보게시판</a>
		</div>
		<div class="div_1">
			<a><img alt="" src="/res/img/type/sharp.png">취업 진로</a>
		</div>
	</div>

	<div class="div1">
		<div class="div_2">홍보</div>
		<div class="div_1">
			<a><img alt="" src="/res/img/type/sharp.png">홍보게시판</a>
		</div>
		<div class="div_1">
			<a><img alt="" src="/res/img/type/sharp.png">동아리 학회</a>
		</div>
	</div>

	<div class="board_div">
		<input type="text" placeholder="다른 게시판을 검색해보세요">
	</div>

	<div class="div1">
		<c:forEach var="list" items="${board_type}" begin="8">
			<div class="div_1">
				<a href="/main/board?i_board_type=${list.i_board_type}"><img
					alt="" src="/res/img/type/sharp.png">${list.type_title}</a>
			</div>
		</c:forEach>
	</div>
</div>


<script defer src="/res/js/main/boardType.js?ver=3"></script>


