<template>
<div class="about-contest">
        <div class="menu">
            <ul class="menu-content flex-column-center"></ul>
            <li class="menu-item">赛项介绍</li>
            <li class="menu-item">赛制说明</li>
            <li class="menu-item">作品要求</li>
            <li class="menu-item">返回顶部</li>
        </div>
        <div id="contest-banner" class="contest-banner"></div>
        <div>
            <div class="empty-tab"></div>
            <div class="contest-tab flex-row-center">
                <ul class="tab-list">
                    <li class="tab-item" :class="{activetab: at1}" @click="tab(1)">
                        <h2>
                            Scratch创意编程
                            <i class="triangle animation slide-in-left"></i>
                        </h2>
                    </li>
                    <li class="tab-item" :class="{activetab: at2}" @click="tab(2)">
                        <h2>
                            Python创意编程
                            <i class="triangle animation slide-in-left"></i>
                        </h2>
                    </li>
                    <li class="tab-item" :class="{activetab: at3}" @click="tab(3)">
                        <h2>
                            Arduino智能设计
                            <i class="triangle animation slide-in-left"></i>
                        </h2>
                    </li>
                    <li class="tab-item" :class="{activetab: at4}" @click="tab(4)">
                        <h2>
                            Micro:bit智能设计
                            <i class="triangle animation slide-in-left"></i>
                        </h2>
                    </li>
                </ul>
            </div>
        </div>
        <div class="contest-intro">
            <div class="title flex-row-center">
                <span class="line1" style="background:rgb(51,51,51)"></span>
                <h1 style="color: rgb(51, 51, 51);">赛项介绍</h1>
                <span class="line1" style="background:rgb(51,51,51)"></span>
            </div>
            <div class="content1 flex-row-center">
                <div class="left big-logo-creative">
                    <i></i>
                </div>
                <div class="right flex flex-column">
                    <h2>Python创意编程赛项</h2>
                    <h3>
                        Python创意编程比赛分初评、复评和终评三个阶段，初评和复评以线上形式开展，终评以线下形式开展（具体事项另行通知）。每人限报1项作品，每项作品限1名指导教师。
                        <br>
                        初评和复评：选手在线创作提交作品，经初评、复评，选出部分优秀作品入围终评。
                        <br>
                         终评：入围Python创意编程比赛终评选手将统一集中在指定场地，在规定时间内现场完成指定的任务题目。
                    </h3>
                    <span class="btn" @click="match">终评通道</span>
                </div>
            </div>
        </div>
        <div class="contest-instruction">
            <div class="instruction-wrap">
                <div class="title flex-row-center animation fadeInUp">
                    <span class="line1" style="background: rgb(51, 51, 51);"></span>
                    <h1 style="color: rgb(51, 51, 51);">赛制说明</h1>
                    <span class="line1" style="background: rgb(51, 51, 51);"></span>
                </div>
                <div class="sub-title flex-column-center animation fadeInUp">
                    <div class="flex-row-center">
                        <span class="dot-triangle"></span>
                        <h2 style="color: rgb(68, 68, 68);">参赛对象</h2>
                        <span class="dot-diamond"></span>
                    </div>
                    <div class="text">Scratch创意编程比赛设小学I组（1-3年级）、小学II组(4-6年级）和初中组。全国各地小学、初中在校学生均以个人名义报名参加。</div>
                    <div class="sub-text"></div>
                </div>
                <div class="content1 flex-row-center">
                    <div class="object flex-column-center animation fadeInUp" style="animation-delay: 0s;">
                        <div class="icon-obj icon-obj-1">小学1组</div>
                        <span>一至三年级</span>
                    </div>
                    <div class="object flex-column-center animation fadeInUp" style="animation-delay: 0.2s;">
                        <div class="icon-obj icon-obj-1">小学2组</div>
                        <span>四至六年级</span>
                    </div>
                    <div class="object flex-column-center animation fadeInUp" style="animation-delay: 0.4s;">
                        <div class="icon-obj icon-obj-1">小学3组</div>
                        <span>初一至初三</span>
                    </div>
                </div>
                <div class="sub-title flex-column-center animation fadeInUp" style="animation-delay: 0.8s;">
                    <div class="flex-row-center">
                        <span class="dot-triangle"></span>
                        <h2 style="color: rgb(68, 68, 68);">参赛步骤</h2>
                        <span class="dot-diamond"></span>
                    </div>
                    <div class="text"></div>
                    <div class="sub-text"></div>
                </div>
                <div class="timeline animation fadeInUp" style="animation-delay: 1s;">
                    <ul class="time-wrap flex">
                        <li class="item active">
                            6月10日-8月10日
                            <span class="circle before"></span>
                            </li>
                        <li class="item active">8月11日-9月30日</li>
                        <li class="item active">6月10日-8月10日</li>
                        <li class="item active">10月下旬</li>
                        <li class="item active">11月-12月</li>
                    </ul>
                    <ul class="step-list flex">
                        <li class="card flex-column-center">
                            <p class="name">作品提交</p>
                            <p class="base-text-">作品申报提交</p>
                        </li>
                        <li class="card flex-column-center">
                            <p class="name">作品初评/复评</p>
                            <p class="base-text-">确定入围选手名单</p>
                        </li>
                        <li class="card flex-column-center active">
                            <p class="name">网络投票</p>
                            <p class="base-text-">公众网络投票</p>
                        </li>
                        <li class="card flex-column-center">
                            <p class="name">线上终评</p>
                            <p class="base-text-">具体时间另行通知</p>
                        </li>
                         <li class="card flex-column-center">
                            <p class="name">公布获奖名单</p>
                            <p class="base-text-">颁发荣誉证书</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="contest-demand">
            <div class="title flex-row-center animation fadeInUp" style="margin-bottom: 60px;">
                <span class="line" style="background: rgb(51, 51, 51);"></span>
                <h1 style="color: rgb(51, 51, 51);">作品要求</h1>
                <span class="line" style="background: rgb(51, 51, 51);"></span>
            </div>
            <div class="sub-title flex-column-center animation fadeInUp">
                      <div class="flex-row-center">
                        <span class="dot-triangle"></span>
                        <h2 style="color: rgb(68, 68, 68);">作品类型</h2>
                        <span class="dot-diamond"></span>
                    </div>
                      <div class="text">
                          <p></p>
                      </div>
                    <div class="sub-text"></div>
            </div>
            <ul class="content1 flex-row-center">
                <li class="content-item flex-column-center animation fadeInUp" style="animation-delay: 0s;">
                    <div class="icon-type icon-type-1">
                        <i></i>
                    </div>
                    <p class="title">互动艺术</p>
                    <p class="base-text desc" style="width: 247px;">引入绘画、录音、摄影等多媒体手段，用新 媒体互动手法实现音乐、美术方面的创意展示。</p>
                </li>
                <li class="content-item flex-column-center animation fadeInUp" style="animation-delay: 0.2s;">
                    <div class="icon-type icon-type-2">
                        <i></i>
                    </div>
                    <p class="title">互动游戏</p>
                    <p class="base-text desc" style="width: 247px;">各种竞技类、探险类、角色扮演类、球类、 棋牌类游戏等等。</p>
                </li>
                <li class="content-item flex-column-center animation fadeInUp" style="animation-delay: 0.4s;">
                    <div class="icon-type icon-type-3">
                        <i></i>
                    </div>
                    <p class="title">实用工具</p>
                    <p class="base-text desc" style="width: 247px;">有实用价值、能解决学习生活中的实际问题的程序工具。 </p>
                </li>
                <li class="content-item flex-column-center animation fadeInUp" style="animation-delay: 0.6s;">
                    <div class="icon-type icon-type-4">
                        <i></i>
                    </div>
                    <p class="title">科学探索</p>
                    <p class="base-text desc" style="width: 247px;">现实模拟、数学研究、科学实验等等各学科的趣味性展示与探究。</p>
                </li>
            </ul>
            <div class="sub-title flex-column-center animation fadeInUp" style="animation-delay: 0.8s;">
            <div class="flex-row-center">
                <span class="dot-triangle"></span>
                <h2 style="color: rgb(68, 68, 68);">作品要求</h2>
                <span class="dot-diamond"></span>
            </div>
            <div class="text">
                <p>参赛作品的著作权归作者所有，使用权由作者与主办单 位共享，主办单位有权出版、展示、宣传参赛作品。</p>
                </div>                
            <div class="sub-text"></div>
            </div>
            <ul class="grid-content flex">
                <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">作品原创</p>
                        <p class="sub-text">作品必须为作者原创，无版权争议。若发现涉嫌抄袭或侵犯他人著作</p>
                        <p class="sub-text">权的行为，一律取消评奖资格。如涉及作品原创问题的版权纠纷，由</p>
                        <p class="sub-text">申报者承担责任。</p>
                    </div>
                </li>
                        <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">构思设计</p>
                        <p class="sub-text">作品构思完整，内容主题清晰，有始有终；创意来源于学习与生活，</p>
                        <p class="sub-text">积极健康，反映青少年的年龄心智特点和玩乐思维。</p>
                    </div>
                </li>
                        <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">用户体验</p>
                        <p class="sub-text">观看或操作流程简易，无复杂、多余步骤；人机交互顺畅，用户体验</p>
                        <p class="sub-text">良好。</p>
                    </div>
                </li>
                        <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">''
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">艺术审美</p>
                        <p class="sub-text">界面美观、布局合理，给人以审美愉悦和审美享受；角色造型生动丰</p>
                        <p class="sub-text">富，动画动效协调自然，音乐音效使用恰到好处；运用的素材有实际</p>
                        <p class="sub-text">意义，充分表现主题。</p>
                    </div>
                </li>
                        <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">程序技术</p>
                        <p class="sub-text">合理正确地使用编程技术，程序运行稳定、流畅、高效，无明显错</p>
                        <p class="sub-text">误；程序结构划分合理，代码编写规范，清晰易读；通过多元、合理</p>
                        <p class="sub-text">的算法解决复杂的计算问题，实现程序的丰富效果。</p>
                    </div>
                </li>
                        <li class="grid-item flex animation fadeInUp" style="animation-delay: 1.2s;">
                    <div class="icon-require icon-require-1">
                        <i></i>
                    </div>
                    <div class="grid-desc">
                        <p class="title">创新创造</p>
                        <p class="sub-text">作品主题鲜明，创意独特，表达形式新颖，构思巧妙，充分发挥想象力。</p>
                    </div>
                </li>
            </ul>
            <div class="sub-title flex-column-center animation fadeInUp" style="animation-delay: 1.5s;">
                <div class="flex-row-center">
                    <span class="dot-triangle"></span>
                    <h2 style="color: rgb(68, 68, 68);">申报文件</h2>
                    <span class="dot-diamond"></span>
                </div>
                <div class="text"></div>
                <div class="sub-text"></div>
            </div>
            <div class="text-content animation fadeInUp" style="animation-delay: 1.8s;">
                <h4>1.在线创作提交Scratch 3.0作品。</h4>
                <h4>2.作品说明文档。在线申报时填写相关作品说明，包括：</h4>
                <p>（1）明确的主题，作品的设计目标，包括：功能需求、探究目的或待解决的问题，作品本身要体现出对目标的响应，能够展现主题内涵、实现功能需求、总结探究结论或解决问题。如果作品目标描述不清晰、或作品未能体现出对目标的完成，则不应获得更多分数。</p>
                <p>（2）编程思维与技巧。选手需为角色、场景等主要应用元素绘制流程、逻辑和功能图，如使用特殊的编程技巧或计算方法也需单独详细说明。</p>
                <p>（3）素材原创与引用要求。如果选手使用了非原创的图形、图片、音频素材，需明确标注引用来源或创作者，标注明确才属于合格作品。同时鼓励创作和使用原创素材，可以考虑给予原创素材适当加分。</p>
                <p>（4）拍摄作品阐述视频。内容包括创作思路、过程等，拍摄时长控制在1分半钟（90秒）以内，格式为MP4。</p>
            </div>
        </div>
    </div>       
</template>

<script>
export default {
    data(){
        return{
            at1: true,
            at2: false,
            at3: false,
            at4: false,
        };
    },
    methods:{
        tab(number){
            if(number==1){
            this.at1=true
            this.at2=false
            this.at3=false
            this.at4=false
            }else if(number==2){
            this.at1=false
            this.at2=true
            this.at3=false
            this.at4=false
            }else if(number==3){
            this.at1=false
            this.at2=false
            this.at3=true
            this.at4=false
            }else if(number==4){
            this.at1=false
            this.at2=false
            this.at3=false
            this.at4=true
            }
        },
         match(){
             this.$router.push('/match')
             },
    }
}
</script>

<style scoped>
@import '../../assets/css/homepage.css';
</style>