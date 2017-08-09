package com.crud.offer.dao;

import java.util.List;

import com.crud.offer.model.OfferModel;
import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
public interface OfferDAO {

	void addOffer(OfferModel offerModel);

	List<OfferModel> listAllOffers();

	List<String> getAllOffersForProduct(ProductModel productModel);

	OfferModel getOfferById(int id);

	void updateOffer(OfferModel offerModel);

	void deleteOffer(int id);
}
