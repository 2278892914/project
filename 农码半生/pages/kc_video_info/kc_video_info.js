const app = getApp()
Page({
  onReady(res) {
    this.videoContext = wx.createVideoContext('myVideo')
  },
  inputValue: '',
  data: {
    openId: '',
    src: '',
    video_url: '',
    video_id: 50,
    comment: {},
    danmuList: [{
        text: '第 1s 出现的弹幕',
        color: '#ff0000',
        time: 1
      },
      {
        text: '第 3s 出现的弹幕',
        color: '#ff00ff',
        time: 3
      }
    ],
    send1: true,
    send2: false
  },
  bindInputBlur(e) {
    this.inputValue = e.detail.value;
    //console.log(e.detail.value);
    //console.log(this.data.openId);
    //console.log(this.data.video_id);
    var that = this;
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/commentvideo.do',
      method: 'GET',
      data: {
        video_id: that.data.video_id,
        openId: that.data.openId,
        comment: e.detail.value
      },

      success: function() {
        wx.request({
          url: 'https://www.ordinarylife.top:8080/wx_talk/findvideocomment.do',
          method: 'GET',
          data: {
            video_id: that.data.video_id,
            //openId: that.data.openId
          },
          success: function (res) {
            //console.log(res.data);
            that.setData({
              comment: res.data,
              send1: true,
              send2: false
            })

          }
        })

//        wx.navigateTo({
//         url: '../kc_video_info/kc_video_info?id=' + //that.data.video_id,
//        })
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

  onLoad: function(options) {
    this.setData({
      openId: app.globalData.openId
    });
    //console.log(this.data.openId);
    var that = this;
    //console.log(this.data.send1);
    //console.log(this.data.send2);
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/lookvideo.do',
      method: 'GET',
      data: {
        video_id: options.id,
        openId: that.data.openId
      },
      success: function(res) {
        //console.log(res.data.video_url);
        //console.log(res.data.id);
        that.setData({
          video_url: res.data.video_url,
          video_id: res.data.id,
          
        })
        //console.log(that.data.video_id);
      }
    });
    //console.log(this.data);
    //console.log(this.data.video_id);
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/findvideocomment.do',
      method: 'GET',
      data: {
        video_id: options.id,
        //openId: that.data.openId
      },
      success: function(res) {
        //console.log(res.data);
        that.setData({
          comment: res.data
        })
      }
    })


  },

})

function getRandomColor() {
  const rgb = []
  for (let i = 0; i < 3; ++i) {
    let color = Math.floor(Math.random() * 256).toString(16)
    color = color.length == 1 ? '0' + color : color
    rgb.push(color)
  }
  return '#' + rgb.join('')
}