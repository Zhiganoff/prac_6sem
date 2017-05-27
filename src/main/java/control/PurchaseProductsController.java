package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.PurchaseProducts;
import service.ProductService;
import service.PurchaseProductsService;
import service.PurchaseService;

@Controller
public class PurchaseProductsController {

    private PurchaseProductsService purchaseProductsService;
    private ProductService productService;
    private PurchaseService purchaseService;


    @Autowired(required=true)
    @Qualifier(value="purchaseProductsService")
    public void setPurchaseProductsService(PurchaseProductsService ps){
        this.purchaseProductsService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService ps) {
        this.productService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="purchaseService")
    public void setPurchaseService(PurchaseService ps){
        this.purchaseService = ps;
    }

    @RequestMapping(value = "/purchaseProducts", method = RequestMethod.GET)
    public String listPurchaseProducts(Model model) {
        model.addAttribute("purchaseProducts", new PurchaseProducts());
        model.addAttribute("purchaseProductsBridge", new PurchaseProductsBridge());
        model.addAttribute("listPurchaseProducts", this.purchaseProductsService.listPurchaseProducts());
        return "purchaseProducts";
    }

    //For add and update purchaseProducts both
    @RequestMapping(value="/purchaseProducts/add", method = RequestMethod.POST)
    public String addPurchaseProducts(@ModelAttribute("purchaseProductsBridge") PurchaseProductsBridge ppb) {

        PurchaseProducts p = new PurchaseProducts();
        p.setPurchaseId(ppb.getPurchaseId());
        p.setPurchaseByPurchaseId(purchaseService.getPurchaseById(ppb.getPurchaseId()));
        p.setProductId(ppb.getProductId());
        p.setProductByProductId(productService.getProductById(ppb.getProductId()));
        p.setNum(ppb.getNum());

        try {
            if (p.getNum() != null){
                //new purchaseProducts, add it
                this.purchaseProductsService.addPurchaseProducts(p);
            } else{
                //existing purchaseProducts, call update
                this.purchaseProductsService.updatePurchaseProducts(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/purchaseProducts";

    }

    @RequestMapping("/purchaseProducts/remove/{id}")
    public String removePurchaseProducts(@PathVariable("id") Long id){

        try {
            this.purchaseProductsService.removePurchaseProducts(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/purchaseProducts";
    }

    @RequestMapping("/purchaseProducts/edit/{purchaseId}-{productId}")
    public String editPurchaseProducts(@PathVariable("purchaseId") Long purchaseId,
                                       @PathVariable("productId") Long productId,
                                       Model model){
        PurchaseProducts pp = this.purchaseProductsService.getPurchaseProductsByIds(purchaseId, productId);
        model.addAttribute("purchaseProducts", pp);
        model.addAttribute("purchaseProductsBridge", new PurchaseProductsBridge(pp));
        model.addAttribute("listPurchaseProducts", this.purchaseProductsService.listPurchaseProducts());
        return "purchaseProducts";
    }

}
