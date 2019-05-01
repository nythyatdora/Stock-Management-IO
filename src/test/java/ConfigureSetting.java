import java.io.*;

public class ConfigureSetting implements Serializable {
    public int rowSetup;
    public int currentPage;
    public int currentID;

    public boolean hasSavedBeforeClose;
    public String recoveryFileName;
    public String currentWriteName;
    public String currentReadName;

    public boolean writeToConfigureFile(ConfigureSetting setting) {
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


    public ConfigureSetting readFromConfigureFile() {
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
}

