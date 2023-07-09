package br.com.brasilcap.intranet.brasilcapintranet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilcap.devcap.core.exception.ApplicationException;
import br.com.brasilcap.intranet.brasilcapintranet.entity.Evento;
import br.com.brasilcap.intranet.brasilcapintranet.repository.EventoRepository;


@RestController
@RequestMapping("eventos")
public class EventoController {
	@Autowired
	private EventoRepository eventoRepository;

	
	@RequestMapping(value = "{mes}", method = RequestMethod.GET)
	public List<Evento> get(@PathVariable String mes) throws ApplicationException {
		System.out.println(mes);
		List<Evento> eventos;
		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(mes);
			eventos = eventoRepository.findByMonth(data);
		} catch (ParseException e) {
			throw new ApplicationException("Data inválida!");
		}
		return eventos;
	}
}
