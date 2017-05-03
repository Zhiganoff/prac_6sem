package test;

import DAO.impl.ClientDAO;
import DAO.impl.ProductDAO;
import model.Client;
import model.Purchase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class testClients {
    @Test
    public void testClientManagement() {
        ClientDAO clientDao = new ClientDAO();
        List<Client> clientsList = clientDao.getAll();

        int start_num = clientsList.size();
        System.out.println(clientsList.size() + " clients at start:");
//        printClientListInfo(clientsList);
//
//        Client sampleClient = new Client();
//        sampleClient.setAddress("New street");
//        sampleClient.setEmail("new@wow.com");
//        sampleClient.setFullname("Ivan Novikov");
//        sampleClient.setPhone(1234);
//
//        clientDao.addSample(sampleClient);
//
//        clientsList = clientDao.getAll();
//
//        Assert.assertEquals(clientsList.size(), start_num + 1);
//        System.out.println(clientsList.size() + " clients after adding");
//        printClientListInfo(clientsList);

    }

    private void printClientInfo(Client client) {
        System.out.println("id = " + client.getId() +
                           ", name = " + client.getFullname() +
                           ", address = " + client.getAddress() +
                           ", phone = " + client.getPhone() +
                           ", email = " + client.getEmail());
    }

    private void printClientListInfo(List<Client> clientsList) {
        for (Client sample : clientsList) {
            printClientInfo(sample);
        }
    }
}
