package id.ids.service;

import id.ids.dto.TransactionResponse;

import java.util.List;

public interface ITransactionService {

    TransactionResponse getAllTrx() throws Exception;
    TransactionResponse getTrxById(Integer id) throws Exception;
}
