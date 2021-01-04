package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("list")
    //@RequestMapping("list")
    public Object listVideo(){
        System.out.println(11);
        return videoService.listVideo();
    }
}
