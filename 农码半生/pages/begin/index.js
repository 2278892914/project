//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function() {

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    /**
     * 进入此方法，先获取到code，然后授权，如果是已经授权了，则userinfo肯定不为空，如果是为空，
     */
    //console.log(app.globalData.code);
    //console.log(e.detail.userInfo);
    app.globalData.userInfo = e.detail.userInfo;
    if (app.globalData.userInfo) {
      //app.globalData.userInfo = e.detail.userInfo,
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      wx.request({
          method: 'GET',
          url: 'https://www.ordinarylife.top:8080/wx_talk/finduserinfo.do',
          data: {
            code: app.globalData.code,
            res: e.detail.userInfo,
          },
          success: function(res) {
            //console.log(res.data.openid);
            app.globalData.openId = res.data.openid;

          }

        }),

        wx.switchTab({
          url: '../index/index',
        })
    }
  }
})