<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 比赛管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
            >
            <el-table-column prop="matchid" label="比赛ID"></el-table-column>
            <el-table-column prop="matchname" label="比赛名" align="center"></el-table-column>
            <el-table-column prop="workstitle" label="作品名"></el-table-column>
            <el-table-column prop="score" label="作品评分"></el-table-column>
            <el-table-column label="操作" width="180" align="center">
                  <template slot-scope="scope">
                    <el-button
                    type="text"
                    icon="el-icon-edit"
                    @click="handleEdit(scope.row)"
                    >提交作品</el-button>
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
    </div>
</template>

<script>
export default {
    name: 'basetable',
    data() {
        return {
            matchid:'',
            studentid:'',
            pageIndex: 1,
            pageSize: 10,
            tableData: [],
            pageTotal: 0,
            form: {},
        };
    },
    created() {
        var query = this.$route.query;
        this.matchid=query.matchid;
        this.studentid=localStorage.getItem('studentid'),
        this.getData();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getData() {
            this.$axios
            .post('http://localhost:8081/api/stumatchinfo',{
                studentid:this.studentid,
            })
            .then(res => {
                this.tableData = res.data;
                this.pageTotal = this.tableData.length;
            });
        },
        // 编辑操作
        handleEdit(row) {
            this.form = row;
            this.$router.push({name:'upworks',query:{matchid:this.form.matchid}});
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
