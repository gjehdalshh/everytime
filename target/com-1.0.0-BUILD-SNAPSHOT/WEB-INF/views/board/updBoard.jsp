<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/board/updBoard.css?ver=4">

<input id="i_user" type="hidden" value="${updBoard.i_user}">
<input id="i_board" type="hidden" value="${updBoard.i_board}">
<input id="i_board_type" type="hidden" value="${updBoard.i_board_type}">
<div class="div1">
	<div class="flex">
		<div class="back" onclick="board(${updBoard.i_board_type})">
			<img alt="" src="/res/img/left.png">
		</div>
		<div class="main_title">글 수정</div>
		<div id="submit">완료</div>

	</div>

	<div>
		<input class="title" type="text" placeholder="제목" value="${updBoard.board_nm}">
	</div>
	<div>
		<input class="ctnt" type="text" placeholder="내용을 입력하세요." value="${updBoard.board_ctnt}">
	</div>

	<div class="rule">
		<div>에브리타임은 누구나 기분 좋게 참여할 수 있는 커뮤니티를 만들기 위해 커뮤니티 이용규칙을 제정하여 운영하고
			있습니다. 위반 시 게시물이 삭제되고 서비스 이용이 일정 기간 제한될 수 있습니다.</div>
		<div>아래는 이 게시판에 해당하는 핵심 내용에 대한 요약 사항이며, 게시물 작성 전 커뮤니티 이용규칙 전문을
			반드시 확인하시기 바랍니다.</div>
		<div>- 타인의 권리를 침해하거나 불쾌감을 주는 행위</div>
		<div>- 범죄, 불법 행위 등 법령을 위반하는 행위</div>
		<div>- 욕설, 비하, 차별, 혐오, 자살, 폭력 관련 내용을 포함한 게시물 작성 행위</div>
		<div>- 음란물, 성적 수치심을 유발하는 행위</div>
		<div>- 스포일러, 공포, 속임, 놀라게 하는 행위</div>
	</div>
	<div class="fix_div">
		<div class="fix">
			<input class="secret" type="checkbox" value="1" checked="checked">익명
		</div>
	</div>
</div>


<script defer src="/res/js/board/updBoard.js?ver=3"></script>