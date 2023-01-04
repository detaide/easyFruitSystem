<template>
   
  <div class="top_body" >
        <div class="left">
            <nav>
                <!-- <a href="">首页</a> -->
                <router-link :to="{name:'home'}">首页</router-link>
                <a href="#推荐" style="transition: 0.5s;">推荐</a>
                <a href="#柑橘橙柚柠">柑橘橙柚柠</a>
                <a href="#葡提浆果">葡提浆果</a>
                <a href="#热带水果">热带水果</a>
                <a href="#苹果香蕉梨">苹果香蕉梨</a>
                <a href="#桃李杏枣">桃李杏枣</a>
                <a href="#西瓜 /蜜瓜">西瓜 /蜜瓜</a>
                <a href="#车厘子/草莓">车厘子/草莓</a>
                
                


            </nav>
        </div>  
        <div class="right">
             <nav>
                
                <router-link :to="{name:'serMsg'}" v-show="globaldata.isLogin" >我的主页</router-link>
                <router-link :to="{name:'login'}" v-show="!globaldata.isLogin" >登陆</router-link>
                <!-- <a href="" v-show="globaldata.isLogin" :to={name:''}>消息</a> -->
                <router-link  :to="{name:'UserBaseInfo'}" v-show="globaldata.isLogin">消息</router-link>
                <a href="" v-show="globaldata.isLogin" @click="exit">退出</a>
            </nav>
        </div>
        
 </div>


</template>

<script>
import {onMounted} from 'vue'

import {useGlobal} from '../store/global.js'
// import { storeToRefs } from 'pinia'
import {useRouter} from 'vue-router'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'


export default {
    setup(){
        const globalStore = useGlobal()
        const global = storeToRefs(globalStore)
        // const globaldata = global.globalObject
        const store = useUserStore()
        const globaldata = store.$state.global_status

        // console.log(globaldata)

        const router = useRouter()

        function exit(){
            // globaldata.value.isLogin = false
            globaldata.isLogin = false
            window.localStorage.clear()
            router.replace({name:'main'})
        }

        return{
            globaldata,
            exit
        }
    }
}
</script>



<style scoped>

.top_body{
    width: 100%;
    height: 30px;
    /* background: rgb(83, 92, 100); */
    background: #333;
    color: rgb(153, 153, 153);
    /* color: #fff; */
    text-align: center;
    line-height: 30px;
    
}

nav a{
    /* color: #fff; */
    color: rgb(176, 176, 176);
    text-decoration: none;
    border-right: 1px solid rgb(66, 66, 66);
    margin-right: 20px;
    padding-right: 20px;
    font-size: 14px;
    /* color: rgb(255, 255, 255); */
}

.left{
    float: left;
    margin-left: 60px;
    
}

.right{
    float: right;
}


.left a{
    margin-right: 30px;
    padding-right: 30px;

}


</style>
