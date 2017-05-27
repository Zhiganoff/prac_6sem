package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Producer;
import service.ProducerService;

@Controller
public class ProducerController {

    private ProducerService producerService;

    @Autowired(required=true)
    @Qualifier(value="producerService")
    public void setProducerService(ProducerService ps){
        this.producerService = ps;
    }

    @RequestMapping(value = "/producers", method = RequestMethod.GET)
    public String listProducers(Model model) {
        model.addAttribute("producer", new Producer());
        model.addAttribute("listProducers", this.producerService.listProducers());
        return "producer";
    }

    //For add and update producer both
    @RequestMapping(value= "/producer/add", method = RequestMethod.POST)
    public String addProducer(@ModelAttribute("producer") Producer p) {

        try {
            if (p.getId() == null){
                //new producer, add it
                this.producerService.addProducer(p);
            }else{
                //existing producer, call update
                this.producerService.updateProducer(p);
            }
        } catch (Exception e) {
            return "error";
        }

        return "redirect:/producers";

    }

    @RequestMapping("/producers/remove/{id}")
    public String removeProducer(@PathVariable("id") Long id){

        this.producerService.removeProducer(id);
        return "redirect:/producers";
    }

    @RequestMapping("/producers/edit/{id}")
    public String editProducer(@PathVariable("id") Long id, Model model){
        model.addAttribute("producer", this.producerService.getProducerById(id));
        model.addAttribute("listProducers", this.producerService.listProducers());
        return "producer";
    }

}
