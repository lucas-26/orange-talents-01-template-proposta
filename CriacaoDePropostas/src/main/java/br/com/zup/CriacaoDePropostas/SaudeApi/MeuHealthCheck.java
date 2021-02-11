package br.com.zup.CriacaoDePropostas.SaudeApi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MeuHealthCheck implements HealthIndicator {

	@Override
	public Health health() {		
		Map<String, Object> details = new HashMap<String, Object>();
		details.put("Versão","1.2.3");
		details.put("descricao", "Meu primeiro HealthCheck");
		details.put("endereco", "127.0.0.1");
		
		return Health.up().withDetail("Detalhes", details).build();
	}

}
