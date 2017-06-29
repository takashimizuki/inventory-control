package jp.co.comnic.javalesson.inventory.control.dao;

import java.util.List;

import javax.persistence.NoResultException;
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
	
	public Food findByName(String str) throws DaoException{
		
		Food fd;
		
		try {
			// Criteria API
			// SELECT * FROM PURCHASE WHERE name = [str]
			query.select(root)
				 .where(builder.equal(root.get("name"), str));
			
			
			fd = em.createQuery(query).getSingleResult();
			
			
		} catch (NoResultException e) {
			
			fd = new Food(str);
			new BaseDao().insert(fd);
		}
		
		return fd;
	}
}
