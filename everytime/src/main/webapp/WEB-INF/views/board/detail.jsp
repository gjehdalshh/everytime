<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/board/detail.css?ver=2">

<!-- 모달창 띄우기 detail -->
<div id="mw_temp" class="mw">
	<div class="bg" onclick="window_close()">
		<!--전체를 깔아주는 div-->
	</div>
	<div class="fg">
		<div class="modal_title">글 메뉴</div>
		<c:if test="${loginUser.i_user == detail.i_user}">
			<div class="change"
				onclick="updBoardMove(${detail.i_user}, ${detail.i_board}, ${detail.i_board_type})">글
				수정</div>
			<div class="remove" onclick="delBoard(${detail.i_board_type})">글
				삭제</div>
		</c:if>
		<c:if test="${loginUser.i_user != detail.i_user}">
			<div class="write">쪽지 보내기</div>
			<div class="danger">신고</div>
		</c:if>
		<div onclick="window_close()" class="window_close">취소</div>
	</div>
</div>

<!-- detail 댓글 모달창 띄우기 -->
<div id="mw_temp_cmt" class="mw">
	<div class="bg" onclick="cmtWindow_close()">
		<!--전체를 깔아주는 div-->
	</div>
	<div class="fg_cmt"></div>
</div>
<div>
	<input type="hidden" id="i_board" value="${detail.i_board}"> <input
		type="hidden" id="i_board_type" value="${detail.i_board_type}">
</div>
<div class="main_div">
	<div class="flex_div">
		<div class="flex">
			<div onclick="board(${detail.i_board_type})">
				<img class="left_img" alt="" src="/res/img/left.png">
			</div>
			<div class="type_title">${detail.type_title}</div>
		</div>
		<div class="flex">
			<div>
				<img class="danger_img" alt="" src="/res/img/danger.jpg">
			</div>
			<div>
				<img onclick="window_open()" class="jum_img" alt=""
					src="/res/img/jum.png">
			</div>
		</div>
	</div>

	<div class="flex_div">
		<div class="flex">
			<div class="profile_div">
				<img alt="" src="/res/img/unknownPerson.png">
			</div>
			<div>
				<div class="secret">
					<c:if test="${detail.secret == 1}">익명</c:if>
					<c:if test="${detail.secret == 2}">${detail.user_nm}</c:if>
				</div>
				<div class="r_dt">${detail.r_dt}</div>
			</div>
		</div>
		<div class="flex">
			<div>
				<button onclick="insFavorite(${detail.i_board},${loginUser.i_user})" class="favorite">공감</button>
			</div>
			<div>
				<button class="save">스크랩</button>
			</div>
		</div>
	</div>

	<div class="border_div">
		<div class="board_nm">${detail.board_nm}</div>
		<div class="board_ctnt">${detail.board_ctnt}</div>
		<div class="flex">
			<div class="like_div">
				<img class="like" alt="" src="/res/img/like_red.png">${detail.favorite}
			</div>
			<div class="talk_div">
				<img class="talk" alt="" src="/res/img/type/talk.png">${detail.cmt}
			</div>
			<div class="star_div">
				<img class="star" alt="" src="/res/img/type/star.png">7
			</div>
		</div>
	</div>

	<c:forEach var="cmtList" items="${detailCmtList}">
		<div class="cmt_div">
			<div class="cmt_flex_div">
				<div class="flex">
					<div>
						<img class="cmt_profile" alt="" src="/res/img/unknownPerson.png">
					</div>
					<div class="cmt_title">익명1</div>
				</div>
				<div class="flex" id="btn_div">
					<div class="cmt_talk_div">
						<img class="cmt_talk" alt="" src="/res/img/type/talk.png">
					</div>
					<div class="cmt_like_div">
						<img class="cmt_like" alt="" src="/res/img/like_red.png">
					</div>
					<div
						onclick="cmtWindow_open(${loginUser.i_user},${cmtList.i_user})"
						class="cmt_other_div">
						<img class="cmt_other" alt="" src="/res/img/jum.png">
					</div>
				</div>
			</div>
			<div class="border_div">
				<div>
					<div class="cmt_ctnt">${cmtList.ctnt}</div>
					<div class="cmt_r_dt">${cmtList.r_dt}</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<div>
		<input class="i_user" type="hidden" value="${loginUser.i_user}">
		<div class="cmt_ins_div">
			<label class="unknown_label"> <input type="checkbox"
				checked="checked">익명
			</label>
			<div class="cmt_ins_imgDiv">
				<img alt="" src="/res/img/airplane.png">
			</div>
			<input class="cmt_ins" type="text" placeholder="댓글을 입력하세요">
		</div>
	</div>
</div>


<script defer src="/res/js/board/detail.js?ver=31"></script>




