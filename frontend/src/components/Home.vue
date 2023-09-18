<template>
  <div>
    <NavigationBar></NavigationBar>
    <MainContentInputBox></MainContentInputBox>
    <MainContent></MainContent>
  </div>
</template>
<script setup>
import MainContentInputBox from "@/components/MainContentInputBox.vue";
import NavigationBar from "@/components/NavigationBar.vue";
import MainContent from "@/components/MainContent.vue";


export default {
  name: 'Home',
  components: {
    MainContentInputBox,
    NavigationBar,
    MainContent
  }
}
</script>