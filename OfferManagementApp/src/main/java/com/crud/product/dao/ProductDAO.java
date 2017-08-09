package com.crud.product.dao;

import java.util.List;

import com.crud.product.model.ProductModel;

/**
 * @author Hardik Shah
 *
 */
public interface ProductDAO {

	void addProduct(ProductModel productModel);

	List<ProductModel> listAllProducts();

	ProductModel getProductById(int id);

	void updateProduct(ProductModel productModel);

	void deleteProduct(int id);
}
