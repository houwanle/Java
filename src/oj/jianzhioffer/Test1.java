package test;
/* 二维数组中的查找
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */
public class Test1 {
	public static void main(String[] args) {
		int target = 8;
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(new Solution().find(target, array));
	}
}

class Solution {
	public boolean find(int target, int[][] array) {
		boolean found = false;
		int lie = array[0].length;
		int hang = array.length;
		int column = lie - 1;
		int row = 0;
		while (hang > row && column >= 0) {
			int value = array[row][column];// 0,2 3
			if (target > value) {
				row++;
			} else if (target < value) {
				column--;
			} else {
				found = true;
				break;
			}
		}
		return found;
	}
}
