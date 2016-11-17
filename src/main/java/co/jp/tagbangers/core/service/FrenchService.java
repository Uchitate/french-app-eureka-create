package co.jp.tagbangers.core.service;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchCreateRequest;
import co.jp.tagbangers.core.repository.FrenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrenchService {

	@Autowired
	FrenchRepository frenchRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;


	public French create(FrenchCreateRequest request) {
		French french = new French(request.getName(), request.getPassword(), request.getEmail(), request.getAddress());
		return frenchRepository.saveAndFlush(french);
	}
}
