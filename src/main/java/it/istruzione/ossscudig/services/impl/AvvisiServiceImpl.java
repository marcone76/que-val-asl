package it.istruzione.ossscudig.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.model.dto.AvvisiDTO;
import it.istruzione.ossscudig.model.entity.Tod1024Avviso;
import it.istruzione.ossscudig.repository.Tod1024AvvisoRepository;
import it.istruzione.ossscudig.services.AvvisiService;

@Service
public class AvvisiServiceImpl implements AvvisiService {

	private static Logger logger = Logger.getLogger(AvvisiServiceImpl.class);

	@Autowired
	Tod1024AvvisoRepository tod1024AvvisoRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List <AvvisiDTO> loadAvvisi() {
		AvvisiDTO avvisiDTO = null;
		List <AvvisiDTO> avvisiList = new ArrayList<>();
		List<Tod1024Avviso> list = tod1024AvvisoRepository.findByAvviso();
		for(Tod1024Avviso p:list) {
			avvisiDTO=new AvvisiDTO();
			avvisiDTO.setDescrizioneTestoAVV(p.getDesTesAvv());
			avvisiDTO.setCodTipoAvv(p.getTod1023Tipoavviso().getCodAvv());
			avvisiDTO.setDescrizioneAvv(p.getTod1023Tipoavviso().getDesTipAvv());
			avvisiList.add(avvisiDTO);
		}
		return avvisiList;

	}

}
