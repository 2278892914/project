// pages/t1/t1.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "t1":"HELLO WORLD",
    "con":false,
    "peoples":[
      {"name":"张三"},
      {"name":"李四"}
    ]
  },
  changeFun:function(){
    //面向对象的概念
    
    this.setData({
      "t1":"你好"
    });

  },
  showFun: function () {
      this.setData({
        "con":true
      });
  },
  nextFun:function(){
    wx.navigateTo({
      url: '../index/index'
    })
  },
  findTom:function(){
    wx.request({
            url:"http://localhost:8080/test/a.do",
      success(res) {
        console.log(res.data)
      }
    });
  }
})