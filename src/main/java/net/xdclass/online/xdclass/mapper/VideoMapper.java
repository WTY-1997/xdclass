package net.xdclass.online.xdclass.mapper;

import net.xdclass.online.xdclass.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VideoMapper {
    /**
     * 查询所有Video
     *
     * @return
     */
    List<Video> listVideo();
}

