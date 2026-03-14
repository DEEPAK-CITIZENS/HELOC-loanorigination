package me.anichakra.poc.pilot.heloc.cosigner.service;

import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;

public interface CosignerCommandService {

	Cosigner addCosigner(Cosigner cosigner);

	Cosigner recordConsent(Long cosignerId);

	Cosigner pullCosignerCredit(Long cosignerId);
}
