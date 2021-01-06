package net.xdclass.online.xdclass.service;

import net.xdclass.online.xdclass.model.entity.Video;
import net.xdclass.online.xdclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
    List<VideoBanner> listVideoBanner();
    Video findDetailById(Integer videoId);
}
