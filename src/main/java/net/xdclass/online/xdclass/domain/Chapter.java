package net.xdclass.online.xdclass.domain;

import java.util.Date;
import java.util.List;

//章对象
//CREATE TABLE `chapter` (
//        `id` int unsigned NOT NULL AUTO_INCREMENT,
//        `video_id` int DEFAULT NULL COMMENT '视频主键',
//        `title` varchar(128) DEFAULT NULL COMMENT '章节名称',
//        `ordered` int DEFAULT NULL COMMENT '章节顺序',
//        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=716 DEFAULT CHARSET=utf8;
public class Chapter {
    private Integer id;
    private Integer videoId;
    private String title;
    private Integer ordered;
    private Date createTime;
    private List<Episode> episodeList;

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
