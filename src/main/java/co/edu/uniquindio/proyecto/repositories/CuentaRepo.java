package co.edu.uniquindio.proyecto.repositories;
import co.edu.uniquindio.proyecto.model.docs.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepo extends MongoRepository<Cuenta,String> {
                                                        //Esto es un db.cuentas.findOne...
    @Query(value = "{email: email}")                     //{email:?0} -> primer argumento del método
    Optional<Cuenta> buscarEmail(String email);          //Optional es el patrón que usa Java para este objeto

    @Query("{usuario.cedula : ?0 }")
    Optional<Cuenta> buscarCedula(String cedula);
}
