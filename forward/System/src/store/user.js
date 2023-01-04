import {defineStore} from 'pinia'
import axios from 'axios'
import { storeToRefs } from 'pinia'
import {useGlobal} from '../store/global.js'
import { uploadContentProps } from 'element-plus'
import { ElMessage } from 'element-plus'



// const globalStore = useGlobal()
// const global = storeToRefs(globalStore)
// const globaldata = global.globalObject

const baseUrl = 'http://localhost:8080'

export const useUserStore = defineStore(
    'users',
    {
        state:()=>{
            const userAccount = {
                username:'root',
                password:'root',               
            }
            const userBaseInfo = {

            }

            const user_address = []

            const orders_list = []

            const userAll = []

            const ordersAll = []

            const stock_list  = []

            const goods_list = []

            const shopCar = []

            
            const global_status = {
                isLogin:false,
                baseUrl:'http://localhost:8080',
                isRoot:false,
                orderName:false,
                orderStatus:''
            }

            return{
                userAccount,
                user_address,
                orders_list,
                userAll,
                ordersAll,
                global_status,
                stock_list,
                goods_list,
                shopCar,
                userBaseInfo,
            }
        },

        getters:{
            
        },
        actions:{
            
            getAddress(){
                const userdata = this.$state.userAccount
                    axios.get(
                        baseUrl + '/getAddress/' + userdata.username
                    ).then(Response=>{
                        this.$state.user_address = []
                        Response.data.forEach((item)=>{
                            this.$state.user_address.push(item)
                        })
                        // console.log(Response.data)
                    })
            },

            getUseInfo(){ 
                axios.get(
                    baseUrl + '/getUserMsg/' + this.$state.userAccount.username,
                ).then(resp =>{
                    this.$state.userBaseInfo = resp.data
                })
            },

            // terms:模式，pay|unpay|search,当为search时使用keys作为关键字
            //             username
            getOrders(terms,keys){
                const userdata = this.$state.userAccount
                axios.get(
                    baseUrl + '/getOrder/' + userdata.username + '/' + terms +'/' +  keys  
                ).then(Response =>{
                    this.$state.orders_list = []
                    Response.data.forEach((item)=>{
                        this.$state.orders_list.push(item)
                    })

                }) 
            },

            getAllOrders(terms,keys){
                const userdata = this.$state.userAccount
                axios.get(
                    baseUrl + '/getAllOrders/'  + terms +'/' +  keys  
                ).then(Response =>{
                    this.$state.orders_list = []
                    Response.data.forEach((item)=>{
                        this.$state.orders_list.push(item)
                    })

                }) 
            },

            getAllUser(){
                axios.get(
                    baseUrl + '/getAllUser'
                ).then(
                    Response=>{
                        this.$state.userAll = []
                        Response.data.forEach((item)=>{
                            this.$state.userAll.push(item)
                        })
                    }
                    
                )
            },

            getStock(keys){
                axios.get(
                    baseUrl + '/getStock/' + keys
                ).then(
                    Response=>{
                        this.$state.stock_list = []
                        Response.data.forEach((item)=>{
                            this.$state.stock_list.push(item)
                        })
                    }
                )
            },

            getGoodsInfo(keys){
                axios.get(
                    baseUrl + '/getGoodsInfo/' + keys
                ).then(
                    Response=>{
                        this.$state.goods_list = []
                        Response.data.forEach((item)=>{
                            this.$state.goods_list.push(item)
                        })
                    }
                )
            },

            getShopCar(username){
                axios.get(
                    baseUrl + '/getShopCar/' + username
                ).then(
                     Response=>{
                        this.$state.shopCar = []
                        // console.log(Response.data)
                        // console.log("shopcar is",this.$state.shopCar)
                        console.log(Response.data)
                         Response.data.forEach((item)=>{
                            this.$state.shopCar.push(item)
                        })
                        console.log("shopcar is",this.$state.shopCar)
                    }
                )
            },
            
            setPassword(username,password){
                axios.get(
                    baseUrl + '/changePwd/' + username + '/' + password
                ).then(
                    Response=>{
                        this.getAllUser()
                        ElMessage({
                            message: '密码更改成功',
                            type: 'success',
                        })
                        
                    }
                )
            },

            deleteUser(username){
                axios.get(
                    baseUrl + '/deleteUser/' + username
                ).then(
                    Response=>{
                        this.getAllUser()
                        ElMessage({
                            message: '删除成功',
                            type: 'success',
                        })
                        
                    }
                )
            },


            deleteOrder(id){
                axios.get(
                    baseUrl + '/deleteOrder/' + id
                ).then(
                    Response=>{
                        this.getOrders()
                        ElMessage({
                            message: '删除成功',
                            type: 'success',
                        })
                    }
                )
            },

            goodChange(goodsInfo){
                axios.post(
                    baseUrl + '/goodsChange',
                    goodsInfo
                ).then(
                    Response=>{
                        this.getGoodsInfo()
                        ElMessage({
                            message: '商品修改成功',
                            type: 'success',
                        })
                    }
                )
            },

            goodDelete(id){
                axios.get(
                    baseUrl + '/goodDelete/' + id 
                ).then(
                    Response=>{
                        this.getGoodsInfo()
                    }
                )
            },

            userSubmit(userInfo){
                axios.post(
                    baseUrl + '/userSubmit',
                    userInfo
                ).then(
                    Response=>{
                        this.getUseInfo()
                        ElMessage({
                            message: '提交成功',
                            type: 'success',
                        })
                    }
                    
                )
            },

            addStock(name,count){
                axios.get(
                    baseUrl + "/addStock/" + name + "/" + count
                ).then(
                    Response=>{
                        this.getStock()
                        this.getGoodsInfo()
                        ElMessage({
                            message: '进货成功',
                            type: 'success',
                        })
                    }
                )
            },

            addAddress(username,address){
                console.log("address" , address)
                axios.get(
                    baseUrl + '/addAddress/' + username + '/' + address
                ).then(
                    Response=>{
                        this.getAddress()
                    }
                )
            },

            selectAddress(id,username){
                axios.get(
                    baseUrl + '/selectAddress/' + id + '/' + username
                ).then(
                    Response=>{
                        this.getAddress()
                        ElMessage({
                            message: '地址切换成功',
                            type: 'success',
                        })
                    }
                )
            },

            deleteAddress(id){
                axios.get(
                    baseUrl + '/deleteAddress/'  + id
                ).then(
                    Response=>{
                        this.getAddress()
                        ElMessage({
                            message: '删除成功',
                            type: 'success',
                        })
                    }
                )
            },

            deleteShopOne(name,username){
                axios.get(
                    baseUrl + '/deleteShopOne/' + name + '/' + username
                ).then(
                    Response=>{
                        this.getShopCar(username)
                    }
                )
            },

            addOrders(orderListInfo){
                console.log("orderList",orderListInfo)
                axios.post(
                    baseUrl + '/addOrders',
                    orderListInfo 
                    // "heiheihei"
                ).then(
                    Response=>{
                        this.getShopCar(this.$state.userAccount.username)
                        ElMessage({
                            message: '结算成功',
                            type: 'success',
                        })
                    }
                )
            },

            addShop(name,username){
                axios.get(
                    baseUrl + '/addShop/' + name + '/' + username
                ).then(
                    Response=>{
                        this.getShopCar(username)
                        ElMessage({
                            message: '加入购物车成功',
                            type: 'success',
                        })
                    }
                )
            },

            // type:fruit|head
            fileUpload(type,file,name){
                console.log(file.values)
                axios.post(
                    baseUrl + '/fileUpload/' + type + '/' + name,
                    file
                ).then(
                    Response=>{
                        ElMessage.success("切换成功")
                    }
                )
            }





        },

        persist:{
            enabled :true,
            strategies:[
                {
                    storage:localStorage,paths:['userAccount',
                    'user_address',
                    'orders_list',
                    'userAll',
                    'ordersAll',
                    'global_status',
                    'stock_list',
                    'goods_list',
                    'shopCar',
                    'userBaseInfo'
                ]
                }
            ]
        }

    

    }
)