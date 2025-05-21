package id.ids.service;

import id.ids.dto.StatusDTO;
import id.ids.dto.TransactionDTO;
import id.ids.dto.TransactionResponse;
import id.ids.model.Transaction;
import id.ids.model.TransactionStatus;
import id.ids.repository.CustomerRepository;
import id.ids.repository.ProductRepository;
import id.ids.repository.TransactionRepository;
import id.ids.repository.TransactionStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionStatusRepository transactionStatusRepository;

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    @Override
    public TransactionResponse getAllTrx() throws Exception {
        TransactionResponse trxResponse = new TransactionResponse();

        try {
            List<Transaction> trxList = transactionRepository.findAll();

            List<TransactionDTO> trxDtoList = new ArrayList<>();
            for (Transaction trx : trxList) {
                if (trx.getProduct() == null || trx.getCustomer() == null || trx.getStatus() == null) {
                    continue;
                }

                TransactionDTO trxDto = new TransactionDTO();
                trxDto.setId(trx.getId());
                trxDto.setProductID(trx.getProduct().getProductId());
                trxDto.setProductName(trx.getProduct().getProductName());
                trxDto.setAmount(trx.getAmount().toString());
                trxDto.setCustomerName(trx.getCustomer().getCustomerName());
                trxDto.setStatus(trx.getStatus().getId());
                trxDto.setTransactionDate(trx.getTransactionDate());
                trxDto.setCreateBy(trx.getCreateBy());
                trxDto.setCreateOn(trx.getCreateOn());

                trxDtoList.add(trxDto);
            }

            List<TransactionStatus> statusList = transactionStatusRepository.findAll();
            List<StatusDTO> statusListDto = new ArrayList<>();
            for (TransactionStatus status : statusList) {
                StatusDTO statusDTO = new StatusDTO();
                statusDTO.setId(status.getId());
                statusDTO.setName(status.getName());
                statusListDto.add(statusDTO);
            }

            trxResponse.setData(trxDtoList);
            trxResponse.setStatus(statusListDto);

        } catch (Exception e) {
            log.error("Unexpected error in getAllTrx: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to retrieve all transaction data", e);
        }

        return trxResponse;
    }


    @Override
    public TransactionResponse getTrxById(Integer id) throws Exception {
        TransactionResponse trxResponse = new TransactionResponse();

        try {
            Optional<Transaction> optionalTrx = transactionRepository.findTransactionById(id);
            if (optionalTrx.isEmpty()) {
                throw new RuntimeException("Transaction not found with id: " + id);
            }
            Transaction trx = optionalTrx.get();

            if (trx.getProduct() == null) {
                throw new RuntimeException("Product data missing in transaction");
            }
            if (trx.getCustomer() == null) {
                throw new RuntimeException("Customer data missing in transaction");
            }
            if (trx.getStatus() == null) {
                throw new RuntimeException("Status data missing in transaction");
            }

            TransactionDTO trxDto = new TransactionDTO();
            trxDto.setId(trx.getId());
            trxDto.setProductID(trx.getProduct().getProductId());
            trxDto.setProductName(trx.getProduct().getProductName());
            trxDto.setAmount(trx.getAmount().toString());
            trxDto.setCustomerName(trx.getCustomer().getCustomerName());
            trxDto.setStatus(trx.getStatus().getId());
            trxDto.setTransactionDate(trx.getTransactionDate());
            trxDto.setCreateBy(trx.getCreateBy());
            trxDto.setCreateOn(trx.getCreateOn());

            StatusDTO statusDto = new StatusDTO();
            statusDto.setId(trx.getStatus().getId());
            statusDto.setName(trx.getStatus().getName());

            List<TransactionDTO> transactionList = new ArrayList<>();
            transactionList.add(trxDto);

            List<TransactionStatus> statusList = new ArrayList<>();
            statusList = transactionStatusRepository.findAll();

            List<StatusDTO> statusListDto = new ArrayList<>();
            for (TransactionStatus status : statusList){
                StatusDTO statusDTO = new StatusDTO();
                statusDTO.setId(status.getId());
                statusDTO.setName(status.getName());
                statusListDto.add(statusDTO);
            }

            trxResponse.setData(transactionList);
            trxResponse.setStatus(statusListDto);

        } catch (RuntimeException e) {
            log.error("Error in getTrxById: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error in getTrxById for id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to retrieve transaction data", e);
        }

        return trxResponse;
    }
}
