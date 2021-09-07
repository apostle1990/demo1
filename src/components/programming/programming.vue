<template>
<div class="view">
  <div class="common_container">
    <div>
      <div class="header-box"></div>
      <div class="header_wrap" style="background: rgb(61, 129, 255);">
        <div class="t-head-con el-row">
          <div class="el-col el-col-24">
            <div class="nav el-row">
            <div class="logo el-col el-col-24 logo-h">
              <img src="../../assets/picture/科协logo.png" class="logo_icon">
            </div>
            </div>
          <div class="join_button_wrap el-row">
            <button type="button" class="button" @click="registration">立即报名</button>
          </div>
          <div class="login el-row">
            <div class="login-bar">登录</div>
          </div>
        </div>
          </div>
      </div>
    </div>
          <div class="navm">
        <span>参赛作品</span>
        <i class="el-icon-arrow-right"></i>
        xx的作品
      </div>
    <div class="work-detail content_container">
      <div class="detail">
        <div class="scratch-work">
          <div class="work-item">
            <div class="work-detail">
              <div class="work-cover">
                <span></span>
            <div style="width: 100%; height: 446px; overflow: hidden;">
              <iframe
              :src=sb3
              allowtransparency="true"
              width="500"
              height="450"
              frameborder="0"
              scrolling="no"
              allowfullscreen
              ></iframe>
              </div>
            </div>
            <div class="work-info">
              <h2>国旗争夺战</h2>
              <div class="personal-wrap">
                <div class="personal">
                  <span class="name">陈一鸣</span>
                  <span class="school">湖北省随州市外国语学校</span>
                </div>
              </div>
              <div class="work-explain-wrap">
                <div class="work-explain">
                  <div class="explain-item">
                  <h3>作品说明</h3>
                  <p class="explain">
                    该游戏由玩家控制我方坦克夺取国旗，并且需要躲避敌方坦克的干扰。该作品旨在向中国军人致敬，对守卫国家边防安全的边防战士致以崇高的敬意。
                  </p>
                </div>
                   <div class="explain-item">
                  <h3>操作说明</h3>
                  <p class="explain">
                    按下小绿旗，通过键盘方向键控制我方坦克，躲避敌方坦克的追击，并夺取国旗，计分器会记录下国旗的数量，随着国旗数量的增多，敌方坦克数量也会增多，如果在游戏过程中被敌方坦克撞到则游戏结束。
                  </p>
                </div>
                </div>
              </div>
            </div>
            </div>
            <div class="func-warp"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  data(){
    return{
      sb3:  'https://scratch3v2.codelab.club/player.html?sb3url=https://adapter.codelab.club/sb3/Pong_Starter.sb3',
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
@import '../../assets/css/match.css';
</style>