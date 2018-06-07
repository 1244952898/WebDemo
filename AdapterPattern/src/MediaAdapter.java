/**
 * Created by zy on 2018-4-18.
 */
public class MediaAdapter {
    IAdvancedMediaPlayer adapter;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase("vlc"))
            this.adapter = new VlcPlayer();
        else
            this.adapter = new Mp4Player();
    }

    public void Play(String type,String fileName){
        if (type.equalsIgnoreCase("vlc"))
            this.adapter.VlcPlay(fileName);
        else
            this.adapter.Mp4Play(fileName);
    }
}
