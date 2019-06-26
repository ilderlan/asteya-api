package br.com.asteya.api.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {
    @Getter private Long identificadoDoRecurso;
    @Getter private HttpServletResponse response;

    public RecursoCriadoEvent(Object source, Long identicadorDoRecurso, HttpServletResponse response) {
        super(source);
        this.identificadoDoRecurso = identicadorDoRecurso;
        this.response = response;
    }
}
