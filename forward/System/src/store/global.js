import {defineStore} from 'pinia'

export const useGlobal = defineStore(
    'global',
    {
        state:()=>{
            const globalObject = {
                isLogin:false,
                baseUrl:'http://localhost:8080',
                isRoot:false
            }



            return{
                globalObject,
            }
        },

        getters:{
            
        },
        actions:{
            
        },
        
        persist:{
            enable:true,
            strategies:[
                {
                    storage:localStorage,paths:[
                        'globalObject'
                    ]
                }
            ]

        }

    

    }
)