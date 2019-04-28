public interface CoreProcess {
    void regexSearch();

    void saveDataToFile();
    void backUpDataToFile();
    void restoreDataToFile();

    void moveToFirstPage();
    void moveToLastPage();
    void moveToPreviousRow();
    void moveToNextRow();

    void shortcutCommand();

    void exitProgram();
}