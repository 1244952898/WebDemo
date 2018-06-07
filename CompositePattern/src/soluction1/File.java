package soluction1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zy on 2018-4-19.
 */
public class File extends AbstractFile {
    ArrayList<AbstractFile> files=new ArrayList<>();
    @Override
    public void killVirus() {
        for (AbstractFile file :
                files ) {
            file.killVirus();
        }
    }
}
