import java.util.List;

class SmileyFaceCount {
    static int countSmileys(List<String> arr) {
        return (int)arr.stream().filter(x -> x.matches("[:;][-~]?[)D]")).count();
    }
}
