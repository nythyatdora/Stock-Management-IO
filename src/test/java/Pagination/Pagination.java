package Pagination;

public class Pagination {
    public static void main(String[] args) {
        // display pagination
        int displayRecordedPage = 1;

        // int number_of_page_recorded = 300;
        // base on a number of counting recorded
        int totalPage = 10000000;

        System.out.println("Page: " + displayRecordedPage + " of " + totalPage/displayRecordedPage + "\t\t\t\t\t\tTotal Page: " + totalPage);

        // display pagination in Search
        int NumberOfPageWantToDisplay = 2;
        int recordedInput = 20;
        int totalPageAvaliable = 30;
        System.out.println(NumberOfPageWantToDisplay+" of "+recordedInput+ "\t\t\t\t\t\t\tTotal Page: " +(totalPageAvaliable-NumberOfPageWantToDisplay));

        // first-next-previous-last
        System.out.println(NumberOfPageWantToDisplay +" of "+(recordedInput/NumberOfPageWantToDisplay+1)+"\t\t\t\t\t\t\tTotal Page: "+(totalPageAvaliable-NumberOfPageWantToDisplay));

    }
}
