class main {
    public int peakIndexInMountainArray(int[] arr) {
        
         int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            
// It means that till array is in increasing order so we have to check in right    
// side, we have to find an element which is greater from both sides
            if (arr[mi] < arr[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
        
//         --- my Solution --
        
//         int lo = 0, hi = arr.length-1;
//         while(lo <= hi){
//             int mid = (lo + hi)/2;
            
//             if((mid > 0 && arr[mid] > arr[mid-1]) && (mid < arr.length-1 && arr[mid] > arr[mid+1])){
//                 return mid;
//             }
//             else if(mid > 0 && arr[mid] > arr[mid-1]){
//                 lo = mid + 1;
//             }
//             else{
//                 hi = mid - 1;
//             }
//         }
//         return lo+1;
    }
}