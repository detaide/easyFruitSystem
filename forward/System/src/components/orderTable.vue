<template>
  <div>
    
        <el-table
            ref="multipleTableRef"
            :data="userorder.slice((currentPage-1)*pageSize,currentPage*pageSize)"
            style="width: 90%;margin:20px;"
        >
            <el-table-column type="selection" width="55"/>
            <el-table-column label="订单ID" property="id" width="160"/>
            <el-table-column property="status" label="状态" width="140" >
              
              <template v-slot=scope>
                <div v-if="scope.row.status ==1">已支付</div>
                <div v-if="scope.row.status == 0">未支付</div>
              </template>
              
            </el-table-column>
            <el-table-column property="detail" label="订单详情" />
            <el-table-column property="time" label="订单时间" />
            <el-table-column property="money" label="支付金额" />
            <el-table-column property="username" label="用户" v-if="global_status.orderName" />
            
            <el-table-column  label="选项">
              <template v-slot="btn">
                <div>
                  <el-button type="danger" style="margin-left: 30px;" @click="orderDelete(btn.row)">删除</el-button>
                </div>
              </template>
                
            </el-table-column>
            
        </el-table>
            <el-pagination  background layout="prev, pager, next" :page-count="list_count" style="margin:20px 0 0 400px" v-model:current-page="currentPage" />
    </div>
</template>

<script>
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
import {useRoute} from 'vue-router'

import {ref,computed} from 'vue'

export default {
  name:'orderTable',
  setup(){
    const store = useUserStore()
    const userInfo = storeToRefs(store)
    const userorder = userInfo.orders_list
    const global_status = userInfo.global_status

    const router = useRoute()
    const currentPage = ref(1)
    const pageSize = 5
    let list_count = computed(()=>{
        // 分页，每页8个
        return Math.ceil(userorder.value.length / pageSize)
    })


    function orderDelete(usermsg){
      store.deleteOrder(usermsg.id)
    }



    return{
      userorder,
      global_status,
      currentPage,
      list_count,
      pageSize,

      orderDelete,
    }



  }
}
</script>

<style scoped>
.el-pagination{
    margin-left:20%;
}
</style>