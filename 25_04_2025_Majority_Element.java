class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int candidate = -1;
        int count = 0;
        
        for(int ele : arr){
            if(count == 0){
                count = 1;
                candidate = ele;
            } else if(ele == candidate){
                count++;
            } else{
                count--;
            }
        }
        
        count = 0;
        for(int ele : arr){
            if(ele == candidate){
                count++;
            }
        }
        
        if(count > arr.length/2){
            return candidate;
        }
        
        return -1;
        
    }
}