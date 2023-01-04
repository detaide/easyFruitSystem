<template>
  <div class="top_navi">
        <el-menu
            class="el-menu-demo"
            mode="horizontal"
        >
            <el-menu-item index="1" @click="jump('userList')">用户详情</el-menu-item>
            <el-menu-item index="2" @click="jump('orderList')">订单详情</el-menu-item>
            <el-menu-item index="3" @click="jump('stockManager')">进货管理</el-menu-item>
            <el-menu-item index="4" @click="jump('goodsList')">商品信息</el-menu-item>
        </el-menu>
  </div>
    <div>
        <router-view/>
    </div>

</template>

<script>
import { onMounted } from '@vue/runtime-core'
import {useRouter} from 'vue-router'
export default {

    setup(){

        

        const router = useRouter()
         function jump(addr_name){
            router.replace({name:addr_name})
        }

        return{
            jump
        }
    },


}
</script>

<style>

</style>