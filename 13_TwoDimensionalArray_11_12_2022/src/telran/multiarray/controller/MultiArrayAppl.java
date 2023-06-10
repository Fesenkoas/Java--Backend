package telran.multiarray.controller;

public class MultiArrayAppl {

	public static void main(String[] args) {
		int [][] arr = new int [5][];
		arr[0] = new int[2];
		arr[1] = new int[4];
		arr[2] = new int[1];
		arr[3] = new int[2];
		arr[4] = new int[3];
		arr[1][3] = 10;
		System.out.println(arr[1][3]);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
