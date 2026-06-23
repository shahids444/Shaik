# Spring Boot & Microservices — Complete Topic Reference

---

## PART 1 — SPRING CORE & BOOT INTERNALS

### 1.1 The Spring IoC Container
- What inversion of control actually means — who creates objects vs who uses them
- `BeanFactory` vs `ApplicationContext` — differences, when each is used, `ClassPathXmlApplicationContext` vs `AnnotationConfigApplicationContext`
- How the container loads and manages beans from component scanning vs explicit configuration
- Eager vs lazy bean initialization — `@Lazy`, when to use, implications for startup time
- The `Environment` abstraction — property sources, profiles, `@Value`, `@ConfigurationProperties`

### 1.2 Bean Lifecycle (know every phase)
- Phase 1 — Class loading and instantiation
- Phase 2 — Dependency injection (constructor, setter, or field)
- Phase 3 — Aware interfaces — `BeanNameAware`, `BeanFactoryAware`, `ApplicationContextAware`
- Phase 4 — `BeanPostProcessor.postProcessBeforeInitialization()` — this is what powers AOP
- Phase 5 — `@PostConstruct` / `InitializingBean.afterPropertiesSet()` / custom `initMethod`
- Phase 6 — `BeanPostProcessor.postProcessAfterInitialization()` — wraps the bean in a proxy if needed
- Phase 7 — Bean in use
- Phase 8 — Destroy — `@PreDestroy` / `DisposableBean.destroy()` / custom `destroyMethod`
- How to implement `BeanPostProcessor` yourself and what you can do with it
- `BeanFactoryPostProcessor` — modifies bean definitions before instantiation (used by PropertySourcesPlaceholderConfigurer)

### 1.3 Dependency Injection Deep Dive
- **Constructor injection** — why it is the production standard (immutability, mandatory dependencies, testability without reflection, fail-fast on missing deps, no circular-dependency surprises)
- **Setter injection** — when acceptable (optional dependencies)
- **Field injection** — why it is an anti-pattern in production (`@Autowired` on fields, hard to test without Spring context, hides dependencies)
- Injection qualifiers — `@Qualifier`, `@Primary`, ordering with `@Order`/`Ordered`
- Injecting collections of beans — `List<MyInterface>`, `Map<String, MyInterface>`
- Resolving circular dependencies — why they are a design smell, `@Lazy` as escape hatch, restructuring as the real fix
- `@Autowired` resolution order (type → qualifier → name)
- Programmatic bean retrieval — `ApplicationContext.getBean()`, when and why to avoid it

### 1.4 Bean Scopes
- **Singleton** — one instance per container; thread-safety implications when a singleton holds mutable state
- **Prototype** — new instance per request; Spring does not manage destruction
- **Request** — one instance per HTTP request
- **Session** — one instance per HTTP session
- **Application** — one instance per `ServletContext`
- Injecting a prototype bean into a singleton — the scope mismatch problem; solutions (`ObjectFactory`, `Provider`, method injection with `@Lookup`, scoped proxy `@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)`)

### 1.5 Auto-Configuration Internals
- How `@SpringBootApplication` decomposes into `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`
- How `@EnableAutoConfiguration` works — `AutoConfigurationImportSelector`, reading `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` (Boot 3.x) or `spring.factories` (Boot 2.x)
- The `@Conditional` family — `@ConditionalOnClass`, `@ConditionalOnMissingBean`, `@ConditionalOnProperty`, `@ConditionalOnWebApplication`, `@ConditionalOnExpression`
- What a starter is — a convenient dependency descriptor that pulls in auto-configuration + required dependencies
- Writing your own starter — a `META-INF/spring` auto-configuration descriptor + a conditional `@Configuration` class
- Auto-configuration ordering — `@AutoConfigureBefore`, `@AutoConfigureAfter`, `@AutoConfigureOrder`
- `spring-boot-actuator` auto-configuration for metrics, health, and environment endpoints

### 1.6 Spring AOP (Aspect-Oriented Programming)
- What problems AOP solves — cross-cutting concerns (logging, security, transactions, caching, metrics)
- AOP concepts — **Aspect**, **Join Point**, **Pointcut**, **Advice** (Before/After/AfterReturning/AfterThrowing/Around), **Weaving**
- **JDK dynamic proxy** — only for interfaces, created by `java.lang.reflect.Proxy`
- **CGLIB proxy** — subclasses the target class, used when no interface; requires the class not be `final`
- The **self-invocation gotcha** — calling an `@Transactional` or `@Async` method from within the same bean bypasses the proxy entirely, so the advice is not applied. Understand exactly why (the `this` reference bypasses the proxy wrapper)
- Pointcut expressions — `execution()`, `within()`, `@annotation()`, `bean()`, combining with `&&`/`||`/`!`
- `@Around` advice — `ProceedingJoinPoint`, calling `proceed()`, modifying args or return value, exception handling
- Practical use — `@LogExecutionTime`, `@AuditLog`, security checks, performance monitoring
- AOP ordering when multiple aspects apply — `@Order`
- `@EnableAspectJAutoProxy` and `proxyTargetClass = true`

---

## PART 2 — SPRING MVC & REST

### 2.1 The DispatcherServlet Request Lifecycle
- How `DispatcherServlet` bootstraps (from `web.xml` to `SpringBootServletInitializer` to embedded Tomcat/Netty)
- Request flow: client → embedded server → `DispatcherServlet` → `HandlerMapping` (finds handler/controller) → `HandlerInterceptor.preHandle()` → `HandlerAdapter` (invokes controller) → controller method → `HandlerAdapter` processes return value → message converter writes response → `HandlerInterceptor.postHandle()`/`afterCompletion()`
- `HandlerInterceptor` vs Servlet `Filter` — what each can and cannot access, when to use each (filter for cross-cutting HTTP concerns, interceptor for Spring-aware concerns)
- `HttpMessageConverter` — how Java objects become JSON/XML (Jackson's `MappingJackson2HttpMessageConverter`), content negotiation

### 2.2 Building Production REST APIs
- `@RestController` vs `@Controller` — `@ResponseBody` implicit
- Request mapping — `@GetMapping`/`@PostMapping`/`@PutMapping`/`@DeleteMapping`/`@PatchMapping`, `@RequestMapping`, `produces`/`consumes`
- Method parameters — `@PathVariable`, `@RequestParam`, `@RequestBody`, `@RequestHeader`, `@CookieValue`, `@ModelAttribute`
- **HTTP status codes done right** — 200/201/204/400/401/403/404/409/422/500, using `ResponseEntity<T>`
- **Idempotency** — GET/PUT/DELETE are idempotent; POST is not; why this matters for retries
- **API versioning strategies** — URI versioning (`/v1/`), request-header versioning, content-negotiation versioning; trade-offs of each
- **DTOs vs entities** — why you must never expose JPA entities directly (cyclic references, accidental data exposure, coupling the API to the DB schema)
- **MapStruct** — code-generation-based mapping (no reflection overhead), `@Mapper`, `@Mapping`, mapping with conversion, mapping nested objects, `@InheritInverseConfiguration`
- **Pagination, filtering, and sorting** — `Pageable` and `Page<T>` from Spring Data, `@PageableDefault`, returning consistent paginated responses

### 2.3 Request Validation
- Bean Validation (Jakarta Validation 3.x) — `@NotNull`, `@NotBlank`, `@NotEmpty`, `@Size`, `@Min`/`@Max`, `@Pattern`, `@Email`, `@Positive`, `@Future`/`@Past`
- Triggering validation — `@Valid` vs `@Validated` (the latter supports method-level + groups)
- **Custom constraint annotations** — `@interface` + `ConstraintValidator<A, T>` implementation
- Validating nested objects and collections — `@Valid` on nested fields
- **Validation groups** — different rules for create vs update
- Handling `MethodArgumentNotValidException` to produce clean error messages

### 2.4 Global Exception Handling
- `@RestControllerAdvice` (a `@ControllerAdvice` + `@ResponseBody`) with `@ExceptionHandler`
- **RFC 7807 Problem Details** — `type`, `title`, `status`, `detail`, `instance` — the standard error response format (Spring Boot 3.x has native support via `ProblemDetail`)
- Mapping domain exceptions to HTTP status codes — custom exception hierarchy
- Handling `ConstraintViolationException` (method-level validation), `MethodArgumentNotValidException` (body validation), `HttpMessageNotReadableException`, `NoHandlerFoundException`, unhandled exceptions

### 2.5 Configuration Management
- `application.yml` vs `application.properties` — multi-document YAML with `---`
- **Externalized config precedence** (Spring Boot's full priority list — command-line args > `SPRING_APPLICATION_JSON` > OS env vars > profile-specific files > `application.yml` > default properties)
- **Profiles** — `spring.profiles.active`, `@Profile`, profile-specific files (`application-prod.yml`), programmatic profile activation
- `@ConfigurationProperties` — type-safe config with prefix, binding, nested objects, lists, validation with `@Validated`
- `@Value` — SpEL expressions, default values, when to prefer it (single property) vs `@ConfigurationProperties` (groups of properties)
- `@RefreshScope` with Spring Cloud Config for runtime refresh without restart
- **Environment variables and secrets** — never commit secrets; use environment injection or vaults

### 2.6 OpenAPI / Swagger Documentation
- `springdoc-openapi` — auto-generating spec from annotations
- `@Operation`, `@Parameter`, `@ApiResponse`, `@Schema`
- Adding examples and descriptions for request/response bodies
- Securing the Swagger UI in production

---

## PART 3 — SPRING DATA JPA & HIBERNATE

### 3.1 The Layers Explained
- JPA (Jakarta Persistence API) — the specification, just interfaces and annotations
- **Hibernate** — the most-used JPA implementation; the actual SQL is generated here
- **Spring Data JPA** — the repository abstraction on top; generates queries from method names, wraps Hibernate

### 3.2 Entity Mapping
- `@Entity`, `@Table`, `@Column` with length/nullable/unique
- **ID generation strategies** — `AUTO`, `IDENTITY` (DB auto-increment, no batch insert), `SEQUENCE` (pre-fetches a range, better for batch), `TABLE` (avoid in production — locks)
- `@Embeddable` and `@Embedded` for value objects
- **Relationships:**
  - `@OneToMany` + `@ManyToOne` — owning vs inverse side, `mappedBy`, common mistake of bidirectional sync
  - `@ManyToMany` — join table, avoiding it when the join table has extra columns (use an explicit join entity)
  - `@OneToOne` — shared primary key vs foreign key approach
  - Cascade types — `PERSIST`, `MERGE`, `REMOVE`, `ALL`, `DETACH`, `REFRESH` — and why `CascadeType.REMOVE` on `@OneToMany` is dangerous
  - Orphan removal — `orphanRemoval = true`

### 3.3 The N+1 Problem (Critical)
- What it is — loading a list of entities, then Hibernate fires one extra query per entity to fetch its associations
- How to detect — `spring.jpa.show-sql=true`, Hibernate statistics, p6spy, `datasource-proxy`
- **Fix 1: `JOIN FETCH` in JPQL** — `SELECT o FROM Order o JOIN FETCH o.items WHERE o.id = :id`
- **Fix 2: `@EntityGraph`** — `@EntityGraph(attributePaths = {"items", "user"})` on repository method
- **Fix 3: `@BatchSize`** — Hibernate fetches associations in batches rather than one by one
- **Fix 4: DTO projections** — `SELECT new com.example.OrderDto(o.id, o.status) FROM Order o` or interface-based projections in Spring Data
- **Fix 5: `@Fetch(FetchMode.SUBSELECT)`** — fetches all associations with one subselect
- Why `FetchType.EAGER` does NOT fix N+1 — it just moves it to load time

### 3.4 Fetch Strategies & The LazyInitializationException
- `FetchType.LAZY` — association is not loaded until accessed (the default for collections, recommended)
- `FetchType.EAGER` — association always loaded with the parent (default for `@ManyToOne`/`@OneToOne`, often a performance trap)
- **`LazyInitializationException`** — accessing a lazy association after the persistence context (session) is closed. Causes: returning an entity from a service, serializing it in a controller, or accessing it in a view after the transaction ended
- **The Open Session In View anti-pattern** — `spring.jpa.open-in-view=false` (set this to `false` in production; the default `true` keeps a session open for the whole HTTP request, hiding lazy-load issues but holding DB connections)
- Solutions — fetch joins, DTOs, `@Transactional` in the service layer

### 3.5 The Persistence Context & Entity Lifecycle
- Persistence context = a first-level cache and a unit of work
- **Entity states** — `TRANSIENT` (new, not managed), `MANAGED` (tracked by context), `DETACHED` (was managed, context closed), `REMOVED` (marked for deletion)
- **Dirty checking** — Hibernate snapshots managed entities and issues UPDATE at flush time if they changed
- **Flush modes** — `AUTO` (before query or commit), `COMMIT` (only on commit), `MANUAL` (explicit)
- `save()` vs `saveAndFlush()` vs `persist()` — when each matters
- First-level cache — `entityManager.find()` hit vs miss, `entityManager.clear()`, `entityManager.detach()`
- Second-level cache — shared across sessions; `@Cache`, `@Cacheable` on entities; Ehcache/Redis backends; when it helps (read-mostly data) and hurts (write-heavy data, stale reads)

### 3.6 Transactions (@Transactional)
- What `@Transactional` actually does — creates a proxy, starts a transaction before the method, commits (or rolls back) after
- **Propagation types:**
  - `REQUIRED` (default) — join existing or create new
  - `REQUIRES_NEW` — always new, suspends existing
  - `NESTED` — savepoint within existing
  - `SUPPORTS` — joins if exists, non-transactional otherwise
  - `NOT_SUPPORTED` — suspends existing, runs non-transactionally
  - `MANDATORY` — must have an existing transaction, throws otherwise
  - `NEVER` — must NOT have a transaction, throws otherwise
- **Isolation levels and the anomalies they prevent:**
  - `READ_UNCOMMITTED` — dirty reads possible
  - `READ_COMMITTED` (Postgres default) — prevents dirty reads, non-repeatable reads possible
  - `REPEATABLE_READ` — prevents dirty + non-repeatable reads, phantom reads possible
  - `SERIALIZABLE` — prevents all anomalies, lowest concurrency
- **Rollback rules** — by default only rolls back on `RuntimeException` and `Error`; `rollbackFor`, `noRollbackFor`
- `readOnly = true` — hints to Hibernate (skip dirty checking, flush is skipped) and to the DB driver (can route to read replicas)
- **The self-invocation gotcha** — calling `@Transactional` method on `this` skips the proxy; the transaction does NOT start
- `@Transactional` on classes vs methods; not on `private` methods
- Checked exceptions and rollback — they do NOT trigger rollback by default; use `rollbackFor = {MyCheckedException.class}`

### 3.7 Locking
- **Optimistic locking** — `@Version` on a numeric/timestamp field; Hibernate includes version in UPDATE WHERE clause; throws `OptimisticLockException` on conflict — best for low-contention scenarios
- **Pessimistic locking** — `LockModeType.PESSIMISTIC_WRITE` / `PESSIMISTIC_READ`; issues `SELECT ... FOR UPDATE`; use for high-contention data like inventory
- When to use each — optimistic for most things (low overhead), pessimistic when you cannot afford retry and contention is high

### 3.8 Connection Pooling with HikariCP
- Why connection pooling — creating a DB connection is expensive; pool reuses them
- Key HikariCP config:
  - `maximumPoolSize` — the most important setting (formula: cores × 2 + disks for OLTP)
  - `minimumIdle` — keep a minimum idle for warm connections
  - `connectionTimeout` — how long to wait for a pool connection before throwing (default 30s; set ~5–10s for fast-fail)
  - `idleTimeout` — how long an idle connection stays before eviction
  - `maxLifetime` — maximum lifetime of a connection (set below DB's `wait_timeout`)
  - `leakDetectionThreshold` — logs a warning if a connection is held longer than this (great for debugging connection leaks)
- Monitoring HikariCP via Micrometer (pool size, active connections, pending acquisition)

### 3.9 Schema Migrations with Flyway
- Why Flyway — versioned, repeatable, auditable schema changes; the only sane way to evolve a DB in production
- Naming convention — `V1__create_user_table.sql`, `V2__add_index.sql` (version, double underscore, description)
- `flyway_schema_history` table — tracks applied migrations
- `spring.flyway.enabled=true`, `spring.flyway.baseline-on-migrate` (for existing schemas)
- Repeatable migrations — `R__seed_data.sql` (rerun when checksum changes)
- **Never use `spring.jpa.hibernate.ddl-auto=create` or `update` in production** — Flyway owns the schema
- Testing migrations — run Flyway in test with an in-memory DB or Testcontainers

### 3.10 Spring Data JPA Repositories
- `JpaRepository` → `CrudRepository` → `Repository` hierarchy
- **Derived query methods** — `findByEmailAndStatus`, `findByNameContainingIgnoreCase`, `existsByEmail`, `deleteByStatus`
- `@Query` with JPQL and native SQL; `nativeQuery = true`
- **Named parameters** (`@Param`) vs positional parameters
- Projections — interface-based (Spring generates a proxy), class-based (DTO), dynamic (`<T>`)
- `@Modifying` + `@Transactional` for bulk update/delete queries
- `Specification<T>` for dynamic queries (Criteria API wrapper)
- Auditing — `@EnableJpaAuditing`, `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `@LastModifiedBy`, `AuditorAware`
- `@Lock` for pessimistic locking in repository methods

---

## PART 4 — SPRING SECURITY

### 4.1 The Security Filter Chain
- How Spring Security works — a chain of `SecurityFilterChain` beans, each a chain of filters wrapping the servlet
- Key filters — `UsernamePasswordAuthenticationFilter`, `BearerTokenAuthenticationFilter`, `ExceptionTranslationFilter`, `AuthorizationFilter`
- `SecurityFilterChain` bean configuration — `HttpSecurity.authorizeHttpRequests()`, `csrf()`, `sessionManagement()`, `cors()`

### 4.2 Authentication & Authorization
- `Authentication` object — who is authenticated, their authorities
- `AuthenticationManager` → `AuthenticationProvider` → `UserDetailsService`
- `UserDetails` and `UserDetailsService` — implementing to load users from DB
- `PasswordEncoder` — always use BCrypt or Argon2; never store plain passwords
- Method security — `@EnableMethodSecurity`, `@PreAuthorize("hasRole('ADMIN')")`, `@PostAuthorize`, `@Secured`
- `HttpSecurity.authorizeHttpRequests()` — `requestMatchers()`, `hasRole()`, `hasAuthority()`, `authenticated()`, `permitAll()`

### 4.3 JWT (JSON Web Tokens)
- Structure — header (alg + typ) + payload (claims: sub, iat, exp, custom) + signature
- Signing algorithms — `HS256` (symmetric, shared secret), `RS256` (asymmetric, private sign + public verify — preferred for microservices)
- Validating a JWT — signature verification, expiry check, issuer/audience check
- **JWT pitfalls** — large payloads slow every request (JWT is sent every time), no built-in revocation (use short expiry + refresh tokens), `none` algorithm vulnerability (always validate alg header)
- Refresh token pattern — short-lived access token + long-lived refresh token stored server-side
- Spring Security integration — `BearerTokenAuthenticationFilter`, `JwtDecoder`, `@AuthenticationPrincipal Jwt jwt`

### 4.4 OAuth2 / OpenID Connect
- **OAuth2 roles** — Resource Owner (user), Client (your app), Authorization Server (Keycloak/Auth0/Okta), Resource Server (your API)
- **Flows** — Authorization Code (+ PKCE for SPAs), Client Credentials (machine-to-machine), Device Code
- **OpenID Connect** — OAuth2 + identity; adds the `id_token`, `userinfo` endpoint, standard claims
- Resource Server config — `spring.security.oauth2.resourceserver.jwt.issuer-uri`; Spring auto-fetches the JWKS endpoint and validates tokens
- **Keycloak** — self-hosted IdP; realms, clients, roles, groups; configuring a Spring Boot app as a resource server; securing microservices with Keycloak-issued tokens
- `@AuthenticationPrincipal OidcUser` vs `@AuthenticationPrincipal Jwt` — which to use when

### 4.5 CORS Configuration
- What CORS is — browser enforcing same-origin; the preflight `OPTIONS` request
- `@CrossOrigin` on controller vs global `CorsConfigurationSource` bean
- Why setting `Access-Control-Allow-Origin: *` is wrong in production (use explicit origins)

---

## PART 5 — SPRING ASYNC, CACHING & SCHEDULING

### 5.1 Async Processing
- `@EnableAsync` + `@Async` — method executes in a separate thread pool
- Configuring a custom `TaskExecutor` — pool size, queue capacity, thread name prefix, rejection policy
- Return types — `void`, `Future<T>`, `CompletableFuture<T>`
- The **self-invocation gotcha** (again) — `@Async` is AOP-based; calling it from the same bean skips the proxy
- Exception handling in `@Async` — `AsyncUncaughtExceptionHandler`

### 5.2 Caching
- `@EnableCaching` — activates the cache abstraction
- `@Cacheable` — cache the return value; `key` SpEL, `condition`, `unless`
- `@CachePut` — always execute the method and update the cache
- `@CacheEvict` — remove entries; `allEntries = true`, `beforeInvocation`
- Cache managers — `ConcurrentMapCacheManager` (in-memory, dev only), **Redis cache manager** (production), Caffeine (in-process, high-performance)
- `RedisCacheConfiguration` — default TTL, key serialization, value serialization (prefer JSON over Java serialization)
- **Cache aside pattern in code** — compare `@Cacheable` to manual cache-aside with `RedisTemplate`
- Cache key design — avoid collisions between different methods/entities

### 5.3 Scheduling
- `@EnableScheduling` + `@Scheduled` — `fixedRate`, `fixedDelay`, `cron` expressions, `initialDelay`
- `fixedRate` vs `fixedDelay` — rate fires at fixed intervals regardless of execution time; delay waits after completion
- Running in a cluster — `@Scheduled` fires on every instance; use ShedLock or Quartz for single-node execution
- `TaskScheduler` for programmatic scheduling

---

## PART 6 — SPRING BOOT PRODUCTION FEATURES

### 6.1 Actuator
- What Actuator provides — production-ready endpoints for health, metrics, info, env, beans, mappings, loggers
- Key endpoints — `/actuator/health`, `/actuator/metrics`, `/actuator/info`, `/actuator/env`, `/actuator/beans`, `/actuator/mappings`, `/actuator/loggers`, `/actuator/prometheus`, `/actuator/circuitbreakers`
- Securing Actuator — expose only what's needed in production; restrict to internal network or an admin role
- **Health indicators** — `HealthIndicator` interface, custom health indicators (e.g., check an external dependency), `DiskSpaceHealthIndicator`, `DataSourceHealthIndicator`
- Health groups — liveness vs readiness (important for Kubernetes probes)
- `management.endpoint.health.show-details=always` in dev, `when-authorized` in production
- **Micrometer integration** — `/actuator/prometheus` exposes metrics; `MeterRegistry`, `Counter`, `Gauge`, `Timer`, `DistributionSummary`

### 6.2 Application Events & Lifecycle
- `ApplicationContext` lifecycle events — `ContextRefreshedEvent`, `ContextStartedEvent`, `ContextStoppedEvent`, `ContextClosedEvent`
- `ApplicationReadyEvent` — fired when the app is ready to serve traffic
- `@EventListener` vs implementing `ApplicationListener<E>`
- `@TransactionalEventListener` — bind event publishing to a transaction phase (AFTER_COMMIT, BEFORE_COMMIT, etc.)
- **Graceful shutdown** — `server.shutdown=graceful`, `spring.lifecycle.timeout-per-shutdown-phase`; Kubernetes sends SIGTERM, Spring waits for in-flight requests before stopping. Critical for zero-downtime rolling deploys.

### 6.3 Spring Profiles & Multi-Environment Config
- Profile-specific `application-{profile}.yml` files
- Activating profiles — `spring.profiles.active` env var (production standard), `@ActiveProfiles` in tests
- Profile groups — `spring.profiles.group.production=prod,metrics`
- `@Profile` on `@Bean` and `@Configuration` classes
- Test slices inherit test profile by default; using `@ActiveProfiles("test")` in tests

---

## PART 7 — ADVANCED MICROSERVICES

### 7.1 Service Communication Patterns
- **Synchronous REST with `RestClient`** (Spring 6.1+ default) — fluent, blocking HTTP client
- **`WebClient`** (reactive, non-blocking) — preferred when you're in a reactive stack or need async
- **OpenFeign** — declarative HTTP client; `@FeignClient`, `@GetMapping`/`@PostMapping` on an interface; automatic load balancing integration; error handling via `ErrorDecoder`; request/response interceptors for adding headers (e.g., auth propagation)
- **gRPC** — binary, contract-first (`.proto` files), HTTP/2, bidirectional streaming; `grpc-spring-boot-starter`; when to use it (internal service-to-service, high throughput, streaming)
- Propagating headers across service calls — `X-Request-Id`, `Authorization` (JWT forwarding), trace context (`traceparent` W3C header)

### 7.2 Service Discovery
- **Why hardcoding service URLs breaks** — instances scale up/down, IPs change, health varies
- **Client-side discovery (Eureka)** — each service registers itself; consumers query the registry and load-balance locally; `@EnableEurekaServer`, `spring.application.name`, `eureka.client.service-url`
- **Server-side discovery** — the gateway/LB queries the registry (AWS ALB + ECS service discovery, Kubernetes DNS)
- **Kubernetes-native service discovery** — K8s DNS (`http://order-service`) replaces Eureka entirely; why you remove Eureka when deploying to K8s

### 7.3 API Gateway — Spring Cloud Gateway
- What an API gateway does — single entry point; routing, auth, rate limiting, request/response transformation, CORS, TLS termination, circuit breaking
- Route configuration — predicates (`Path`, `Host`, `Method`), filters (`StripPrefix`, `AddRequestHeader`, `RewritePath`)
- Built-in filters — `RequestRateLimiter` (backed by Redis), `CircuitBreaker`, `RetryGatewayFilter`
- Custom `GatewayFilter` — authentication validation, request enrichment (injecting user context)
- Global filters — apply to all routes (e.g., correlation-ID injection, logging)
- Gateway vs load balancer — the distinction

### 7.4 Centralized Configuration — Spring Cloud Config
- Config server — reads from a Git repo (or filesystem, Vault, Consul); serves config to client services
- Client config — `spring.config.import=configserver:http://config-server:8888`
- Encryption/decryption of sensitive values — symmetric key or keypair
- `@RefreshScope` + Spring Cloud Bus (`/actuator/refresh` or bus-refresh)
- Why centralized config matters in production — one place to change; audit trail; no redeploy for config changes

### 7.5 Resilience4j (Production Fault Tolerance)
- Why the Hystrix era is over — Hystrix is in maintenance mode; Resilience4j is the current standard

**Circuit Breaker:**
- States — **CLOSED** (normal, passes calls through), **OPEN** (trips when failure rate exceeds threshold; fails fast), **HALF-OPEN** (probes a limited number of test calls)
- Config — `failureRateThreshold` (% of calls that must fail to open), `slidingWindowSize`, `minimumNumberOfCalls` (minimum before evaluating), `waitDurationInOpenState`, `permittedNumberOfCallsInHalfOpenState`
- Slow call threshold — open the circuit if calls are too slow (not just failing)
- Event publishing — listen to state transitions for alerting
- Health indicator — exposes circuit state to `/actuator/circuitbreakers`

**Retry:**
- `maxAttempts`, `waitDuration` (fixed) or **exponential backoff** (`ExponentialBackoffIntervalFunction`)
- **Jitter** — randomize wait to prevent thundering herd when many services retry simultaneously
- `retryExceptions` — only retry transient failures (e.g., `SocketTimeoutException`, 503)
- `ignoreExceptions` — never retry (e.g., `IllegalArgumentException`, business exceptions)
- **Critical rule** — never retry a non-idempotent operation (POST to payment) without an idempotency key, or you double-charge/double-submit

**Rate Limiter:**
- Limits the rate of outgoing calls to protect a downstream service
- `limitForPeriod`, `limitRefreshPeriod`, `timeoutDuration`
- Useful for third-party APIs with rate limits (Stripe, Twilio, etc.)

**Bulkhead:**
- **Semaphore Bulkhead** — limits concurrent calls (lightweight, same thread); `maxConcurrentCalls`
- **Thread Pool Bulkhead** — runs calls on a separate thread pool; isolates blocking calls (e.g., a slow DB call shouldn't starve other operations)
- Why bulkheads matter — one slow dependency should not exhaust the thread pool of the whole service

**Time Limiter:**
- Bounds the duration of async calls; throws `TimeoutException` after `timeoutDuration`
- Must be combined with `CompletableFuture` or reactive

**Decorator composition and order:**
- The recommended order: `RateLimiter → Bulkhead → TimeLimiter → CircuitBreaker → Retry`
- Why order matters — e.g., putting Retry outside CircuitBreaker means retries still go through a closed circuit; putting it inside means no retries against an open circuit (which is usually what you want)

**Fallbacks:**
- `@CircuitBreaker(name = "...", fallbackMethod = "myFallback")` — invoke when circuit is open or call fails
- Fallback must have the same signature + a `Throwable` parameter
- Return sensible defaults, cached data, or a degraded response — not exceptions

**Metrics:**
- Resilience4j integrates with Micrometer; expose `/actuator/prometheus` to see circuit breaker state, call counts, failure rate in Grafana

### 7.6 Distributed Transactions — Saga Pattern
- Why distributed ACID transactions don't work across services — two-phase commit (2PC) creates tight coupling and is a distributed deadlock waiting to happen
- **Saga = a sequence of local transactions**, each publishing an event/message when it completes; if one fails, compensating transactions undo the previous steps
- **Choreography** — services react to events from the previous step; no central coordinator; loose coupling; harder to visualize and trace
- **Orchestration** — a central orchestrator (saga coordinator) tells each service what to do via commands; easier to reason about; the orchestrator can be its own service or a state machine in the originating service
- **Compensating transactions** — must be idempotent (they may be retried); not always a simple rollback (e.g., "cancel order" is not the same as deleting it)
- Handling partial failures — the compensating chain; what happens if a compensating transaction fails; retry with idempotency keys

### 7.7 The Outbox Pattern (Reliable Event Publishing)
- The **dual-write problem** — if you update the DB and publish to Kafka in the same method, they can go out of sync (DB commit succeeds but Kafka publish fails, or vice versa); never do both independently
- **Outbox solution** — write the event to an `outbox` table in the **same local DB transaction** as the business data change; a separate **relay process** (poller or CDC) reads the outbox and publishes to Kafka
- The relay guarantees at-least-once delivery; consumers must be **idempotent** (dedupe on event ID)
- CDC approach — **Debezium** reads the Postgres WAL (write-ahead log) and publishes each outbox table INSERT to Kafka automatically, with no polling latency
- Polling approach — a scheduled job reads unpublished outbox rows and publishes them; simpler but adds latency

### 7.8 CQRS (Command Query Responsibility Segregation)
- Core idea — separate the write model (commands that change state) from the read model (queries that return state)
- Why — write model can be normalized for consistency; read model can be denormalized, precomputed, or materialized for query performance
- In a Kafka/event-driven system — domain events from the write side update read-model projections (materialized views)
- When it's worth it — high read/write asymmetry, complex read requirements, separate scaling needed; not for simple CRUD
- Event sourcing — a related but more extreme pattern; store only events, not current state; derive state by replaying events

### 7.9 Idempotency in Distributed Systems
- Why idempotency is critical — in at-least-once delivery (Kafka default, HTTP retries), the same request may arrive multiple times; non-idempotent operations cause double-charges, duplicate records
- **Idempotency key pattern** — client sends a unique key (UUID) with each request; server stores processed key-result pairs (in Redis or DB); on retry, returns the stored result without reprocessing
- Redis SETNX for distributed idempotency — `SET key value NX EX ttl` atomically sets only if not exists
- Making Kafka consumers idempotent — include a unique event ID in each event; store processed event IDs; before processing, check if already processed
- Idempotent producers in Kafka — `enable.idempotence=true` prevents duplicate messages due to producer retries

### 7.10 API Gateway Patterns
- **Backend-for-Frontend (BFF)** — a gateway tailored for a specific frontend (mobile BFF, web BFF); aggregates calls, transforms data for each client's needs
- **Aggregation** — one gateway call that fans out to multiple downstream services and merges the results
- **Request transformation** — modify request headers, body, or path before forwarding
- **Response transformation** — mask sensitive fields, restructure the response
- **Authentication at the gateway** — validate the JWT once at the gateway; pass user context (user ID, roles) as a header downstream; services trust the gateway header

---

## PART 8 — MESSAGING WITH APACHE KAFKA

### 8.1 Kafka Fundamentals
- **Topics** — logical channel for messages; an append-only log
- **Partitions** — a topic is split into partitions; each partition is an ordered, immutable log; this enables parallelism and horizontal scaling
- **Offsets** — each message in a partition has a unique offset; consumers track their offset
- **Producers** — publish messages to a topic; choose the partition via key (same key → same partition, guaranteeing order per key) or round-robin
- **Consumers** — read messages from partitions; commit offsets to track progress
- **Consumer groups** — a group of consumers cooperatively consuming a topic; each partition is consumed by exactly one consumer in the group; scale consumers up to the number of partitions
- **Replication** — each partition is replicated across brokers; one leader (handles reads/writes) + followers (replicas); `replication.factor`
- **Retention** — messages are retained for a configurable period (time or size) regardless of consumption; replay is possible

### 8.2 Delivery Semantics
- **At-most-once** — commit offset before processing; messages may be lost on crash
- **At-least-once** — commit offset after processing; messages may be processed more than once on crash/retry (the production default)
- **Exactly-once** — Kafka's transactional API + idempotent producer; very hard to achieve end-to-end and has performance cost; usually simulated with at-least-once + idempotent consumers

### 8.3 Spring for Apache Kafka
- `KafkaTemplate<K, V>` — `send()`, `sendDefault()`, `executeInTransaction()`
- `@KafkaListener` — `topics`, `groupId`, `containerFactory`, `concurrency`; return type for reply-to patterns
- `ConsumerRecord<K, V>` vs `@Payload` vs message conversion (Jackson)
- **Error handling** — `DefaultErrorHandler` (replaces old `SeekToCurrentErrorHandler`); `BackOffPolicies`; configuring retry attempts
- **Dead Letter Topics (DLT)** — messages that fail after all retries are published to a `<topic>.DLT` topic; `DeadLetterPublishingRecoverer`
- Batch listeners — consume a list of records at once for higher throughput
- Message headers — accessing Kafka headers in `@KafkaListener` methods

### 8.4 Schema Management
- Why schemas matter — producer and consumer must agree on message format; schema changes break consumers
- **Schema Registry** (Confluent or Apicurio) — central schema store; producer registers schema; consumer fetches schema by ID embedded in each message
- **Avro** — binary, compact, schema evolution rules; `SpecificRecord` vs `GenericRecord`
- **Protobuf** — Google's binary protocol; strongly typed; efficient
- **Schema evolution** — backward-compatible changes (add optional fields), forward-compatible changes (remove fields), breaking changes (require schema versioning strategy)
- `spring-kafka` + Avro + Schema Registry integration

### 8.5 Kafka in Production
- Consumer lag monitoring — the most important Kafka operational metric; measured per consumer group + topic + partition
- Rebalancing — happens when consumers join/leave or partitions change; can cause a brief pause in processing; use `CooperativeStickyAssignor` to minimize rebalancing impact
- **Idempotent producer** — `enable.idempotence=true`; prevents duplicates on producer retry
- **Transactional producer** — write to multiple partitions/topics atomically; `transactional.id`
- Partition key design — distribute load evenly; avoid hot partitions; consider ordering requirements
- Compression — `compression.type=snappy` or `lz4` to reduce broker disk and network usage
- `acks=all` — producer waits for all in-sync replicas to acknowledge; safest setting for data durability

---

## PART 9 — REDIS IN PRODUCTION

### 9.1 Core Usage Patterns
- **Cache-aside** — check cache first; on miss, load from DB, populate cache; on write, invalidate or update cache; the most common pattern
- **Read-through** — cache is between app and DB; cache loads data on miss; app only talks to cache
- **Write-through** — write to cache and DB synchronously; consistent but adds write latency
- **Write-behind (write-back)** — write to cache immediately, DB asynchronously; low latency but risk of data loss
- **TTL-based expiry** — always set a TTL; never cache indefinitely (stale data)
- **Eviction policies** — `allkeys-lru` (evict least recently used when full — use this for caches), `volatile-lru`, `noeviction` (default — returns error when full — wrong for caches)

### 9.2 Cache Stampede Prevention
- When many requests miss the cache simultaneously (e.g., after cache warms up, or TTL expires on a hot key), all go to DB — the stampede
- **Solution 1 — Probabilistic early expiration** — random early refresh before TTL expires
- **Solution 2 — Distributed lock on cache miss** — acquire a lock; one process loads from DB; others wait and then hit cache; implemented with `SET key value NX EX`
- **Solution 3 — Jitter on TTL** — add random variance to TTL so all entries don't expire simultaneously

### 9.3 Distributed Locks
- `SET key value NX EX seconds` — atomic "set if not exists" with expiry; the correct single-instance distributed lock
- Always set an expiry to prevent lock starvation if the holder crashes
- **Redlock** — distributed lock across multiple Redis nodes for high availability; controversial (Martin Kleppmann's analysis); use with caution in strict scenarios
- Use cases — preventing duplicate processing, leader election, rate limiting

### 9.4 Redis Data Structures for Production Use Cases
- **Strings** — sessions, counters (`INCR`), idempotency keys, feature flags
- **Hashes** — storing objects (user sessions, cart contents) — more efficient than serializing to JSON
- **Lists** — message queues, activity feeds (LPUSH/RPOP for queue semantics)
- **Sets** — unique visitors, tags, "users who viewed this"
- **Sorted Sets** — leaderboards (ZADD with score), rate limiting (sliding window), delayed job queues (score = execution time)
- **Streams** — lightweight message streaming (alternative to Kafka for simpler use cases); consumer groups

### 9.5 Redis with Spring Boot
- `spring-boot-starter-data-redis` — autoconfigures `RedisTemplate` and `StringRedisTemplate`
- `RedisTemplate<K, V>` — serialization matters; use `Jackson2JsonRedisSerializer` for values, `StringRedisSerializer` for keys (never default Java serialization in production)
- `@Cacheable`/`@CachePut`/`@CacheEvict` with `RedisCacheManager`
- `RedisCacheConfiguration` — default TTL, key prefix, serialization config
- Reactive Redis — `ReactiveRedisTemplate` for reactive stacks

---

## PART 10 — OBSERVABILITY IN SPRING BOOT

### 10.1 Structured Logging
- Use `SLF4J` as the facade; **Logback** or **Log4j2** as implementation
- **Structured logging** — log as JSON (`logstash-logback-encoder`), not plain text; fields like `timestamp`, `level`, `logger`, `message`, `traceId`, `spanId`, `userId`, `requestId`
- **Correlation IDs** — generate a unique `X-Request-Id` at the gateway; propagate as an MDC (`MDC.put("requestId", id)`) so every log line for a request shares the same ID; critical for debugging in a microservices system
- Log levels — `ERROR` (unexpected, needs attention), `WARN` (unexpected but handled), `INFO` (significant business events), `DEBUG` (diagnostic detail), `TRACE` (very verbose); change levels at runtime via `/actuator/loggers`
- What NOT to log — passwords, tokens, PII, credit card numbers

### 10.2 Metrics with Micrometer
- Micrometer = a vendor-neutral metrics facade (like SLF4J for metrics)
- Metric types — `Counter` (monotonically increasing), `Gauge` (up or down value), `Timer` (duration + count), `DistributionSummary` (value distribution), `LongTaskTimer` (long-running tasks)
- Auto-configured metrics — JVM (heap, GC, threads), HTTP requests (count, duration), DataSource (HikariCP pool), Kafka consumer/producer, Resilience4j
- Custom business metrics — `meterRegistry.counter("orders.placed", "status", status).increment()`
- Tags — dimensions that let you slice metrics (e.g., `method`, `status`, `service`, `endpoint`)
- Prometheus scraping — `management.endpoints.web.exposure.include=prometheus`; Prometheus scrapes `/actuator/prometheus`; Grafana visualizes

### 10.3 Distributed Tracing with OpenTelemetry
- **Trace** = the full journey of a request across all services
- **Span** = one unit of work in the trace (one service call, one DB query); has start time, duration, tags, logs
- **Context propagation** — the `traceparent` W3C header carries `traceId` + `spanId` between services; without propagation, traces break at service boundaries
- **OpenTelemetry** (OTel) — the CNCF standard for traces, metrics, and logs; replaces vendor-specific agents and Sleuth-specific integrations; `opentelemetry-spring-boot-starter`
- **Micrometer Tracing** (Spring Boot 3.x) — integrates with OTel; replaces Spring Cloud Sleuth; auto-instruments `@Transactional`, JDBC, Kafka, HTTP clients
- Trace backends — **Jaeger**, **Grafana Tempo**, **Zipkin** — store and visualize traces; configure exporter (`OTLP`, `Zipkin`)
- Sampling — tracing every request at high traffic is expensive; configure sampling rate (e.g., 10% in production, 100% in dev); head-based vs tail-based sampling

---

## PART 11 — SECURITY IN SPRING MICROSERVICES

### 11.1 Secrets Management
- **Never hardcode secrets in code or config files**
- Never commit secrets to Git — even in "test" or "dev" branches
- **Vault (HashiCorp)** — dynamic secrets (short-lived credentials generated on demand), static secrets (stored securely), secret rotation; `spring-cloud-vault`
- **AWS Secrets Manager** / **Parameter Store** — managed secrets in AWS; rotate automatically; integrate with EKS via IRSA (IAM Roles for Service Accounts)
- **Kubernetes Secrets** — base64 encoded (not encrypted by default); enable encryption at rest; use External Secrets Operator to sync from Vault/AWS Secrets Manager into K8s secrets

### 11.2 Service-to-Service Security
- **mTLS (mutual TLS)** — both client and server present certificates; verifies identity of both sides; the correct solution for service-to-service trust
- **Service mesh (Istio/Linkerd)** — manages mTLS transparently across all services; no app-level cert management; also handles traffic management, observability, retries
- **JWT propagation** — passing the user's JWT through to downstream services for identity context; validate at every service or only at the gateway (tradeoffs)

### 11.3 OWASP Top 10 (Spring Applications)
- **Injection** — SQL/JPQL injection (use parameterized queries/Criteria API, never string concatenation); command injection
- **Broken authentication** — short-lived JWTs, proper token validation, no plain passwords, MFA
- **Broken access control** — `@PreAuthorize` checks, never trust input for authorization decisions
- **Security misconfiguration** — actuator endpoints secured, CORS restricted, debug off in production, no default credentials
- **Vulnerable components** — Snyk/Dependabot for dependency scanning; image scanning with Trivy
- **SSRF (Server-Side Request Forgery)** — validate and restrict URLs the application fetches; allowlist trusted hosts
- **Insecure deserialization** — never deserialize untrusted data without strict type whitelisting
- **Logging PII** — do not log sensitive user data

---

## PART 12 — SPRING REACTIVE (BONUS — WebFlux)

### 12.1 Why Reactive
- Traditional blocking model — one thread per request; threads block waiting for I/O; limits concurrency to thread pool size
- Reactive model — non-blocking I/O; a small number of threads handle many requests via event loop; scales better for I/O-heavy workloads (many network calls, streaming)
- **When to use WebFlux** — high-concurrency I/O-heavy services, streaming, SSE, real-time applications; not for CPU-heavy workloads (no benefit)

### 12.2 Project Reactor
- `Mono<T>` — 0 or 1 item asynchronously
- `Flux<T>` — 0 to N items asynchronously
- Core operators — `map`, `flatMap`, `filter`, `zip`, `merge`, `concatMap`, `switchIfEmpty`, `onErrorReturn`, `onErrorResume`, `retry`, `timeout`, `delayElements`
- `flatMap` vs `concatMap` — flatMap runs inner publishers concurrently (non-deterministic order); concatMap runs sequentially
- **Backpressure** — subscriber signals how many items it can handle; prevents overwhelming a slow consumer; `onBackpressureBuffer`, `onBackpressureDrop`, `onBackpressureLatest`
- Schedulers — `Schedulers.boundedElastic()` for blocking I/O in reactive, `Schedulers.parallel()` for CPU work
- Do NOT block in a reactive chain (no `block()`, no thread sleeps) — it defeats the purpose and starves the event loop

### 12.3 Spring WebFlux
- `@RestController` works with WebFlux; return `Mono<T>` or `Flux<T>` from handler methods
- **Functional routing** — `RouterFunction` + `HandlerFunction` — an alternative to annotation-based controllers
- **R2DBC** — reactive non-blocking JDBC; `ReactiveCrudRepository`; does not support JPA/Hibernate (they are blocking)
- `WebClient` (non-blocking) — the reactive alternative to `RestTemplate`; proper for reactive stacks
- **Server-Sent Events (SSE)** — streaming data to clients; return `Flux<ServerSentEvent<T>>`

---

## Quick Reference — Technologies & Versions (2026 Production Baseline)

| Component | Production Version | Notes |
|---|---|---|
| Java | **Java 21** (LTS) | Records, sealed classes, virtual threads (Loom), pattern matching |
| Spring Boot | **3.3.x / 3.4.x** | Requires Java 17 minimum; native image support |
| Spring Framework | **6.1.x** | Observability overhaul, RestClient, problem details |
| Hibernate | **6.x** | Via Spring Data JPA 3.x |
| Spring Cloud | **2023.x / 2024.x** | Micrometer Tracing replaces Sleuth |
| Resilience4j | **2.x** | Spring Boot 3 native support |
| Kafka | **3.x** | KRaft mode (no ZooKeeper dependency) |
| Spring Security | **6.x** | Lambda DSL only (no method chaining deprecated API) |
| MapStruct | **1.5.x** | Annotation processor |
| Flyway | **10.x** | DB migrations |
| Testcontainers | **1.19.x** | Spring Boot 3.1+ has native Testcontainers support |
| Micrometer | **1.12.x** | Includes Micrometer Tracing |

---

*That is the complete topic reference for Spring Boot and Microservices. Every section is something you need to understand deeply and implement in running code — not just read about. Start with Part 1 (Core) and Part 2 (MVC), build on them with Part 3 (JPA) and Part 4 (Security), then move into Microservices (Parts 7–12). Observability (Part 10) and security (Parts 4 and 11) weave through everything.*
ROADMAP_EOF
echo "Spring Boot topics file complete."
wc -w /home/claude/springboot_topics.md