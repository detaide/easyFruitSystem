const { defineConfig } = require('@vue/cli-service')
module.exports = {
    lintOnSave:false,
    transpileDependencies: true,
    proxy:{
        '/api':{
            target:'http://localhost:8080',
            changeOrigin:true,  // 允许跨域
            rewrite:path => path.replace(/^\/api/,'')
        }
    },
    publicPath:'./'
 
}