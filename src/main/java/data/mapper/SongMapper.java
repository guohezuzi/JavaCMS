package data.mapper;

import entity.Song;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guohezuzi
 * @create 2018-03-31 下午4:48
 */
@Mapper
public interface SongMapper {
    void insertSong(Song song);
    void updateSong(Song song);
}
