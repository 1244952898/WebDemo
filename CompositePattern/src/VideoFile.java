/**
 * Created by zy on 2018-4-19.
 */
public class VideoFile  implements Component {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void Add(Component component) {
        System.out.println("叶子节点无法添加对象");
    }

    @Override
    public void Remove(Component component) {
        System.out.println("叶子节点无法删除对象");
    }

    @Override
    public Component Get(int i) {
        System.out.println("叶子节点无法获取对象");
        return null;
    }

    @Override
    public void KillVirus() {
        System.out.println("对音频进行"+name+"杀毒。。。");
    }
}