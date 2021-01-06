package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.model.entity.Video;
import net.xdclass.online.xdclass.model.entity.VideoBanner;
import net.xdclass.online.xdclass.service.VideoService;
import net.xdclass.online.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("video_banner")
    public JsonData indexBanner() {
        List<VideoBanner> bannerList = videoService.listVideoBanner();
        return JsonData.bulidSucccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @GetMapping("list")
    public JsonData listVideo() {
        List<Video> listVideos = videoService.listVideo();
        return JsonData.bulidSucccess(listVideos);
    }

    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true)Integer videoId){
        Video video = videoService.findDetailById(videoId);
        System.out.println(video);
        return JsonData.bulidSucccess(video);
    }

}
