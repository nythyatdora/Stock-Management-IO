public interface FileLocation {
    String DEFAULT_FILE_NAME = "./collection.bak";
    String SETTING_FILE_NAME = "./setting.bak";

    String SETTING_FILE_LOCATION = "./meta/setting.bak";
    String BACKUP_FILE_LOCATION = "./meta/backup/";
    String RESTORE_FILE_LOCATION = "./meta/";

    String BACKUP_FILE_PREFIX = "file_backup-";
    String EXTENSION_FILE_DATA = ".sql";
}
