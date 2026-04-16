package com.app.clientes.service;

import com.app.clientes.model.Cliente;
import com.app.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // LISTAR TODOS
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // BUSCAR POR ID
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // CRIAR CLIENTE
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // ATUALIZAR CLIENTE
    public Cliente atualizar(Long id, Cliente dadosAtualizados) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        if (clienteOpt.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Cliente cliente = clienteOpt.get();

        cliente.setNome(dadosAtualizados.getNome());
        cliente.setEmail(dadosAtualizados.getEmail());
        cliente.setTelefone(dadosAtualizados.getTelefone());

        return clienteRepository.save(cliente);
    }

    // DELETAR CLIENTE
    public void deletar(Long id) {

        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
    }
}