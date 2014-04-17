package ru.arkuzmin.diplom.optimization.math.pareto;

/**
 * Коэффициент относительной важности критериев.
 * @author ArKuzmin
 *
 */
public class RelativeImportance {

	private double weight;
	
	private int i;
	private int j;
	
	/**
	 * Конструктор.
	 * @param weight - коэффициент относительной важности i-го критерия по сравнению с j-м.
	 * @param i
	 * @param j
	 */
	public RelativeImportance (double weight, int i, int j) {
		this.weight = weight;
		this.i = i;
		this.j = j;
	}

	public double getWeight() {
		return weight;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	@Override
	public String toString() {
		return "[" + i + "] > [" + j + "] : " + weight;
	}
}
