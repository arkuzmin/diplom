package ru.arkuzmin.diplom.optimization.math.pareto;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Сообщение об относительной важности критериев.
 * @author ArKuzmin
 *
 */
public class RelativeImportanceMessage {
	
	private List<RelativeImportance> koeffs;
	
	public RelativeImportanceMessage (List<RelativeImportance> koeffs) {
		//initKoeffs(koeffs);
		this.koeffs = koeffs;
	}
	
	private void initKoeffs(List<RelativeImportance> koeffs) {
		Map<Integer, RelativeImportance> map = new HashMap<Integer, RelativeImportance>();
		for (RelativeImportance ri : koeffs) {
			if (map.get(ri.getI()) != null) {
				throw new IllegalArgumentException("Illegal relative koefficients!");
			}
			map.put(ri.getI(), ri);
		}
		
		SortedSet<Integer> ss = new TreeSet<Integer>();
		ss.addAll(map.keySet());
		
		this.koeffs = new LinkedList<RelativeImportance>();
		for (Integer key : ss) {
			this.koeffs.add(map.get(key));
		}
		Collections.reverse(this.koeffs);
	}
	
	/**
	 * Строим новый векторный критерий на основе сообщений об относительной важности.
	 * @param old
	 * @return
	 */
	public VectorCriteria getNewVCriteria(VectorCriteria old) {
		VectorCriteria newVC = old;
		
		for (RelativeImportance ri : koeffs) {
			int i = ri.getI();
			int j = ri.getJ();
			
			Criteria jCr = newVC.getCr(j);
			Criteria iCr = newVC.getCr(i);
			
			jCr.setValue(iCr.getValue()*ri.getWeight() + (1-ri.getWeight())*jCr.getValue());
		}
		
		return newVC;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (RelativeImportance ri : this.koeffs) {
			sb.append(ri).append("|");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
