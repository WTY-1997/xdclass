package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.domain.Video;
import net.xdclass.online.xdclass.service.VideoService;
import net.xdclass.online.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("list")
    public Object listVideo(){
        List<Video> listVideos = videoService.listVideo();
        return JsonData.bulidSucccess(listVideos);
    }
}
