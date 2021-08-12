<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"  href="/res/css/user/login.css?ver=5">

<div>
	<div class="div1">
		<div class="clock_div">
			<a href="/main/home">
			<img alt="" src="/res/img/clock.jpg">
			</a>
		</div>
		<div class="everytime_top">대학 생활을 더 편하고 즐겁게</div>
		<div class="everytime">에브리타임</div>
	</div>
	
	<form id="login_form">
		<div><input class="input_id" onkeypress="loginEnter()" type="text" name="user_id"></div>
		<div><input class="input_pw" onkeypress="loginEnter()" type="password" name="user_pw"></div>
		<div><input type="button" id="btn_login" value="에브리타임 로그인"></div>
	</form>
	<div class="find">
		<a href="">아이디/비밀번호 찾기</a>
	</div>
	<div class="join"><a href="/user/join">회원가입</a></div>
</div>
<script defer src="/res/js/user/login.js?ver=3"></script>