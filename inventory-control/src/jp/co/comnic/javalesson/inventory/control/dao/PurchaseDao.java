package jp.co.comnic.javalesson.inventory.control.dao;

import java.util.List;

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
	
//	public Purchase findById(Integer id) {
//		return super.findById(Purchase.class, id);
//	}

	@Override
	public void insert(Object entity) throws DaoException {
		// TODO Auto-generated method stub
		super.insert(entity);
	}
}