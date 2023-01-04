<template>

     <div class="common-layout">
        <el-container>
            <el-header>
                <top-navi-user/>
            </el-header>
            <div class="divide"></div>
            <el-main>
                <div class="common-layout-mid">
                    <el-container>
                    <el-aside>
                        <navigateleft/>
                    </el-aside>
                    <el-main class="use_info">
                        <router-view ></router-view>
                    </el-main>
                    </el-container>
                </div>
            </el-main>
            <!-- <el-footer>Footer</el-footer> -->
        </el-container>
  </div>

</template>

<script>
import {onMounted, ref} from 'vue'

import {useRouter} from 'vue-router'
import navigateleft from '../components/NavigateUser.vue'
import TopNaviUser from '../components/TopNavigate.vue'
import {useUserStore} from '../store/user.js'


    export default {

        components:{
            navigateleft,
            TopNaviUser,
        },

       
        setup(){
        }

    }


</script>

    

<style scoped>

    


    .el-header{
        margin-left: 20px;
        height: 30px;
    }

    .el-main{
        padding: 0px;
        margin-left: 20px;
    }

    .use_info{
        margin: 0 auto;
        margin-top: 60px;
        margin-left: 20px;
    }

    .divide{
        margin-left: 40px;
        width: 96%;
        height: 80px;
        background: rgb(83, 83, 196);
        margin-top: 2px;
        margin-bottom: 2px;
    }

    .right_msg{
        margin: 0 auto;
    }

    
    


</style>