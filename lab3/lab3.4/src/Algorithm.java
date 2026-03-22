public class Algorithm<T extends Comparable> {
    public void  FindMax(T arr[]){
        T max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max.compareTo(arr[i]) < 0){
                max = arr[i];
            }
        }
        System.out.println("Max: " + max);
    }
}
