package br.com.fiap.dasa.api;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) { super(message); }
}
