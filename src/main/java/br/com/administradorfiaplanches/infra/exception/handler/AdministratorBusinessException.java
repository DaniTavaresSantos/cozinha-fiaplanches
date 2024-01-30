package br.com.administradorfiaplanches.infra.exception.handler;

public class AdministratorBusinessException extends RuntimeException{

        public AdministratorBusinessException(String message) {
            super(message);
        }
}
