<template>
  <top-navigate/>
  <div class="top_center">
        <div class="logo">
            <el-image
                    style="width:100%;"
                    :src="base_url + 'logo.jpg'"
                    fit="cover"
                />
        </div>
        <div class="serach_body">
                <input type="search" id="search" placeholder="输入想要购买的商品">
                <el-button type="primary" id="search_btn">
                    <el-icon size="20px">
                        <Search/>
                    </el-icon>
                </el-button>
        </div>
        <div class="link">
            <el-image
                    style="width:100%;"
                    :src="base_url + 'adv.jpg'"
                    fit="cover"
                />
        </div>
  </div>

  <!-- 滚动图片  -->
  <div class="carousel">
     <el-carousel :interval="4000" type="card" height="400px">
        <el-carousel-item v-for="item in items" :key="item">
        <img :src="base_url + item.url" alt="">
        </el-carousel-item>
    </el-carousel>
  </div>

    <div class="show" v-for="item in list" :key="item">
        <div class="recomend" >
            <div class="recomend_title" :id="item.name">
                <span style="float:left;font-size:30px;margin-left:20px;font-weight:bold;"> 
                    {{item.name}} </span>
                <span style="float:right;line-height:70px">
                    <a href="">更多>></a>    
                </span>      
            </div>

            <div class="skeleton">
                <clear-fix :classfy="item.name"/>
            </div>
        </div>
    </div>
    

    <div class="tail">
        <tail/>
    </div>

    <el-backtop :right="50" :bottom="100" />



</template>

<script>
import TopNavigate from '../components/TopNavigate.vue'
import clearFix from '../components/clearFix.vue'
import Tail from '../components/tail.vue'
export default {
    components:{
        TopNavigate,
        clearFix,
        Tail
    },

    setup() {
        
        const base_url = '/src/assets/Image/index_img/'
        const base_a_url = '/src/assets/Image/goods_img/'

        

        const items = ([
            {url:'lunbo1.jpg'},
            {url:'lunbo2.jpg'},
            {url:'lunbo3.jpg'}
        ])

        const list = [
            {name:'推荐'},
            {name:'柑橘橙柚柠'},
            {name:'葡提浆果'},
            {name:'热带水果'},
            {name:'苹果香蕉梨'},
            {name:'桃李杏枣'},
            {name:'西瓜 /蜜瓜'},
            {name:'车厘子/草莓'},
        ]

        return{
            base_url,
            items,
            base_a_url,
            list
        }

    }

}
</script>

<style scoped>

.top_center{
    display: flex;
    margin: auto;
    width: 100%;
    margin-bottom: 20px;
    
}


.logo{
    background: red;
    width: 500px;
    
}

.top_center div{
    height: 100px;
}



.serach_body{
    width: 450px;
    margin-left: 20px;
    line-height: 100px;
}

.link{
    margin-left: 20px;
    width: 550px;
    
}

#search{
    width: 300px;
    height: 50px;
    border:1px solid rgb(224, 224, 224);
    background: #fff;
    text-shadow: none;
    letter-spacing: 0.1em;
    font-size: 0.9em;
    transition: 0.5s;
    outline: none;
    box-shadow: none;
    padding:0 20px;
}

#search_btn{
    margin-left: 10px;
    background: #fff;
    border:1px solid rgb(224, 224, 224);
    color: rgb(97, 97, 97);
    cursor: pointer;
    width: 60px;
    height: 50px;
}


.recomend{
    width: 85%;
    margin: auto;
    margin-top: 50px;
    
    /* border-bottom: 2px solid red; */
}

a{
    text-decoration: none;
    color:black;
    border-right: none;
}

.recomend_title{
    height: 46px;
    border-bottom: 2px solid red;
    /* margin-right: 10px; */
}

.skeleton{
    /* background: skyblue; */
    margin-top: 10px;
    display: flex;
    overflow-x:auto;
    width: 97%;
    margin-left: 30px;
}

.tail{
    margin-bottom: 50px;
}


</style>