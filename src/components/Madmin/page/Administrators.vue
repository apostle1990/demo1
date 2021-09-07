<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 管理员管理
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
                <el-input v-model="administratorid" placeholder="管理员ID" class="handle-input mr10"></el-input>
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
                <el-table-column prop="administratorid" label="管理员ID" align="center"></el-table-column>
                <el-table-column prop="password" label="密码"></el-table-column>
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
                <el-form-item label="密码">
                    <el-input v-model="form.password"></el-input>
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
                <el-form-item label="管理员ID">
                    <el-input v-model="addform.administratorid"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="addform.password"></el-input>
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
            administratorid:'',
            localadmin:'',
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
        this.localadmin = localStorage.getItem('adminid');
        this.getData();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getData() {
            this.$axios
            .post('http://localhost:8081/api/adm',{
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
                if(this.administratorid==''){
                        break;
                }else{
                        if(this.tableData1[i].administratorid==this.administratorid){
                        j++;
                        continue;
                        }else{
                            this.tableData.splice(j,1);
                        }
                    }
            }
            // this.search();
        },
        //添加管理员
        newmatch(){
            this.addVisible = true;
        },
        addmatch(){
                this.$axios
                .post('http://localhost:8081/api/addadm',{
                    administratorid:this.addform.administratorid,
                    password:this.addform.password,
                })
                .then(res => {
                    if(res.data.code===200){
                    this.$message.success('创建成功');
                    this.getData();
                    this.addVisible = false;
                    }else if(res.data.code===400){
                        this.$message.error('创建失败');
                    }else if(res.data.code===600){
                        this.$message.error('管理员已存在');
                    }
                });
        },
        // 删除操作
        handleDelete(index, row) {
            if(this.tableData[index].administratorid==this.localadmin){
                this.$message.error(`无法删除当前登录账号`);
            }else{
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$axios
                .post('http://localhost:8081/api/deleteadm',{
                    administratorid:this.tableData[index].administratorid,
                })
                .then(res => {
                    if(res.data.code===200){
                    this.$message.success('删除成功');
                    this.tableData.splice(index, 1);
                    }else if(res.data.code===400){
                        this.$message.success('删除失败');
                    }
                });
                })
                .catch(() => {});
            }
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
                console.log("Tmatchid"+this.tableData[t].administratorid);
                 console.log("Mmatchid"+this.multipleSelection[i].administratorid);
                 for(let j=0; j<this.tableData.length; j++){
                    if(this.tableData[t].administratorid==this.multipleSelection[i].administratorid){
                        if(this.tableData[t].administratorid!=this.localadmin){
                        this.$axios
                        .post('http://localhost:8081/api/deleteadm',{
                            administratorid:this.tableData[t].administratorid,
                        })
                        this.tableData.splice(t, 1);
                        str += this.multipleSelection[i].administratorid + ' ';
                        }
                    }else {
                        t++;
                    }
                 }
                 t=0;
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
                .post('http://localhost:8081/api/updateadm',{
                    administratorid:this.tableData[this.idx].administratorid,
                    password:this.tableData[this.idx].password,
                })
                .then(res => {
                    if(res.data.code===200){
                        this.editVisible = false;
                        this.getData();
                        this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                        this.$set(this.tableData, this.idx, this.form);
                    }else if(res.data.code===400){
                        this.$message.error('修改失败');
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
