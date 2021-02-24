package br.com.zup.CriacaoDePropostas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.CriacaoDePropostas.controller.PropostaController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;


@Component
class MinhasMetricas {

	
	private final MeterRegistry meterRegistry;
	PropostaController proposta;
	
	public MinhasMetricas(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	//contador de quantas requisições estão chegando para minha api
	public void meuContador() {
		Collection<Tag> tags = new ArrayList<>();	
	    tags.add(Tag.of("emissora", "Mastercard"));
	    tags.add(Tag.of("banco", "Itaú"));

	    Counter contadorDePropostasCriadas = this.meterRegistry.counter("proposta_criada", tags);
	    contadorDePropostasCriadas.increment();
	    
	    Timer verificaTempoDaConsulta = this.meterRegistry.timer("consultar_proposta", tags);
	    verificaTempoDaConsulta.record(() -> {
	    	Long valor = Long.getLong("1");
	    	proposta.buscaProposta(valor);
	    });
	}
}

@Component
class MinhasMetrica2 {
	private final MeterRegistry meterRegistry;
	final Collection<String> strings = new ArrayList<String>();
	final Random random = new Random();
	
	public MinhasMetrica2(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
		criarGauge();
	}
	
	
	private void criarGauge() {
		Collection<Tag> tags = new ArrayList<>();	
	    tags.add(Tag.of("emissora", "Mastercard"));
	    tags.add(Tag.of("banco", "Itaú"));
	
	    meterRegistry.gauge("meu_gauge", tags, strings, Collection::size);
	}
	
	public void removeString() {
		strings.removeIf(Objects::nonNull);
	}
	
	public void addString() {
		strings.add(UUID.randomUUID().toString());
	}
	
	
	public void simulandoGauge(Random random, Collection<String> strings) {
		double randomNumber = random.nextInt();
		if(randomNumber % 2 == 0) {
			addString();
		}
		else {
			removeString();
		}
	}
}
