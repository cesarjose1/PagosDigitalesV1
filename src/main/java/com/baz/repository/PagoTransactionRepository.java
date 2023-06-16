//package com.baz.repository;
//
//import com.baz.model.Pago;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//@Repository
//public class PagoTransactionRepository {
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public Pago registraPago(Pago pago) {
//        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
//        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
//        try {
//            String sql = "INSERT INTO PAGOS VALUES (?, ?, ?, ?, ?);";
//            jdbcTemplate.update(sql,
//                    new Object[] { pago.getId(), pago.getNombrePagador(), pago.getNombreBeneficiario(), pago.getMonto(), pago.getReferencia() });
//            transactionManager.commit(transactionStatus);
//        } catch (RuntimeException e) {
//            transactionManager.rollback(transactionStatus);
//            throw e;
//        }
//
//        return pago;
//    }
//}