import { createApp } from 'vue'
import App from './App.vue'
import './index.css'
import router from './routers/index'
import ElementPlus from 'element-plus'
import '../node_modules/element-plus/dist/index.css'
import 'default-passive-events'
import * as ElementPlusIconsVue  from '@element-plus/icons-vue'
import {createPinia} from 'pinia'
import piniaPersist from 'pinia-plugin-persist'

// import VueCookies from 'vue-cookies'


const pinia = createPinia()
pinia.use(piniaPersist)

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

app.use(router).use(ElementPlus).mount('#app')
app.use(pinia)
// app.config.globalProperties.$cookies = VueCookies
