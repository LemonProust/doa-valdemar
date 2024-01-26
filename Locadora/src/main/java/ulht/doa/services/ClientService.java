package ulht.doa.services;

import ulht.doa.DTO.ClientDTO;
import ulht.doa.entities.ClientEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientService {



    // Validar CPF
    public boolean verifyCPF(String cpf){
        for (int i = 0; i <cpf.length(); i++){
            if(!Character.isDigit(cpf.charAt(i))){
                if(!(i == 3 || i ==7 || i == 11)){
                    return false;
                }
            }
        }
    }

    // Verify Data
    public boolean verifyData(String data){
        for (int i = 0; i <data.length(); i++){
            if(!Character.isDigit(data.charAt(i))){
                if(!(i == 2 || i == 5)){
                    return false;
                }
            }
        }
    }

    // Validar cadastro
    public boolean createClient(ClientDTO clientDTO){

        if (clientDTO.getName() != null && clientDTO.getName().length()> 0 && verifyCPF(clientDTO.getCpf()) && clientDTO.getEmail() != null && clientDTO.getEmail().length() > 0 && clientDTO.getAddress() != null && clientDTO.getAddress().length() > 0){
            SimpleDateFormat formate = new SimpleFormat("dd/MM/yyyy");
            Date data = formate.parse(clientDTO.getBirthDate());

            ClientEntity clientEntity = new ClientEntity(clientDTO);
            clientEntity.createClient(clientDTO);
            return true;
        }
        return false;
    }
}
