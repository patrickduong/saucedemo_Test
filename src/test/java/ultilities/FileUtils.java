package ultilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static void clearFolder(String path) throws IOException {
        Files.walk(Paths.get(path)).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
    }
}
