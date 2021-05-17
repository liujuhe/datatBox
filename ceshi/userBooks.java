package software.ceshi;

public class userBooks {
    private int id;
    private String Boook_name;
    private int ISBN;
    private double Book_price;
    private String Book_author;
    private String Published_house;
    private String Borrower_name;
    private String Borrower_phone;

    public userBooks() {
    }

    @Override
    public String toString() {
        return "userBooks{" +
                "id=" + id +
                ", Boook_name='" + Boook_name + '\'' +
                ", ISBN=" + ISBN +
                ", Book_price=" + Book_price +
                ", Book_author='" + Book_author + '\'' +
                ", Published_house='" + Published_house + '\'' +
                ", Borrower_name='" + Borrower_name + '\'' +
                ", Borrower_phone='" + Borrower_phone + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoook_name() {
        return Boook_name;
    }

    public void setBoook_name(String boook_name) {
        Boook_name = boook_name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public double getBook_price() {
        return Book_price;
    }

    public void setBook_price(double book_price) {
        Book_price = book_price;
    }

    public String getBook_author() {
        return Book_author;
    }

    public void setBook_author(String book_author) {
        Book_author = book_author;
    }

    public String getPublished_house() {
        return Published_house;
    }

    public void setPublished_house(String published_house) {
        Published_house = published_house;
    }

    public String getBorrower_name() {
        return Borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        Borrower_name = borrower_name;
    }

    public String getBorrower_phone() {
        return Borrower_phone;
    }

    public void setBorrower_phone(String borrower_phone) {
        Borrower_phone = borrower_phone;
    }
}
