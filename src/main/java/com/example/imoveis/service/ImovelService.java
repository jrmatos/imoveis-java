package com.example.imoveis.service;

import com.example.imoveis.dto.CriarImovelDTO;
import com.example.imoveis.exceptions.ImovelNotFoundException;
import com.example.imoveis.model.Imovel;
import com.example.imoveis.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {
    private final ImovelRepository imovelRepository;

    // poderia usar @RequiredArgsConstructor
    ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public List<Imovel> findAll(String tipo) {
        if (tipo != null) return imovelRepository.findByTipo(tipo);

        return imovelRepository.findAll();
    }

    public Imovel create(CriarImovelDTO criarImovelDTO) {
        Imovel imovelToSave = criarImovelDTO.toImovel();
        return imovelRepository.save(imovelToSave);
    }

    public Imovel findById(Integer id) throws ImovelNotFoundException {
        Optional<Imovel> findResult = imovelRepository.findById(id);

        if (findResult.isPresent()) {
            return findResult.get();
        }

        throw new ImovelNotFoundException("Imovel nao encontrado");
    }
}
