package br.com.klb.desafio.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import br.com.klb.desafio.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente,Long>{

	@Override
	<S extends Cliente> S save(S entity);

	@Override
	<S extends Cliente> Iterable<S> saveAll(Iterable<S> entities);

	@Override
	Optional<Cliente> findById(Long id);

	@Override
	boolean existsById(Long id);

	@Override
	Iterable<Cliente> findAll();

	@Override
	Iterable<Cliente> findAllById(Iterable<Long> ids);

	@Override
	long count();

	@Override
	void deleteById(Long id);

	@Override
	void delete(Cliente entity);

	@Override
	void deleteAll(Iterable<? extends Cliente> entities);

	@Override
	void deleteAll();
	
} 