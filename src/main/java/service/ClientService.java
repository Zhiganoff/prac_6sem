package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.ClientDAO;
import model.Client;

@Service
public class ClientService {

    private ClientDAO clientDAO;

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Transactional
    public void addClient(Client p) {
        this.clientDAO.addSample(p);
    }

    @Transactional
    public void updateClient(Client p) {
        this.clientDAO.updateSample(p);
    }

    @Transactional
    public List<Client> listClients() {
        return this.clientDAO.listAll();
    }

    @Transactional
    public Client getClientById(Long id) {
        return this.clientDAO.getById(id);
    }

    @Transactional
    public void removeClient(Long id) {
        this.clientDAO.removeById(id);
    }

}
