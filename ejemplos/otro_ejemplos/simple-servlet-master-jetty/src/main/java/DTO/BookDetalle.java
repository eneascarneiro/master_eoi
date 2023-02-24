package DTO;

public class BookDetalle{

    private int book_id;

    private String book_title;

    double precio;

    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getBook_title() {
        return book_title;
    }
    public void setBook_tittle(String book_tittle) {
        this.book_title = book_tittle;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}