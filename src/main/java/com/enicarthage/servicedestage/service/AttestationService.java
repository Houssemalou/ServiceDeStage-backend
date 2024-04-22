package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Attestation;
import com.enicarthage.servicedestage.repository.AttestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttestationService {

    @Autowired
    private AttestationRepository attestationRepository;

    public Optional<Attestation> getAttestationById(Long id) {
        return attestationRepository.findById(id);
    }

    public Attestation createAttestation(Attestation attestation) {
        return attestationRepository.save(attestation);
    }

    public Attestation updateAttestation(Long id, Attestation attestation) {
        if (attestationRepository.existsById(id)) {
            attestation.setId(id);
            return attestationRepository.save(attestation);
        }
        return null;
    }

    public void deleteAttestation(Long id) {
        attestationRepository.deleteById(id);
    }

    public List<Attestation> getAllAttestations() {
        return attestationRepository.findAll();
    }
}

