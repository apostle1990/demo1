<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 我的作品
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div>
            <el-row>
                <el-col :span="4" v-for="(item, index) in this.tableData" :key="item.worksdid" :offset="index > 0 ? 1 : 0">
                    <el-card :body-style="{ padding: '0px' }" shadow="always" class="card">
                        <img src="@/assets/picture/scratch.jpg" class="image">
                        <div style="padding: 14px;">
                            <span>{{item.workstitle}}</span>
                            <br>
                            <div class="bottom clearfix">
                                <el-button type="text" @click="up(item)">提交</el-button>
                            </div>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
        matchid:'',
        studentid:'',
        tableData: [],
        form: {},
    };
  },
  created() {
    var query = this.$route.query;
    this.matchid=query.matchid;
    this.studentid=localStorage.getItem('studentid'),
    this.getData();
    },
  methods:{
        getData() {
            this.$axios
            .post('http://localhost:8081/api/stuworks',{
                studentid:this.studentid
            })
            .then(res => {
                this.tableData = res.data;
            });
        },
        up(item) {
            console.log(item);
            this.$axios
            .post('http://localhost:8081/api/updateworks',{
                matchid:this.matchid,
                studentid:this.studentid,
                worksid:item.worksid,
                score:0
            })
            .then(res => {
               if(res.data.code == 200){
                   this.$message.success('成功');
               }else if(res.data.code ==400){
                   this.$message.error('失败');
               }
            });
        },
  }
}
</script>

<style>
  .card {
    height: 250px;
    width: 220px;
    margin: 0px;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>