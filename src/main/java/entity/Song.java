package entity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* String: 18-2-2
 * \* Time: 下午4:55
 * \* Description:歌曲类(包含基本歌曲信息)
 * \
 */
public class Song {
    private int id;

    //@NotEmpty(message = "歌曲名不能为空")
    private String song_name;

    //@NotEmpty(message = "作曲不能为空")
    private String author;

    //@NotEmpty(message = "歌手不能为空")
    private String singer;

    //@NotEmpty(message = "发行日期不能为空")
    private String issue_date;

    //@NotEmpty(message = "专辑名不能为空")
    private String album;

    //@NotEmpty
    private String pic_url;

    //@NotEmpty
    private String song_url;

    public Song(int id, String song_name, String author, String singer, String issue_date, String album) {
        this.id=id;
        this.song_name = song_name;
        this.author = author;
        this.singer = singer;
        this.issue_date = issue_date;
        this.album = album;
    }

    public Song(int id, String song_name, String author, String singer, String issue_date, String album , String pic_url, String song_url) {
        this.id=id;
        this.song_name = song_name;
        this.author = author;
        this.singer = singer;
        this.issue_date = issue_date;
        this.album = album;
        this.pic_url=pic_url;
        this.song_url=song_url;
    }

    public Song() {
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
