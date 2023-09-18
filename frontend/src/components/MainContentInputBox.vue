<template>
  <div>
    <div class="d-flex text-right" @click="toggleModal">
      <div class="main-content" >
        <div>
          <div class="d-flex content-input-bar align-items-center">
            <img src="@/assets/nv_profile.png" class="content-input-profile" />
            <div class="content-input-button" id="contentInputBtn">
              <div class="content-input-placeholder">
                무슨 생각을 하고 계신가요?
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 컨텐츠 입력 모달 시작 -->
    <b-modal id="modal-lg" size="lg" ref="myModal" title="게시물 만들기" class="custom-size">
      <template v-slot:modal-header>
        <h5 class="modal-title">게시물 만들기</h5>
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
              <div>
                <p
                    contenteditable="true"
                    @input="updateText"
                    @blur="saveText"
                    :data-placeholder="placeholder"
                    class="content-input">
                </p>
              </div>
            </div>
            <div class="upload-box" id="uploadBox">
              <div
                  class="image-box d-flex justify-content-center align-items-center"
              >
                <img src="@/assets/image.svg" />
              </div>
              <div class="mbJpegPng">
                <div>최대 5mb 이하 jpeg, png 첨부 가능</div>
              </div>
              <input type="file" id="imageFile" style="display: none" />
              <div
                  class="imageFileBtn d-flex justify-content-center"
                  onclick="document.getElementById('imageFile').click()"
              >
                <div
                    class="image-select d-flex justify-content-center align-items-center"
                >
                  <div class="image-select-font">이미지 가져오기</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <template v-slot:modal-footer>
        <b-button variant="secondary" @click="closeModal">Close</b-button>
        <b-button variant="primary" @click="addBoard">등록하기</b-button>
      </template>
    </b-modal>
    <!-- 컨텐츠 입력 모달 종료 -->
  </div>

</template>
<script>

export default {
  name: 'MainContentInputBox',
  data(){
    return {
      text: '',
      placeholder: '무슨 생각을 하고 계신가요?'
    };
  },
  methods: {
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
    addBoard() {
      console.log(this.text);
    }
  }

}

</script>
<style scoped>
.main-content {
  width: 600px;
  height: auto;
  background-color: rgb(255, 255, 255);
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  border-radius: 8px;
  padding: 0;
  cursor: pointer;
}
.content-input-bar {
  height: 67px;
}
.content-input-profile {
  height: 48px;
  width: 48px;
  border-radius: 50%;
  margin-left: 10px;
}
/* content-input */
.content-input-button {
  width: 500px;
  height: 40px;
  background: #ececec;
  border-radius: 29px;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  align-items: center;
  cursor: pointer;
}
.content-input-placeholder {
  margin-left: 15px;
  color: rgb(150, 150, 150);
}
.upload-box {
  width: 732px;
  height: 208px;
  background: #f2f2f2;
  border-radius: 10px;
  border: 2.5px #adc9ff dashed;
}
.mbJpegPng {
  text-align: center;
  color: #acacac;
  font-size: 12px;
  word-wrap: break-word;
  display: flex;
  justify-content: center;
}
.image-select {
  width: 139px;
  height: 40px;
  background: #d9d9d9;
  border-radius: 7px;
  margin-top: 10px;
}
.image-select-font {
  text-align: center;
  color: #959ca9;
  font-size: 12px;
  font-weight: 700;
  word-wrap: break-word;
}
.image-box {
  height: 100px;
  padding-right: 15px;
}
.imageFileBtn {
  cursor: pointer;
}
p[data-placeholder]:empty::before {
  content: attr(data-placeholder);
  color: grey;
}
.content-input {
  font-size: 20px;

}
[contenteditable]:focus {
  outline: none;
}
</style>