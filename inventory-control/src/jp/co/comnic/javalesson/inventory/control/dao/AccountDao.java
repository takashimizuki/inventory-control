package jp.co.comnic.javalesson.inventory.control.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.inventory.control.entity.Account;
/**
 * <p>�����e�[�u����CRUD�������������DAO�N���X</p>
 */
public class AccountDao extends BaseDao {
	
	public AccountDao() throws DaoException {}
	private CriteriaQuery<Account> query = builder.createQuery(Account.class);
	private Root<Account> root = query.from(Account.class);
	
	public List<Account> findAll() {
		return super.findAll(query, root);
	}
	
	public Account findById(String id) {
		return super.findById(Account.class, id);
	}
	
	public Account loginAuthenticate(String email, String password)  {

		Account account = null;
		
		try {
			// Criteria API���g�p���Ĉȉ�SQL�𐶐�����
			// SELECT * FROM ACCOUNT WHERE email = [email] AND password = [password]
			query.select(root)
				 .where(builder.equal(root.get("email"), email), 
						builder.equal(root.get("password"), password));
			
			// SQL�����s���Č��ʂ�P��̃G���e�B�e�B�E�I�u�W�F�N�g�Ƃ��Ď擾
			account = em.createQuery(query).getSingleResult();
			
		} catch (NoResultException e) {
			// getSingleResult���\�b�h�͌��ʂ��Ȃ������ꍇ��NoResultException��throw
			// ���邽�߁A���̗�O�����͕s�v
		}
		
		return account;
	}
}

