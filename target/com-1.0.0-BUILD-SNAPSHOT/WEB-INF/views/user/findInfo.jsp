<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/user/findInfo.css?ver=2">

<a href="/main/home">
	<div class="flex_div">
		<div class="school">계명대</div>
		<div class="everytime">에브리타임</div>
	</div>
</a>
<div>
	<div class="flex">
		<c:if test="${param.page == 1}">
			<div class="find_color" onclick="pageMove(1)">아이디 찾기</div>
			<div class="find_normal" onclick="pageMove(2)">비밀번호 찾기</div>
		</c:if>
		<c:if test="${param.page == 2}">
			<div class="find_normal" onclick="pageMove(1)">아이디 찾기</div>
			<div class="find_color" onclick="pageMove(2)">비밀번호 찾기</div>
		</c:if>
	</div>
	<c:if test="${param.page == 1}">
		<div class="title_id">아이디 찾기</div>
		<div class="title_info">아이디는 가입 시 입력하신 이메일을 통해 찾을 수 있습니다.</div>
		<div>
			<div class="mail_div">
				<input class="mail" type="text" name="mail" placeholder="이메일">
			</div>
		</div>
	</c:if>
	<c:if test="${param.page == 2}">
		<div class="title_pw">비밀번호 찾기</div>
		<div class="title_info2">비밀번호는 가입 시 입력하신 아이디, 이메일을 통해 찾을 수 있습니다.</div>
		<div>
			<div class="mail_div">
				<input class="user_id" type="text" name="user_id" placeholder="아이디">
			</div>
		</div>
		<div>
			<div class="mail_div">
				<input class="mail" type="text" name="mail" placeholder="이메일">
			</div>
		</div>
	</c:if>

	<div class="btn_div" onclick="btn_find(${param.page})">
		<input class="btn_find" type="button" value="아이디 / 비밀번호 찾기">
	</div>
</div>

<script defer src="/res/js/user/findInfo.js?ver=17"></script>

