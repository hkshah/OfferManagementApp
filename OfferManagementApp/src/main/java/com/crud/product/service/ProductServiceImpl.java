package com.crud.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.product.dao.ProductDAO;
import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;

	/**
	 * @author Hardik Shah
	 *
	 * @param productDao
	 *            the productDao to set
	 */
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return boolean
	 */
	@Override
	@Transactional
	public void addProduct(ProductModel productModel) {
		productDAO.addProduct(productModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return list of products
	 */
	@Override
	@Transactional
	public List<ProductModel> listAllProducts() {
		return productDAO.listAllProducts();
	}

	/**
	 * @author Hardik Shah
	 *
	 * @return ProductModel
	 */
	@Override
	@Transactional
	public ProductModel getProductById(int id) {
		return productDAO.getProductById(id);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	@Transactional
	public void updateProduct(ProductModel productModel) {
		productDAO.updateProduct(productModel);
	}

	/**
	 * @author Hardik Shah
	 *
	 */
	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}
}
