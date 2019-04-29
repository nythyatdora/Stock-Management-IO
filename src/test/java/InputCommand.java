public interface InputCommand {
    char DISPLAY_TABLE = '*';

    char WRITE_PRODUCT_UPPER = 'W';
    char WRITE_PRODUCT_LOWER = 'w';

    char READ_PRODUCT_UPPER = 'R';
    char READ_PRODUCT_LOWER = 'r';

    char UPDATE_PRODUCT_UPPER = 'U';
    char UPDATE_PRODUCT_LOWER = 'u';

    char DELETE_PRODUCT_UPPER = 'D';
    char DELETE_PRODUCT_LOWER = 'd';

    char FIRST_PAGE_UPPER = 'F';
    char FIRST_PAGE_LOWER = 'f';

    char MOVE_PREVIOUS_UPPER = 'P';
    char MOVE_PREVIOUS_LOWER = 'p';

    char MOVE_NEXT_UPPER = 'N';
    char MOVE_NEXT_LOWER = 'n';

    char LAST_PAGE_UPPER = 'L';
    char LAST_PAGE_LOWER = 'l';

    char SEARCH_PRODUCT_UPPER = 'S';
    char SEARCH_PRODUCT_LOWER = 's';

    char GOTO_PAGE_UPPER = 'G';
    char GOTO_PAGE_LOWER = 'g';

    char ROW_SETUP_UPPER = 'O';
    char ROW_SETUP_LOWER = 'o';

    char SAVE_FILE_UPPER = 'V';
    char SAVE_FILE_LOWER = 'v';

    char BACKUP_FILE_UPPER = 'C';
    char BACKUP_FILE_LOWER = 'c';

    char RESTORE_FILE_UPPER = 'T';
    char RESTORE_FILE_LOWER = 't';

    char HELP_LAYOUT_UPPER = 'H';
    char HELP_LAYOUT_LOWER = 'h';

    char EXIT_UPPER = 'E';
    char EXIT_LOWER = 'e';
}
