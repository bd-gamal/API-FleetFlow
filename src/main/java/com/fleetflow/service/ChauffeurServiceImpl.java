package com.fleetflow.service;

import com.fleetflow.dto.ChauffeurRequestDTO;
import com.fleetflow.dto.ChauffeurResponseDTO;
import com.fleetflow.entity.Chauffeur;
import com.fleetflow.mapper.ChauffeurMapper;
import com.fleetflow.repository.ChauffeurRepository;
import com.fleetflow.repository.LivraisonRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChauffeurServiceImpl implements ChauffeurService{

    private final ChauffeurRepository chauffeurRepository;
    private final ChauffeurMapper chauffeurMapper;
    private final LivraisonRepo livraisonRepo;


    @Override
    @Transactional
    public ChauffeurResponseDTO ajouterChauffeur(ChauffeurRequestDTO requestDTO) {
        Chauffeur chauffeur = chauffeurMapper.toEntity(requestDTO);
        chauffeur.setDisponible(true);
        Chauffeur savedChauffeur = chauffeurRepository.save(chauffeur);
        return chauffeurMapper.toDto(savedChauffeur);
    }

    @Override
    @Transactional
    public ChauffeurResponseDTO modifierChauffeur(Long id, ChauffeurRequestDTO requestDTO) {
        Chauffeur chauffeur = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable avec l'ID : " + id));

        chauffeurMapper.updateEntityFromDto(requestDTO, chauffeur);
        return chauffeurMapper.toDto(chauffeurRepository.save(chauffeur));
    }

    @Override
    @Transactional
    public void supprimerChauffeur(Long id) {
        if (!chauffeurRepository.existsById(id)) {
            throw new RuntimeException("Chauffeur introuvable avec l'ID : " + id);
        }
        chauffeurRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<ChauffeurResponseDTO> listerChauffeursDisponibles(Pageable pageable) {
        return chauffeurRepository.findByDisponibleTrue(pageable)
                        .map(chauffeurMapper::toDto);
    }

    @Override
    @Transactional
    public Page<ChauffeurResponseDTO> listerTousLesChauffeurs(Pageable pageable) {
        return chauffeurRepository.findAll(pageable)
                .map(chauffeurMapper::toDto);
    }
}
