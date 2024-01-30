package br.com.administradorfiaplanches.infra.exception.handler;

public class PaymentRefusedException extends RuntimeException{

        public PaymentRefusedException(String message) {
            super(message);
        }
}
