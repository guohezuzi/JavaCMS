package data;

import entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 18-2-2
 * \* Time: 下午8:49
 * \* Description:对song表访问的实现类
 * \
 */
@Repository
public class JdbcSongRepositoryImp implements SongRepository {
    private final String INSERT_SONG="INSERT INTO song VALUES (NULL,?,?,?,?,?,?,?);";
    private final String DELETE_SONG="DELETE FROM song WHERE id=?;";
    private final String UPDATE_SONG="UPDATE song SET name=?,author=?,singer=?,issue_date=?,album=?,pic_url=?,song_url=? WHERE id=?";
    private final String SHOW_SONG="SELECT * FROM song limit 0,30;";
    private final String SEARCH_SONG_AS_NAME ="SELECT * FROM song WHERE name=?;";
    private final String SEARCH_SONG_AS_SINGER="SELECT * FROM song WHERE singer=?";
    private final JdbcOperations jdbc;

    @Autowired
    //在此idea检查出错 songMapper已经注入
    private JdbcSongRepositoryImp(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void addSong(Song song) {
        jdbc.update(INSERT_SONG,
                song.getName(),
                song.getAuthor(),
                song.getSinger(),
                song.getIssue_date(),
                song.getAlbum()
        );
    }

    @Override
    public void delSong(Song song) {
        jdbc.update(DELETE_SONG,song.getId());
    }

    @Override
    public void updSong(Song song) {
        jdbc.update(UPDATE_SONG,
                song.getName(),
                song.getAuthor(),
                song.getSinger(),
                song.getIssue_date(),
                song.getAlbum(),
                song.getPic_url(),
                song.getSong_url(),
                song.getId()
        );
    }

    @Override
    public List<Song> showAllSong() {
        return jdbc.query(SHOW_SONG,new SongRowMapper());
    }

    @Override
    public List<Song> searchAsName(String name) {
        return jdbc.query(SEARCH_SONG_AS_NAME,new SongRowMapper(), name);
    }

    @Override
    public List<Song> searchAsSinger(String singer) {
        return jdbc.query(SEARCH_SONG_AS_SINGER,new SongRowMapper(), singer);
    }

    //查询30条数据
    @Override
    public ArrayList<List<Song> > showThirtySong(int start) {
        ArrayList<List<Song> > result=new ArrayList<>();
        while (start<30) {
            String limit=Integer.toString(start)+",6";
            String query=SHOW_SONG.replaceAll("\\d+,\\d+",limit);
            List<Song> songList=jdbc.query(query,new SongRowMapperForWeb());
            result.add(songList);
            start+=6;
        }
        return result;
    }

    //管理员界面的映射
    private static class SongRowMapper implements RowMapper<Song> {
        public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Song(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getString("singer"),
                    rs.getString("issue_date"),
                    rs.getString("album")
                    );
        }
    }

    //web用的映射(用户界面的映射)
    private static class SongRowMapperForWeb implements RowMapper<Song> {
        public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Song(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getString("singer"),
                    rs.getString("issue_date"),
                    rs.getString("album"),
                    rs.getString("pic_url").replaceAll(" ","%20"),
                    rs.getString("song_url")
            );
        }
    }
}
