public class Test {

    public static void main(String[] args) {
        String line = "Sam 58 69 99 131 168 236 278 380 467 408 466";
        NameSurferEntry entry = new NameSurferEntry(line);
        System.out.println(entry.toString());
        System.out.println(entry.getName());
        System.out.println(entry.getRank(10));

        System.out.println(System.getProperty("user.dir"));
        NameSurferDataBase nsdb = new NameSurferDataBase("data/NamesData.txt");

    }
}
