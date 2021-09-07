<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 平台通知
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>    
        <div class="container">
            <el-form  :model="form" label-width="80px">
                <el-form-item label="学生名">
                    <el-input v-model="form.studentname" style="width:250px"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password" style="width:250px" show-password></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.email" style="width:350px"></el-input>
                </el-form-item>
                <el-form-item label="QQ">
                    <el-input v-model="form.qq" style="width:350px"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="saveeidt">保存</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  export default {
      created(){
          this.studentid=localStorage.getItem('studentid'),
          this.getstu();
      },
      data() {
          return {
              studentid:'',
              form: {},
              }
    },
    methods: {
        getstu(){
            this.$axios
            .post('http://localhost:8081/api/getstu',{
                studentid:this.studentid
            })
            .then(res => {
                this.form = res.data;
            });
        },
      saveeidt() {
            this.$axios
            .post('http://localhost:8081/api/updatestu',{
                studentid:this.studentid,
                studentname:this.form.studentname,
                password:this.form.password,
                email:this.form.email,
                qq:this.form.qq,
            })
            .then(res => {
                if(res.data.code == 200){
                    this.$message.success('修改成功');
                    this.form = res.data;
                }else if(res.data.code == 400){
                    this.$message.error("修改失败");
                }
            });
      },
    }
  }
</script>