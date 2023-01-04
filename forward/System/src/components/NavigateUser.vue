<template>

    <div class="navigate_left">
        <el-row class="tac"> 
            <el-col :span="23">
                    <div class="mb-2">
                        <el-avatar size="large" id="user_img" :src="'/src/assets/Image/headImg/' + userdata.username + '.jpg'" />
                        <div id="emit_info">
                            <span>{{userMsg.userId}}</span>
                        </div>      
                    </div>        
            <el-menu 
                active-text-color="#ffd04b"
                background-color="#545c64"
                class="el-menu-vertical-demo"
                default-active="1"
                text-color="#fff"
                :default-openeds="openeds"
                
            >
                <el-menu-item index="5" v-show="globaldata.isRoot">
                <!-- <el-icon><document /></el-icon> -->
                <span @click="jump('root')">管理员模式</span>
                </el-menu-item>

                <el-sub-menu index="1">
                    <template #title>
                        <!-- <el-icon><location /></el-icon> -->
                        <span>个人信息</span>
                    </template>
                    <el-menu-item index="1-1" @click="jump('UserBaseInfo')">基础信息</el-menu-item>
                    <el-menu-item index="1-2" @click="jump('address')">地址管理</el-menu-item>
                    <el-menu-item index="1-3">我的余额</el-menu-item>

                </el-sub-menu>

            <el-sub-menu index="2">
                <template #title>
                    <!-- <el-icon><location /></el-icon> -->
                    <span>订单信息</span>
                </template>
                    <el-menu-item index="2-1" @click="jump('finish')">已完成订单</el-menu-item>
                    <el-menu-item index="2-2" @click="jump('unfinish')">未完成订单</el-menu-item>
                    <el-menu-item index="2-3" @click="jump('allOrders')">历史订单</el-menu-item>         
                </el-sub-menu>
                
                <el-menu-item index="3" >
                <!-- <el-icon><document /></el-icon> -->
                <span @click="jump('favorate')">我的购物车</span>
                </el-menu-item>
                <el-menu-item index="4">
                <!-- <el-icon><setting /></el-icon> -->
                <span>消息</span>
                </el-menu-item>
            </el-menu>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import {onMounted, ref} from 'vue'

import {useRouter} from 'vue-router'
import axios from 'axios'

import {useUserStore} from '../store/user.js'
import {useGlobal} from '../store/global.js'
import { storeToRefs } from 'pinia'


export default {

    setup(){

            const router = useRouter()

            const openeds = ['1','2']

            const store = useUserStore()
            const userInfo = storeToRefs(store)
            const userMsg = userInfo.userBaseInfo
            const userdata = userInfo.userAccount

            const globalStore = useGlobal()
            const global = storeToRefs(globalStore)
            // const globaldata = global.globalObject
            const globaldata = store.$state.global_status

            function jump(addr_name){
                // if(addr_name == 'unfinish')
                //     store.getOrders('unpay')
                // if(addr_name == 'finish')
                //     store.getOrders('pay')
                // else store.getOrders()
                router.replace(
                    {
                        name:addr_name,
                        
                    }
                )
            }

            


            return{
                router,
                openeds,
                userMsg,
                jump,
                globaldata,
                userdata
            }
        }


}
</script>

<style scoped>
.mb-2{
        background-color: rgb(84, 92, 100);
        width: 99.7%;
        font-size: 16px;
        color: rgb(255,208,75);
        display: flex;
        flex-direction: row;
        text-align: center;
        height: 80px;
        line-height: 80px;
}


.navigate_left{
    margin-left: 20px;
}

#user_img{
    margin-top: 10px;
    margin-left: 30px;
    margin-right: 10px;
}



</style>