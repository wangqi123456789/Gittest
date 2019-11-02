import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
public class wq {
        private static void splitFile(File srcFile, int eachSize) {
            if (0 == srcFile.length())
                throw new RuntimeException("文件长度为0，不可拆分");
            byte[] fileContent = new byte[(int) srcFile.length()];
            // 先把文件读取到数组中
            try {
                FileInputStream fis = new FileInputStream(srcFile);
                fis.read(fileContent);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 计算需要被划分成多少份子文件
            int fileNumber;
            // 文件是否能被整除得到的子文件个数是不一样的
            // (假设文件长度是25，每份的大小是5，那么就应该是5个)
            // (假设文件长度是26，每份的大小是5，那么就应该是6个)
            if (0 == fileContent.length % eachSize)
                fileNumber = (int) (fileContent.length / eachSize);
            else
                fileNumber = (int) (fileContent.length / eachSize) + 1;
            for (int i = 0; i < fileNumber; i++) {
                String eachFileName = srcFile.getName() + "-" + i;
                File eachFile = new File(srcFile.getParent(), eachFileName);
                byte[] eachContent;
                if (i != fileNumber - 1) // 不是最后一个
                    eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
                else // 最后一个
                    eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);

                try {
                    // 写出去
                    FileOutputStream fos = new FileOutputStream(eachFile);
                    fos.write(eachContent);
                    // 记得关闭
                    fos.close();
                    System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        int eachSize = 100 * 1024; // 100k
        File srcFile = new File("D:/wq/www.txt");
        splitFile(srcFile, eachSize);
        System.out.println("wq");
    }
}
