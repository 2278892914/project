// pages/kc_video/kc_video.js

Page({

  /**
   * 页面的初始数据
   */ 
  data: {
    video_type: {},
    video: {},
    openId: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    var that = this;
    //console.log(options);
    //console.log(this.data.openId);
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/findvideotype.do',
      success: function(res) {
        //console.log(res.data);
        that.setData({
          video_type: res.data
        });
      },
    });
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/findvideo.do',
      method: 'GET',
      data: {
        video_id: 1
      },
      success: function(res) {
        //console.log(res.data); 
        that.setData({
          video: res.data
        });
      }
    });

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  findtypevideo: function(res) {
    var that = this;
    //console.log(res.target.dataset.id)
    var video_id = res.target.dataset.id;
    //console.log(video_id);
    wx.request({
      url: 'https://www.ordinarylife.top:8080/wx_talk/findvideo.do',
      method: 'GET',
      data: {
        video_id: video_id
      },
      success: function(res) {
        //console.log(res.data);
        that.setData({
          video: res.data
        });
      }
    });
  },
  lookvideo: function(res) {
    //console.log(res.target.dataset.video_id);
    var id = res.target.dataset.video_id;
    wx.navigateTo({
      url: '../kc_video_info/kc_video_info?id=' + id,
    })
  }
})