import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // 정렬이 되어있어야 이분 탐색 가능
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int find = 7;
        int count = 0;

        while (start < end){
            int mid = (start + end) / 2;
            if (arr[mid] == find){
                System.out.println("find 값의 인덱스 위치: " + mid);
                System.out.println(count + "번 만에 찾았습니다.");
                return;
            }
            if (find > arr[mid]){
                start = mid + 1;
            }
            if (find < arr[mid]){
                end = mid - 1;
            }
            count++;
        }
        System.out.println("찾고자 하는 값이 없습니다.");
    }
}
