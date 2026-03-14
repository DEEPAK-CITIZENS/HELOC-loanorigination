package me.anichakra.poc.pilot.heloc.cosigner.service.impl;

import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;
import me.anichakra.poc.pilot.heloc.cosigner.repo.CosignerRepository;
import me.anichakra.poc.pilot.heloc.cosigner.service.CosignerCommandService;

@CommandService
public class DefaultCosignerCommandService implements CosignerCommandService {

	@Inject
	private CosignerRepository cosignerRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Cosigner addCosigner(Cosigner cosigner) {
		return cosignerRepository.saveAndFlush(cosigner);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Cosigner recordConsent(Long cosignerId) {
		Cosigner cosigner = cosignerRepository.findById(cosignerId).get();
		cosigner.setConsentGiven(true);
		cosigner.setConsentDate(new Date());
		return cosignerRepository.saveAndFlush(cosigner);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Cosigner pullCosignerCredit(Long cosignerId) {
		Cosigner cosigner = cosignerRepository.findById(cosignerId).get();
		return cosignerRepository.saveAndFlush(cosigner);
	}
}
