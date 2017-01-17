package ck.itheima.com.phoneplay.beans;

/**
 * 类名:    HomeListItemBean
 * 创建者:  ckqu
 * 创建时间:2017/1/17 0017 上午 9:44
 * 包名:    ck.itheima.com.phoneplay.beans
 * 更新者:  $Author$ $Date$
 * 描述:    首页的bean
 */

public class HomeListItemBean {


    public String type;
    public int    id;
    public String title;
    public String description;
    public String posterPic;
    public String thumbnailPic;
    public String url;
    public String hdUrl;
    public String uhdUrl;
    public int    videoSize;
    public int    hdVideoSize;
    public int    uhdVideoSize;
    public int    status;
    public String traceUrl;
    public String clickUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getTraceUrl() {
        return traceUrl;
    }

    public void setTraceUrl(String traceUrl) {
        this.traceUrl = traceUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUhdVideoSize() {
        return uhdVideoSize;
    }

    public void setUhdVideoSize(int uhdVideoSize) {
        this.uhdVideoSize = uhdVideoSize;
    }

    public int getHdVideoSize() {
        return hdVideoSize;
    }

    public void setHdVideoSize(int hdVideoSize) {
        this.hdVideoSize = hdVideoSize;
    }

    public int getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(int videoSize) {
        this.videoSize = videoSize;
    }

    public String getUhdUrl() {
        return uhdUrl;
    }

    public void setUhdUrl(String uhdUrl) {
        this.uhdUrl = uhdUrl;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public void setHdUrl(String hdUrl) {
        this.hdUrl = hdUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;

    }

    public void setType(String type) {
        this.type = type;
    }
}
