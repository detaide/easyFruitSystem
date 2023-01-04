<template>
  <div class="orders_body">
    <div class="top_info">
        <span style="font-size:40px;color: rgb(117, 117, 117);">我的订单</span>
        <span style="font-size:3px;">请谨防钓鱼链接或诈骗电话，<a href="">了解更多>></a></span>
    </div>

    <div class="navigate">
        <div class="navi_left">
             <nav>
                <!-- <a href="">全部订单</a> -->
                <router-link :to="{name:'allOrders'}" replace>全部订单</router-link>
                <router-link :to="{name:'finish'}" replace>已完成</router-link>
                <router-link :to="{name:'unfinish'}" replace>未完成</router-link>
            </nav>
        </div>
       <div class="navi_right">
            <nav>
                <el-input  placeholder="请输入购买过的商品" style="width:200px" v-model="search"/> 
                <el-button type="primary" style="margin-left: 2px;" @click="searchHandler">搜索</el-button>
                <router-view/>
            </nav>
       </div>
    </div>

    

    
  </div>
</template>


<script>
import {ref} from 'vue'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'

export default {
    setup(){
        const search = ref('')

        const store = useUserStore()

        function searchHandler(){
            store.getOrders('search',search.value)
        }

        return{
            search,
            searchHandler
        }
    }
}
</script>




<style scoped>

.navigate{
    width: 1300px;
}


a{
    text-decoration: none;
    color: rgb(117, 117, 117);
    border-right: 1px solid rgb(66, 66, 66);
    margin-right: 20px;
    padding-right: 20px;
}

.top_info{
    margin-bottom: 30px;
    text-align: left;
}

.top_info span{
    margin-right: 20px;
}


.navi_left{
    float: left;
    margin-bottom: 30px;
}

.navi_left a{
    padding-right: 30px;
    font-size: 16px;
    margin-left: 10px;
}

.navi_left a:first-child{
    margin-left: 30px;
}

.navi_left a:last-child{
    border: none;
}



.top_info a:first-child{
    border: none;
}




</style>