package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.ProducerDAO;
import model.Producer;

@Service
public class ProducerService {

    private ProducerDAO producerDAO;

    public void setProducerDAO(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @Transactional
    public void addProducer(Producer p) {
        this.producerDAO.addSample(p);
    }

    @Transactional
    public void updateProducer(Producer p) {
        this.producerDAO.updateSample(p);
    }

    @Transactional
    public List<Producer> listProducers() {
        return this.producerDAO.listAll();
    }

    @Transactional
    public Producer getProducerById(Long id) {
        return this.producerDAO.getById(id);
    }

    @Transactional
    public void removeProducer(Long id) {
        this.producerDAO.removeById(id);
    }

}
