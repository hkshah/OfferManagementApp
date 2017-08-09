package com.crud.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return boolean
	 */
	@Override
	public void addProduct(ProductModel productModel) {
		sessionFactory.getCurrentSession().save(productModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return list of products
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> listAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from ProductModel").list();
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return ProductModel
	 */
	@Override
	public ProductModel getProductById(int id) {
		return (ProductModel) sessionFactory.getCurrentSession().get(ProductModel.class, new Integer(id));
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	public void updateProduct(ProductModel productModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(productModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(ProductModel.class, new Integer(id)));
	}
}
