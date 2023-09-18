<template>
  <div id="app">
    <NavigationBar></NavigationBar>
    <MainContentInputBox></MainContentInputBox>
    <MainContent></MainContent>
  </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar.vue';
import MainContentInputBox from '@/components/MainContentInputBox.vue';
import MainContent from "@/components/MainContent.vue";

export default {
  name: 'App',
  components: {
      NavigationBar,
      MainContentInputBox,
      MainContent,
  }
}
</script>


<style>
body {
  font-family: "Noto Sans KR", sans-serif;
  background-color: rgb(236, 236, 236) !important;
}
</style>
