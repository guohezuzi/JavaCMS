package data;

import entity.Song;

import java.util.ArrayList;
import java.util.List;

//song表访问数据库接口
public interface SongRepository {
    void addSong(Song song);
    void delSong(Song song);
    void updSong(Song song);
    List<Song> showAllSong();

    List<Song> searchAsName(String name);

    List<Song> searchAsSinger(String singer);

    /*
    * 查找30条数据
    * @return List形式的30条数据,一个List中分5个List,每个List 6条数据
    * @Parameter start查询的元素开始的位置
    * */
    ArrayList<List<Song> > showThirtySong(int start);
}
