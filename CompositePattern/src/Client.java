/**
 * Created by zy on 2018-4-19.
 */
public class Client {
    public static void main(String[] args) {
        //针对抽象构件编程
        Component file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;

        folder1 = new Composite("Sunny的资料");
        folder2 = new Composite("图像文件");
        folder3 = new Composite("文本文件");
        folder4 = new Composite("视频文件");

        file1=new TxtFile("a.txt");
        file2=new ImageFile("a.image");
        file3=new VideoFile("a.mp4");
        file4 = new TxtFile("葵花宝典.doc");
        file5 = new VideoFile("笑傲江湖.rmvb");

        folder2.Add(file1);
        folder2.Add(file2);

        folder3.Add(file3);
        folder3.Add(file4);

        folder4.Add(file5);

        folder1.Add(folder2);
        folder1.Add(folder3);
        folder1.Add(folder4);

        folder1.KillVirus();
    }
}
