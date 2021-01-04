package net.xdclass.online.xdclass.service.impl;

import net.xdclass.online.xdclass.domain.Video;
import net.xdclass.online.xdclass.mapper.VideoMapper;
import net.xdclass.online.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
