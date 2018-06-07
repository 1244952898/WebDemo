/**
 * Created by zy on 2018-4-18.
 */
public class MediaPlayer implements IMediaPlayer {
    MediaAdapter mediaAdapter;
    public void Play(String type, String mediaName) {
        if (type.equalsIgnoreCase("mp3")){
            Mp3Play(type,mediaName);
        }
        else if (type.equalsIgnoreCase("mp4")){
            mediaAdapter=new MediaAdapter(type);
            mediaAdapter.Play(type,mediaName);
        }
        else if (type.equalsIgnoreCase("vlc")){
            mediaAdapter=new MediaAdapter(type);
            mediaAdapter.Play(type,mediaName);
        }
        else  {
            System.out.println("文格"+type+"格式未知！");
        }
    }

    @Override
    public void Mp3Play(String type, String mediaName) {
        System.out.println("播放"+type+"的文件:"+mediaName);
    }
}
