import DAO.ClientDAO;
import models.Client;

/**
 * Created by zhigan on 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ClientDAO dao = new ClientDAO();
//        Client entity = new Client();
        try {
//            dao.addClient(entity);
            System.out.print("before\n");
            Client get_client = dao.getClient(1);
            System.out.print("after\n");
            System.out.print(get_client.getAddress());
        }
        catch (Throwable ex) {
        }
    }
}
