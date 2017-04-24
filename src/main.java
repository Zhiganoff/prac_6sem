import model.Client;
import DAO.impl.ClientDAO;
import util.HibernateUtil;

import java.util.List;

public class main {
    public static void main(String[] args) {
        ClientDAO sampleClient = new ClientDAO();
        List<Client> clientsList = sampleClient.getAll();

        for (Client cur : clientsList) {
            System.out.println(cur.getAddress());
        }

        HibernateUtil.closeEMF();
    }
}
