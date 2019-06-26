package br.com.asteya.api.event.listener;

import br.com.asteya.api.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {
    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        Long codigo = recursoCriadoEvent.getIdentificadoDoRecurso();
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        setHeaderLocation(codigo, response);
    }

    private void setHeaderLocation(Long codigo, HttpServletResponse response) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
        response.setHeader("Locaction", uri.toASCIIString());
    }
}
