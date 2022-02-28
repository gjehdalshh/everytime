<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/user/naverLogin.css?ver=2">
<div class="main_div">
	<div class="title">추가 정보 입력하기
		<a href="/user/login"><img alt="" src="/res/img/x.png"></a>
	</div>
	<input class="user_nm" type="hidden" value="${param.user_nm}">
	<input class="ph" type="hidden" value="${param.ph}">
	<input class="mail" type="hidden" value="${param.mail}">
	<input class="gender" type="hidden" value="${param.gender}">
	<input class="entrance" type="hidden" value="${param.entrance}">
	<div>
		<div class="sub_title">에브리 타임에서 사용할 비밀번호 입력</div>
		<div class="pw">비밀번호</div>
		<div>
			<input class="user_pw" type="password" name="user_pw" placeholder="비밀번호">
		</div>
		<div class="pw_chk">비밀번호 확인</div>
		<div>
			<input class="clkPw" type="password" name="clkPw" placeholder="비밀번호 확인">
		</div>
		
		<div>
			<input class="btn" type="button" value="확인">
		</div>
	</div>
	
</div>

<script defer src="/res/js/user/naverLogin.js?ver=31"></script>