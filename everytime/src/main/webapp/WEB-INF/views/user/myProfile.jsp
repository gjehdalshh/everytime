<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"  href="/res/css/user/myProfile.css?ver=2">
<div>
	<input id="i_user" type="hidden" name="i_user" value="${loginUser.i_user}">
	<div class="my_info"><a href="/main/home"><img alt="" src="/res/img/left.png"></a>내 정보</div>
	<div class="div1">
		<div class="flex">
			<div class="profile_div">
				<img alt="" src="/res/img/profile.jpg">
			</div>
			<div class="info">
				<div class="nm">${loginUser.user_id}</div>
				<div class="color">${loginUser.user_nm}</div>
				<div class="flex">
					<div class="color">${loginUser.university}</div>
					<div class="color">${loginUser.entrance}</div>
				</div>
			</div>
		</div>
		<div class="check_div">
			<div class="check"><img alt="" src="/res/img/check.png"></div>
			<div>인증완료</div>
		</div>
	</div>
	
	<div class="div2">
		<div class="div_1">계정</div>
		<div class="div_2"><a href="">학교 인증</a></div>
		<div class="div_2" onclick="idChange(1)">아이디 변경</div>
		<div class="div_2" onclick="idChange(2)">비밀번호 변경</div>
	</div>
	
	<div class="div3">
		<div class="div_1">커뮤니티</div>
		<div class="div_2" onclick="idChange(3)">이름 설정</div>
		<div class="div_2"><a href="">프로필 이미지 변경</a></div>
		<div class="div_2"><a href="">이용 제한 내역</a></div>
		<div class="div_2"><a href="">쪽지 설정</a></div>
		<div class="div_2"><a href="">커뮤니티 이용규칙</a></div>
	</div>
	
	<div class="div4">
		<div class="div_1">앱 설정</div>
		<div class="div_2"><a href="">다크 모드</a></div>
		<div class="div_2"><a href="">알림 설정</a></div>
		<div class="div_2"><a href="">암호 잠금</a></div>
		<div class="div_2"><a href="">캐시 삭제</a></div>
	</div>
	
	<div class="div5">
		<div class="div_1">이용 안내</div>
		<div class="div_2"><a href="">앱 버전</a></div>
		<div class="div_2"><a href="">문의하기</a></div>
		<div class="div_2"><a href="">공지사항</a></div>
		<div class="div_2"><a href="">서비스 이용약관</a></div>
		<div class="div_2"><a href="">개인정보 처리방침</a></div>
		<div class="div_2"><a href="">오픈소스 라이선스</a></div>
	</div>
	
	<div class="div6">
		<div class="div_1">기타</div>
		<div class="div_2"><a href="">정보 동의 설정</a></div>
		<div class="div_2"><a href="">회원 탈퇴</a></div>
		<div class="div_2"><a href="/logout">로그아웃</a></div>
	</div>
</div>

<script defer src="/res/js/user/myProfile.js?ver=5"></script>







