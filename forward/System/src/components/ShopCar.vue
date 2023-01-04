<template>

  <div class="shopCar_body">
    <div class="top_info">
        <span style="font-size:40px;color: rgb(117, 117, 117);">我的购物车</span>
        <span style="font-size:3px;">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算，<a href="">了解更多>></a></span>
    </div>

    <div class="cart-wrap">
        <div class="table">
            
            <el-table :data="list"  style="width: 100%"  @selection-change="HandlerSelect">
                <el-table-column type="selection" width="55" />
                <el-table-column prop="goodsName" label="商品名称" width="180" />
                <el-table-column prop="" label="商品描述">
                    <template v-slot='btn'>
                        <div>
                            <el-button type="primary" style="margin-left: 2px;" @click="active(btn.$index)" >查看详情</el-button>
                        </div>
                    </template>
                    
                </el-table-column>
                <el-table-column prop="goodsCount" label="商品数量" />
                <el-table-column prop="goodsMonovelent" label="商品单价" width="180" />
                <el-table-column prop="" label="总价" ref="moneys">
                    <template v-slot='total'>
                        {{get_total(total.row)}}
                    </template>
                    
                </el-table-column>
                <el-table-column prop="" label="操作" >
                    <template v-slot="scoped">
                        <div>
                            <el-button type="danger" style="margin-left: 2px;"  @click="deleteHandler(scoped.row)">删除</el-button>
                        </div>
                    </template>
                    
                </el-table-column>>
            </el-table>
        </div> 

        <!-- <el-pagination  background layout="prev, pager, next" :page-count="list_count" style="margin:20px 0 0 400px" v-model:current-page="currentPage" /> -->
        
        <el-divider/>
        <div class="Computed">
            <div class="left_title">
                <span style="margin-left:20px">已选择 <span style="font-size:26px;color:red;">{{selected_num}}</span> 件</span>
            </div>
            <div class="right_car">
                <span>
                    合计： <span style="font-size:24px;color:rgb(255, 103, 0)">{{total_money}}</span> 元
                </span>
                <button id="shop_btn" @click="pay = true">结 算</button>
            </div>
           
        </div>
        <!-- {{multiSelection}} -->


        
    </div>
  </div>

    <el-dialog v-model="dialogactive" title="商品详情">
                <el-image
                    style="width: 100px; height: 100px"
                    :src="goods_img + list[index].goodsName + '.jpg'"
                    fit="cover" 
                />

                <div class="content" style="margin:30px;">
                    <span id="goods_emit" style="display:block;">商品简介</span>
                    <span style="margin-top:30px;display:block;">{{list[index].goodsContext}}</span>
                </div>

        
    </el-dialog>

    <el-dialog v-model="pay" title="支付页面">
                <el-image
                    style="width: 250px; height: 250px"
                    fit="cover" 
                    src="/src/assets/Image/index_img/pay.jpg"
                />
                <br>

                <el-button type="primary" style="margin-left: 2px;" @click="submit" >购买</el-button>

                


        
    </el-dialog>

</template>

<script>

import {ref,computed, watch} from 'vue'

import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
import { ElMessage } from 'element-plus'

export default {

    setup(){
        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const list = userInfo.shopCar

       

        const dialogactive = ref(false)
        const pay = ref(false)
        const index = ref(null)
        const context = ref(null)
        const total_money = ref(0)

        const multiSelection = ref([])

        const goods_img = "/src/assets/Image/goods_img/"

        const currentPage = ref(1)
        const pageSize = 5
        // let list_count = computed(()=>{
        //     // 分页，每页8个
            
        //     return Math.ceil(list.value.length / pageSize)
        // })

        function active(btn_index){
            context.value = list.value[btn_index].describe
            dialogactive.value = true
            index.value = btn_index   
                
        }

        const selected_num = ref(0)

        // function selected_num(){
        //     // return multiSelection.value.length
        //     // return 123
        // }



        function change(){
            dialogactive.value = false
            list.value[index.value].describe = context.value
        }


        function deleteHandler(scoped){
            // console.log(userInfo.userAccount.value.username)
            store.deleteShopOne(scoped.goodsName,userInfo.userAccount.value.username)
        }

        function get_total(goods){
            // console.log(goods.goodsMonovelent,goods.count)

            return (goods.goodsCount * goods.goodsMonovelent).toFixed(2);
            
            
        }


        // 选中时变更总价格
        function HandlerSelect(selection){
            total_money.value = 0
            // multiSelection.value = selection
            console.log(selection.length)
            multiSelection.value = selection
            selected_num.value = selection.length
            selection.map(item =>{total_money.value = (Number(total_money.value) +  Number(item.goodsMonovelent)*Number(item.goodsCount)).toFixed(2)})
        }

        function submit(){
            // console.log(multiSelection.value)
            var detail = ''
            var listOrderInfo = {}
            const list = []
            if(multiSelection.value.length <=0){
                ElMessage.error("未选择商品")
                pay.value = false
                return
            }

            multiSelection.value.forEach(item=>{
                detail = detail + item.goodsName + '*' + item.goodsCount  +','
                list.push(item.goodsName)
            })

            var timeOrders = getTImeOrder()

            listOrderInfo.id = timeOrders
            listOrderInfo.username = userInfo.userAccount.value.username
            listOrderInfo.status = 1
            listOrderInfo.detail = detail
            listOrderInfo.money = total_money.value

            list.forEach(item=>{
                store.deleteShopOne(item,listOrderInfo.username)
            })


            pay.value = false
            store.addOrders(listOrderInfo)


            
        }

        function getTImeOrder(){
            var time = ''
            var date = new Date()
            time += date.getFullYear()
            time += (date.getMonth() + 1) < 10 ? ('0' + (date.getMonth() + 1)) : (date.getMonth()+1)
            time += date.getDate() < 10 ? ('0' + date.getDate()) : date.getDate()
            time += date.getHours() < 10? ('0' + date.getHours()) : date.getHours()
            time += date.getMinutes() < 10? ('0' + date.getMinutes()) : date.getMinutes()
            time += date.getSeconds() < 10? ('0' + date.getSeconds()) : date.getSeconds()
            return time
        }

        // function payment(){

        // }





        return{
            list,
            // lists,
            dialogactive,
            pay,
            index,
            goods_img,
            context,
            total_money,
            // list_count,  
            currentPage,
            pageSize,
            selected_num,

            active,
            change,
            get_total,
            HandlerSelect,
            deleteHandler,
            multiSelection,
            submit
        }
    },

    computed:{

    }
    

}
</script>

<style>

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

.top_info a:first-child{
    border: none;
}

.el-pagination{
    margin-top: 20px;
    margin-left: 300px;
   
}

.Computed{
    width: 89%;
    height: 60px;
    margin-top: 20px;
    margin-left: 20px;
    border: 2px solid rgb(255, 103, 0);
    display: flex;
    position: relative;
}

.Computed div{
    line-height: 60px;
}

.Computed span{
    color: rgb(117, 117, 117);
    font-size: 15px;
}



.right_car{
    /* float:right; */
    position: absolute;
    right: -2px;
    
}

.right_car span{
    color: rgb(255, 103, 0);
}

#shop_btn{
    margin-left: 20px;
    height: 62px;
    border: none;
    background: rgb(255, 103, 0);
    width: 200px;
    padding-top: -10px;
    color: #fff;
    font-size: 24px;
    line-height: 50px;

}


</style>