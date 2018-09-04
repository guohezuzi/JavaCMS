package controller;

import data.SongRepository;
import data.mapper.SongMapper;
import entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: guohezuzi
 * \* Date: 18-2-2
 * \* Time: 下午7:00
 * \* Description:对歌曲操作的前端控制器
 * \
 */
@Controller
@RequestMapping("music")
public class MusicController {
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Autowired
    public MusicController(SongRepository songRepository, SongMapper songMapper) {
        this.songMapper = songMapper;
        this.songRepository = songRepository;
    }

    @RequestMapping(method = GET)
    public String musicHome(){
        return "forward:/index";
    }

    /**添加歌曲的处理*/
    @RequestMapping(value = "m_add_song", method = POST)
    public String addSongToView(@RequestPart("song_file") MultipartFile music_file,
                                @RequestPart("song_pic") MultipartFile picFile,
                                Song song, Model model) throws IOException {
        music_file.transferTo(new File("/home/guohezuzi/Code/IdeaProjects/JavaCMS/src/main/webapp/resources/song/" + song.getSong_name() + ".mp3"));
        picFile.transferTo(new File("/home/guohezuzi/Code/IdeaProjects/JavaCMS/src/main/webapp/resources/img/" + song.getSong_name() + ".jpg"));
        song.setPic_url("/resources/img/"+song.getSong_name()+".jpg");
        song.setSong_url("/resources/song/"+song.getSong_name()+".mp3");
        songMapper.insertSong(song);
        model.addAttribute("isAdd", true);
        return "forward:/admin";
    }

    /**更新歌曲的处理*/
    @RequestMapping(value = "m_upd_song", method = GET)
    public String mUpdSong(Song song, Model model,
                           @RequestParam(value = "update", required = false) String update,
                           @RequestParam(value = "delete", required = false) String delete) {
        if (update !=null) {
            songMapper.updateSong(song);
            model.addAttribute("isUpdate", true);
        }
        else if(delete != null){
            songRepository.delSong(song);
            /*// TODO: 18-5-17
            * 文件的删除
            * */
            model.addAttribute("isDelete",true);
        }
        else {
            model.addAttribute("isError",true);
        }
        return "forward:/admin";
    }

    /**搜索歌曲的处理*/
    @RequestMapping(value = "m_search_song", method = GET)
    public String mSearchSong(@RequestParam("search") String search,
                              @RequestParam("select") String select,
                              Model model) {
        switch (select) {
            case "name":
                model.addAttribute(songRepository.searchAsName(search));
                return "admin";
            case "singer":
                model.addAttribute(songRepository.searchAsSinger(search));
                return "admin";
            default:
                return null;
        }
    }
}
