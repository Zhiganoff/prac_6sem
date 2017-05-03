package guest;
 
import javax.servlet.http.HttpServletRequest;

import DAO.impl.ClientDAO;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GuestController {
 
    @Autowired
    private ClientDAO clientDao;
 
    @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {

        List<Client> lst = clientDao.getAll();
        int sz = lst.size();
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "clientList", lst);
    }
}