package se.grouprich.projectmanagement.service;

import org.springframework.data.repository.CrudRepository;

import se.grouprich.projectmanagement.model.AbstractEntity;

public abstract class AbstractService<E extends AbstractEntity, R extends CrudRepository<E, Long>>
{
	protected R superRepository;

	AbstractService(R superRepository)
	{
		this.superRepository = superRepository;
	}

	public E findById(Long id)
	{
		return superRepository.findOne(id);
	}

	public E createOrUpdate(E entity)
	{
		return superRepository.save(entity);
	}

	public Iterable<E> findAll()
	{
		return superRepository.findAll();
	}
}