package com.crud.offer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.crud.offer.model.OfferModel;
import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
@Repository
public class OfferDAOImpl implements OfferDAO {

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
	public void addOffer(OfferModel offerModel) {
		sessionFactory.getCurrentSession().save(offerModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return list of offers
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<OfferModel> listAllOffers() {
		return sessionFactory.getCurrentSession().createQuery("from OfferModel").list();
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return offer
	 */
	@Override
	public OfferModel getOfferById(int id) {
		return (OfferModel) sessionFactory.getCurrentSession().get(OfferModel.class, new Integer(id));
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	public void updateOffer(OfferModel offerModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(offerModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	public void deleteOffer(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(OfferModel.class, new Integer(id)));
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllOffersForProduct(ProductModel productModel) {
		String query = "select code from OfferModel where (product = '" + productModel.getCode()
				+ "' or product = 'All' ) and startDate <= '" + productModel.getCreatedOn() + "' and endDate >= '"
				+ productModel.getCreatedOn() + "'";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}