import {createRouter, createWebHistory,createWebHashHistory} from 'vue-router'
import index from '../components/index.vue'
import UserMsg from '../components/UserMsg.vue'
import UserBaseInfo from '../components/UserBaseInfo.vue'

import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'


const routes = [
    {
        path:'/',
        name:'home',
        component:()=>import('../components/main.vue')
    },
    {
        path:'/info',
        name:'serMsg',
        component:UserMsg,
        redirect:{name:'UserBaseInfo'},
        children:[
            {
                path:'UserBaseInfo',
                name:'UserBaseInfo',
                component:UserBaseInfo,
        
            },
            {
                path:'orders',
                name:'Orders',
                component:()=>import('../components/orders.vue'),
                // beforeEnter:(to,from,next)=>{
                //     const store = useUserStore()
                //     store.getOrders()
                //     next()
                // },
                redirect:{name:'finish'},
                children:[
                    {
                        path:'finish',
                        name:'finish',
                        component:()=>import('../components/orderTable.vue'),
                        beforeEnter:(to,from,next) =>{
                            const store = useUserStore()
                            store.getOrders('pay')
                            next()
                        }
                    },
                    {
                        path:'unfinish',
                        name:'unfinish',
                        component:()=>import('../components/orderTable.vue'),
                        beforeEnter: (to, from, next) => {
                            const store = useUserStore()
                            store.getOrders('unpay')
                            next()
                        }
                    },
                    {
                        path:'allOrders',
                        name:'allOrders',
                        component:()=>import('../components/orderTable.vue'),
                        beforeEnter: (to, from, next) => {
                            const store = useUserStore()
                            store.getOrders()
                            next()
                        }
                    }
                ]
            },
            {
                path:'favorate',
                name:'favorate',
                component:()=>import('../components/ShopCar.vue')
            },
            {
                path:'address',
                name:'address',
                component:()=>import('../components/address.vue')
            },
            {
                path:'root',
                name:'root',
                component:()=>import('../components/root.vue'),
                redirect:{name:'userList'},
                children:[
                    {
                        path:'userList',
                        name:'userList',
                        component:()=>import('../components/userTable.vue')
                    },
                    {
                        path:'orderList',
                        name:'orderList',
                        component:()=>import('../components/orderTable.vue'),
                        beforeEnter:(to,from,next) =>{
                            const store = useUserStore()
                            store.getAllOrders()
                            next()
                        }
                    },
                    {
                        path:'stockManager',
                        name:'stockManager',
                        component:()=>import('../components/Stock.vue')
                    },
                    {
                        path:'goodsList',
                        name:'goodsList',
                        component:()=>import('../components/goodsList.vue')
                    }
                ]
            }

        ]
            

    },
    {
        path:'/main',
        name:'main',
        component:()=>import('../components/main.vue')
    },
    {
        path:'/login',
        name:'login',
        component:()=>import('../components/Login.vue')
    }

    
]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router