import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,7};
        int len = arr.length;
        // 최초 힙구성: n/2번만큼 heapify
        for (int i = len / 2 - 1; i >= 0; i--){
            heapify(arr, len, i);
        }
        // 최초 힙 구성 이후에 root 노드와 마지막 노드를 change
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 강사님이 짠 코드
    static void heapify(int[] arr, int len, int root){
//      부모 노드를 자식 노드(left, right)와 비교했을 때 자식이 더 큰 경우에 change
//      자식 노드가 arr.length - 1보다 크면 반환 (자식 노드 유무 확인)
        int max_index = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left < len && arr[max_index] < arr[left]){
            max_index = left;
        }
        if (right < len && arr[max_index] < arr[right]){
            max_index = right;
        }
        if (max_index != root){
            swap(arr, root, max_index);
            heapify(arr, len, max_index);
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void heapSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
}