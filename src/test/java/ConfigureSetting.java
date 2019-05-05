import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigureSetting implements Serializable {
    public int rowSetup = 10;
    public int currentPage = 1;
    public int currentID;

    public boolean hasSavedBeforeClose=false;
    public String recoveryFileName;
    public String currentWriteName;

    public static boolean isFileExist() {
        File tempFile = new File(FileLocation.SETTING_FILE_NAME);
        return tempFile.exists();
    }

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

    private static String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getBackupFileName() {
        return FileLocation.BACKUP_FILE_LOCATION + FileLocation.BACKUP_FILE_PREFIX + currentDate() + FileLocation.EXTENSION_FILE_DATA;
    }

    public static void main(String[] args) {
        ConfigureSetting.writeToConfigureFile(new ConfigureSetting());
    }
}

