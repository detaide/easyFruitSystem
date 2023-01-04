<template>
    <div class="center">
        <el-row class="mb-4">
            <el-button type="primary" @click="jump">用户信息</el-button>
            <el-button type="primary" @click="jump2">主页</el-button>
        </el-row>
    </div>
   
</template>

<script>
import {useRouter} from 'vue-router'
export default {

    

    setup(){
        const router = useRouter()

        function jump(){           
            router.push('info')
        }

        function jump2(){
            router.push('main')
        }

        return{
            jump,
            jump2
        }
    }

    

}
</script>

<style scoped>

    .center{
        height: 300px;
        width: 300px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
    }

</style>