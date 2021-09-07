<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 老师管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除</el-button>
                <el-input v-model="teacherid" placeholder="老师ID" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" @click="newmatch">新增</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="teacherid" label="老师ID" align="center"></el-table-column>
                <el-table-column prop="teachername" label="老师名"></el-table-column>
                <el-table-column prop="telephone" label="电话号码"></el-table-column>
                <el-table-column prop="password" label="密码"></el-table-column>
                <el-table-column prop="email" label="邮箱"></el-table-column>
                <el-table-column prop="qq" label="QQ号"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
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

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible">
            <el-form  :model="form" label-width="70px">
                <el-form-item label="老师名">
                    <el-input v-model="form.teachername"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.email"></el-input>
                </el-form-item>
                <el-form-item label="QQ">
                    <el-input v-model="form.qq"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 新增弹出框 -->
        <el-dialog title="编辑" :visible.sync="addVisible">
            <el-form :model="addform" label-width="70px">
                <el-form-item label="学生名">
                    <el-input v-model="addform.teachername"></el-input>
                </el-form-item>
                <el-form-item label="电话号码">
                    <el-input v-model="addform.telephone"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="addform.password"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="addform.email"></el-input>
                </el-form-item>
                <el-form-item label="QQ">
                    <el-input v-model="addform.qq"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addVisible = false">取 消</el-button>
                <el-button type="primary" @click="addmatch">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    name: 'basetable',
    data() {
        return {
            teacherid:'',
            pageIndex: 1,
            pageSize: 10,
            tableData: [],
            tableData1: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            addVisible: false,
            pageTotal: 0,
            form: {},
            addform:{},
            idx: -1,
            id: -1
        };
    },
    created() {
        this.getData();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getData() {
            this.$axios
            .post('http://localhost:8081/api/tea',{
                code:1
            })
            .then(res => {
                this.tableData = res.data;
                this.tableData1 = this.tableData.concat();;
                this.pageTotal = this.tableData.length;
            });
        },
        // 触发搜索按钮
        handleSearch() {
            this.tableData = this.tableData1.concat();
            const length = this.tableData1.length;
            let j=0;
            for (let i = 0; i < length; i++) {
                if(this.teacherid==''){
                        break;
                }else{
                        if(this.tableData1[i].teacherid==this.teacherid){
                        j++;
                        continue;
                        }else{
                            this.tableData.splice(j,1);
                        }
                    }
            }
        },
        //添加比赛
        newmatch(){
            this.addVisible = true;
        },
        addmatch(){
                this.$axios
                .post('http://localhost:8081/api/addtea',{
                    teachername:this.addform.teachername,
                    telephone:this.addform.telephone,
                    password:this.addform.password,
                    email:this.addform.email,
                    qq:this.addform.qq,
                })
                .then(res => {
                    if(res.data.code===200){
                    this.$message.success('创建成功');
                    this.getData();
                    this.addVisible = false;
                    }else if(res.data.code===400){
                        this.$message.error('创建失败');
                    }else if(res.data.code===600){
                        this.$message.error('老师用户已存在');
                    }
                });
        },
        // 删除操作
        handleDelete(index, row) {
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$axios
                .post('http://localhost:8081/api/deletetea',{
                    teacherid:this.tableData[index].teacherid,
                })
                .then(res => {
                    if(res.data.code===200){
                    this.$message.success('删除成功');
                    this.tableData.splice(index, 1);
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
            let t=0;
            for (let i = 0; i < length; i++) {
                console.log("Tmatchid"+this.tableData[t].teacherid);
                 console.log("Mmatchid"+this.multipleSelection[i].teacherid);
                 for(let j=0; j<this.tableData.length; j++){
                    if(this.tableData[t].teacherid==this.multipleSelection[i].teacherid){
                        this.$axios
                        .post('http://localhost:8081/api/deletetea',{
                            teacherid:this.tableData[t].teacherid,
                        })
                        this.tableData.splice(t, 1);
                    }else {
                        t++;
                    }
                 }
                 t=0;
                str += this.multipleSelection[i].teacherid + ' ';
            }
            this.$message.error(`删除了${str}`);
            this.multipleSelection = [];
        },
        // 编辑操作
        handleEdit(index, row) {
            this.idx = index;
            this.form = row;
            this.editVisible = true;
        },
        // 保存编辑
        saveEdit() {
                this.$axios
                .post('http://localhost:8081/api/updatetea',{
                    teacherid:this.tableData[this.idx].teacherid,
                    teachername:this.tableData[this.idx].teachername,
                    password:this.tableData[this.idx].password,
                    email:this.tableData[this.idx].email,
                    qq:this.tableData[this.idx].qq,
                })
                .then(res => {
                    if(res.data.code===200){
                        this.editVisible = false;
                        this.getData();
                        this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                        this.$set(this.tableData, this.idx, this.form);
                    }else if(res.data.code===400){
                        this.$message.success('修改失败');
                    }
                });
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
