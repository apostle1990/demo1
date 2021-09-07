<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 作品评分
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="project-info-middle f-cb">
            <div class="project-info-program f-fl">
                <div class="ui-common-scratch-container">
                    <div class="ui-common-scratch-v3 scratch3 ui-common-scratch" id="scratch-parent">
                        <input type="file" class="u-upload-library-fileinput" accept="">
                        <div id="scratch3-parent">
                            <div class="player_app_3vUYe">
                               <div class="player_stage-only_3WHZN box_box_2jjDp">
                                   <div class="box_box_2jjDp">
                                       <div class="stage-header_stage-header-wrapper_1F4gT stage-header_stage-header-wrapper-player_3_59T box_box_2jjDp">
                                           <div class="stage-header_stage-menu-wrapper_15JJt stage-header_stage-menu-wrapper-player_2wz5j box_box_2jjDp">
                                               <div class="controls_controls-container_2xinB">
                                                     <el-button type="success"  circle class="green-flag_green-flag_1kiAo" title="运行" id="green"></el-button>
                                                     <el-button type="danger"  circle class="stop-all_stop-all_1Y8P9" title="停止" id="stop"></el-button>
                                                     <input type="file" id="file" name="file">
                                               </div>
                                               <div class="stage-wrapper_stage-canvas-wrapper_3ewmd box_box_2jjDp">
                                                   <div class="stage_stage_1fD7k box_box_2jjDp" style="width: 718px; height: 539px;">
                                                       <div>
                                                           <canvas id="test" width="718" height="539" style="height: 539px; width: 718px;">
                                                               </canvas>
                                                        </div>
                                                    </div>
                                               </div>
                                           </div>
                                       </div>
                                   </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="project-info-detail f-fl">
            <div>
            <el-input v-model="score" placeholder="请输入评分" :disabled="change"></el-input>
            <el-button type="primary" @click="changeedit">修改</el-button>
           <el-button type="primary" @click="saveedit(score)">保存</el-button>
            </div>
            </div>
        </div>
    </div>
    
</template>

<script>
const ScratchRender = require('scratch-render/dist/web/scratch-render');
const VirtualMachine = require('scratch-vm/dist/web/scratch-vm');
const ScratchStorage = require('scratch-storage/dist/web/scratch-storage');
const ScratchSVGRenderer = require('scratch-svg-renderer/dist/web/scratch-svg-renderer');
export default {
    created(){
        var query = this.$route.query;
        this.matchid=query.matchid;
        this.teacherid = localStorage.getItem('teacherid');
        this.worksid = query.worksid;
    },
    mounted(){
        // These variables are going to be available in the "window global" intentionally.
        // Allows you easy access to debug with `vm.greenFlag()` etc.
        window.devicePixelRatio = 1;

        var canvas = document.getElementById('test');
        var render = new ScratchRender(canvas);
        var vm = new VirtualMachine();
        var storage = new ScratchStorage();
        var mockMouse = data => vm.runtime.postIOData('mouse', {
            canvasWidth: canvas.width,
            canvasHeight: canvas.height,
            ...data,
        });
        vm.attachStorage(storage);
        vm.attachRenderer(render);
        vm.attachV2SVGAdapter(new ScratchSVGRenderer.SVGRenderer());
        vm.attachV2BitmapAdapter(new ScratchSVGRenderer.BitmapAdapter());

        document.getElementById('file').addEventListener('change', e => {
            let reader = new FileReader();
            let thisFileInput = e.target;
            reader.onload = () => {
                vm.start();
                vm.loadProject(reader.result)
                    .then(() => {
                        // we add a `#loaded` div to our document, the integration suite
                        // waits for that element to show up to assume the vm is ready
                        // to play!
                        const div = document.createElement('div');
                        div.id = 'loaded';
                        document.body.appendChild(div);
                    });
            };
            reader.readAsArrayBuffer(thisFileInput.files[0]);
        });

        document.getElementById('green').addEventListener('click', e => {
            vm.greenFlag(); // 执行程序
        });
        document.getElementById('stop').addEventListener('click', e => {
            vm.stopAll(); 
        });
    },
    data(){
        return{
            matchid:'',
            teacherid:'',
            worksid:'',
            workscontext:'',
            score: '',
            change:true,
        }
    },
    methods:{
        changeedit(){
            this.change=false;
        },
        saveedit(score){
            if(score==''){
                this.$message.error('请输入评分')
            }else{
            this.$axios
            .post('http://localhost:8081/api/setscore',{
                matchid:this.matchid,
                teacherid:this.teacherid,
                worksid:this.worksid,
                teacherscore:this.score
            })
            .then(res => {
                if(res.data.code == 200){
                    this.$message.success('评分成功')
                }else if(res.data.code == 400){
                    this.$message.error('评分失败')
                }
            });
            this.change=true;
            }
        }
    }
}
</script>
<style scoped>
.ui-project-info .project-info-middle {
    border-bottom: 1px solid rgba(235, 235, 235, 0.5);
    padding: 20px 30px 30px;
}
.f-cb, .f-cbli li {
    zoom: 1;
}
.ui-project-info .project-info-program {
    width: 720px;
    height: 582px;
    overflow: hidden;
}
.project-info-program {
    position: relative;
}
.ui-common-scratch-container {
    width: 100%;
    height: 100%;
    position: relative;
}
.ui-project-info .project-info-program .ui-common-scratch {
    margin-top: 0;
}
.ui-common-scratch-v3 {
    width: 100%;
    height: 100%;
    position: relative;
}
.ui-common-scratch-container .u-upload-library-fileinput {
    display: none;
}
input[type=file] {
    cursor: pointer;
}
input {
    vertical-align: baseline;
    margin: 0;
}
.ui-common-scratch-v3 #scratch3-parent {
    height: 100%;
}
.player_app_3vUYe {
    width: 100%;
    margin: 0;
}
.player_stage-only_3WHZN {
    width: 100%;
}
.stage-header_stage-header-wrapper-player_3_59T {
    background: #EDF1F7;
    border: 1px solid #DDDDDD;
    border-radius: 6px 6px 0 0;
    height: 40px;
}
.ui-project-info .project-info-detail {
    height: 582px;
    position: relative;
}
.f-fr {
    float: right;
}
.f-fl {
    float: left;
}
.stage-header_stage-menu-wrapper-player_2wz5j {
    height: 40px;
    /* flex-direction: row-reverse; */
}
.controls_controls-container_2xinB {
    display: flex;
}
.green-flag_green-flag_1kiAo {
    width: 2rem;
    height: 2rem;
    padding: 0.375rem;
    border-radius: 0.25rem;
    user-select: none;
    cursor: pointer;
}
.stop-all_stop-all_1Y8P9 {
    opacity: 0.5;
}
.stop-all_stop-all_1Y8P9 {
    width: 2rem;
    height: 2rem;
    padding: 0.375rem;
    border-radius: 0.25rem;
    user-select: none;
    cursor: pointer;
}

</style>