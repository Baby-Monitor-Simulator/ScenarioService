package com.babymonitor.scenario;

import com.babymonitor.scenario.service.ScenarioServiceImpl;
import com.babymonitor.scenario.repository.ScenarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@Testcontainers
@DataMongoTest
@Import(ScenarioServiceImpl.class)
class ResultServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private ScenarioServiceImpl resultService;

	@Autowired
	private ScenarioRepository resultRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@BeforeEach
	void setUp() {
		resultRepository.deleteAll();
	}

//	@Test
//	void whenAddResult_thenResultIsPersistedSuccessfully() {
//		// Given
//		Result result = new Result("Test Result", 1, 123);
//
//		// When
//		resultService.addResult(result);
//
//		// Then
//		List<Result> savedResults = resultRepository.findByUser(1);
//		assertThat(savedResults).hasSize(1);
//		Result savedResult = savedResults.get(0);
//		assertThat(savedResult.getResult()).isEqualTo("Test Result");
//		assertThat(savedResult.getUser()).isEqualTo(1);
//		assertThat(savedResult.getSession()).isEqualTo(123);
//	}
//
//	@Test
//	void whenFindByUser_thenReturnsCorrectResults() {
//		// Given
//		Result result1 = new Result("Result 1", 1, 1);
//		Result result2 = new Result("Result 2", 1, 2);
//		Result result3 = new Result("Result 3", 2, 3);
//		resultRepository.saveAll(List.of(result1, result2, result3));
//
//		// When
//		List<Result> userResults = resultService.findByUser(1);
//
//		// Then
//		assertThat(userResults).hasSize(2);
//		assertThat(userResults)
//				.extracting(Result::getResult)
//				.containsExactlyInAnyOrder("Result 1", "Result 2");
//	}
//
//	@Test
//	void whenFindResult_withValidId_thenReturnsCorrectResult() {
//		// Given
//		Result result = new Result("Test Result", 1, 123);
//		Result savedResult = resultRepository.save(result);
//
//		// When
//		Result foundResult = resultService.findByUserAndSession(1, 123);
//
//		// Then
//		assertNotNull(foundResult);
//		assertThat(foundResult.getResult()).isEqualTo("Test Result");
//		assertThat(foundResult.getUser()).isEqualTo(1);
//		assertThat(foundResult.getSession()).isEqualTo(123);
//	}
//
//	@Test
//	void whenFindResult_withInvalidId_thenReturnsNull() {
//		// When
//		Result result = resultService.findByUserAndSession(1, 999);
//
//		// Then
//		assertNull(result);
//	}
//
//	@Test
//	void whenFindByUser_withNonExistentUser_thenReturnsEmptyList() {
//		// When
//		List<Result> results = resultService.findByUser(999);
//
//		// Then
//		assertThat(results).isEmpty();
//	}

}