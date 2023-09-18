<template>
  <div class="login-body">
    <!-- 로그인화면 시작 -->
    <div class="padding-t-b-100">
      <div class="row d-flex justify-content-center">
        <!-- 로고박스 시작 -->
        <div class="logo-box d-flex align-items-center">
          <div class>
            <!-- 로고 -->
            <div>
              <img src="@/assets/fs_logo.png" alt="Logo" width="50" height="50">
            </div>
            <!-- 환영글 -->
            <div class="logo-content logo-content-font">
              이곳은 한국 스마트 정보 교육원 47기<br/>
              우리 함께 즐겨요!
            </div>
          </div>
        </div>
        <!-- 로그인 박스 시작 -->
        <div class="login-box">
          <form class="row g-3 d-flex justify-content-center" id="login-form">
            <div class="col-auto input-box">
              <label for="inputPassword2" class="visually-hidden">이메일 또는 전화번호</label>
              <input type="password" class="form-control login-input " id="inputPassword1" placeholder="이메일 또는 전화번호">
            </div>
            <div class="col-auto input-box">
              <label for="inputPassword2" class="visually-hidden">비밀번호</label>
              <input type="password" class="form-control login-input" id="inputPassword2" placeholder="비밀번호">
            </div>
            <div class="col-auto btn-box">
              <div class="form-control login-input" id="loginBtn" >로그인</div>
            </div>
            <div class="d-flex justify-content-center">
              <div class="bottom-border"><a href="#">비밀번호를 잊으셨나요?</a></div>
            </div>
            <div class="col-auto btn-box">
              <div class="form-control btn btn-success" id="addBtn" data-bs-toggle="modal" data-bs-target="#addModal">새 계정 만들기</div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- 로그인화면 종료 -->
    <!-- 회원가입 모달 시작 -->
    <div class="modal" id="addModal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header row">
            <div class="d-flex">
              <h2 class="modal-title">가입하기</h2>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <p>빠르고 쉽게 가입할 수 있습니다.</p>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-md-6 ms-auto">
                <input class="input-col-6">
              </div>
              <div class="col-md-6 ms-auto">
                <input class="input-col-6">
              </div>
            </div>
            <p>Modal body text goes here.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 회원가입 모달 종료 -->
    <!-- 푸터 시작 -->
    <div class="footer-box">
      <div class="text-center">문의는 cpzzansu@gmail.com을 통해 해주시면 감사하겠습니다.<br>JS © 2023</div>
    </div>
    <!-- 푸터 종료 -->
  </div>

</template>
<script>
export default {
  name: 'LoginPage',
}
</script>
<style>
.login-body {
  background-color: white;
}
.padding-t-b-100 {
  padding-top: 150px;
  padding-bottom: 150px;
  background-color: #f0f2f5;
}
.logo-box {
  width: 500px;
  margin: 50px;
  align-items: center;
}
.logo-content {
  padding-top: 20px;
  padding-bottom: 20px;
}
.logo-content-font {
  font-family: SFProDisplay-Regular, Helvetica, Arial, sans-serif;
  font-size: 28px;
  font-weight: normal;
  line-height: 32px;
  width: 500px;
}
.login-box {
  width: 400px;
  height: 400px;
  background-color: white;
  border-radius: 10px;
  box-shadow: 3px 4px 11px 0px rgba(0, 0, 0, 0.3);
}
.login-input {
  width: 370px;
  height: 50px;
  padding: 14px 16px;
  font-size: 20px;
}
.btn-box {
  padding-top: 10px;
}
#login-form {
  margin-top: 3px;
}
#loginBtn {
  height: 55px;
  background-color: #1877f2;
  color: white;
  text-align: center;
  font-weight: normal;
}
.footer-box {
  height: 140px;
  padding: 20px;
}
.bottom-border {
  align-items: center;
  border-bottom: 1px solid #dadde1;
  display: flex;
  padding: 20px 16px;
  text-align: center;
}
#addBtn {
  font-weight: normal;
  font-size: 18px;
  width: 150px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50px;
  background-color: #42b72a;
  border: 0px;
}
.footer-box {
  margin-top: 20px;
}
.input-col-6 {
  margin-left: 5px;
  margin-right: 5px;
}
</style>