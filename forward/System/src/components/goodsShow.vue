<template>
  <div class="list">
        <!-- <el-skeleton-item variant="image" style="width: 240px; height: 240px;" /> -->
        <img :src="'/src/assets/Image/goods_img/' + name + '.jpg'" style="width: 240px; height: 240px;" alt="">
        <div class="msg">
            <div  class="purchase_left">
                <span style="font-size:16px">{{name}}</span>
                <span style="color:red;font-size:20px">￥<span>{{price}}元/500g</span> </span>   
            </div>

            <button id="purchase_btn" @click="addToShop(name)">
                    <el-icon :size="20">
                        <ShoppingCart />
                    </el-icon>
                    
                <div>加入购物车</div>
                
            </button>

  
        </div>
        
  </div>
</template>

<script>
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
import { ElMessage } from 'element-plus'

export default {
    props:[
        "name",
        "price"
    ],

    setup(props) {
        const store = useUserStore()

        
        function addToShop(name){
            console.log("add to shop")
            // console.log(name)
            // console.log(store.$state.userAccount.username)
            if(store.$state.global_status.isLogin == false){
                ElMessage({
                            message: '请先进行登陆',
                            type: 'error',
                        })
            }else
                store.addShop(name,store.$state.userAccount.username)
            
        }

        return{
            addToShop
        }

    }

}
</script>

<style scoped>
    .list{

        background: rgb(255, 255, 255);
        margin-left: 50px;
    }

    .purchase_left{
        text-align: left;
        display: flex;
        flex-direction: column;
        position: absolute;
        left:10px;
        top: 5px;
        
    }


    .purchase_left span{
        font-size: 16px;
    }



    .msg{
        display: flex;
        height: 60px;
        position: relative;
        text-align: center;
        /* border: 1px solid black; */
        /* border-top: none; */
    }

    #purchase_btn{
        position: absolute;
        right: 10px;
        height: 30px;
        bottom:5px;
        border: none;
        background: rgb(255, 103, 0);
        padding-left: 10px;
        padding-right: 10px;
        display: flex;
        padding: 6px;
        cursor: pointer;
    }



</style>