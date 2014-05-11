package ru.arkuzmin.diplom.optimization.fx;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Вспомогательные методы для графиков.
 * @author ArKuzmin
 *
 */
@Deprecated
public class DatasetUtils {

	/**
	 * Возвращает набор данных для Spider - диаграммы.
	 * @param list
	 * @return
	 */
	public static CategoryDataset createSpiderDataset(List<VectorCriteria> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		
		for (VectorCriteria vc : list) {
			List<Criteria> crl = vc.getVector();
			for (Criteria cr : crl) {
				dcd.addValue(cr.getValue(), "test" + (new Date()).getTime() + (new Random()).nextDouble(), cr.getName());
			}
		}	
		
		return dcd;
	}
}
