package utils;

public class Util {
	public static void swap(int[] list, int idx1, int idx2)
	{
		int tmp;
		
		tmp = list[idx1];
		list[idx1] = list[idx2];
		list[idx2] = tmp;
	}
}
