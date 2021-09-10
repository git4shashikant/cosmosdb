package com.test.cosmodb;

import com.azure.cosmos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CosmodbApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {

		CosmosClient cosmosClient = new CosmosClientBuilder().endpoint("https://localhost:8081")
				.key("C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==")
				.consistencyLevel(ConsistencyLevel.EVENTUAL)
				.buildClient();
		CosmosDatabase cosmosdb = cosmosClient.getDatabase("cosmosdb");
		CosmosContainer user = cosmosdb.getContainer("user");
		System.out.println(user.getId());
	}

	@Test
	void testRepository() {
		Optional<User> user = userRepository.findById("6c3a0de8-ce58-4b8f-b982-c7884824748d");
		System.out.println(user.get());
	}

	@Test
	void testRepositoryFindAll() {
		Iterable<User> all = userRepository.findAll();
		all.forEach(user -> {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getSection());
		});
	}

}
