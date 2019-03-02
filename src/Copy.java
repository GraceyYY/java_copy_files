import java.io.*;

public class Copy {
    public static void copyFilesUsingFileStreams(String srcPath, String destPath ){
        File src = new File(srcPath);
        File dest = new File(destPath);
    }

    private static void copyFile(File src, File dest) {
        try (InputStream input = new FileInputStream(src);
             OutputStream output = new FileOutputStream(dest)) {
            int byteRead;
            byte[] buffer = new byte[1024];
            while((byteRead = input.read(buffer)) != -1){
                output.write(buffer, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir(File src, File dest) {

    }
}
