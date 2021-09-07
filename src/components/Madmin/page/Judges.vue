<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 评委管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
             <el-tabs :tab-position="tabPosition" >
                 <el-tab-pane label="现有评委">
            <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除</el-button>
                <el-input v-model="teacherid" placeholder="老师ID" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch(1)">搜索</el-button>
                <el-table
                :data="judges"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="teacherid" label="老师ID" align="center"></el-table-column>
                <el-table-column prop="teachername" label="老师名"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="pageIndex"
                    :page-size="pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
            </div>
                 </el-tab-pane>
                 <el-tab-pane label="可成为评委">
           <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="addAllSelection"
                >批量添加</el-button>
                <el-input v-model="teacherid" placeholder="比赛ID" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch(2)">搜索</el-button>
                <el-table
                :data="teacher"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="teacherid" label="老师ID" align="center"></el-table-column>
                <el-table-column prop="teachername" label="老师名"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleadd(scope.$index, scope.row)"
                        >添加</el-button>
                    </template>
                </el-table-column>
            </el-table>
            </div>
                 </el-tab-pane>
                 </el-tabs>
        </div>
    </div>
</template>

<script>
export default {
    name: 'basetable',
    data() {
        return {
            matchid:'',
            teacherid:'',
            pageIndex: 1,
            pageSize: 10,
            judges: [],
            judges1: [],
            teacher: [],
            teacher1: [],
            multipleSelection: [],
            delList: [],
            pageTotal: 0,
            form: {},
            addform:{},
            idx: -1,
            id: -1,
            tabPosition: 'left'
        };
    },
    created() {
        var query = this.$route.query; 
        this.matchid=query.matchid;
        this.getjudges();
        this.getteacher();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getjudges() {
            this.$axios
            .post('http://localhost:8081/api/teamatch',{
                matchid:this.matchid,
            })
            .then(res => {
                this.judges = res.data;
                this.judges1 = this.judges.concat();;
                this.pageTotal = this.judges.length;
            });
        },
        getteacher(){
            this.$axios
            .post('http://localhost:8081/api/inteamatch',{
                matchid:this.matchid,
            })
            .then(res => {
                this.teacher = res.data;
                this.teacher1 = this.teacher.concat();;
            });
        },
        // 触发搜索按钮
        handleSearch(item) {
            if(item==1){
            this.judges = this.judges1.concat();
            const length = this.judges1.length;
            let j=0;
            for (let i = 0; i < length; i++) {
                if(this.teacherid==''){
                        break;
                }else{
                        if(this.judges1[i].teacherid==this.teacherid){
                        j++;
                        continue;
                        }else{
                            this.judges.splice(j,1);
                        }
                    }
            }                
            }else if(item==2){
            this.teacher = this.teacher1.concat();
            const length = this.teacher1.length;
            let j=0;
            for (let i = 0; i < length; i++) {
                if(this.teacherid==''){
                        break;
                }else{
                        if(this.teacher1[i].teacherid==this.teacherid){
                        j++;
                        continue;
                        }else{
                            this.teacher.splice(j,1);
                        }
                    }
            }              
            }
        },
        // 删除操作
        handleDelete(index, row) {
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$axios
                .post('http://localhost:8081/api/deleteteamatch',{
                    matchid:this.matchid,
                    teacherid:this.judges[index].teacherid
                })
                .then(res => {
                    if(res.data.code===200){
                        this.teacher.push(this.judges[index]);
                    this.$message.success('删除成功');
                    this.judges.splice(index, 1);
                    }else if(res.data.code===400){
                        this.$message.error('删除失败');
                    }
                });
                })
                .catch(() => {});
        },
        // 多选操作
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        delAllSelection() {
            const length = this.multipleSelection.length;
            let str = '';
            for (let i = 0; i < length; i++) {
                for(let j=0;j<length;j++){
                    if(this.judges[j].teacherid==this.multipleSelection[i].teacherid){
                        this.$axios
                        .post('http://localhost:8081/api/deleteteamatch',{
                            matchid:this.matchid,
                            teacherid:this.judges[j].teacherid
                            }).then(res => {
                                if(res.data.code===200){
                                    }else if(res.data.code===400){
                                        this.$message.success('删除失败');
                                        }
                            });
                    }else{t++;}
                }
                str += this.multipleSelection[i].teacherid + ' ';
            }
            this.$message.error(`删除了${str}`);
            this.multipleSelection = [];
        },        
        handleadd(index, row) {
            // 二次确认添加
            this.$confirm('确定要添加吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$axios
                .post('http://localhost:8081/api/addteamatch',{
                    matchid:this.matchid,
                    teacherid:this.teacher[index].teacherid
                })
                 .then(res => {
                    if(res.data.code===200){
                    this.judges.push(this.teacher[index]);
                    this.$message.success('添加成功');
                    this.teacher.splice(index, 1);
                    }else if(res.data.code===400){
                        this.$message.error('添加失败');
                    }
                });
                })
                .catch(() => {});
        },
        addAllSelection() {
            const length = this.multipleSelection.length;
            let str = '';
            for (let i = 0; i < length; i++) {
                for(let j=0;j<length;j++){
                    if(this.teacher[j].teacherid==this.multipleSelection[i].teacherid){
                        this.$axios
                        .post('http://localhost:8081/api/addteamatch',{
                            matchid:this.matchid,
                            teacherid:this.teacher[j].teacherid
                            }).then(res => {
                                if(res.data.code===200){
                                    }else if(res.data.code===400){
                                        this.$message.success('删除失败');
                                        }
                                        });
                    }else{
                        t++;
                    }
                }
                str += this.multipleSelection[i].teacherid + ' ';
            }
            this.$message.error(`删除了${str}`);
            this.multipleSelection = [];
        }, 
        // 分页导航
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
            this.getData();
        }
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
