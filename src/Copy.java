import java.io.*;

public class Copy {
    public static void copyFilesUsingFileStreams(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        try {
            if (src.exists()) {
                copyDir(src, dest);
                System.out.println("Files has been copied to \"" + dest.getCanonicalPath() + "\"");
            } else {
                System.out.println("The path does not exist, please check again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(File src, File dest) {
        try (InputStream input = new FileInputStream(src);
             OutputStream output = new FileOutputStream(dest)) {
            int byteRead;
            byte[] buffer = new byte[1024];
            while ((byteRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir(File src, File dest) {
        dest.mkdirs();
        File[] files = src.listFiles();
        String destPath = dest.getAbsolutePath();

        for (File file : files) {
            String path = destPath + "/" + file.getName();
            File copy = new File(path);

            if (file.isDirectory()) {
                copyDir(file, copy);
            } else {
                copyFile(file, copy);
            }
        }
    }
}
