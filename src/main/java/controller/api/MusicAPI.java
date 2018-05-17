package controller.api;

import data.SongRepository;
import data.mapper.SongMapper;
import entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 2018-05-13
 * \* Time: 下午4:24
 * \* Description:音乐的json数据
 * \
 */
@Controller
@RequestMapping("/api/music")
public class MusicAPI {
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Autowired
    public MusicAPI(SongRepository songRepository, SongMapper songMapper) {
        this.songMapper = songMapper;
        this.songRepository = songRepository;
    }

    /**
     * 异步请求加载更多数据
     * @param page 第多少页数据 30一页(起始为第0页)
     */
    @RequestMapping(value = "music.json",method = GET)
    @ResponseBody
    public ArrayList<List<Song>> load(@RequestParam int page){
        return songRepository.showThirtySong(30*page);
    }
}
