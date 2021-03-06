<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/main/selectBoard.css?ver=5">
<div class="div1">
	<input class="pageNow" type="hidden" value="${param.pageNow}">
	<input class="pageFirst" type="hidden" value="${param.pageFirst}">
	<div class="flex_div">
		<c:if test="${param.i_board_type == null}">
			<form action="/main/selectBoard" method="Post">
		</c:if>
		<c:if test="${param.i_board_type != null}">
			<form action="/main/selectBoard?i_board_type=${param.i_board_type}&pageNow=${param.pageNow}&pageFirst=${param.pageFirst}" method="Post">
		</c:if>
			<div class="relative">
				<img class="search_img" alt="" src="/res/img/search.svg"> <input
					class="search" type="text" placeholder="글 제목, 내용, 해시태그"
					name="board_nm" id="board_nm"> <input class="submit"
					type="submit">
			</div>
		</form>
		<div onclick="back(${param.i_board_type})" class="back">취소</div>
	</div>

	<div class="div2">
		<c:forEach var="list" items="${selectList}">
			<c:if test="${param.pageNow == null}">
				<div class="border" onclick="detail(${list.i_board_type},${list.i_board},${list.i_user}, 1, 1)">
			</c:if>
			<c:if test="${param.pageNow != null}">
				<div class="border" onclick="detail(${list.i_board_type},${list.i_board},${list.i_user}, ${param.pageNow}, ${param.pageFirst})">
			</c:if>
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
			</div>
		</c:forEach>
	</div>
</div>

<script defer src="/res/js/main/selectBoard.js?ver=2"></script>