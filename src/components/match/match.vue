<template>
<div class="contentmatch">
    <div class="sign">
        <div class="base-banner-match">
            <h2>我要参赛</h2>
        </div>
        <div>
            <div class="content-wrap">
                <p class="tips">
                    <span class="base-text">提示：每个用户仅能选择如下四个赛项中的一个参加，不能重复参赛。</span>
                </p>
                <ul class="contest-list">
                    <li class="item flex">
                        <div class="main-content flex-column">
                            <h2>Scratch创意编程比赛</h2>
                            <p class="base-text">该比赛设小学I组（1-3年级）、小学II组(4-6年级）和初中组。全国各地小学、初中在校学生均以个人名义报名参加。</p>
                            <button type="button" class="button" @click="registration">报名</button>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
  data(){
    return{
    }
  },
  methods:{
    registration(){
      this.$router.push('/registration')
    }
  }
}
</script>

<style scoped>
@import '../../assets/css/homepage.css';
</style>