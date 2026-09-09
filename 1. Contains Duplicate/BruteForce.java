import java.util.*;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array size: ");
		int n = sc.nextInt();
		System.out.println("Enter elements in array: ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i] = sc.nextInt();
		}
		Solution s = new Solution();
		boolean result = s.containsDuplicate(arr);
		System.out.print("The array contains duplcate: "+ result);
	}
}

class Solution 
{
    public boolean containsDuplicate(int[] arr)
    {
        for(int i=0;i<arr.length - 1;i++)
        {
            for(int j=i+ 1;j<arr.length;j++)
            {
                if(arr[i] == arr[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
