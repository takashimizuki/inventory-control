package jp.co.comnic.javalesson.inventory.control.dao;


/**
 * <p>DAO�w�Ŕ���������O���܂Ƃ߂�J�X�^���̗�O�N���X�B��ʑw�ɓ`�d����B</p>
 * 
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException(Exception e) {
		super("an exception occur in the DAO layer.", e);
	}
}
