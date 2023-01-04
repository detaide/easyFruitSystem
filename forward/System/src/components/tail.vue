<template>
<img src="/src/assets/Image/tail_img/operators.jpg" alt="" style="margin-top:30px;" >
  <div class="tail_body">
        <div  v-for="item in links" :key="item.name">
            <div class="link_tail">
              <img :src="base_url + item.url" alt=""  style="padding:5px;width:40px">
              <span class="link_title">{{item.name}}
              </span>
              <img :src="base_url + item.QRCode"  alt="" id="QR_img">

            </div>

        </div>
  </div>
  <div class="info" style="margin-top:20px">
    <span>关于本店</span>
    <span>招贤纳士</span>
    <span>联系我们</span>
    <span>客服热线: 0000-12345678</span>
  </div>

  <div class="copyright" style="margin-top:20px">
      <span id="copyright_span">Copyright ©2022-2022 PTU乐乐水果店 PTUfruit.com All Rights Reserved</span>
      <span style="font-size: 12px;">莆计科课设版权所有</span>
  </div>

</template>


<script>
import {ref} from 'vue'
export default {

  setup(){

    const base_url = '/src/assets/Image/tail_img/'

    const links = ref([
      {
        name:'微 信',
        url:'wechat.jpg',
        QRCode:'wechat_QR.jpg'
      },
      {
        name:'Github',
        url:'github.jpg',
        QRCode:'github_QR.jpg'
      },
      {
        name:'华 为',
        url:'huawei.jpg',
        QRCode:'huawei_QR.jpg'
      }
    ])

    return{
      base_url,
      links
    }

  }

}
</script>

<style scoped>
  .tail_body{
    text-align: center;
    display: flex;
    margin-left: 340px;
    margin-top: 10px;
  }


  .link_tail{
    margin-left: 40px;
    border: 1px solid rgb(219, 214, 214);
    height: 50px;
    width: 200px;
    text-align: left;
    display: flex;
  }

  .link_title{
    display: block;
    font-weight: bold;
    margin-left: 10px;
  }

  #QR_img{
    padding-left: 30px;
  }

  .link_title{
    line-height: 40px;
    width: 50px;
  }

  

  .info span{
      border-right: 1px solid rgb(207, 199, 199);
      margin-right: 20px;
      padding-right: 20px;
  }

  .info span:last-child{
    border-right: none;
  }

  #copyright_span{
      border-right: 1px solid rgb(207, 199, 199);
      margin-right: 20px;
      padding-right: 20px;
      font-size: 12px;
  }

</style>