<template>
    <div>
        <div class="stock" style="text-align:left;">
        <el-button type="primary" style="margin-left: 2px;margin:20px;" @click="dialogactive = true">进货</el-button>
    </div>

   <el-table :data="stock_list.slice((currentPage-1)*pageSize,currentPage*pageSize)"  stripe style="width: 100%">
    <el-table-column prop="stockId" label="进货ID" width="180" />
    <el-table-column prop="goodsName" label="商品名称" width="180" />
    <el-table-column prop="stockTime" label="进货时间" />
    <el-table-column prop="stockCount" label="进货数量" />
  </el-table>
  <el-pagination  background layout="prev, pager, next" :page-count="list_count" style="margin:20px 0 0 300px" v-model:current-page="currentPage" />

  <el-dialog v-model="dialogactive" title="进货管理">
        <el-form
            label-width="100px"
            :model="new_goods"
            style="max-width: 460px"
        >
            <el-form-item label="商品名称">
            <el-input  v-model="new_goods.name"/>
            </el-form-item>
            <el-form-item label="进货数量">
            <el-input  v-model="new_goods.count"/>
            </el-form-item>
        </el-form>
        <el-button type="primary" style="margin-left: 2px;margin:20px;" @click="stock_new()">进货</el-button>
        <el-button type="primary" style="margin-left: 2px;margin:20px;" @click="dialogactive = false">取消</el-button>
    </el-dialog>
    </div>
    

</template>

<script>
import {ref, toRaw , computed} from 'vue'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'

export default {

    setup(){

        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const stock_list = userInfo.stock_list

        const currentPage = ref(1)
        const pageSize = 8

        let list_count = computed(()=>{
            // 分页，每页8个
            return Math.ceil(stock_list.value.length / pageSize)
        })
        

        const new_goods = ref({
            id:'',
            name:'',
            time:'',
            count:''
        })

        const dialogactive = ref(false)


        function stock_new(){
            // console.log(toRaw(new_goods.value))
            // stock.value.push(new_goods.value)
            store.addStock(new_goods.value.name,new_goods.value.count)


            dialogactive.value = false
        }

        return{
            new_goods,
            dialogactive,
            stock_list,
            currentPage,
            pageSize,
            list_count,

            stock_new
        }
    }

}
</script>

<style>

</style>