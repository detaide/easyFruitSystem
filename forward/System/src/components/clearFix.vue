<template>
  <div style="display:flex;">
    <template v-for="(item) in goods_list" :key="item.goodsClass">

      <div v-if="item.goodsClass == classfy">
         <goods-show :name="item.goodsName" :price="item.goodsMonovelent"/>
      </div>
    </template>
    
        
  </div>
</template>

<script>
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
import goodsShow from '../components/goodsShow.vue'
export default {

    components:{
        goodsShow,
    },
    props:[
      "classfy"
    ],

    setup(props){
      const store = useUserStore()
      const userInfo = storeToRefs(store)
      const goods_list = userInfo.goods_list


      return{
        goods_list
      }
    }

}
</script>

<style>

</style>