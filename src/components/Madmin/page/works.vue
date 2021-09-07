<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 作品管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div>
            <el-row>
                <el-col :span="3" v-for="(item, index) in this.tableData" :key="item.studentid" :offset="index > 0 ? 1 : 0">
                    <el-card :body-style="{ padding: '0px' }" shadow="always" class="card">
                        <img src="@/assets/picture/scratch.jpg" class="image">
                        <div style="padding: 14px;">
                            <span>{{item.workstitle}}</span>
                            <br>
                            <span>{{item.studentname}}</span>
                            <br>
                            <span>{{item.score}}</span>
                            <div class="bottom clearfix">
                              <el-input v-model="item.score" placeholder="成绩修改" class="handle-input mr10"></el-input>
                                <el-button type="text" @click="updateworks(item)">成绩修改</el-button>
                            </div>
                            <el-button type="text" @click="deleteworks(index,item)">删除</el-button>
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
      tableData: [],
      form: {},
    };
  },
  created() {
    var query = this.$route.query; 
    this.matchid=query.matchid;
    this.getData();
    },
  methods:{
        getData() {
            this.$axios
            .post('http://localhost:8081/api/matchworks',{
                matchid:this.matchid
            })
            .then(res => {
                this.tableData = res.data;
            });
        },
        updateworks(item){
            console.log(item);
            this.$axios
            .post('http://localhost:8081/api/updateworks',{
                studentid:item.studentid,
                matchid:this.matchid,
                score:item.score,
            })
            .then(res => {
                if(res.data.code==200){
                    this.$message.success('修改成功');
                }else if(res.data.code==400){
                    this.$message.success('修改失败');
                }
            });
        },
        deleteworks(index,item){
            this.$axios
            .post('http://localhost:8081/api/deleteworks',{
                matchid:this.matchid,
                studentid:item.studentid,
            })
            .then(res => {
                if(res.data.code==200){
                    this.tableData.splice(index, 1);
                    this.$message.success('修改成功');
                }else if(res.data.code==400){
                    this.$message.success('修改失败');
                }
            });
        }
  }
}
</script>

<style>
  .card {
    height: 350px;
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