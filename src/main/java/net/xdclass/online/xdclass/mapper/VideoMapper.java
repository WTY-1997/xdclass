package net.xdclass.online.xdclass.mapper;

import net.xdclass.online.xdclass.model.entity.Video;
import net.xdclass.online.xdclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoMapper {
    /**
     * 查询所有Video
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(Integer videoId);
}

