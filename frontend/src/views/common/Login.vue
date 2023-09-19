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
              <input type="text" class="form-control login-input" v-model="memberEmail" placeholder="이메일 또는 전화번호">
            </div>
            <div class="col-auto input-box">
              <label for="inputPassword2" class="visually-hidden">비밀번호</label>
              <input type="password" class="form-control login-input" v-model="memberPw"  id="inputPassword2" placeholder="비밀번호">
            </div>
            <div class="col-auto btn-box">
              <div class="form-control login-input" @click="LoginAction" id="loginBtn">로그인</div>
            </div>
            <div class="d-flex justify-content-center">
              <div class="bottom-border"><a href="#">비밀번호를 잊으셨나요?</a></div>
            </div>
            <div class="col-auto btn-box">
              <div class="form-control btn btn-success" id="addBtn" @click="toggleModal">새 계정 만들기</div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- 로그인화면 종료 -->
    <!-- 회원가입 모달 시작 -->
    <b-modal id="modal-lg" size="lg" ref="myModal" title="게시물 만들기" class="custom-size">
      <template v-slot:modal-header>
        <div>
          <h2 class="modal-title">가입하기</h2>
          <p>빠르고 쉽게 가입할 수 있습니다.</p>
        </div>
        <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
            @click="closeModal"
        ></button>
      </template>
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-body">
            <div>
              <div class="col-md-12 ms-auto InputBox">
                <input
                    type="text"
                    placeholder="이메일"
                    v-model="email"
                    class="emailInput">
              </div>
              <div class="col-md-12 ms-auto InputBox">
                <input
                    type="password"
                    placeholder="비밀번호"
                    v-model="password"
                    class="emailInput"
                    @keyup.enter="save">
              </div>
            </div>
            <div class="addInformation">
              <p>회원가입을 원하시면 email과 비밀번호를 입력하시고, 회원가입 버튼을 누르시면 됩니다.</p>
            </div>
          </div>
        </div>
      </div>
      <template v-slot:modal-footer>
        <button type="button" class="btn btn-success" id="saveBtn" @click="save">회원가입하기</button>
      </template>
    </b-modal>
    <!-- 회원가입 모달 종료 -->
    <!-- 푸터 시작 -->
    <div class="footer-box">
      <div class="text-center">문의는 cpzzansu@gmail.com을 통해 해주시면 감사하겠습니다.<br>JS © 2023</div>
    </div>
    <!-- 푸터 종료 -->
  </div>

</template>
<script>
import axios from "axios";
import { required } from '@vuelidate/validators'
import { useVuelidate } from '@vuelidate/core'

export default {
  name: 'LoginPage',
  data() {
    return{
      memberEmail: '',
      memberPw: '',
      emailPlaceholder: '이메일',
      email: '',
      password: '',
    }
  },
  methods: {
    LoginAction() {
      console.log(this.memberEmail);
    },
    toggleModal() {
      this.$refs.myModal.toggle()
    },
    closeModal() {
      this.$refs.myModal.hide()
    },
    updateText(event){
      this.text = event.target.innerText;
    },
    saveText() {
      if(!this.text.trim()){
        this.text = '';
      }
    },
    async save() {
      try {
        let response = await axios.post('/api/member', {
          memberEmail: this.email,
          memberPw: this.password,
        },
        {
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
          },
        });

        if (response.data) {
          // 회원가입 성공
          alert('회원가입되셨습니다.');

          this.email = '';
          this.password = '';

          this.closeModal();
        }
      } catch (error) {
        console.error("API 요청 중 오류 발생:", error);
      }
    },

  }
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
.InputBox{
  width: 729px; height: 46px; background: #EFEFEF; border-radius: 3px; border: 1px #C1C1C1 solid;
  display: flex;
  align-items: center;
  margin-top: 10px;
}
[contenteditable]:focus {
  outline: none;
}
p[data-placeholder]:empty::before {
  content: attr(data-placeholder);
  color: grey;
}
.emailInput{
  background-color: transparent; /* 배경색을 투명하게 설정 */
  border: none;                   /* 테두리 제거 */
  outline: none;
  margin: auto auto auto 10px;
  width: 100%;
}
input {
  text-decoration: none;
  color: #464646;
}
.addInformation{
  margin: 30px auto auto 10px;
}
#saveBtn{
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
</style>