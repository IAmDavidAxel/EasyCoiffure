package domain.user.credential;

import domain.user.Credential;
import infrastructure.ObjectNotFoundException;
import infrastructure.exception.PersistenceException;


public interface CredentialRepository {

	Credential findByUsername(String username) throws ObjectNotFoundException;

	void save(Credential credential, String username) throws PersistenceException;
}
