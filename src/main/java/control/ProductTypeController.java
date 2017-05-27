package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.ProductType;
import service.ProductTypeService;

@Controller
public class ProductTypeController {

    private ProductTypeService productTypeService;

    @Autowired(required=true)
    @Qualifier(value="productTypeService")
    public void setProductTypeService(ProductTypeService ps){
        this.productTypeService = ps;
    }

    @RequestMapping(value = "/productTypes", method = RequestMethod.GET)
    public String listProductTypes(Model model) {
        model.addAttribute("productType", new ProductType());
        model.addAttribute("listProductTypes", this.productTypeService.listProductTypes());
        return "productType";
    }

    //For add and update productType both
    @RequestMapping(value= "/productType/add", method = RequestMethod.POST)
    public String addProductType(@ModelAttribute("productType") ProductType p) {

        try {
            if (p.getId() == null){
                //new productType, add it
                this.productTypeService.addProductType(p);
            }else{
                //existing productType, call update
                this.productTypeService.updateProductType(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/productTypes";

    }

    @RequestMapping("/productTypes/remove/{id}")
    public String removeProductType(@PathVariable("id") Long id){

        try {
            this.productTypeService.removeProductType(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/productTypes";
    }

    @RequestMapping("/productTypes/edit/{id}")
    public String editProductType(@PathVariable("id") Long id, Model model){
        model.addAttribute("productType", this.productTypeService.getProductTypeById(id));
        model.addAttribute("listProductTypes", this.productTypeService.listProductTypes());
        return "productType";
    }

}
