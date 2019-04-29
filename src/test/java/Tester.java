
public class Tester implements InputCommand {
    public static void main(String[] args) {
        BaseCode baseCode = new BaseCode();
        baseCode.outputHelpLayout();
//        baseCode.outputWelcomeLayout();
//        baseCode.outputLogoLayout();
//        baseCode.outputLoadingLayout();

//        do {
//            baseCode.outputMainLayout();
//
//            char inputCommand = TextFieldConsole.readCharType("Command : ");
//
//            switch (inputCommand) {
//                case DISPLAY_TABLE:
//                    baseCode.displayTableData();
//                    break;
//
//                case WRITE_PRODUCT_UPPER:
//                case WRITE_PRODUCT_LOWER:
//                    baseCode.writeDataLayout();
//                    break;
//
//                case READ_PRODUCT_UPPER:
//                case READ_PRODUCT_LOWER:
//                    baseCode.readDataLayout();
//                    break;
//
//                case UPDATE_PRODUCT_UPPER:
//                case UPDATE_PRODUCT_LOWER:
//                    baseCode.updataDataLayout();
//                    break;
//
//                case DELETE_PRODUCT_UPPER:
//                case DELETE_PRODUCT_LOWER:
//                    baseCode.deleteDataLayout();
//                    break;
//
//                case FIRST_PAGE_UPPER:
//                case FIRST_PAGE_LOWER:
//                    baseCode.moveToFirstPage();
//                    break;
//
//                case MOVE_PREVIOUS_UPPER:
//                case MOVE_PREVIOUS_LOWER:
//                    baseCode.moveToPreviousRow();
//                    break;
//
//                case MOVE_NEXT_UPPER:
//                case MOVE_NEXT_LOWER:
//                    baseCode.moveToNextRow();
//                    break;
//
//                case LAST_PAGE_UPPER:
//                case LAST_PAGE_LOWER:
//                    baseCode.moveToLastPage();
//                    break;
//
//                case SEARCH_PRODUCT_UPPER:
//                case SEARCH_PRODUCT_LOWER:
//                    baseCode.searchDataLayout();
//                    break;
//
//                case GOTO_PAGE_UPPER:
//                case GOTO_PAGE_LOWER:
//                    baseCode.gotoDataLayout();
//                    break;
//
//                case ROW_SETUP_UPPER:
//                case ROW_SETUP_LOWER:
//                    baseCode.setRowLayout();
//                    break;
//
//                case SAVE_FILE_UPPER:
//                case SAVE_FILE_LOWER:
//                    baseCode.saveDataToFile();
//                    break;
//
//                case BACKUP_FILE_UPPER:
//                case BACKUP_FILE_LOWER:
//                    baseCode.backUpDataToFile();
//                    break;
//
//                case RESTORE_FILE_UPPER:
//                case RESTORE_FILE_LOWER:
//                    baseCode.restoreDataToFile();
//                    break;
//
//                case HELP_LAYOUT_UPPER:
//                case HELP_LAYOUT_LOWER:
//                    baseCode.outputHelpLayout();
//                    break;
//
//                case EXIT_UPPER:
//                case EXIT_LOWER:
//                    System.exit(0);
//                    break;
//
//                default:
//                    baseCode.outputInvalidInputLayout();
//                    break;
//            }
//        } while (true);
    }
}
