<template>
        <div class="science-home">
                <div class="banner">
            <el-carousel :interval="4000" type="card" height="200px">
                <el-carousel-item v-for="item in 6" :key="item">
                    <h3 class="medium">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </div>
        <div class="news">
            <el-carousel height="200px" direction="vertical" :autoplay="false">
                <el-carousel-item v-for="item in 3" :key="item">
                    <h3 class="medium">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </div>
        <div class="home-target">
            <div class="title flex-row-center">
                <span class="line"></span>
                <h1>参赛对象</h1>
                <span class="line"></span>
                </div>
                <p class="summary">全国各地小学、初中、高中(含中等职业学校)在校学生均可以个人或团队方式参加。</p>
            <div class="grade">
                <div><span  class="pic icon-obj icon-obj-1">小学组</span></div>
                <div class="center-marge"><span  class="pic icon-obj icon-obj-1">初中组</span></div>
                <div><span  class="pic icon-obj icon-obj-1">高中组</span></div>
            </div>
        </div>
        <div class="award">
            <div class="title flex-row-center">
                <h1>赛项设置</h1>
            </div>
            <div class="box">
                <div class="content">
                    <div class="flex-row-center">
                    <div class="award-item">
                        <h1>创意编程</h1>
                        <ul class="card flex">
                            <li class="item">
                                <a href="">
                                    <p class="icon icon-scratch"></p>
                                    <p class="sub-text">Scratch创意编程赛项</p>
                                </a>
                            </li>
                                
                        </ul>
                    </div>
                    <div class="award-item">
                        <h1>创意编程</h1>
                        <ul class="card flex">
                            <li class="item">
                                <a href="">
                                    <p class="icon icon-scratch"></p>
                                    <p class="sub-text">Scratch创意编程赛项</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                </div>
            </div>
        </div>
        <div class="prize">
            <div class="title flex-row-center">
                <span class="line"></span>
                <h1>奖项设置</h1>
                <span class="line"></span>
            </div>
            <p class="summary">
                大赛设等次奖、专项奖、优秀指导教师奖、优秀组织单位奖，颁发荣誉证书， 
                <br>
                并择优推荐获奖作品在相关网站、报刊等媒体上播出或刊载。
            </p>
            <div class="wrap">
                <div class="item">
                    <p class="pic">
                        <i class="pic-1"></i>
                    </p>
                    <p class="title">等次奖</p>
                    <p class="info">等次奖包括一、二、三等奖及“优秀奖”。创意编程比赛拟设约1000个等次奖，智能设计比赛拟设约150个等次奖。</p>
                </div>
                <div class="item">
                    <p class="pic">
                        <i class="pic-2"></i>
                    </p>
                    <p class="title">专项奖</p>
                    <p class="info">等次奖包括一、二、三等奖及“优秀奖”。创意编程比赛拟设约1000个等次奖，智能设计比赛拟设约150个等次奖。</p>
                </div>
                <div class="item">
                    <p class="pic">
                        <i class="pic-3"></i>
                    </p>
                    <p class="title">优秀老师执导奖</p>
                    <p class="info">等次奖包括一、二、三等奖及“优秀奖”。创意编程比赛拟设约1000个等次奖，智能设计比赛拟设约150个等次奖。</p>
                </div>
                <div class="item">
                    <p class="pic">
                        <i class="pic-4"></i>
                    </p>
                    <p class="title">优秀组织奖</p>
                    <p class="info">等次奖包括一、二、三等奖及“优秀奖”。创意编程比赛拟设约1000个等次奖，智能设计比赛拟设约150个等次奖。</p>
                </div>
            </div>
        </div>
        <div class="guide"></div>
    </div>
</template>

<style scoped>
@import '../../assets/css/homepage.css';
</style>