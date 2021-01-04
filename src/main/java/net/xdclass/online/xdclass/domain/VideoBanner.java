package net.xdclass.online.xdclass.domain;
//视频轮播图
//CREATE TABLE `video_banner` (
//        `id` int unsigned NOT NULL AUTO_INCREMENT,
//        `url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
//        `img` varchar(256) DEFAULT NULL COMMENT '图片地址',
//        `create_time` datetime DEFAULT NULL,
//        `weight` int DEFAULT NULL COMMENT '数字越小排越前',
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

import java.util.Date;

public class VideoBanner {


    private Integer id;
    private String url;
    private String img;
    private Date createTime;
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", weight=" + weight +
                '}';
    }
}
