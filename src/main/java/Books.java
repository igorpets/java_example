class Books {
    String title; // Название книги.
    String author;
}
class BooksTestDrive {
    public static void main(String [] args) {
 
        Books [] myBooks = new Books[3];
        int x = 0;
        while (x < 3) {
            myBooks[x] = new Books();
            x++;
        }
  
        myBooks[0].title = "Введение в Java";
        myBooks[1].title = "Java рулит";
        myBooks[2].title = "Cбоpник рецептов пo Golang";

        myBooks[0].author = "Том Сойер";
        myBooks[1].author = "Агата Кристи";
        myBooks[2] .author = "Гёте";

        x = 0;
        while (x < 3) {
            System.out.print(myBooks[x].title);
            System.out.print(", автор ");
            System.out.println(myBooks[x].author);
            x++;
        }
    }
}
