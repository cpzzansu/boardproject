<template>
  <div>
    <div class="d-flex text-right" v-for="boardResponse in boardList" :key="boardResponse.board.boardCode">
      <div class="main-content" >
        <div>
          <!-- 상단 id 바 -->
          <div class="d-flex profile-bar">
            <img src="@/assets/nv_profile.png" class="main-profile" />
            <div>
              <div class="main-user-id">{{ boardResponse.board.memberEmail }}</div>
              <div class="main-upload-time">{{ boardResponse.board.boardRegistTime }}</div>
            </div>
          </div>
          <!-- 메인 컨텐츠 내용 -->
          <div class="main-content-text">
            {{
              boardResponse.board.boardContent
            }}
          </div>
          <!-- 메인 컨텐츠 사진 -->
          <div v-for="boardFile in boardResponse.files" :key="boardFile.idx">
            <img :src="'http://localhost:90'+boardFile.imageSourcePath" class="main-content-img" />
          </div>
          <!-- 메인 컨텐츠 댓글, 공유 알림 -->
          <div class="d-flex flex-row-reverse">
            <div class="main-reply">공유 1회</div>
            <div class="main-reply">댓글 2개</div>
          </div>
          <!-- 메인 컨텐츠 하단 좋아요, 댓글, 공유 버튼 -->
          <div class="d-flex main-content-footer justify-content-center">
            <div class="d-flex main-content-footer-items">
              <div class="main-content-like-icon">
                <img src="@/assets/hand-thumbs-up-fill.svg" />
              </div>
              <div>좋아요</div>
            </div>
            <div class="d-flex main-content-footer-items">
              <div class="main-content-like-icon">
                <img src="@/assets/chat-left.svg" />
              </div>
              <div>댓글 달기</div>
            </div>
            <div class="d-flex main-content-footer-items">
              <div class="main-content-like-icon">
                <img src="@/assets/chat-left.svg" />
              </div>
              <div>공유하기</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {
      boardList: []
    };
  },
  async created() {
    try {
      let response = await this.$http.get("/api/board");
      if (response.status === 200) {
        this.boardList = response.data;
      }
    } catch (error) {
      console.error("Failed to fetch posts:", error);
    }
  }
};
</script>

<style>
.main-content {
  width: 600px;
  height: auto;
  background-color: rgb(255, 255, 255);
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  border-radius: 8px;
  padding: 0;
}
.main-profile {
  height: 48px;
  width: 48px;
  border-radius: 50%;
  margin-top: 10px;
  margin-left: 10px;
}
.main-user-id {
  margin-top: 13px;
  margin-left: 10px;
  font-weight: bold;
}
.main-upload-time {
  font-size: 12px;
  color: rgb(165, 165, 165);
  margin-left: 10px;
}
.profile-bar {
  height: 67px;
}
.main-content-text {
  margin-top: 10px;
  margin-left: 10px;
}
.main-content-img {
  margin-top: 20px;
  width: 600px;
  height: auto;
}
.main-reply {
  margin-top: 20px;
  height: 40px;
  margin-right: 11px;
}
.main-content-footer {
  border-top: 1px solid rgb(221, 221, 221);
  padding: 15px;
}
.main-content-footer-items {
  margin-left: 50px;
  margin-right: 50px;
  font-weight: 800;
  color: rgb(113, 113, 113);
}
.main-content-like-icon {
  margin-right: 5px;
}
</style>