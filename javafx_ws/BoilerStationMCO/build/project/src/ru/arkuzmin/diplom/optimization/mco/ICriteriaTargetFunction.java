package ru.arkuzmin.diplom.optimization.mco;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;

/**
 * Целевая функция критерия оптимизации.
 * @author ArKuzmin
 *
 */
public interface ICriteriaTargetFunction {
	
	/**
	 * Возвращает значение критерия при заданном наборе параметров.
	 * @param x
	 * @return
	 */
	public Criteria getValue(BoilerStation station);
}
