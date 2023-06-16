package com.baz.repository;

import com.baz.model.Pago;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PagoRepository extends R2dbcRepository<Pago, Long> {

}
