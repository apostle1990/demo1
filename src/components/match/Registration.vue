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
            <button type="button" class="button">立即报名</button>
          </div>
          <div class="login el-row">
            <div class="login-bar">登录</div>
          </div>
        </div>
          </div>
      </div>
    </div>
    <div class="form_container content_container">
      <div class="sign-box">
        <h1>报名参赛</h1>
        <el-form ref="form" :model="form" class="sign-form">
            <el-form-item label="参赛小组">
              <el-select v-model="form.region" placeholder="请选择参赛组别" style="width: 350px;">
                <el-option label="小学1组" value="shanghai"></el-option>
                <el-option label="小学2组" value="beijing"></el-option>
                <el-option label="初中组" value="beijing"></el-option>
              </el-select>
            </el-form-item>
               <el-form-item label="电话号码" class="el-form-item" >
            <el-input v-model="form.name" style="width: 350px;"></el-input>
            </el-form-item>
            <el-form-item>
              <button class="sign-btn" @click="onSubmit" 
              style="background-color: rgb(61, 129, 255); box-shadow: rgba(61, 129, 255, 0.3) 0px 8px 12px 0px;">
                报名</button>
              </el-form-item>
            </el-form>
      </div>
    </div>
    </div>
    </div>
</template>

<script>
export default {
  data() {
    return{
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
    }
  }
}
</script>
<style scoped>
@import '../../assets/css/match.css';
</style>