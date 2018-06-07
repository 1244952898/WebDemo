/**
 * Created by zy on 2018-4-18.
 */
public class VlcPlayer implements IAdvancedMediaPlayer {
    @Override
    public void VlcPlay(String fileName) {
        System.out.println("播放文件："+fileName);
    }

    @Override
    public void Mp4Play(String fileName) {
        System.out.println("无法播放！");
    }
}
