package ru.arkuzmin.diplom.optimization.math.utils;

/**
 * Вспомогательный мат. методы.
 * @author ArKuzmin
 *
 */
public class MathUtils {

	/**
	 * Округление до целого.
	 * @param d
	 * @return
	 */
	public static int toInt(double d) {
		return (int) (d + 0.5);
	}
	
	/**
	 * Перевод в другую систему счисления.
	 * @param num
	 * @return
	 */
	public static String toOtherSystem(int num, int sys) {
		StringBuilder sb = new StringBuilder("");
		
		int r; 
		
		if (num < sys) {
			sb.append(num);
		}
		while (num >= sys) {
			r = num % sys;
			num = num / sys;
			sb.append(r);
			
			if (num < sys) {
				sb.append(num);
			}
		}
	
		return sb.reverse().toString();
	}
	
	
	public static String doubleToString(double koeff, int numbers) {
		String str = String.valueOf(koeff);
		int pos = str.indexOf(".");
		pos = pos > 0 ? pos : 0;
		int ind = pos + numbers > str.length() ? str.length() : pos + numbers;
		String result = str.substring(0, ind);
		return result;
	}
}
