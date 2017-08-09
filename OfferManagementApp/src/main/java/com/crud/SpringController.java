package com.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.offer.model.OfferModel;
import com.crud.offer.service.OfferService;
import com.crud.product.model.ProductModel;
import com.crud.product.service.ProductService;

/**
 * @author Hardik Shah
 *
 */
@Controller
public class SpringController {

	private ProductService productService;
	private OfferService offerService;

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired(required = true)
	@Qualifier(value = "offerService")
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	@RequestMapping(value = "/")
	public String homePage(Model model) {
		List<ProductModel> productList = productService.listAllProducts();
		List<String> offerList;
		for (ProductModel productModel : productList) {
			offerList = offerService.getAllOffersForProduct(productModel);
			productModel.setOfferList(offerList);
		}
		model.addAttribute("productList", productList);
		model.addAttribute("offerList", offerService.listAllOffers());
		return "home";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model) {
		model.addAttribute("product", new ProductModel());
		return "addproduct";
	}

	@RequestMapping(value = "/addOffer", method = RequestMethod.POST)
	public String addOffer(Model model) {
		OfferModel offerModel = new OfferModel();
		List<String> productList = new ArrayList<String>();
		for (ProductModel productModel : productService.listAllProducts()) {
			productList.add(productModel.getCode());
		}
		offerModel.setProductList(productList);
		model.addAttribute("offer", offerModel);
		return "addoffer";
	}

	@RequestMapping(value = "/add/product", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") ProductModel productModel) {
		productModel.setCreatedOn(new Date());
		productService.addProduct(productModel);
		return "redirect:/";
	}

	@RequestMapping(value = "/add/offer", method = RequestMethod.POST)
	public String insertOffer(@ModelAttribute("offer") OfferModel offerModel) {
		offerService.addOffer(offerModel);
		return "redirect:/";
	}

	@RequestMapping("/edit/product/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("productdetails", productService.getProductById(id));
		return "editproduct";
	}

	@RequestMapping("/edit/offer/{id}")
	public String editOffer(@PathVariable("id") int id, Model model) {
		OfferModel offerModel = offerService.getOfferById(id);
		List<String> productList = new ArrayList<String>();
		for (ProductModel productModel : productService.listAllProducts()) {
			productList.add(productModel.getCode());
		}
		offerModel.setProductList(productList);
		model.addAttribute("offerdetails", offerModel);
		return "editoffer";
	}

	@RequestMapping(value = "/update/product", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") ProductModel productModel) {
		productService.updateProduct(productModel);
		return "redirect:/";
	}

	@RequestMapping(value = "/update/offer", method = RequestMethod.POST)
	public String updateOffer(@ModelAttribute("offer") OfferModel offerModel) {
		offerService.updateOffer(offerModel);
		return "redirect:/";
	}

	@RequestMapping("/delete/product/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}

	@RequestMapping("/delete/offer/{id}")
	public String deleteOffer(@PathVariable("id") int id) {
		offerService.deleteOffer(id);
		return "redirect:/";
	}
}