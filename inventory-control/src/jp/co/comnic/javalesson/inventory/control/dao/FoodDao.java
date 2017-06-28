package jp.co.comnic.javalesson.inventory.control.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.inventory.control.entity.Food;

public class FoodDao extends BaseDao {
	public FoodDao() throws DaoException {}
	private CriteriaQuery<Food> query = builder.createQuery(Food.class);
	private Root<Food> root = query.from(Food.class);
	
	public List<Food> findAll() {
		return super.findAll(query, root);
	}
	
	public Food findById(Integer id) {
		return super.findById(Food.class, id);
	}
}
