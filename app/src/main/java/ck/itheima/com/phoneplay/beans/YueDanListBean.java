package ck.itheima.com.phoneplay.beans;

import java.util.List;

/**
 * 类名:    YueDanListBean
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 8:58
 * 包名:    ck.itheima.com.phoneplay.beans
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanListBean {

    private int totalCount;
    private List<PlayListsBean> playLists;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<PlayListsBean> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayListsBean> playLists) {
        this.playLists = playLists;
    }

    public static class PlayListsBean {
        private int         id;
        private String      title;
        private String      thumbnailPic;
        private String      playListPic;
        private String      playListBigPic;
        private int         videoCount;
        private String      description;
        private String      category;
        private CreatorBean creator;
        private int         status;
        private int         totalViews;
        private int         totalFavorites;
        private String      updateTime;
        private String      createdTime;
        private int         integral;
        private int         weekIntegral;
        private int         totalUser;
        private int         rank;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumbnailPic() {
            return thumbnailPic;
        }

        public void setThumbnailPic(String thumbnailPic) {
            this.thumbnailPic = thumbnailPic;
        }

        public String getPlayListPic() {
            return playListPic;
        }

        public void setPlayListPic(String playListPic) {
            this.playListPic = playListPic;
        }

        public String getPlayListBigPic() {
            return playListBigPic;
        }

        public void setPlayListBigPic(String playListBigPic) {
            this.playListBigPic = playListBigPic;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(int totalViews) {
            this.totalViews = totalViews;
        }

        public int getTotalFavorites() {
            return totalFavorites;
        }

        public void setTotalFavorites(int totalFavorites) {
            this.totalFavorites = totalFavorites;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getWeekIntegral() {
            return weekIntegral;
        }

        public void setWeekIntegral(int weekIntegral) {
            this.weekIntegral = weekIntegral;
        }

        public int getTotalUser() {
            return totalUser;
        }

        public void setTotalUser(int totalUser) {
            this.totalUser = totalUser;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public static class CreatorBean {
            private int    uid;
            private String nickName;
            private String smallAvatar;
            private String largeAvatar;
            private int    vipLevel;
            private String vipImg;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getSmallAvatar() {
                return smallAvatar;
            }

            public void setSmallAvatar(String smallAvatar) {
                this.smallAvatar = smallAvatar;
            }

            public String getLargeAvatar() {
                return largeAvatar;
            }

            public void setLargeAvatar(String largeAvatar) {
                this.largeAvatar = largeAvatar;
            }

            public int getVipLevel() {
                return vipLevel;
            }

            public void setVipLevel(int vipLevel) {
                this.vipLevel = vipLevel;
            }

            public String getVipImg() {
                return vipImg;
            }

            public void setVipImg(String vipImg) {
                this.vipImg = vipImg;
            }
        }
    }
}
