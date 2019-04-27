public class Product {
    private int proId;
    private String proName;
    private String author;
    private String importDate;
    private int qty;

    public Product() {

    }

    public Product(int proId, String proName, String author, String importDate, int qty) {
        this.proId = proId;
        this.proName = proName;
        this.author = author;
        this.importDate = importDate;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public int getProId() {
        return proId;
    }

    public String getProName() {
        return proName;
    }

    public String getAuthor() {
        return author;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}