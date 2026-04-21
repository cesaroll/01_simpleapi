# CLAUDE.md

## Git Conventions

- Do not add Claude as co-author in commit messages — no `Co-Authored-By` lines

## Build & Run

```bash
mvn clean package       # build
mvn spring-boot:run     # run on port 8080
mvn test                # run all tests
mvn test -Dtest=ItemControllerTest  # run a specific test class
```

H2 console available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`).

## Architecture

Layered package structure under `com.example.simpleapi`:

- `controller/` — REST controllers (`@RestController`)
- `service/` — Business logic (`@Service`)
- `repository/` — JPA repositories (Spring Data)
- `entity/` — JPA entities
- `dto/` — Request/response payloads (Java records)
- `exception/` — Custom exceptions and `@RestControllerAdvice` global handler

## Code Conventions

- **Dependency injection**: constructor injection only — use `@RequiredArgsConstructor`, no `@Autowired` field injection
- **DTOs**: use Java records for immutable request payloads
- **Entities**: use Lombok (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder`) — no manual getters/setters/constructors
- **Exception handling**: throw `ResourceNotFoundException` for missing resources; `GlobalExceptionHandler` maps it to 404
- **HTTP status codes**: use `@ResponseStatus` (`CREATED` for POST, `NO_CONTENT` for DELETE)
- Java 17 features are fine

## Testing Conventions

- Integration tests only — `@SpringBootTest` + `@AutoConfigureMockMvc` + `MockMvc`
- No unit tests with mocked dependencies
- Test class naming: `[Entity]ControllerTest`
- Use `@BeforeEach` to wipe the repository before each test
- Use `ObjectMapper` for JSON serialization in test request bodies
- Use JsonPath for response assertions

## Configuration

- `src/main/resources/application.yml` — single config file, no profiles
- H2 in-memory database, PostgreSQL compatibility mode
- DDL auto: `create-drop` (schema recreated on each startup)
- SQL logging enabled (`show-sql: true`)

## Humanizer

- Every time you write some content - Make sure to use the humanizer skill in /skills/humanizer