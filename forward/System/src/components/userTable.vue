<template>
  <div>
    <el-table :data="userAll" stripe style="width: 100%">
    <el-table-column prop="username" label="用户名" width="180" />
    <el-table-column prop="password" label="密码" />
    <el-table-column prop="loginTime" label="登陆时间" />
    <el-table-column prop="registerTime" label="注册时间" />
    <el-table-column prop="123" label="操作" >
        <template v-slot="scope">
            <el-button type="primary" style="margin-left: 2px;" @click="active(scope.row.username)" >修改密码</el-button>
            <el-button type="danger" style="margin-left: 2px;" @click="userDelete(scope.row.username)">删除</el-button>
        </template>
    </el-table-column>

  </el-table>
  </div>

    <el-dialog v-model="dialogactive" title="修改密码">
        <span>输入新的密码：</span><el-input  placeholder="请输入密码" style="width:200px" v-model="user.password"/> 
        <el-button type="primary" style="margin-left: 2px;" @click="change_passwd()" >修改</el-button>
    </el-dialog>

</template>

<script>
import {ref} from 'vue'
import {useUserStore} from '../store/user.js'
import { storeToRefs } from 'pinia'
export default {
    
    setup(){
        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const userAll = userInfo.userAll

        const user = ref({username:'',password:''})

        const dialogactive = ref(false)
        

        function active(username){
            user.value.username = username
            dialogactive.value = true
        }

        function change_passwd(){
            dialogactive.value = false
             store.setPassword(user.value.username,user.value.password)        
        }

        function userDelete(username){
            store.deleteUser(username)
        }

        return{
            dialogactive,
            user,
            userAll,

            active,
            change_passwd,
            userDelete
        }
    }

}
</script>

<style>

</style>