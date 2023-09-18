<template>
  <div>
    <NavigationBar></NavigationBar>
    <MainContentInputBox></MainContentInputBox>
    <MainContent></MainContent>
  </div>
</template>

<script>
  import NavigationBar from "@/components/NavigationBar.vue";
  import MainContentInputBox from "@/components/MainContentInputBox.vue";
  import MainContent from "@/components/MainContent.vue";

  export default {
    name: 'HomePage',
    components:{
      NavigationBar,
      MainContentInputBox,
      MainContent
    }
  }
</script>
