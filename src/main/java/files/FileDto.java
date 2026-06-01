package files;

import java.io.File;

public class FileDto {
    File file;

    public FileDto(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
