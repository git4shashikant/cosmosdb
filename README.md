# cosmosdb

- Install and run cosmos db emulator on windows machine
- access emulator @ https://localhost:8081/_explorer/index.html
- add dependency of "azure-spring-boot-starter-cosmos" in pom.xml file
- define properties to connect with running intance of emulator
  azure.cosmos.uri=https://localhost:8081
  azure.cosmos.key=<primaryKey>
  azure.cosmos.database= <dbName>
  azure.cosmos.populateQueryMetrics=true
- create a DB entity 
'''
@NoArgsConstructor
@Container(containerName = "user")
public class User {

    @Id
    @GeneratedValue
    private String Id;

    @PartitionKey
    private String section;

    private String name;
    ...
}    
'''
- create a repository 
'''
@Repository
  public interface UserRepository extends CosmosRepository<User, String> {
}
'''
- create controller to expose the apis
-  add annotation @EnableCosmosRepositories at application class
- Add test case to check if working
- use postman to test the controller apis
