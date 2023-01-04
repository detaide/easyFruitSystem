controller ---- 前端path交接控制

mapper ---映射层，完成函数映射，对数据库进行访问

server ---- 对mappe层的调用

函数调用
controller.functionA --> service.functionA  --> mapper.functionA

controller new service object

service new mapper object

mapper do function
