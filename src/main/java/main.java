import DAO.impl.ClientDAO;
import model.Client;

import java.util.List;

/**
 * Created by zhigan on 03.05.17.
 */
import model.Client;
import DAO.impl.ClientDAO;

import java.util.List;

public class main {
    public static void main(String[] args) {
        ClientDAO sampleClient = new ClientDAO();
        
        List<Client> clientsList = sampleClient.getAll();
        System.out.println("clientsList.size() = " + clientsList.size());

        for (Client cur : clientsList) {
            System.out.println(cur.getAddress());
        }
    }
}
