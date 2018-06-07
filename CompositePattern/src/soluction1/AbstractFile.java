package soluction1;

/**
 * Created by zy on 2018-4-19.
 */
public abstract class AbstractFile {
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }
    public abstract void killVirus();
}
