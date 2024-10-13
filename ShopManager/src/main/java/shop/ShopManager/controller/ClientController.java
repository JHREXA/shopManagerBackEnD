
package shop.ShopManager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.ShopManager.model.Client;
import shop.ShopManager.services.IClientService;

@RestController
public class ClientController {
    
    @Autowired
    private IClientService clientService;
    
    @PostMapping("/clients/create")
    public void saveClient(@RequestBody Client newClient){
        clientService.saveClient(newClient);
    }
    
    @GetMapping("/clients/get")
    @ResponseBody
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
    
    @GetMapping("/clients/getone/{clientId}")
    @ResponseBody
    public Client getClient(@PathVariable Long clientId){
        return clientService.getClient(clientId);
    }
    
    @DeleteMapping("/clients/delete/{clientId}")
    public void deleteClient(@PathVariable Long clientId){
        clientService.deleteClient(clientId);
    }
    
    @PutMapping("/clients/edit/{clientId}")
    public void editClient(@PathVariable Long clientId,
                           @RequestBody Client editedClient){
        clientService.editClient(clientId, editedClient);
    }
}
