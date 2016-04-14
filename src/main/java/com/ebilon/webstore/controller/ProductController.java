package com.ebilon.webstore.controller;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ebilon.webstore.exception.NoProductFound;
import com.ebilon.webstore.exception.NoProductsFoundUnderCategoryException;
import com.ebilon.webstore.service.ProductService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.ebilon.webstore.domain.Product;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch" +
                "640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(10);
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @RequestMapping("/{category}")
    public String getProductsByCategoty(Model model,
                                        @PathVariable String category){
     List<Product> products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()){
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products",products);
        return "products";
    }
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId,
                                 Model model) {
        Product product =  productService.getProductById(productId);
        model.addAttribute("product",product);
        return "product";
    }
    @RequestMapping("/{category}/{price}")
    public String filterProducts(@PathVariable String category,@MatrixVariable(pathVar = "price")Map<String,List<String>> priceParams, @RequestParam String manufacturer,Model model ){
        model.addAttribute("products",productService.getProductsByManufacturer(category,priceParams,manufacturer));
        return "products";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct")Product newProduct,BindingResult result, HttpServletRequest request) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage  = newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage!=null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+"resources/images/"+ newProduct.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed",e);
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }
    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setAllowedFields("productId","name","unitPrice","description","manufacturer",
                "category","unitsInStock", "productImage","condition");
        binder.setDisallowedFields("unitsInOrder","discontinued");
    }
    @ExceptionHandler(NoProductFound.class)
    public ModelAndView handleError(HttpServletRequest req, NoProductFound exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}