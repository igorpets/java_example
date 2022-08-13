import java.util.*;
public class HelloWorld{

    public static class Util {
        public static <TT> TT getValue(Object obj, Class<TT> clazz) {
            return (TT) obj;
        }
        public static <XX> XX getValue(Object obj) {
            return (XX) obj;
        }
    }

    public static void main(String []args) {
        List list = Arrays.asList("Author", "Book");
        for (Object element : list) {
            String data = Util.getValue(element, String.class);
            System.out.println(data);
            System.out.println(Util.<String>getValue(element));
        }
    }
}