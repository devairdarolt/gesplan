package com.gesplan.contato.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gesplan.contato.entity.Contato;
import com.gesplan.contato.form.ContatoDTO;
import com.gesplan.contato.repositories.ContatoRepository;
import com.gesplan.contato.services.exceptions.DataIntegrityException;
import com.gesplan.contato.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;

	public Contato find(Long id) {
		Optional<Contato> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contato.class.getName()));
	}

	public Contato insert(Contato obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Contato update(Contato newContato) {
		Contato oldContato = find(newContato.getId());
		return repo.save(updateData(newContato, oldContato));
	}

	private Contato updateData(Contato newContato, Contato oldContato) {
		oldContato.setNome(newContato.getNome());
		oldContato.setEmail(newContato.getEmail());
		oldContato.setSobrenome(newContato.getSobrenome());
		oldContato.setObservacao(newContato.getObservacao());
		oldContato.setTelefones(newContato.getTelefones());
		return oldContato;

	}

	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Contato");
		}

	}

	public List<Contato> findAll() {
		return repo.findAll();
	}

	public Page<Contato> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	public Contato fromDTO(@Valid ContatoDTO objDto) {
		Contato contato = new Contato(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSobrenome(),objDto.getObservacao());	
		for (String x : objDto.getTelefones()) {
			if (!x.isBlank() && !x.isEmpty()) {
				contato.getTelefones().add(x);
			}
		}
		return contato;
	}
}
