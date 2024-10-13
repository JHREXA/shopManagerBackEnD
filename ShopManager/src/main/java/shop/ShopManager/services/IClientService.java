
package shop.ShopManager.services;

import java.util.List;
import shop.ShopManager.model.Client;


public interface IClientService {
    
    // Method for creating a client:
    public void saveClient(Client newClient);
    
    // Method for getting all the clients:
    public List<Client> getAllClients();
    
    // Method for getting one client through its id:
    public Client getClient(Long clientId);
    
    // Method for deleting one client:
    public void deleteClient(Long clientId);
    
    // Method for editing one client:
    public void editClient(Long clientId, Client editedClient);
}
