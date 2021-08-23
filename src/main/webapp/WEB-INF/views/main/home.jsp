<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/main/home.css?ver=2">
<header id="header">
	<div class="everytime_div">에브리타임</div>
	<div class="header_div">
		<div class="every_name">계명대</div>
		<div class="header_div">
			<div>
				<a href="/main/selectBoard"><img class="header_search" alt=""
					src="/res/img/search.svg"></a>
			</div>
			<div>
				<c:if test="${loginUser != null}">
					<a href="/user/myProfile"> <img class="header_person" alt=""
						src="/res/img/person.jpg">
					</a>
				</c:if>
				<c:if test="${loginUser == null}">
					<a href="/user/login"> <img class="header_person" alt=""
						src="/res/img/person.jpg">
					</a>
				</c:if>
			</div>
		</div>
	</div>
</header>

<div class="div"></div>

<div>
	<ul id="main_ul">
		<li class="main_li"><img class="home_li" alt=""
			src="/res/img/home.png">학교홈</li>
		<li class="main_li"><img class="book_li" alt=""
			src="/res/img/book.png">열람실현황</li>
		<li class="main_li"><img class="bus_li" alt=""
			src="/res/img/bus.png">셔틀버스</li>
		<li class="main_li"><img class="bus_li" alt=""
			src="/res/img/bus.png">스쿨버스</li>
		<li class="main_li"><img class="speak_li" alt=""
			src="/res/img/speak.jpg">학사공지</li>
		<li class="main_li"><img class="calendar_li" alt=""
			src="/res/img/calendar.jpg">학사일정</li>
		<li class="main_li"><img class="book_li" alt=""
			src="/res/img/book.png">도서관</li>
	</ul>
</div>

<div class="advertise">
	<img alt="" src="/res/img/playable.png">
</div>

<div class="div2">
	<div onclick="boardTypeMove()" class="famous_board_div">
		<div class="famous_board">즐겨찾는 게시판</div>
		<div class="board_more">더 보기 ></div>
	</div>
	<div>
		<c:forEach var="type_list" items="${type_list}" begin="0" end="9">
			<div onclick="board(${type_list.i_board_type})" class="type_flex">
				<div class="type_board">${type_list.type_title}</div>
				<div class="board_title">${type_list.board_nm}</div>
			</div>
		</c:forEach>
	</div>
</div>

<div class="div3">
	<div class="hot_board_div">실시간 인기 글</div>
	<c:forEach var="hotList" items="${hotList}" end="2">
		<div
			onclick="hotBoardMove(${hotList.i_board}, ${hotList.i_user}, ${hotList.i_board_type})"
			class="div_1">
			<div class="flex_div">
				<div class="flex">
					<img class="flex_img" alt="" src="/res/img/unknownPerson.png">
					<div class="unknown">
						<c:if test="${hotList.secret == 1}">익명</c:if>
						<c:if test="${hotList.secret == 2}">${hotList.user_nm}</c:if>
					</div>
				</div>
				<div class="r_dt">${hotList.r_dt}</div>
			</div>
			<div class="hot_title">${hotList.board_nm}</div>
			<div class="hot_ctnt">${hotList.board_ctnt}</div>
			<div class="flex_div">
				<div class="type_board_small">${hotList.type_title}</div>
				<div class="flex">
					<div class="like_img">
						<img alt="" src="/res/img/like_red.png">${hotList.favorite}
					</div>
					<div class="message_img">
						<img alt="" src="/res/img/type/talk.png">${hotList.cmt}
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<script defer src="/res/js/main/home.js?ver=10"></script>
