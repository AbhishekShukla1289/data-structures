
// Brute Force Time complexity: O(N^2), memory: O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++ )
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[j] == nums[i])
                    return true;
            }
        }
        return false;
    }
	


// By sorting the array first , used Arrays.sort Time complexity: O(N lg N), memory: O(1)

    public boolean containsDuplicate(int[] nums) {
        
        Arrays.sort(nums); // Arrays.sort() uses Merge sort or Tim sort internally
        for(int i = 1; i < nums.length; i++ )
        {
           if(nums[i] == nums[i-1])
               return true;
        }
        return false;
    }

//Using HashSet Time complexity: O(N), memory: O(N)

public boolean containsDuplicate(int[] nums) {

    final Set<Integer> distinct = new HashSet<Integer>(); //final means we don't want distinct point to another Set instance. But the content of distinct can be modified.
    for(int num : nums) {
        if(distinct.contains(num)) {
            return true;
        }
        distinct.add(num);
    }
    return false;
}

//Using Streams

    public boolean containsDuplicate(int[] nums) {

        return nums.length != Arrays.stream(nums)
                .distinct()
                .count();
    }
	
}