package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LivraisonServiceTest {
    @Mock
    private LivraisonRequestDTO livraisonRequestDTO;
    @Mock
    private LivraisonMapper livraisonMapper;
    @Mock
    LivraisonRepo livraisonRepo;

    @InjectMocks
    private LivraisonService livraisonService;
    
    @Test
    void createLivraisonTest(){
        Livraison livraison = new Livraison();
        LivraisonResponseDTO responseDTO = new LivraisonResponseDTO();

        LivraisonRequestDTO requestDTO = new LivraisonRequestDTO();
        responseDTO.setStatut(StatutLivraison.EN_ATTENTE);

        when(livraisonMapper.toEntity(requestDTO)).thenReturn(livraison);
        when(livraisonRepo.save(livraison)).thenReturn(livraison);
        when(livraisonMapper.toResponseDto(livraison)).thenReturn(responseDTO);

        LivraisonResponseDTO result = livraisonService.createLivraison(requestDTO);
        assertNotNull(result);
        assertEquals(StatutLivraison.EN_ATTENTE,result.getStatut());

    }


}