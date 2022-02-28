<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"  href="/res/css/user/join.css?ver=2">

<div class="div1">
	<div class="join">회원가입<a href="/user/login"><img alt="" src="/res/img/x.png"></a></div>
	<div class="school_sel">학교 선택</div>
	<div class="entrance">입학년도</div>
	
	
		<div>
			<select class="select" name="entrance">
				<option class="" value="선택안함">연도 선택 (학번)</option>
				<option value="2021학번">2021학번</option>
				<option value="2020학번">2020학번</option>
				<option value="2019학번">2019학번</option>
				<option value="2018학번">2018학번</option>
				<option value="2017학번">2017학번</option>
				<option value="2016학번">2016학번</option>
			</select>
		</div>
		<div class="school">학교</div>
		<div>
			<input class="university" type="text" name="university" placeholder="학교 이름을 검색하세요">
		</div>
		<div>
			<div class="nm">이름</div>
			<div>
				<input class="user_nm" type="text" name="user_nm" id="user_nm" placeholder="이름" required>
			</div>
		</div>
		<div>
			<div class="id">아이디</div>
			<div>
				<input class="user_id" type="text" name="user_id" id="user_id" placeholder="아이디" required>
			</div>
		</div>
		<div>
			<div class="pw">비밀번호</div>
			<div>
				<input class="user_pw" type="password" name="user_pw" id="user_pw" placeholder="비밀번호">
			</div>
		</div>
		<div>
			<div class="pw_chk">비밀번호확인</div>
			<div>
				<input class="clkPw" type="password" name="clkPw" id="clkPw" placeholder="비밀번호확인">
			</div>
		</div>
		<div>
			<div class="user_ph">휴대전화</div>
			<div>
				<input class="ph" type="text" id="ph" name="ph" placeholder="-없이 입력">
			</div>
		</div>
		<div>
			<div class="user_mail">이메일</div>
			<div>
				<input class="mail" type="text" name="mail" placeholder="이메일">
			</div>
		</div>
		<div>
			<div class="user_gender">성별</div>
			<select class="gender" name="gender">
				<option value="선택안함">선택안함</option>
				<option value="1">남자</option>
				<option value="2">여자</option>
			</select>
		</div>
		
		<div>
			<input type="button" id="btn_join" value="회원가입">
		</div>
</div>

<script defer src="/res/js/user/join.js?ver=9"></script>



