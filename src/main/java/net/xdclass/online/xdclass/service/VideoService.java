package net.xdclass.online.xdclass.service;

import net.xdclass.online.xdclass.domain.Video;
import net.xdclass.online.xdclass.domain.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
    List<VideoBanner> listVideoBanner();
    Video findDetailById(Integer videoId);
}
