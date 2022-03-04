package sheet4;

public class PriorityQueueDist {
    //node struct - [ node, dist from source, prec node]
    private Integer[][] arr;

    public void sort() {
        int n = arr.length;

        for (int i = n / 2; i > -1; i--) {
            heapify(arr, n, i);
        }

        for (int i = n-1; i > 0; i--) {
            int temp = arr[0][1];
            arr[0][1] = arr[i][1];
            arr[i][1] = temp;

            heapify(arr, i, 0);
        }

    }

    public boolean isVisited(Integer node) {
        return false;
    }

    public void heapify(Integer[][] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l][1] > arr[largest][1]) {
            largest = l;
        }

        if (r < n && arr[r][1] > arr[largest][1]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i][1];
            arr[i][1] = arr[largest][1];
            arr[largest][1] = swap;

            heapify(arr, n, largest);
        }

    }

    public Integer extractMin() {
        sort();
        if (!isVisited(arr[0][0])) {
            return arr[0][0];
        } else {
            int i = 1;
            while (isVisited(arr[i][0])) {
                i++;
            }
            return arr[i][0];
        }
    }
}
