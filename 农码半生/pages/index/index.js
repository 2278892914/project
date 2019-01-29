//index.js
//获取应用实例
const app = getApp()
Page({
  data: {
    question: {},
    findV: ""
  },
  changeFun: function(ev) {
    this.setData({
      findV: ev.detail.value
    });
  },
  findQue: function() {
    var v = this.data.findV;
    const thiz = this;
   // console.log(v);
    wx.request({
      url: "https://www.ordinarylife.top:8080/wx_talk/findcomment.do",
      data: {
        findV: v,
        flag:'like'
      },
      success: function(res) {
        //console.log(res.data);
        thiz.setData({
          question: res.data
        });
      }


    });
  },
   findallcomment:function(res){
     const thiz = this;
     wx.request({
       url: "https://www.ordinarylife.top:8080/wx_talk/findcomment.do",
       data: {
         flag: 'all'
       },
       success: function (res) {
         //console.log(res.data);
         thiz.setData({
           question: res.data
         });
       }
     });
   },
  findcommentimage:function(){
    const thiz = this;
    wx.request({
      url: "https://www.ordinarylife.top/wx_talk/findcomment.do",
      data: {
        flag: 'image'
      },
      success: function (res) {
        //console.log(res.data);
        thiz.setData({
          question: res.data
        });
      }
    });
  },
  findvideo:function(){
    wx.navigateTo({
      url: '../kc_video/kc_video',
    })
  },
  send:function(){
    wx.navigateTo({
      url: '../sendmes/sendmes',
    })
  },
  onShow(){
    const thiz = this;
    wx.request({
      url: "https://www.ordinarylife.top:8080/wx_talk/findcomment.do",
      data: {
        flag: 'all'
      },
      success: function (res) {
        //console.log(res.data);
        thiz.setData({
          question:res.data
        })
      }
    });
  },
  comment:function(res){
    //console.log(res.target.dataset);
    var id = res.target.dataset.id;
    wx.navigateTo({
      url: '../comment/comment?id='+id,
    })
  }
})