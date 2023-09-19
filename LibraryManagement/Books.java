package LibraryManagement;

public class Books {
    private int id;
    private int year;
    private String tittle;
    private String author;
    private String available;

    Books(int id,String tittle,String author,int year,String available){
        this.id=id;
        this.tittle=tittle;
        this.author=author;
        this.year=year;
        this.available=available;
    }

    public int getId() {return id;}
    public String getTittle() {return tittle;}
    public String getAuthor(){return author;}
    public int getYear() {return year;}
    public boolean getAvailable(){
        if(available.equals("Available")){
            return true;
        }
        else return false;
            }

    public void setId(int id) {this.id = id;}
    public void setTittle(String tittle) {this.tittle = tittle;}
    public void setAuthor(String author) {this.author = author;}
    public void setYear(int year) {this.year = year;}
    public void setAvailable(String available) {this.available = available;}

    public void printDetails(){
        System.out.println(" "+id+"        "+tittle+"      "+author+"      "+year+"     "+available);
    }
}
