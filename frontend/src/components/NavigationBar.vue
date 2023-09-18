<template>
  <!-- 네비게이션 바 시작 -->
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid text-left">
      <!-- 로고 -->
      <NavigationLogo></NavigationLogo>
      <!-- 네비게이션 바 아이콘 -->
      <div class="center-div d-flex">
        <a class="navbar-brand nav-icon" href="#"
        ><img src="@/assets/nv_home.svg"
        /></a>
        <a class="navbar-brand nav-icon" href="#"
        ><img src="@/assets/nv_people.svg"
        /></a>
        <a class="navbar-brand nav-icon" href="#"
        ><img src="@/assets/nv_video.svg"
        /></a>
      </div>
    </div>
    <!-- profile 사진 -->
    <div>
      <img src="@/assets/nv_profile.png" class="nv-profile" />
    </div>
  </nav>
</template>

<script>
  import NavigationLogo from '@/components/NavigationLogo.vue'

  export default {
    name: 'NavigationBar',
    components: {
      NavigationLogo,
    }
  }
</script>

<style scoped>
.center-div {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
/* nav 아이콘 */
.nav-icon {
  padding-left: 70px;
  padding-right: 70px;
  padding-top: 16px;
  padding-bottom: 16px;
  border-radius: 10px;
}
/* nav 아이콘 마우스 hover */
.nav-icon:hover {
  background-color: rgb(229, 229, 229);
}
/* profile 양식 */
.nv-profile {
  height: 60px;
  width: 60px;
  border-radius: 50%;
  margin-right: 20px;
}
</style>