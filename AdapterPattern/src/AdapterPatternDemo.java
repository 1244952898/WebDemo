/**
 * Created by zy on 2018-4-18.
 */
public class AdapterPatternDemo {
    // IMediaPlayer 接口
    // 实体类 AudioPlayer
    //接口IAdvancedMediaPlayer
    // AdvancedMediaPlayer实体类
    //适配器类 MediaAdapter 传递所需的音频类型
    //Vlc Mp4 mp3
    public static void main(String[] args) {
        MediaPlayer player=new MediaPlayer();
        player.Play("mp3","123.mp3");
        player.Play("mp4","444.mp4");
        player.Play("vlc","123.vlc");
        player.Play("xfl","123.xfl");
    }
}
