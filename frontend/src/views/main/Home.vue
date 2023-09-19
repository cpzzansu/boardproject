<template>
  <div>
    <NavigationBar></NavigationBar>
    <MainContentInputBox></MainContentInputBox>
    <MainContent></MainContent>
  </div>
</template>

<script>
import axios from 'axios';
import NavigationBar from "@/components/NavigationBar.vue";
import MainContentInputBox from "@/components/MainContentInputBox.vue";
import MainContent from "@/components/MainContent.vue";

export default {
  name: 'HomePage',
  components: {
    NavigationBar,
    MainContentInputBox,
    MainContent
  },
  created() {
    const token = localStorage.getItem('token');  // 예를 들어 token이 로컬 스토리지에 저장되어 있다고 가정

    axios.get("/api/private/resource", {
      headers: {
        'Authorization': 'Bearer ' + token
      }
    })
        .then(response => {
          console.log(response.data);
        })
        .catch(error => {
          if (error.response && error.response.status === 401) {
            this.$router.push('/login');
          }
        });
  }
}
</script>
