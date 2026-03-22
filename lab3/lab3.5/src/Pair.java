public class Pair <T,U> {
    private T first;
    private U second;
    public Pair(T first,U second){
        this.first = first;
        this.second = second;
    }
    public boolean ComparePairs(Pair<T,U> otherPair){
        if (first.equals(otherPair.first) && second.equals(otherPair.second)){
            return true;
        }
        else {
            return false;
        }
    }
}
