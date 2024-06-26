package com.example.agenciaviagens.service;

import com.example.agenciaviagens.model.Destino;
import com.example.agenciaviagens.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public Destino salvarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public List<Destino> listarDestinos() {
        return destinoRepository.findAll();
    }

    public List<Destino> pesquisarPorNome(String nome) {
        return destinoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Destino> pesquisarPorLocalizacao(String localizacao) {
        return destinoRepository.findByLocalizacaoContainingIgnoreCase(localizacao);
    }

    public Optional<Destino> obterDestinoPorId(Long id) {
        return destinoRepository.findById(id);
    }

    public void excluirDestino(Long id) {
        destinoRepository.deleteById(id);
    }

    public Destino avaliarDestino(Long id, double nota) {
        Optional<Destino> destinoOpt = destinoRepository.findById(id);
        if (destinoOpt.isPresent()) {
            Destino destino = destinoOpt.get();
            double novaAvaliacaoMedia = ((destino.getAvaliacaoMedia() * destino.getNumeroAvaliacoes()) + nota) / (destino.getNumeroAvaliacoes() + 1);
            destino.setAvaliacaoMedia(novaAvaliacaoMedia);
            destino.setNumeroAvaliacoes(destino.getNumeroAvaliacoes() + 1);
            return destinoRepository.save(destino);
        }
        return null;
    }
}
