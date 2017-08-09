package com.crud.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.offer.dao.OfferDAO;
import com.crud.offer.model.OfferModel;
import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
@Service("offerService")
public class OfferServiceImpl implements OfferService {

	private OfferDAO offerDAO;

	/**
	 * @author Hardik Shah
	 *
	 * @param offerDao
	 *            the offerDao to set
	 */
	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return boolean
	 */
	@Override
	@Transactional
	public void addOffer(OfferModel offerModel) {
		offerDAO.addOffer(offerModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return list of offers
	 */
	@Override
	@Transactional
	public List<OfferModel> listAllOffers() {
		return offerDAO.listAllOffers();
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return offer
	 */
	@Override
	@Transactional
	public OfferModel getOfferById(int id) {
		return offerDAO.getOfferById(id);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	@Transactional
	public void updateOffer(OfferModel offerModel) {
		offerDAO.updateOffer(offerModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	@Transactional
	public void deleteOffer(int id) {
		offerDAO.deleteOffer(id);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	@Transactional
	public List<String> getAllOffersForProduct(ProductModel productModel) {
		return offerDAO.getAllOffersForProduct(productModel);
	}
}
