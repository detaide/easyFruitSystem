<template>
    <div class="center">
        <el-form :model="userdata" label-width="120px">
            <el-form-item label="账号">
                <span>{{userdata.username}}</span>
            </el-form-item>
            <el-form-item label="修改密码">
                <el-input  style="width:220px;" v-model="userdata.password"/>
                <el-button type="primary" style="margin-left:20px;" @click="changepwd()">修改</el-button>
            </el-form-item>
            
            <el-form-item label="头像" >
                <el-image
                    style="width: 100px; height: 100px"
                    :src="'/src/assets/Image/headImg/' + userdata.username + '.jpg'"
                    fit="cover"     
                />
                <el-upload
                    class="upload-demo"
                    action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                    
                    style="margin-left:20px"
                    :auto-upload="false"
                    :on-change="checkType"
                    :before-upload="beforeAvatarUpload"
                    :file-list="fileList"
                >
                    <el-button type="primary">点我更换</el-button>
                    <template #tip>
                    </template>
                </el-upload>
            </el-form-item>

            
        </el-form>

        <el-form v-model="user_info" label-width="120px">

            <el-form-item label="用户名">
            <el-input v-model="user_info.userId" style="width:220px;" />
            </el-form-item>

            <el-form-item label="性别">
                <el-select v-model="user_info.gender" placeholder="选择你的性别">
                    <el-option value="男" />
                    <el-option value="女" />
                </el-select>
            </el-form-item>
        
            <el-form-item label="生日">
                <el-col :span="11">
                    <el-date-picker
                    v-model="user_info.birthday"
                    type="date"
                    placeholder="年/月/日"
                    style="width: 100%"
                    />
                </el-col>
            </el-form-item>

            <el-form-item label="手机号">
                <el-input v-model="user_info.phone" style="width:220px;" />
            </el-form-item>

            <el-form-item label="邮箱">
                <el-input v-model="user_info.email" style="width:220px;" />
            </el-form-item>

            <el-form-item label="地址">
                <el-cascader size='large' :options='options.regionData' v-model='addr_select' @change="addrChangeHandler"></el-cascader>
                <el-input  type="textarea" style="width:400px;margin-left:20px" @change="addrChangeHandler" v-model="addr_sufix"/>
            </el-form-item>

            <el-form-item label="个人简介">
            <el-input v-model="user_info.context" type="textarea" style="width:600px;"/>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">更改</el-button>
                <el-button @click="cancel" type="primary">取消</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>

import {onMounted, ref} from 'vue'
import { regionData, CodeToText } from 'element-china-area-data'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
import { ElMessage } from 'element-plus'


export default {

    setup(){
        const store = useUserStore()
        const userInfo = storeToRefs(store)

        const userdata = userInfo.userAccount
        const user_info = userInfo.userBaseInfo

        const addr_select = ref(['130000','130200','130202'])

        const options = ref({regionData})

        const address = ref('')

        const addr_sufix = ref('')

        const fileList=ref([])


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
            store.fileUpload("head",formatData,userdata.value.username)
            fileList.value = []
            
        }


        function onSubmit(){
            store.userSubmit(user_info.value)
            store.addAddress(userdata.value.username,address.value)
        }

        function addrChangeHandler(value){
            address.value = ''
            if(addr_select.value.length != 3) return
            addr_select.value.map(item=> address.value = address.value +  CodeToText[item] + '-')
            // addr_select.value.map(item=>console.log(item))
            address.value = address.value + addr_sufix.value
            console.log(address.value)
        }

        function changepwd(){
            store.setPassword(userdata.value.username,userdata.value.password)
        }

        function cancel(){
            store.getUseInfo()
            console.log(user_info.value)
        }

        function beforeAvatarUpload(file){
            console.log(file)
        }


        



        return{
            options,
            addr_select,
            userdata,
            user_info,
            addr_sufix,
            fileList,

            onSubmit,  
            addrChangeHandler,
            changepwd,
            cancel,
            checkType,
            beforeAvatarUpload,


        }
    }

}
</script>

<style scoped>


</style>