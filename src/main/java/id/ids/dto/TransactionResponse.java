package id.ids.dto;

import java.util.List;

public class TransactionResponse {
    private List<TransactionDTO> data;
    private List<StatusDTO> status;


    public TransactionResponse() {
    }

    public TransactionResponse(List<TransactionDTO> data, List<StatusDTO> status) {
        this.data = data;
        this.status = status;
    }


    public List<TransactionDTO> getData() {
        return data;
    }

    public void setData(List<TransactionDTO> data) {
        this.data = data;
    }

    public List<StatusDTO> getStatus() {
        return status;
    }

    public void setStatus(List<StatusDTO> status) {
        this.status = status;
    }
}
