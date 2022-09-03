class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        int[] indexArr = new int[len];
        for(int i = 0; i < len; i++){
            indexArr[i] = i;
        }
        int[] ans = new int[len];
        int[] tmp = new int[len];
        mergeSort(nums, tmp, 0, nums.length - 1, indexArr, ans);
        for(int num : ans){
            result.add(num);
        }
        return result;
    }

    public void mergeSort(int[] nums, int[] tmp, int start, int end, int[] indexArr, int[] ans){
        if(start >= end){
            return;
        }
        mergeSort(nums, tmp, start, (start + end) / 2, indexArr, ans);
        mergeSort(nums, tmp, (start + end) / 2 + 1, end, indexArr, ans);
        merge(nums, tmp, start, end, indexArr, ans);
    }

    public void merge(int[] nums, int[] tmp, int start, int end, int[] indexArr, int[] ans){
        int left = start;
        int mid = start + (end - start) / 2;
        int right = mid + 1;
        int index = left;
        while(left <= mid && right <= end){
            if(nums[indexArr[left]] <= nums[indexArr[right]]){
                //reversed, large -> small
                tmp[index++] = indexArr[right++];
            }else{
                ans[indexArr[left]] += end - right + 1;
                tmp[index++] = indexArr[left++];
            }
        }
        
        while(left <= mid){
            tmp[index++] = indexArr[left++];
        }
        while(right <= end){
            tmp[index++] = indexArr[right++];
        }
        for(int i = start; i <= end; i++){
            indexArr[i] = tmp[i];
        }
    }

}
