package com.app.clientes.exception;

import java.time.LocalDateTime;

public class ErroResponse {

    private String mensagem;
    private int status;
    private LocalDateTime data;

    public ErroResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
        this.data = LocalDateTime.now();
    }

    public String getMensagem() { return mensagem; }
    public int getStatus() { return status; }
    public LocalDateTime getData() { return data; }
}