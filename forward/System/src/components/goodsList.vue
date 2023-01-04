<template>
  <el-table :data="list.slice((currentPage-1)*pageSize,currentPage*pageSize)" stripe style="width: 100%">
    <el-table-column prop="goodsId" label="商品ID" width="180" />
    <el-table-column prop="goodsName" label="商品名称" width="180" />
    <el-table-column prop="" label="商品描述">
        <template v-slot='btn'>
            <div>
                <el-button type="primary" style="margin-left: 2px;" @click="active(btn.$index)" >查看详情</el-button>
            </div>
        </template>
        
    </el-table-column>
    <el-table-column prop="goodsCount" label="商品数量" />
    <el-table-column prop="goodsMonovelent" label="商品价格" />
    <el-table-column prop="price" label="操作" >
        <template v-slot='btn2'>
            <div>
                <el-button type="primary" style="margin-left: 2px;"  @click="changeHandler(btn2.$index)">修改</el-button>
                <el-button type="danger" style="margin-left: 2px;"  @click="Deletehangler(btn2.row)">删除</el-button>
            </div>
        </template>
        
    </el-table-column>
    
  </el-table>
  <el-pagination  background layout="prev, pager, next" :page-count="list_count" style="margin:20px 0 0 300px" v-model:current-page="currentPage" />

    <el-dialog v-model="dialogactive" title="商品详情" :before-close="unchange">
                <el-image
                    style="width: 100px; height: 100px"
                    :src="goods_img + list[index + pageSize*(currentPage-1)].goodsName + '.jpg'"
                    fit="cover" 
                />
                <el-upload
                    class="upload-demo"
                    action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                    style="margin-bottom:20px"
                    :auto-upload="false"
                    :on-change="checkType"
                    :file-list="fileList"
                >
                    <el-button type="primary" style="margin-left:-10px; margin-top:5px">更换</el-button>
                    <template #tip>
                    </template>
                </el-upload>
                <span>产地：</span><el-input  placeholder="产地" style="width:200px" v-model="list[index+ pageSize*(currentPage-1)].goodsLocation" /> 

                <div class="content" style="margin:30px;">
                    <div id="goods_emit">商品分类</div>
                    <div><el-select v-model="list[index+ pageSize*(currentPage-1)].goodsClass" :placeholder="list[index+ pageSize*(currentPage-1)].goodsClass">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                        :disabled="item.disabled"
                        />
                    </el-select></div>
                    <span id="goods_emit">商品简介</span>
                    <el-input v-model="list[index+ pageSize*(currentPage-1)].goodsContext" type="textarea" rows="3"/>
                </div>
                

                <el-button type="primary" style="margin: 4px;" @click="goodsChange()">修改</el-button>
                <el-button type="primary" style="margin: 4px;" @click="unchange()">取消</el-button>
        
    </el-dialog>

    <el-dialog v-model="dialogMsg" title="商品详情" :before-close="unchange">
        <el-form
            label-width="100px"
            style="max-width: 460px"
            :model="list[index]"
        >
            <el-form-item label="商品名称">
                <el-input  v-model="list[index+ pageSize*(currentPage-1)].goodsName"/>
            </el-form-item>
            <el-form-item label="商品数量">
                <el-input  v-model="list[index+ pageSize*(currentPage-1)].goodsCount"/>
            </el-form-item>
            <el-form-item label="商品价格">
                <el-input  v-model="list[index+ pageSize*(currentPage-1)].goodsMonovelent"/>
            </el-form-item>
            
        </el-form>

                
        <el-button type="primary" style="margin: 4px;" @click="goodsChange()">修改</el-button>
        <el-button type="primary" style="margin: 4px;" @click="unchange()">取消</el-button>
        
    </el-dialog>


</template>

    


<script>
import {computed, onMounted, ref} from 'vue'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'

export default {

    setup(){
        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const list = userInfo.goods_list
        

        const dialogactive = ref(false)
        const dialogMsg = ref(false)
        const index = ref(null)
        const currentPage = ref(1)
        const pageSize = 8
        const fileList=ref([])

        const options = ref(
            [
                {
                    value: '推荐',
                },
                {
                    value: '柑橘橙柚柠',
                },
                {
                    value: '葡提浆果',
                },
                {
                    value: '热带水果',
                },
                {
                    value: '苹果香蕉梨',
                },
                 {
                    value: '桃李杏枣',
                },
                 {
                    value: '西瓜 /蜜瓜',
                },
                {
                    value: '车厘子/草莓',
                },
                
            ]
        )
        
        const goods_img = "/src/assets/Image/goods_img/"


        function active(btn_index){
            dialogactive.value = true
            index.value = btn_index           
        }

        function change(){
            dialogactive.value = false
            list.value[index.value].describe = context.value
        }


        function unchange(){
            dialogactive.value = false
            dialogMsg.value = false
            store.getGoodsInfo()
            
        }

        function changeHandler(btn_index){
            dialogMsg.value = true
            index.value = btn_index
        }

        let list_count = computed(()=>{
            // 分页，每页8个
            return Math.ceil(list.value.length / pageSize)
        })

        function goodsChange(){
            store.goodChange(list.value[index.value+pageSize*(currentPage.value-1)])
            console.log(list.value[index.value+pageSize*(currentPage.value-1)])
            dialogactive.value = false
            dialogMsg.value = false
        }

        function Deletehangler(msg){
            store.goodDelete(msg.goodsId)
        }

        function checkType(file){
            // console.log(file.raw)
            let fileType = file.name.substring(file.name.lastIndexOf('.') + 1)
            if(fileType != 'jpg'){
                ElMessage.error("文件格式错误,仅支持jpg格式")
                fileList.value = []
                return false;
            }
            // let headImg = URL.createObjectURL(file.raw)
            let formatData = new FormData()
            formatData.append('file',file.raw)
            // console.log(list.value[index.value + pageSize*(currentPage.value-1)].goodsName)
            store.fileUpload("fruit",formatData,list.value[index.value + pageSize*(currentPage.value-1)].goodsName)
            fileList.value = []
            
        }




        return{
            list,
            dialogactive,
            index,
            goods_img,
            options,
            dialogMsg,
            list_count,
            currentPage,
            pageSize,
            fileList,

            active,
            change,
            unchange,
            changeHandler,
            close,
            goodsChange,
            Deletehangler,
            checkType

        }
    },

    


}
</script>

<style scoped>


.upload-demo{
    text-align: center;
    margin-left: 10px;
}

#goods_emit{
    display: block;
    margin-bottom: 20px;
    font-size: 18px;
}



</style>