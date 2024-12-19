package stirling.software.SPDF.config.security.database;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import stirling.software.SPDF.config.interfaces.DatabaseBackupInterface;
import stirling.software.SPDF.utils.FileInfo;

/**
 * @author Ou
 * @date 2024/12/19
 */
@Component
public class FaceDatabase implements DatabaseBackupInterface {
    @Override
    public void exportDatabase() throws IOException {}

    @Override
    public boolean importDatabase() {
        return false;
    }

    @Override
    public boolean hasBackup() {
        return false;
    }

    @Override
    public List<FileInfo> getBackupList() {
        return List.of();
    }
}
