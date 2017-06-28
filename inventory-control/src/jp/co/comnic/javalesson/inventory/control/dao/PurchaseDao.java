package jp.co.comnic.javalesson.inventory.control.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.inventory.control.entity.Purchase;

/**
 * <p>部署テーブルのCRUD操作を実装するDAOクラス</p>
 * 
 */
public class PurchaseDao extends BaseDao {
	
	public PurchaseDao() throws DaoException {}
	
	private CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
	private Root<Purchase> root = query.from(Purchase.class);
	
	public List<Purchase> findAll() {
		return super.findAll(query, root);
	}
	
//	public Purchase findById(String id) {
//		return super.findById(Purchase.class, id);
//	}
	
//	public Purchase ListDisplay(String email) {
//
//		Purchase purchase = null;
//		
//		try {
//			// SELECT * FROM ACCOUNT WHERE email = [email]
//			query.select(root)
//				 .where(builder.equal(root.get("email"), email));
//
//		purchase = em.createQuery(query).getSingleResult();
//			
//		} catch (NoResultException e) {
//			
//		}
//		
//		return purchase;
//	}
}