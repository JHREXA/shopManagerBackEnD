
package shop.ShopManager.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ShopManager.model.Client;
import shop.ShopManager.repository.IClientRepository;

@Service
public class ClientService implements IClientService{

    @Autowired
    private IClientRepository clientRepo;
    
    @Override
    public void saveClient(Client newClient) {
        clientRepo.save(newClient);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClient(Long clientId) {
        return clientRepo.findById(clientId).orElse(null);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepo.deleteById(clientId);
    }

    @Override
    public void editClient(Long clientId, Client editedClient) {
        Client existingClient = this.getClient(clientId);
        
        if(existingClient != null){
            existingClient.setClientId(editedClient.getClientId());
            existingClient.setName(editedClient.getName());
            existingClient.setSurname(editedClient.getSurname());
            existingClient.setIdNumber(editedClient.getIdNumber());
            
            this.saveClient(existingClient);
        }
    }
    
}
