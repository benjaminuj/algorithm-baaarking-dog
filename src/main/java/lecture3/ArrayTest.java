package lecture3;

import java.util.Arrays;

public class ArrayTest {
    static int len;
    static int[] arr = new int[10];
    public static void main(String[] args) {
        insert_test();
        Arrays.fill(arr, 0);
        erase_test();
    }
    // 강의에서, len이 10을 넘어가게 되는 경우는 고려하지 않은 것 같다.
    static void insert(int idx, int num, int arr[]){
        // 추가적인 메모리를 쓰지 않는 방법 = 가장 오른쪽 값부터 이동시키기!
        for (int i = len-1; i >= idx; i--) {
            arr[i+1] = arr[i];
        }
        arr[idx] = num;
        len++;
    }

    static void erase(int idx, int arr[]){
        len--;
        for(int i = idx; i < len; i++) {
            arr[i] = arr[i+1];
        }
        arr[len] = 0;
    }

    static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.print("\n\n");
    }

    static void insert_test(){
        System.out.println("***** insert_test *****");
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        len = 3;
        insert(3, 40, arr); // 10 20 30 40
        printArr(arr);
        insert(1, 50, arr); // 10 50 20 30 40
        printArr(arr);
        insert(0, 15, arr); // 15 10 50 20 30 40
        printArr(arr);
    }

    static void erase_test() {
        System.out.println("***** erase_test *****");
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 40;
        arr[3] = 30;
        arr[4] = 70;
        arr[5] = 20;

        len = 6;
        erase(4, arr); // 10 50 40 30 20
        printArr(arr);
        erase(1, arr); // 10 40 30 20
        printArr(arr);
        erase(3, arr); // 10 40 30
        printArr(arr);
    }

}
