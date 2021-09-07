import Vue from 'vue'
import Router from 'vue-router'
import homepage from '@/components/home/homepage'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',component: homepage},
    {path: '/programming',component: () => import('@/components/programming/programming')},
    {path: '/registration',component: () => import('@/components/match/Registration')},
    {
      path: '/madmin',
      component: () => import(/* webpackChunkName: "home" */ '../components/Madmin/common/Home.vue'),
      meta: { title: '管理员后台' },
      children: [
          {
              path: '/dashboard',
              component: () => import(/* webpackChunkName: "dashboard" */ '../components/Madmin/page/Dashboard.vue'),
              meta: { title: '系统首页' }
          },
          {
              path: '/matchinfo',
              component: () => import(/* webpackChunkName: "table" */ '../components/Madmin/page/matchinfo.vue'),
              meta: { title: '比赛管理' }
          },
          {
            path: '/works',
            name: 'works',
            component: () => import(/* webpackChunkName: "table" */ '../components/Madmin/page/works.vue'),
            meta: { title: '作品展示' }
        },
          {
              path: '/matchnews',
              component: () => import(/* webpackChunkName: "tabs" */ '../components/Madmin/page/matchnews.vue'),
              meta: { title: '新闻管理' }
          },
          {
              path: '/student',
              component: () => import(/* webpackChunkName: "form" */ '../components/Madmin/page/student.vue'),
              meta: { title: '学生用户管理' }
          },
          {
            path: '/teacher',
            component: () => import(/* webpackChunkName: "form" */ '../components/Madmin/page/teacher.vue'),
            meta: { title: '老师用户管理' }
        },
        {
            path: '/judges',
            name: 'judges',
            component: () => import(/* webpackChunkName: "form" */ '../components/Madmin/page/judges.vue'),
            meta: { title: '评委管理' }
        },
        {
            path: '/Administrators',
            component: () => import(/* webpackChunkName: "upload" */ '../components/Madmin/page/Administrators.vue'),
            meta: { title: '管理员管理' }
        },
          {
              path: '/editor',
              component: () => import(/* webpackChunkName: "editor" */ '../components/Madmin/page/VueEditor.vue'),
              meta: { title: '新闻编辑' }
          },
          {
            path: '/notice',
            component: () => import(/* webpackChunkName: "icon" */ '../components/Madmin/page/notice.vue'),
            meta: { title: '通知管理' }
        },
      ]
  },
  {
      path: '/login',
      component: () => import(/* webpackChunkName: "login" */ '../components/Madmin/page/Login.vue'),
      meta: { title: '登录' }
  },
    {
    path: '/Sadmin',
    component: () => import(/* webpackChunkName: "home" */ '../components/Sadmin/common/Home.vue'),
    meta: { title: '学生后台' },
    children: [
        {
            path: '/studashboard',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/Dashboard.vue'),
            meta: { title: '系统首页' }
        },
        {
            path: '/stuinfo',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/Studentinfo.vue'),
            meta: { title: '我的信息' }
        },
        {
            path: '/myworkslist',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/workslist.vue'),
            meta: { title: '作品列表' }
        },
        {
            path: '/myworks',
            name: 'mywork',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/works.vue'),
            meta: { title: '我的作品' }
        },
        {
            path: '/upworks',
            name: 'upworks',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/upworks.vue'),
            meta: { title: '提交作品' }
        },
        {
            path: '/mymatch',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/StudentMatch.vue'),
            meta: { title: '我的比赛' }
        },
        {
            path: '/stunotice',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/Sadmin/page/mynotice.vue'),
            meta: { title: '平台通知' }
        }
    ]},
    {
        path: '/Tadmin',
        component: () => import(/* webpackChunkName: "home" */ '../components/Tadmin/common/Home.vue'),
        meta: { title: '老师后台' },
        children: [
            {
                path: '/tdashboard',
                component: () => import(/* webpackChunkName: "dashboard" */ '../components/Tadmin/page/Dashboard.vue'),
                meta: { title: '系统首页' }
            },
            {
                path: '/teachermatch',
                component: () => import(/* webpackChunkName: "dashboard" */ '../components/Tadmin/page/teachermatch.vue'),
                meta: { title: '评委比赛' }
            },
            {
                path: '/teacherworks',
                name:'teacherworks',
                component: () => import(/* webpackChunkName: "dashboard" */ '../components/Tadmin/page/works.vue'),
                meta: { title: '比赛作品' }
            },
            {
                path: '/teacherscore',
                name:'teacherscore',
                component: () => import(/* webpackChunkName: "dashboard" */ '../components/Tadmin/page/score.vue'),
                meta: { title: '作品评分' }
            },
            {
                path: '/teanotice',
                component: () => import(/* webpackChunkName: "dashboard" */ '../components/Tadmin/page/mynotice.vue'),
                meta: { title: '平台通知' }
            }
    ]}
]


})
