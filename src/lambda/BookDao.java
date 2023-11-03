package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class BookDao {

    public List<Book> getBooks(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"alpha"));
        list.add(new Book(2,"beta"));
        list.add(new Book(3,""));

        return list;
    }
}

 class BookService{

    public List<Book> get() {
        BookDao bookDao = new BookDao();
        List<Book> list = bookDao.getBooks();
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });

        return list;
    }

     public static void main(String[] args) {
//         BookService service = new BookService();
//         List<Book> list = service.get();

//         List<Book> nonEmptyBookNames = list.stream()
//                 .sorted(new Comparator<Book>() {
//                     @Override
//                     public int compare(Book o1, Book o2) {
//                         return o2.getId() - o1.getId();
//                     }
//                 }).toList();
//
////                 .filter(book -> !book.getName().isEmpty() && book.getId() > 1)
////                 .map(book -> book.getId() + ": " + book.getName() + " : " + 2)
////                 .toList();
//
//         nonEmptyBookNames.forEach((k) -> System.out.println(k.getId() + " " + k.getName()));

         int mapSize = 1000000; // 1 million entries

         Map<String, Integer> map = new HashMap<>();

         Random random = new Random();

         // Generate and populate the map with random data
         for (int i = 0; i < mapSize; i++) {
             String key = String.valueOf(i);
             int value = random.nextInt(100); // Random integer values between 0 and 99
             map.put(key, value);
         }


//         Map<String,Integer> map = Map.of("apple" ,1 , "mango", 5, "papaya",4,"",2,"q",1);

         long start = 0 , end = 0;

         start = System.currentTimeMillis();
         Map<String,Integer> mp = map.entrySet().stream().parallel()
                 .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                 .filter(e -> e.getKey().equals("5000"))
                 .collect(Collectors.toMap(
                         Map.Entry::getKey , Map.Entry::getValue , (e1,e2)->e1 , LinkedHashMap::new
                 ));

         mp.entrySet().stream().forEach((obj)-> System.out.println(obj));
         end = System.currentTimeMillis();
         System.out.println( end - start);

         start = System.currentTimeMillis();
         Map<String,Integer> pp = map.entrySet().stream().parallel()
                 .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                 .filter(e -> e.getKey().equals("10000"))
                 .collect(Collectors.toMap(
                         Map.Entry::getKey , Map.Entry::getValue , (e1,e2)->e1 , LinkedHashMap::new
                 ));

         pp.entrySet().stream().forEach((obj)-> System.out.println(obj));
         end = System.currentTimeMillis();
         System.out.println( end - start);
     }

 }
