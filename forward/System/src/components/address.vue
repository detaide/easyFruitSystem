<template>
  <div class="address_body">
        <div class="title">
            <span style="font-size:20px;margin-right:30px">当前使用地址：</span>
            <span>{{current_address}}</span>
        </div>
  </div>

  <div class="address_table" style="margin-top:40px">
        <el-table :data="useraddress.slice((currentPage-1)*pageSize,currentPage*pageSize)" stripe style="width: 90%">
        <el-table-column prop="id" label="地址ID" width="180" />
        <el-table-column prop="address" label="地址" />
        <el-table-column prop="" label="选项">
            <template v-slot="scoped">
                <div>
                    <el-button type="primary" style="margin-left: 30px;" @click="selectHandler(scoped.row)">选择</el-button>
                    <el-button type="danger" style="margin-left: 30px;" @click="deleteHandler(scoped.row)">删除</el-button>
                </div>
            </template>
            
        </el-table-column>
  </el-table>
  </div>
  <el-pagination  background layout="prev, pager, next" :page-count="list_count" style="margin:20px 0 0 300px" v-model:current-page="currentPage" />

  <div class="address_add" style="margin-top:40px;">
    <span>添加地址请在基础信息中修改，本页面不开放修改</span>

  </div>
</template>

<script>

import {useUserStore} from '../store/user.js'
import {useGlobal} from '../store/global.js'
import { storeToRefs } from 'pinia'
import {computed,ref} from 'vue'

export default {
    setup(){
        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const useraddress = userInfo.user_address

        const currentPage = ref(1)
        const pageSize = 6

        let list_count = computed(()=>{
            // 分页，每页8个
            return Math.ceil(useraddress.value.length / pageSize)
        })


        function selectHandler(scoped){
            store.selectAddress(scoped.id,userInfo.userAccount.value.username)
            // console.log(scoped.id)
        }

        function deleteHandler(scoped){
            store.deleteAddress(scoped.id)
        }


        
    return{
        useraddress,
        currentPage,
        list_count,
        pageSize,

        selectHandler,
        deleteHandler
    }
    },
    computed:{
        current_address(){
             return this.useraddress.filter((item)=>{
                return item.status == 1
            })[0].address

            
        }
    }
}


</script>

<style>
.title,.address_add{
    text-align: left;
}



</style>