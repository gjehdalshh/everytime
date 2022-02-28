<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/main/subBoard.css?ver=12">


<!-- 모당창 띄우기 -->
<div id="mw_temp" class="mw">
	<div class="bg" onclick="window_close()">
		<!--전체를 깔아주는 div-->
	</div>
	<div class="fg">
		<div class="modal_title">글 메뉴</div>
		<div class="write" onclick="insBoard(${board_type.i_board_type})">글
			쓰기</div>
		<div onclick="window_close()" class="window_close">취소</div>
	</div>
</div>

<div>
	<div class="flex_div">
		<div class="left">
			<a href="/main/boardType"><img alt="" src="/res/img/left.png"></a>
		</div>
		<div class="type_title">${board_type.type_title}</div>
		<div class="flex">
			<div class="search">
				<a href=""><img alt="" src="/res/img/search.svg"></a>
			</div>
			<div class="jum" onclick="window_open()">
				<img alt="" src="/res/img/jum.png">
			</div>
		</div>
	</div>
	<div class="div1">
		<c:forEach var="list" items="${subBoard_list}">
			<div class="border"
				onclick="detail(${list.i_board_type},${list.i_board},${list.i_user})">
				<div class="nm">${list.board_nm}</div>
				<div class="ctnt">${list.board_ctnt}</div>
				<div class="flex_between">
					<div class="flex">
						<div class="r_dt">${list.r_dt}</div>
						<div class="between">|</div>
						<div class="secret">
							<c:if test="${list.secret == 1}">
								익명
							</c:if>
							<c:if test="${list.secret == 2}">
								${list.user_nm}
							</c:if>
						</div>
					</div>
					<div class="flex">
						<div class="like_img">
							<img alt="" src="/res/img/like_red.png">${list.favorite}
						</div>
						<div class="message_img">
							<img alt="" src="/res/img/type/talk.png">${list.cmt}
						</div>
					</div>
				</div>
				<div class="type_title_div">${list.type_title}</div>
			</div>
		</c:forEach>
	</div>

</div>


<script defer src="/res/js/main/subBoard.js?ver=11"></script>