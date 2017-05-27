package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import service.ClientService;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired(required=true)
    @Qualifier(value="clientService")
    public void setClientService(ClientService ps){
        this.clientService = ps;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String listClients(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("listClients", this.clientService.listClients());
        return "client";
    }

    //For add and update client both
    @RequestMapping(value= "/client/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client p) {

        try {
            if (p.getId() == null){
                //new client, add it
                this.clientService.addClient(p);
            } else{
                //existing client, call update
                this.clientService.updateClient(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/clients";

    }

    @RequestMapping("/clients/remove/{id}")
    public String removeClient(@PathVariable("id") Long id){

        try {
            this.clientService.removeClient(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/clients";
    }

    @RequestMapping("/clients/edit/{id}")
    public String editClient(@PathVariable("id") Long id, Model model){
        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClients());
        return "client";
    }

}
