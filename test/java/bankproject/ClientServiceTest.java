package bankproject;

import bankproject.clientservice.ClientService;
import org.junit.jupiter.api.Test;

class ClientServiceTest {

    @Test
    void shouldNotValidateEmptyName() {
        //given
        ClientService clientService = new ClientService();

        //when
        Client client = new Client();
        client.setFirstName("");
        client.setLastName("Najman");
        clientService.newClient(client);
        Integer IdClient= client.getClientId();

        //then

        IdClient = null;

    }
}