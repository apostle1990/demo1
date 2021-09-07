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
                            <div class="bottom clearfix">
                                <el-button type="text" @click="selectwork(item)">作品查看</el-button>
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
        selectwork(item){
            this.$router.push({name:'teacherscore',query:{matchid:this.matchid, worksid:item.worksid, workscontext:item.workscontext}});
        }
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