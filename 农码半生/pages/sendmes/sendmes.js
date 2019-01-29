function getRandomColor() {
  const rgb = []
  for (let i = 0; i < 3; ++i) {
    let color = Math.floor(Math.random() * 256).toString(16)
    color = color.length == 1 ? '0' + color : color
    rgb.push(color)
  }
  return '#' + rgb.join('')
}
const app = getApp()
Page({
 
  inputValue: '',
  data: {
    title: "",
    comment: "",
    src: '',
    tempFilePaths: '',
    openId: '',
    flag:false
  },
  bindInputBlur(e) {
    this.inputValue = e.detail.value
  },
  bindButtonTap() {
    const that = this
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


  changeFun: function (ev) {
    //console.log(ev.detail.value),
      this.setData({
        title: ev.detail.value
      })
  },
  changeFun1: function (ev) {
    //console.log(ev.detail.value),
      this.setData({
        comment: ev.detail.value
      })
  },
  chooseimage: function () {
    var _this = this;
    
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        //console.log(res.tempFilePaths);
        _this.setData({
          flag:true,
          tempFilePaths: res.tempFilePaths
        })
      }
    })
  },
  sendcomment: function () {
    //console.log(this.data.title);
    //console.log(this.data.comment);
    //console.log(this.data.tempFilePaths);
    //console.log(this.data.openId);
    var that = this;
    if (this.data.title && this.data.comment){
      wx.request({
        url: 'https://www.ordinarylife.top:8080/wx_talk/sendcomment.do',
        data: {
          title: that.data.title,
          comment: that.data.comment,
          image: that.data.tempFilePaths,
          openid: that.data.openId
        },
        success() {
          wx.switchTab({
            url: '../index/index',
          })
        }
      })
    }else{
      wx.showToast({
        title: '不能为空',
      })
    }
    
    
  },
  onLoad: function () {
    this.setData({
      openId: app.globalData.openId
    });
  },

})