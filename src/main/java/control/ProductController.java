package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Product;
import service.ProducerService;
import service.ProductService;
import service.ProductTypeService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ProductController {

    private ProductService productService;
    private ProducerService producerService;
    private ProductTypeService productTypeService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService ps) {
        this.productService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="producerService")
    public void setProducerService(ProducerService ps){
        this.producerService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="productTypeService")
    public void setProductTypeService(ProductTypeService ps){
        this.productTypeService = ps;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
//        model.addAttribute("product", new Product());
        model.addAttribute("productBridge", new ProductBridge());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

    //For add and update product both
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productBridge") ProductBridge pb) {
        Product p = new Product();
        p.setId(pb.getId());
        p.setName(pb.getName());
        p.setCost(pb.getCost());
        p.setNum(pb.getNum());
        p.setSize(pb.getSize());
        p.setProperties(pb.getProperties());
        p.setProducerByProducerId(producerService.getProducerById(pb.getProducerId()));
        p.setProductTypeByProducttypeId(productTypeService.getProductTypeById(pb.getProducttypeId()));

        try {
            if (p.getId() == null) {
                //new product, add it
                this.productService.addProduct(p);
            } else {
                //existing product, call update
                this.productService.updateProduct(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/products";

    }

    @RequestMapping("/products/remove/{id}")
    public String removeProduct(@PathVariable("id") Long id) {
        try {
            this.productService.removeProduct(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/products";
    }

    @RequestMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product p = this.productService.getProductById(id);
        model.addAttribute("product", p);
        model.addAttribute("productBridge", new ProductBridge(p));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

}