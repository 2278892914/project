//app.js
App({
  globalData: {
    userInfo: null,
    code: null,
    openId: '',
    
  },
  onLaunch: function() {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        this.globalData.code = res.code
        //console.log(this.globalData.code);
      }
    })
    // 获取用户信息
    wx.getSetting({
      
      success: res => {
        var that = this;
        
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框      
          //console.log("授权成功");
          wx.getUserInfo({
            success: res => {
              
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              //console.log(res.userInfo);
              var code = this.globalData.code;
              /**
              wx.request({
                method:'GET',
                url: 'http://127.0.0.1:8080/wx_talk/finduserinfo.do',
                data:{
                  code:code,
                  nickName: res.userInfo.nickName,
                  res:res.userInfo,
                },
                success:function(res){
                  //console.log(res.data)
                  that.globalData.openId = res.data;
                  //console.log(that.globalData.openId)
                }
                
              })
              */
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  }
  
})