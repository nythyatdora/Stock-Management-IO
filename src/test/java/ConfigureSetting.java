import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigureSetting implements Serializable {
    public int rowSetup = 10;
    public int currentPage = 1;
    public int currentID;

    public boolean hasSavedBeforeClose;
    public String recoveryFileName;
    public String currentWriteName;

    public String currentCollectionFile = "";
    public String backupFilePrefix = "file_backup-";
    public String backupFileLocation = "./meta/recovery/";
    public String extensionFileData = ".bak";

    public static boolean writeToConfigureFile(ConfigureSetting setting) {
        try {
            FileOutputStream file = new FileOutputStream(FileLocation.SETTING_FILE_NAME);
            ObjectOutputStream outStream = new ObjectOutputStream(file);

            outStream.writeObject(setting);

            outStream.close();
            file.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static ConfigureSetting readFromConfigureFile() {
        ConfigureSetting temp;

        try {
            FileInputStream file = new FileInputStream(FileLocation.SETTING_FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);

            temp = (ConfigureSetting) in.readObject();

            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            return null;
        }
        return temp;
    }

    private String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM,dd-mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getBackupFileName() {
        return this.backupFileLocation + this.backupFilePrefix + currentDate() + this.extensionFileData;
    }

    public static void main(String[] args) {
        ConfigureSetting setting = new ConfigureSetting();
        setting.writeToConfigureFile(new ConfigureSetting());
    }
}

