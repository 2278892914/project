const app = getApp()
Page({

  inputValue: '',
  data: {
    id: '',
    openId: '',
    video_id: 50,
    comment: {},
    question: {},
    send1: true,
    send2: false,
  },
  onLoad: function(res) {
    var that = this;
    //发送两个异步请求，一个是问题的详情，另外一个是问题的评论
    //console.log(res.id);
    //console.log(app.globalData.openId);
    this.setData({
      id: res.id,
      openId: app.globalData.openId
    })
    wx.request({
      url: "https://www.ordinarylife.top:8080/wx_talk/commentinfo.do",
      method: 'GET',
      data: {
        id: res.id,
        openid: app.globalData.openId
      },
      success(ops) {
       // console.log(ops.data.image);
        that.setData({
          question: ops.data
        })
      }
    }),
    //查找帖子评论
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/findtzcomment.do',
      method:'GET',
      data:{
        id:that.data.id
      },
      success:function(res){
        //console.log(res);
        that.setData({
          comment:res.data
        })
      }
    })

  },
  bindInputBlur(e) {
    this.inputValue = e.detail.value;
    //console.log(e.detail.value);
    var that = this;
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/sendtzcomment.do',
      method: 'GET',
      data: {
        ques_id: that.data.id,
        openId: that.data.openId,
        content: e.detail.value
      },

      success: function() {
        wx.request({
          url: 'https://www.ordinarylife.top:8080/wx_talk/findtzcomment.do',
          method: 'GET',
          data: {
            id: that.data.id
          },
          success: function(res) {
            //console.log(res.data);
            that.setData({
              comment: res.data,
              send1: true,
              send2: false
            })

          }
        })
      }
    })


  },
  bindButtonTap() {
    const that = this;
    wx.chooseVideo({
      sourceType: ['album', 'camera'],
      maxDuration: 60,
      camera: ['front', 'back'],
      success(res) {
        that.setData({
          src: res.tempFilePath
        })
      }
    })
  },
  bindSendDanmu() {
    this.videoContext.sendDanmu({
      text: this.inputValue,
      color: getRandomColor()
    })
  },
  focusFun: function() {
    //console.log(1111);
    this.setData({
      send1: false,
      send2: true
    });

  },
  comment: function(e) {
    //console.log(e)
  },
})