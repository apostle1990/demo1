<template>
<div id="homepage">
    <main class="main-layout">
    <div class="head">
        <div class="header-box"></div>
        <div class="header-wrap">
            <div class="header-content">
                <a href="" class="logo-wrap active link-active">
                    <span class="icon-logo"></span>
                </a>
                <ul class="nav">
                    <li class="nav-item">
                        <span class="title active nav-item-active" @click="componentName = 'home'">
                            首页
                        </span>
                    </li>
                    <li class="nav-item">
                        <span class="title active nav-item-active" @click="componentName = 'matchmessage'">
                            赛事介绍
                        </span>
                    </li>
                        <li class="nav-item">
                        <span class="title active nav-item-active" @click="componentName = 'matchnews'">
                            新闻通告
                        </span>
                    </li>
                    <li class="nav-item">
                        <span class="title active nav-item-active" @click="works">
                            作品展示
                        </span>
                    </li>
                    <li class="nav-item">
                        <span class="title active nav-item-active" @click="programming">
                            在线编程
                        </span>
                    </li>
                    <li class="nav-item">
                        <span class="title active nav-item-active" @click="componentName = 'match'">
                            参赛通道
                        </span>
                    </li>
                </ul>
                <div class="flex flex-row-center">
                    <button class="judge-btn" @click="mlogin">管理员入口</button>
                    <button class="judge-btn" @click="dialogFormVisible = true">教师入口</button>
                    <div class="about-login">
                        <div class="login-bar"  @click="student = true">登录</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="body">
        <component :is="componentName"></component>
    </div>
    <div class="science-footer">
        <div class="content">
            <div class="main-content">
                <ul>
                    <li>
                        <a target="_blank" href="">关于活动</a>
                    </li>
                    <li>
                        <a target="_blank" href="">关于大赛</a>
                    </li>
                    <li>
                        <a target="_blank" href="">下载中心</a>
                    </li>
                    <li>
                        <a target="_blank" href="">联系我们</a>
                    </li>
                </ul>
                <p class="small-text">京ICP备11018462号-2 京公网安备：110108009524号</p>
            </div>
        </div>
    </div>
    </main>
    <el-dialog :visible.sync="student">
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="登录" name="login">
            <el-form :model="loginForm" :rules="loginFormRules" ref="loginForm">
            <el-form-item label="手机号：" prop="telephone">
            <el-input v-model="loginForm.telephone" ></el-input>
            </el-form-item>
            <el-form-item label="密码：" prop="password">
            <el-input v-model="loginForm.password" type="password"></el-input>
            </el-form-item>
            </el-form>
            <el-button type="primary" @click="slogin">登录</el-button>
            <el-button type="info" @click="resetLoginForm()">重置</el-button>
            </el-tab-pane>
            
            <el-tab-pane label="注册" name="register">
            <el-form :model="loginForm" :rules="loginFormRules">
                <el-form-item label="手机号：" prop="telepohne">
                <el-input v-model="loginForm.telephone" prefix-icon="iconfont icon-user"></el-input>
                </el-form-item>
                <el-form-item label="密码：" prop="password">
                <el-input v-model="loginForm.password" prefix-icon="iconfont icon-3702mima" type="password"></el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" @click="register">注册</el-button>
            <el-button type="info" @click="student = false">返回</el-button>
        </el-tab-pane>
  </el-tabs>
</el-dialog>

<el-dialog title="教师登录" :visible.sync="dialogFormVisible">
  <el-form :model="Teacherform">
    <el-form-item label="手机号" :label-width="formLabelWidth">
      <el-input v-model="Teacherform.telephone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" :label-width="formLabelWidth">
      <el-input v-model="Teacherform.password" autocomplete="off" type="password"></el-input>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button type="primary" @click="Tlogin()">确 定</el-button>
    <el-button @click="dialogFormVisible = false">取 消</el-button>
  </div>
</el-dialog>
</div>
</template>

<script>
export default {
    data(){
        return{
        componentName:'home',
        activeName: 'login',
        student: false,
        dialogFormVisible: false,
        formLabelWidth: '80px',
        info:null,
        error : {
          name: '',
          pwd : ''
        },
        form: {
          telephone: '',
          password: '',
        },
      // 这是登录表单的数据绑定对象
      loginForm: {
        telephone: '1234567890',
        password: '123456'
      },
      Teacherform: {
        telephone: '123421',
        password: '1234567'
      },
      // 这是表单的验证规则对象
      loginFormRules: {
        // 验证用户名是否合法
        telepohne: [
          { required: true, message: '输入手机号', trigger: 'blur' },
          { min: 11, max: 11, message: '长度为11个字符', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: '请输入登录密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ],
        responseResult: []
      }
      };
    },
    methods:{
        programming(){
            window.open("http://localhost:8601")
            },
            works(){
                this.$router.push('/programming')
            },
          // 点击重置按钮，重置登录表单
        resetLoginForm() {
                 this.$refs.loginForm.resetFields();
        },
        mlogin(){
            this.$router.push('/login');
        },
        slogin() {
            let v=this;
            this.$axios
            .post('http://localhost:8081/api/slogin',{
                telephone:this.loginForm.telephone,
                password:this.loginForm.password
            })
            .then(res => {
                if(res.data.code === 200){
                    localStorage.setItem("studentid",res.data.id);
                    this.$router.push('/Sadmin')
                }else if(res.data.code === 400){
                    alert("账号不存在或账号密码错误")
                }
            });
        },
        register(){
             this.$axios
            .post('http://localhost:8081/api/register',{
                telephone:this.loginForm.telephone,
                password:this.loginForm.password
            })
            .then(res => {
                if(res.data.code === 200){
                    alert("注册成功")
                    localStorage.setItem("studentid",res.data.id);
                    this.$router.push('/Sadmin')
                }else if(res.data.code === 400){
                    alert("账号已注册")
                }else if(res.data.code === 600){
                    alert("注册失败")
                }
            });
        },
        Tlogin(){
            this.$axios
            .post('http://localhost:8081/api/tlogin',{
                telephone:this.Teacherform.telephone,
                password:this.Teacherform.password
            })
            .then(res => {
                if(res.data.code === 200){
                    console.log(res.data);
                    localStorage.setItem("teacherid",res.data.id);
                    this.$router.push('/Tadmin')
                }else if(res.data.code === 400){
                    alert("账号不存在或账号密码错误")
                }
            });
        },
        handleClick(tab, event) {
            console.log(tab, event);
            }},
        components: {
        home:require('@/components/home/home.vue').default,
        matchnews:require('@/components/match/matchnews.vue').default,
        match:require('@/components/match/match.vue').default,
        matchmessage:require('@/components/match/matchmessage.vue').default,
    }
          
}
</script>

<style scoped>
@import '../../assets/css/homepage.css';
</style>