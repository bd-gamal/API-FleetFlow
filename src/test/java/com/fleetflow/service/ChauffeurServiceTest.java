package com.fleetflow.service;

import com.fleetflow.dto.ChauffeurResponseDTO;
import com.fleetflow.entity.Chauffeur;
import com.fleetflow.mapper.ChauffeurMapper;
import com.fleetflow.repository.ChauffeurRepository;
import com.fleetflow.repository.LivraisonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChauffeurServiceTest {

    @Mock
    private ChauffeurRepository chauffeurRepository;

    @Mock
    private ChauffeurMapper chauffeurMapper;

    @InjectMocks
    private ChauffeurService chauffeurService;

    @Test
    void listerChauffeursDisponibles() {
        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(1L);
        List<Chauffeur> chauffeurs = List.of(chauffeur);
        ChauffeurResponseDTO dto = new ChauffeurResponseDTO();

        when(chauffeurRepository.findByDisponibleTrue()).thenReturn(chauffeurs);
        when(chauffeurMapper.toDto(chauffeur)).thenReturn(dto);

        List<ChauffeurResponseDTO> result = chauffeurService.listerChauffeursDisponibles();

        assertEquals(1, result.size());
        verify(chauffeurRepository).findByDisponibleTrue();
    }
}