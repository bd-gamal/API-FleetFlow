package com.fleetflow.service;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.Chauffeur;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.entity.Vehicule;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.ChauffeurRepository;
import com.fleetflow.repository.ClientRepo;
import com.fleetflow.repository.LivraisonRepo;
import com.fleetflow.repository.VehiculeRepo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class LivraisonServiceTest {
    @Mock
    private LivraisonRepo livraisonRepo;
    @Spy
    private LivraisonMapper livraisonMapper = Mappers.getMapper(LivraisonMapper.class);
    @Mock
    private ClientRepo clientRepo;
    @Mock
    private VehiculeRepo vehiculeRepo;
    @Mock
    private ChauffeurRepository chauffeurRepo;

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

    @Test
    void assignerChauffeurEtVehicule_CasNominal() {
        Long livraisonId = 1L, chauffeurId = 2L, vehiculeId = 3L;
        Livraison livraison = new Livraison();
        Chauffeur chauffeur = new Chauffeur();
        Vehicule vehicule = new Vehicule();

        when(livraisonRepo.findById(livraisonId)).thenReturn(Optional.of(livraison));
        when(chauffeurRepo.findById(chauffeurId)).thenReturn(Optional.of(chauffeur));
        when(vehiculeRepo.findById(vehiculeId)).thenReturn(Optional.of(vehicule));
        when(livraisonRepo.save(any(Livraison.class))).thenAnswer(i -> i.getArgument(0));

        livraisonService.assignerChauffeurEtVehicule(livraisonId, chauffeurId, vehiculeId);

        assertEquals(chauffeur, livraison.getChauffeur());
        assertEquals(vehicule, livraison.getVehicule());
        assertEquals(StatutLivraison.EN_COURS, livraison.getStatut());
        verify(livraisonRepo, times(1)).save(livraison);
    }

    @Test
    void modifierStatut(){

        Long id = 2L;

        Livraison livraison = new Livraison();
        livraison.setId(id);
        livraison.setStatut(StatutLivraison.EN_ATTENTE);

        LivraisonStatutRequestDTO request = new LivraisonStatutRequestDTO();
        request.setStatut(StatutLivraison.LIVREE);

        when(livraisonRepo.findById(id)).thenReturn(Optional.of(livraison));
        when(livraisonRepo.save(livraison)).thenReturn(livraison);

        livraisonService.modifierStatut(id,request);
        assertNotNull(livraison.getStatut());
        assertEquals(StatutLivraison.LIVREE, livraison.getStatut());
    }
}
