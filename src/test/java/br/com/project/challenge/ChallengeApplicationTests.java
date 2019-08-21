package br.com.project.challenge;

import br.com.project.challenge.service.TransportadoraService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ChallengeApplicationTests {
	@Autowired
	private TransportadoraService transportadoraService;

	@Test
	public void contextLoads() {
	}
}
