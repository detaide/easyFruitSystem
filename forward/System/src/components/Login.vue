<template>
    <div class="backgnd">
        <h1>Login</h1>
        <input type="text" placeholder="Username" v-model="userdata.username">
        <i></i>
        <input type="password" placeholder="Password" v-model="userdata.password" >
        <i></i>
        <div class="check">
            <button @click="Login">登录</button>
            <button @click="Register">注册</button>
        </div>
        
    </div>
 
</template>

<script>
import {onMounted, ref} from "vue"

import {useRouter} from 'vue-router'
import axios from 'axios'
import { ElMessage } from 'element-plus'

import {useUserStore} from '../store/user.js'
import {useGlobal} from '../store/global.js'
import { storeToRefs } from 'pinia'
// import Cookies from 'js-cookie'


export default {
    
    name:'Login',
    setup(props,context) {
        const store = useUserStore()
        const userInfo = storeToRefs(store)
        const globalStore = useGlobal()
        const global = storeToRefs(globalStore)
        const route = useRouter()

        const userdata = userInfo.userAccount
        // const globaldata = global.globalObject
        const globaldata = userInfo.global_status
        const useraddress = userInfo.user_address
        const user_order = userInfo.orders_list

        function Login(){
            axios.post(
                globaldata.value.baseUrl + '/login',
                userdata.value
            ).then(
                response=>{
                    if(response.data){
                        successLogin()
                        globaldata.value.isLogin = true;
                        if(userdata.value.username == 'root'){
                            globaldata.value.isRoot = true
                            store.getAllUser()
                            userInfo.global_status.value.orderName = true
                        }else{
                            globaldata.value.isRoot = false
                            userInfo.global_status.value.orderName = false
                        }
                        console.log(userdata.value.username)

                        const userCookie = {
                            username:userdata.value.username,
                            password:userdata.value.password
                        }

                        // console.log(Cookies)
                        
                        store.getUseInfo()
                        store.getAddress()
                        store.getOrders()
                        store.getGoodsInfo()
                        store.getStock()
                        store.getShopCar(userdata.value.username)
                        route.push({name:'main'})
                        
                    }
                    else{
                        failLogin()
                    }
                }
            )
        }

        function Register(){
            axios.post(
                globaldata.value.baseUrl + '/register',
                userdata.value
            ).then(
                response=>{
                    if(response.data)
                        successRegister()
                    else{
                        failRegister()
                    }
                }
            )
        }

        // 登陆成功回显
        const successRegister = () => {
                ElMessage({
                    message: '注册成功',
                    type: 'success',
                })
        }

        const failRegister = () =>{
            ElMessage(
                {
                    message:'注册失败，账号已存在',
                    type:'error'
                }
            )
        }

        const successLogin = () => {
                ElMessage({
                    message: '登陆成功',
                    type: 'success',
                })
        }

        const failLogin = () =>{
            ElMessage(
                {
                    message:'登陆失败，账号或密码错误',
                    type:'error'
                }
            )
        }

        function getAddress(){
                axios.get(
                    globaldata.value.baseUrl + '/getAddress/' + userInfo.userAccount.value.username
                ).then(Response=>{
                    Response.data.forEach((item)=>{
                        useraddress.value.push(item)
                    })
                    // console.log(Response.data)
                })
        }

        function getUseInfo(){
            
            axios.get(
                globaldata.value.baseUrl + '/getUserMsg/' + userdata.value.username,
            ).then(resp =>{
                userdata.value.userBaseInfo = resp.data
                // console.log(userdata.value.userBaseInfo)
            })
        }

        function getOrders(){
            axios.get(
                globaldata.value.baseUrl + '/Orders/' + userdata.value.username,
            ).then(resp =>{
                Response.data.forEach((item)=>{
                        user_order.value.push(item)
                    })
            })
        }

    

        return {
            userInfo,
            userdata,

            Login,
            Register
        }
    }
}
</script>

<style scoped>
@import "../static/CSS/login.css";

</style>