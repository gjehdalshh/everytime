<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/res/css/user/idChange.css?ver=12">
<input id="i_user" type="hidden" name="i_user" value="${loginUser.i_user}">

<!-- 아이디 변경 -->
<div class="div1">
	<div class="idChange">
		<div class="flex">
			<div class="back">
				<a href="/user/myProfile"><img alt="" src="/res/img/left.png"></a>
			</div>
			<div class="title">아이디 변경</div>
		</div>
		<div>
			<div class="name">이름</div>
			<div>
				<input class="user_nm" type="text" placeholder="이름" name="user_nm">
			</div>
		</div>
		<div>
			<div class="id">아이디</div>
			<div>
				<input class="user_chkId" type="text" placeholder="기존 아이디" name="user_chkId">
				<input class="user_id" type="text" placeholder="변경할 아이디" name="user_id">
			</div>
		</div>
		<div>
			<div class="pw">비밀번호</div>
			<div>
				<input class="user_pw" type="password" placeholder="비밀번호"
					name="user_pw">
			</div>
		</div>
		<div class="sub_ctnt">
			<div>* 반드시 본인의 아이디를 입력해주세요</div>
			<div>* 계정 분실 시 아이디/비밀번호 찾기, 개인정보 관련 주요 고지사항 안내 등에 사용됩니다</div>
		</div>
		<div>
			<button class="idChangeBtn">아이디 변경</button>
		</div>
	</div>
</div>


<!-- 비밀번호 변경 -->
<div class="div2">
	<div class="idChange">
		<div class="flex">
			<div class="back">
				<a href="/user/myProfile"><img alt="" src="/res/img/left.png"></a>
			</div>
			<div class="title">비밀번호 변경</div>
		</div>
		<div>
			<div class="now_pw">현재 비밀번호</div>
			<div>
				<input class="user_changePw" type="password" placeholder="현재 비밀번호" name="user_pw">
			</div>
		</div>
		<div>
			<div class="pw">새 비밀번호</div>
			<div>
				<input class="new_pw" type="password" placeholder="새 비밀번호" name="new_pw">
				<input class="new_chkPw" type="password" placeholder="새 비밀번호 확인" name="new_chkPw">
			</div>
		</div>
		<div class="sub_ctnt">
			<div>* 혹시 타인에게 계정을 양도하려고 하시나요?</div>
			<div>에브리타임 이용약관에서는 타인에게 계정 판매, 양도 및 대여 등을 엄격하게 금지하고 있습니다.</div>
			<div>모니터링 시스템에 의해 계정 양도가 적발될 경우 해당 계정은 영구 정지, 탈퇴 등의 조치가 가해지며,
			계정 양도로 인해 사기, 불법 행위가 발생할 경우 관련법에 따라 법적 책임을 지게 될 수있습니다.</div>
			<div>* 타인에 의한 계정 사용이 의심되시나요?</div>
			<div>개인정보 보호를 위해 비밀번호를 변경하여 주시기 바랍니다. 비밀번호를 변경하면
			모든 디바이스(앱, 브라우저 등)에서 즉시 로그아웃 처리됩니다</div>
		</div>
		<div>
			<button class="pwChangeBtn">비밀번호 변경</button>
		</div>
	</div>
</div>

<!-- 이름 설정 -->
<div class="div3">
	<div class="idChange">
		<div class="flex">
			<div class="back">
				<a href="/user/myProfile"><img alt="" src="/res/img/left.png"></a>
			</div>
			<div class="title">이름 설정</div>
		</div>
		<div>
			<div class="changeNm">이름</div>
			<div>
				<input class="user_changeNm" type="text" value="${selUserNm.user_nm}" placeholder="이름" name="user_nm">
			</div>
		</div>
		<div class="sub_ctnt">
			<div>* 이름을 설정하면 30일간 변경할 수 없습니다.</div>
		</div>
		<div>
			<button class="nmChangeBtn">이름 설정</button>
		</div>
	</div>
</div>

<script defer src="/res/js/user/idChange.js?ver=2"></script>