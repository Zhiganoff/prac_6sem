package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Purchase;
import service.ClientService;
import service.PurchaseService;

@Controller
public class PurchaseController {

    private PurchaseService purchaseService;
    private ClientService clientService;

    @Autowired(required=true)
    @Qualifier(value="purchaseService")
    public void setPurchaseService(PurchaseService ps){
        this.purchaseService = ps;
    }

    @Autowired(required=true)
    @Qualifier(value="clientService")
    public void setClientService(ClientService ps){
        this.clientService = ps;
    }

    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public String listPurchases(Model model) {
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("purchaseBridge", new PurchaseBridge());
        model.addAttribute("listPurchases", this.purchaseService.listPurchases());
        return "purchase";
    }

    //For add and update purchase both
    @RequestMapping(value= "/purchase/add", method = RequestMethod.POST)
    public String addPurchase(@ModelAttribute("purchaseBridge") PurchaseBridge pb) {
        Purchase p = new Purchase();
        p.setId(pb.getId());
        p.setDate(pb.getDate());
        p.setAddress(pb.getAddress());
        p.setStatus(pb.getStatus());
        p.setDeliveryMethod(pb.getDeliveryMethod());
        p.setPaymentMethod(pb.getPaymentMethod());
        p.setClientByClientId(clientService.getClientById(pb.getClientId()));

        try {
            if (p.getId() == null){
                //new purchase, add it
                this.purchaseService.addPurchase(p);
            }else{
                //existing purchase, call update
                this.purchaseService.updatePurchase(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/purchases";

    }

    @RequestMapping("/purchases/remove/{id}")
    public String removePurchase(@PathVariable("id") Long id){

        try {
            this.purchaseService.removePurchase(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/purchases";
    }

    @RequestMapping("/purchases/edit/{id}")
    public String editPurchase(@PathVariable("id") Long id, Model model){
        Purchase p = this.purchaseService.getPurchaseById(id);
        model.addAttribute("purchase", p);
        model.addAttribute("purchaseBridge", new PurchaseBridge(p));
        model.addAttribute("listPurchases", this.purchaseService.listPurchases());
        return "purchase";
    }

}
