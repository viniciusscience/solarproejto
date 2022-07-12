package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.ClienteModel;
import br.com.triersistemas.solar.repository.ClienteRepository;
import br.com.triersistemas.solar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> consultar() {
        return clienteRepository.findAll().stream().map(ClienteModel::new).collect(Collectors.toList());
    }

    @Override
    public ClienteModel consultar(UUID id) {
        return new ClienteModel(this.buscarClienteID(id));
    }

    @Override
    public ClienteModel cadastrar(ClienteModel model) {
        var cliente = new Cliente(model);
       return  new ClienteModel(clienteRepository.save(cliente));

    }

    @Override
    public ClienteModel alterar(ClienteModel model) {
        Cliente cliente = this.buscarClienteID(model.getId());
        cliente.editar(model.getNome(), model.getAniver(), model.getCpf(), model.getEmail());
        return new ClienteModel(this.clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel remover(UUID id) {
        Cliente cliente = this.buscarClienteID(id);
        clienteRepository.delete(cliente);
        return new ClienteModel(cliente);
    }

    private Cliente buscarClienteID(UUID id){
     return  clienteRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
