package LibraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Books>list=new ArrayList<>();
        System.out.println("Welcome To Library Management System");
        Scanner in =new Scanner(System.in);
        int idd=101;
        while (true){
            System.out.println("Choose the option \n1.Add Book \n2.Show All Books \n3.Show Available Book \n4.Borrow Book \n5.Return Book \n6.Borrowed books \n7.Search \n8.Exit");
            int option = in.nextInt();
            switch (option){
                case 1 ->{
                    System.out.println("Enter the book tittle : ");
                    String tittle= in.next();
                    System.out.println("Enter the Author name : ");
                    String author = in.next();
                    System.out.println("Publish year : ");
                    int year = in.nextInt();
                    list.add(new Books(idd++,tittle,author,year,"Available"));
                    System.out.println("Book added successfully..!");
                }
                case 2 ->{
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" id       Book Tittle        Author        Year      status    ");
                    System.out.println("-------------------------------------------------------------");
                    for (Books books : list){
                       books.printDetails();
                    }
                    System.out.println();
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 ->{
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" id       Book Tittle        Author        Year      status    ");
                    System.out.println("-------------------------------------------------------------");
                    for (Books books : list){
                        if(books.getAvailable()){
                            books.printDetails();
                        }
                    }
                    System.out.println();
                    System.out.println("-------------------------------------------------------------");
                }
                case 4 ->{
                    boolean found=false;
                    System.out.println("Enter the id :");
                    int id=in.nextInt();
                    for (Books books : list){
                        if(id==books.getId()) {
                            found=true;
                            if (books.getAvailable()) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println(" id       Book Tittle        Author        Year      status    ");
                                System.out.println("-------------------------------------------------------------");
                                books.printDetails();
                                System.out.println();
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("Book is Available");
                                books.setAvailable("Unavailable");
                            }
                            else{
                                System.out.println("Book already borrowed");
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Enter the valid book id");
                    }
                }
                case 5 ->{
                    boolean found = false;
                    System.out.println("Enter the book id :");
                    int id = in.nextInt();
                    for (Books books : list){
                        if(id== books.getId()) {
                            found=true;
                            if (!books.getAvailable()) {
                                System.out.println("Book returned successfully..!");
                                books.setAvailable("Available");
                            }
                            else if(books.getAvailable()){
                                System.out.println("its available book.are you cross checking me.just for fun..!");
                            }
                        }
                    }
                    if(!found) System.out.println("Enter the valid id");

                }
                case 6 ->{
                    boolean found = false;
                    for (Books books : list){
                        if(!books.getAvailable()){
                            found=true;
                            System.out.println("-------------------------------------------------------------");
                            System.out.println(" id       Book Tittle        Author        Year      status    ");
                            System.out.println("-------------------------------------------------------------");
                            books.printDetails();
                            System.out.println();
                            System.out.println("-------------------------------------------------------------");
                        }
                    }
                    if(!found) System.out.println("Books not borrowed");
                }
                case 7 ->{
                    boolean found = false;
                    System.out.println("Enter the book id :");
                    int id = in.nextInt();
                    for (Books books : list) {
                    if(id== books.getId()){
                        found=true;
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(" id       Book Tittle        Author        Year      status    ");
                        System.out.println("-------------------------------------------------------------");
                        books.printDetails();
                        System.out.println();
                        System.out.println("-------------------------------------------------------------");
                    }
                    }
                    if(!found) System.out.println("Enter the valid id");
                }
                case 8 -> System.exit(0);

                default -> System.out.println("Enter the valid option");
            }
        }
    }
}
