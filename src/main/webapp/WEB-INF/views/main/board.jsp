<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/main/board.css?ver=12">
<c:if test="${loginUser == null}">
	<script>
		alert('로그인 후 이용해주세요')
		location.href="/user/login"
	</script>
</c:if>
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
			<a href="/main/home"><img alt="" src="/res/img/left.png"></a>
		</div>
		<div class="type_title">${board_type.type_title}</div>
		<div class="flex">
			<div class="search"
				onclick="moveSearch(${board_type.i_board_type}, ${param.pageNow}, ${param.pageFirst})">
				<img alt="" src="/res/img/search.svg">
			</div>
			<div class="jum" onclick="window_open()">
				<img alt="" src="/res/img/jum.png">
			</div>
		</div>
	</div>
	<div class="div1">
		<c:forEach var="list" items="${board_list}">
			<div class="border"
				onclick="detail(${board_type.i_board_type},${list.i_board},${list.i_user},${vo.pageNow}, ${vo.pageFirst})">
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
		<div class="pageDiv">
			<c:if test="${vo.pageFirst != 1}">
				<div class="pageList"
					onclick="pageMove(${param.i_board_type}, ${vo.pageFirst - 5}, ${vo.pageFirst - 5})"><</div>
			</c:if>
			<c:forEach var="page" begin="${vo.pageFirst}" end="${vo.pageLast}">
				<c:if test="${page le vo.pageCount}">
					<c:if test="${page == vo.pageNow}">
						<div class="pageListColor"
							onclick="pageMove(${param.i_board_type}, ${page}, ${vo.pageFirst})">${page}</div>
					</c:if>
					<c:if test="${page != vo.pageNow}">
						<div class="pageList"
							onclick="pageMove(${param.i_board_type}, ${page}, ${vo.pageFirst})">${page}</div>
					</c:if>
				</c:if>
			</c:forEach>
			
			<div class="pageList"
				onclick="pageMove(${param.i_board_type}, ${vo.pageFirst + 5}, ${vo.pageFirst + 5})">></div>

		</div>
	</div>

	<div class="flex_fix"
		onclick="insBoard(${board_type.i_board_type}, ${vo.pageNow}, ${vo.pageFirst})">
		<div>
			<img class="ins_img" alt="" src="/res/img/pencil.png">
		</div>
		<div>글 쓰기</div>
	</div>

</div>
<script defer src="/res/js/main/board.js?ver=2"></script>


