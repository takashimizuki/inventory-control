package jp.co.comnic.javalesson.inventory.control.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.exceptions.DatabaseException;

/**
 * <p>DAO�N���X�̋��ʂƂȂ���N���X�B</p>

 */
public class BaseDao {

	protected EntityManager em = Persistence.createEntityManagerFactory("inventory-control").createEntityManager();
	protected EntityTransaction tx = em.getTransaction();
	protected CriteriaBuilder builder = em.getCriteriaBuilder();
	
	/**
	 * <p>�S������</p>
	 * 
	 * @param query
	 * @param root
	 * @return �������ʂ̃G���e�B�e�B�E�I�u�W�F�N�g���i�[���ꂽ���X�g
	 */
	protected <T> List<T> findAll(CriteriaQuery<T> query, Root<T> root) {
		return em.createQuery(query.select(root)).getResultList();
	}
	
	/**
	 * <p>��L�[����</p>
	 * 
	 * @param entityClass
	 * @param id
	 * @return �������ʂ̃G���e�B�e�B�E�I�u�W�F�N�g
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return em.find(entityClass, id);
	}
		
	/**
	 * <p>�V�K���R�[�h�̑}��</p>
	 * 
	 * @param entity
	 */
	public void insert(Object entity) throws DaoException {

		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * <p>�������R�[�h�̍폜</p>
	 * 
	 * @param entityClass �폜���郌�R�[�h�ɑΉ�����G���e�B�e�B�E�N���X
	 * @param id �폜���郌�R�[�h��ID
	 */
	public <T> void remove(Class<T> entityClass, Serializable id) throws DaoException {
		// �G���e�B�e�B�E�I�u�W�F�N�g���擾���č폜
		remove(em.find(entityClass, id));
	}
	
	/**
	 * <p>�������R�[�h�̍폜</p>
	 * 
	 * @param entity �폜����G���e�B�e�B�E�I�u�W�F�N�g
	 */
	public void remove(Object entity) throws DaoException {
		try {
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public void update(Object entity) throws DaoException {
		try {
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}