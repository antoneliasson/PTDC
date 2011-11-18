
public class Sortering {
	public static void insertionSort(int[] v) {
		for (int i = 1; i < v.length; i++) {
			int temp = v[i];
			int j = i;
			while (j > 0 && temp < v[j-1]) {
				v[j] = v[j-1];
				j--;
			}
			v[j] = temp;
		}
	}
	public static void main(String[] args) {
		int[] list = {4, 7, 2, 5, 9, 0, 3, 6, 8, 1};
		
		System.out.println("Osorterad lista: ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		
		long begin = System.nanoTime();
		insertionSort(list);
		long end = System.nanoTime();
		
		System.out.println("\nEfter sortering: ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("\nTid: " + (end - begin));
	}
}
