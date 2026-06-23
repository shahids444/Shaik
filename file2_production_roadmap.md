# FILE 2 — The Production God Roadmap: 5 Months to End-to-End Mastery

> **Goal:** In 5 months, become a genuinely elite, production-grade engineer — someone who can design, build, secure, deploy, observe, and *operate* real systems the way they actually run inside top product companies. **Production-only.** If a tool/practice isn't used in real production, it's not here. Everything needed for an end-to-end production developer *is* here.
>
> **This is not interview prep.** (That's File 3.) This file builds the actual capability. The bet: once you've *built and run* production systems, interviews become "let me tell you how I did this," and your GitHub proves it before you speak.
>
> **Effort assumption:** ~3 focused hours on weekdays, ~6–7 on weekend days. If you do less, the calendar stretches — but never dilute the depth. **The definition of "done" for everything below: containerized · deployed · observable · tested · documented.** A skill you can't demonstrate in running, deployed code is a skill you don't have yet.

---

## The Core Idea — One Evolving Capstone

You will build **one real system** and harden it continuously across all 5 months until it's a fully production-deployed, observable, secured, multi-service platform. Pick a domain rich enough to exercise every pattern:

- **Recommended: an e-commerce platform** (users, catalog, cart, orders, payments, inventory, notifications) **or a fintech/payments platform** (accounts, transactions, ledger, settlements). Both naturally force Saga, idempotency, and event-driven patterns later.

This single capstone is your crown-jewel portfolio piece. Maintain **two GitHub repos** from Day 1: the capstone itself, and `production-notes` where you write every concept in your own words (this doubles as revision material and proves depth).

---

## What "Production-Grade" Actually Means (Your North Star)

Every item below is taught and built in this plan. This list *is* the definition of the engineer you're becoming. Production code is:

- **Resilient** — survives downstream failure without cascading (circuit breakers, retries-with-backoff, timeouts, bulkheads, fallbacks, graceful degradation).
- **Observable** — you can answer "what is it doing right now, and why" without shipping new code (structured logs + correlation IDs, metrics/the four golden signals, distributed traces).
- **Configurable without redeploy** — externalized config, profiles, secrets in a vault (never in code/Git), feature flags.
- **Secure by default** — OAuth2/OIDC/JWT, secrets management, input validation, dependency + image scanning, least-privilege IAM, TLS/mTLS.
- **Consistent under failure** — knows ACID dies across services; uses Saga, the Outbox pattern, idempotency keys, eventual consistency correctly.
- **Deployable safely and repeatably** — containerized, versioned, shipped via automated pipelines with canary/blue-green and instant rollback. **(The heart of this plan.)**
- **Tested at every layer** — unit, integration (real deps via Testcontainers), component, contract, load, fault-injection, mutation.
- **Operable** — health/readiness/liveness probes, autoscaling, SLIs/SLOs/error budgets, runbooks, graceful shutdown.
- **Performant under real load** — profiled, connection-pooled, cached at the right layers, with queries that hold up at scale.

---

## The Complete Production Stack (The Territory)

Sequenced so each layer builds on the last. Go **deep on one stack** — that focus is what makes you elite instead of shallow-everywhere.

1. **Language/Core (hardened for production):** Modern Java (17/21 LTS — records, sealed classes, pattern matching, virtual threads/Project Loom), production Java patterns, JVM behavior under load, concurrency for real workloads.
2. **Backend mastery:** Spring Boot (deep, not CRUD), Spring Data JPA/Hibernate at scale, Spring Security, Spring Cloud (Config, Gateway, discovery), and reactive Spring (WebFlux/R2DBC) as a bonus.
3. **Data & messaging:** PostgreSQL (indexing, query plans, transactions, pooling), Redis (caching, distributed locks, idempotency), Apache Kafka (event-driven backbone), NoSQL awareness (MongoDB/DynamoDB).
4. **Advanced microservices:** service discovery, API gateway, REST/OpenFeign/gRPC, **Resilience4j** (circuit breaker, retry, rate limiter, bulkhead, time limiter), **Saga, Outbox, CQRS, idempotency**, distributed tracing.
5. **Testing (all layers):** JUnit 5, Mockito, Spring test slices, Testcontainers, WireMock, component tests, contract tests (Spring Cloud Contract/Pact), load tests (Gatling/k6), mutation tests (PIT).
6. **OS & scripting:** Linux (the runtime of everything), Bash, Git mastery (rebase, bisect, reflog).
7. **Containers & orchestration (deployment core):** Docker (multi-stage, non-root, Compose), Kubernetes (Pods → Operators), Helm.
8. **CI/CD & GitOps (deployment core):** GitHub Actions + Jenkins, the modern CI-runner + **ArgoCD** GitOps split, **Argo Rollouts** for canary/blue-green, registries, supply-chain security (image scan, SBOM, signing).
9. **Cloud (AWS deep):** EC2, ECS, EKS, Lambda, S3, RDS, DynamoDB, ElastiCache, VPC, ALB, CloudFront, Route 53, API Gateway, IAM, SQS/SNS, **Terraform** (IaC), CloudWatch.
10. **Observability & SRE:** logs/metrics/traces, Prometheus + Grafana, ELK/Splunk, **OpenTelemetry** (the 2026 vendor-neutral standard), Jaeger/Tempo, SLIs/SLOs/error budgets, incident response, chaos engineering.
11. **Frontend (production React, since you're full-stack):** TypeScript-first React, performance (code splitting, memoization, Suspense/streaming, Core Web Vitals), state (TanStack Query + Redux Toolkit/Zustand), testing (Jest/RTL/Playwright/MSW), frontend observability (browser OpenTelemetry, RUM).
12. **Security & quality (cross-cutting):** OWASP Top 10, OAuth2/OIDC + Keycloak, secrets (Vault), SAST/DAST/dependency/image scanning (SonarQube/Snyk/Trivy), quality gates.

> **A note on what's deliberately *excluded*:** legacy/rare-in-production tooling. No Hystrix (dead — Resilience4j replaced it). No `ddl-auto=update` in prod (Flyway/Liquibase instead). No Spring Cloud Sleuth as primary (Micrometer Tracing + OpenTelemetry now). No H2-for-integration-tests (Testcontainers with the real DB). No clicking-in-consoles for infra (Terraform). This plan keeps only what real teams run in 2026.


---

# 🟦 MONTH 1 — Spring Boot Mastery + The Full Testing Discipline

**Outcome:** Stop being a "Spring user," become someone who understands Spring the way an operator does — and can test at every layer. By month-end your capstone is a cleanly-architected, fully-tested backend service.

## Week 1 — Spring Core & Boot Internals (the *why*)
**📚 Learn deeply:**
- **IoC container & ApplicationContext** — bean definition, `BeanFactory` vs `ApplicationContext`, lazy vs eager init.
- **Full bean lifecycle** — instantiation → dependency population → aware-interfaces → `BeanPostProcessor` (before-init) → `@PostConstruct` → `InitializingBean` → custom init → in-use → `@PreDestroy` → `DisposableBean`. Know *why* `BeanPostProcessor` is the hook that powers AOP.
- **DI done right** — constructor vs setter vs field; *why constructor injection is the production standard* (immutability, testability, fail-fast, no reflection hacks in tests).
- **Bean scopes** — singleton (+ thread-safety implications), prototype, request/session/application.
- **Auto-configuration internals** — `@SpringBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`; the `@Conditional` family that drives the "magic"; what a starter actually is.
- **Spring AOP** — JDK dynamic vs CGLIB proxies, advice types, pointcuts; why `@Transactional`/`@Async` are AOP-based and the **self-invocation gotcha** that silently breaks them.

**🛠️ Build:** Scaffold the capstone with clean layered, package-by-feature architecture (controller → service → repository). Write a custom `BeanPostProcessor` that logs each lifecycle phase. Write a tiny custom auto-configuration gated by `@ConditionalOnProperty`. Write a `@LogExecutionTime` aspect, trigger the self-invocation gotcha, then fix it — document what happened.

## Week 2 — Spring MVC, Production REST, Config & Profiles
**📚 Learn:**
- **MVC request lifecycle** — `DispatcherServlet` → handler mapping → handler adapter → controller → message converters → response; filters vs interceptors.
- **Production REST design** — resource modeling, correct verbs/status codes, idempotency of PUT/DELETE, **API versioning** (URI vs header vs content negotiation), pagination/filtering/sorting, **DTOs vs entities** (never expose JPA entities — why), MapStruct mapping.
- **Validation** — Bean Validation (`@Valid`, constraints, custom validators, nested/collection validation, validation groups).
- **Global error handling** — `@RestControllerAdvice` + `@ExceptionHandler`, a consistent error contract (**RFC 7807 Problem Details**), mapping domain exceptions to HTTP.
- **Config management** — `application.yml` hierarchy, **profiles** (`@Profile`, profile-specific files), `@ConfigurationProperties` (type-safe) vs `@Value`, config precedence, env-specific config (foundation for never hardcoding).

**🛠️ Build:** Full REST surface for the core domain — DTOs + MapStruct, full validation incl. a custom validator, RFC 7807 errors, pagination/filtering/sorting, clean versioning. Add OpenAPI/Swagger (springdoc). Set up dev/staging/prod profiles; prove the same jar behaves differently via env vars only. Write a "how a request flows through Spring MVC" note with a diagram.

## Week 3 — Spring Data JPA / Hibernate at Production Scale
**📚 Learn (where most "Spring devs" are secretly weak):**
- **Layers** — JPA (spec) vs Hibernate (impl) vs Spring Data JPA (repos).
- **Entity mapping depth** — ID generation strategies and their performance (IDENTITY vs SEQUENCE vs TABLE), all relationship types, **owning vs inverse side**, `mappedBy`, cascade, orphan removal.
- **The N+1 problem** — *the* defining issue. Detect it (SQL logging, Hibernate statistics) and fix every way: `JOIN FETCH`, `@EntityGraph`, `@BatchSize`, DTO projections.
- **Fetch strategies** — LAZY vs EAGER, `LazyInitializationException`, the open-session-in-view anti-pattern (disable it).
- **Persistence context & entity lifecycle** — transient → managed → detached → removed; dirty checking; flush timing; `save` vs `saveAndFlush`; first-level cache.
- **Transactions for real** — `@Transactional` **propagation** (REQUIRED, REQUIRES_NEW, NESTED, etc.) with scenarios; **isolation levels** and the anomalies they prevent (dirty/non-repeatable/phantom reads); read-only tx; rollback rules; the self-invocation gotcha again.
- **Performance** — second-level cache (when it helps/hurts), batch inserts/updates, projections, **HikariCP** pooling (sizing, leak detection, timeouts).
- **Migrations** — **Flyway** (or Liquibase): versioned schema migrations, the production-correct way to evolve a DB (**never `ddl-auto=update` in prod**).

**🛠️ Build:** Model the domain with proper relationships; deliberately create an N+1, observe it in SQL logs, fix it three ways, benchmark each. Add Flyway migrations for the whole schema (baseline + incremental); turn off auto-DDL. Configure HikariCP explicitly with leak detection. Write one `@EntityGraph` and one DTO-projection query; document the SQL each generates.

## Week 4 — The Full Testing Discipline (every layer)
A cornerstone week — production engineers test at every layer.
**📚 Learn the pyramid layer by layer:**
- **Unit — JUnit 5** — lifecycle, assertions, assumptions, `@ParameterizedTest` (`@ValueSource`/`@CsvSource`/`@MethodSource`), `@Nested`, `@DisplayName`, `assertThrows`, timeouts.
- **Mocking — Mockito** — mocks vs stubs vs spies vs fakes (know the difference), `@Mock`/`@InjectMocks`/`@Spy`, `when/thenReturn`, `doThrow/doAnswer`, **`ArgumentCaptor`**, `verify` (times/never/atLeast), strict vs lenient stubbing, mocking static/final (`mockito-inline`).
- **Spring test slices (fast, targeted)** — `@WebMvcTest` + `MockMvc` (web layer, `@MockBean` services), `@DataJpaTest` (persistence), `@SpringBootTest` (full integration) — and *when each is appropriate*.
- **Integration tests with Testcontainers** — spin up real **PostgreSQL/Redis/Kafka** in Docker for tests (not H2). Strong production signal.
- **Component testing** — test a single service in isolation end-to-end (its API → its DB) with real infra via Testcontainers but external collaborators stubbed (WireMock) — the "service-level" test between unit and full integration.
- **Mock external HTTP — WireMock** — simulate downstreams incl. failures/timeouts/500s to test *your* resilience and error handling.
- **Contract testing — Spring Cloud Contract / Pact** — ensure services agree on API contracts so independent deploys don't break each other.
- **Load & performance — Gatling / k6 (or JMeter)** — define a load profile, run it, read p50/p95/p99 latency + throughput, find the breaking point.
- **Test quality** — line vs branch coverage, why chasing 100% is wrong, and **mutation testing (PIT)** as the real measure of test effectiveness.
- **TDD** — red-green-refactor for at least one feature.

**🛠️ Build:** Meaningful coverage on the capstone — unit (Mockito) for all service logic, `@WebMvcTest` for controllers, `@DataJpaTest` + **Testcontainers** for repos, ≥1 full `@SpringBootTest`, ≥1 **component test**, a **WireMock** test simulating downstream failure, a **Gatling/k6** load-test report (committed), and one **PIT mutation** run (read the report — note where tests were weaker than coverage suggested). Do one feature fully TDD.

**✅ Month 1 done when you can demonstrate:** clean Spring Boot service (DTOs, validation, RFC 7807, versioning, OpenAPI); explain bean lifecycle, auto-config, AOP proxies, N+1 (+3 fixes), tx propagation/isolation from memory; Flyway + explicit HikariCP (no auto-DDL, no hardcoded config); a genuinely tested codebase across all layers above with a load-test report and a mutation run.


---

# 🟩 MONTH 2 — Advanced Microservices + Data & Messaging (Production Patterns)

**Outcome:** Your single service becomes a resilient, event-driven *system*. You learn the patterns that keep real distributed systems alive.

## Week 5 — PostgreSQL Deep + Redis (production data layer)
**📚 PostgreSQL (not just `SELECT *`):** indexing mastery (B-tree/hash/GIN/BRIN, composite-index **column order**, covering/partial indexes, when an index *hurts*, index-only scans); reading **`EXPLAIN ANALYZE`** (seq vs index vs bitmap scan, nested-loop vs hash vs merge join, finding the slow node); transactions & concurrency (isolation levels, MVCC, row locking, `SELECT ... FOR UPDATE`, deadlocks, **optimistic vs pessimistic locking**); partitioning, `VACUUM`/autovacuum, connection limits; scaling (read replicas, when to shard).

**📚 Redis (production):** caching patterns (**cache-aside** default, read-through, write-through, write-behind); **TTL + eviction** (LRU/LFU); cache invalidation; **cache stampede** prevention (locks, jitter); Redis as **distributed lock** (`SETNX`, Redlock + its caveats), rate-limiter store, session store, and **idempotency keys**; data structures (strings/hashes/lists/sets/sorted-sets for leaderboards) and when each fits.

**🛠️ Build:** Add cache-aside caching to hot reads with sensible TTLs; reproduce a cache stampede and fix it. Add proper indexes based on `EXPLAIN ANALYZE` of your real queries (document before/after plans + timings). Implement Redis-backed idempotency. Add optimistic locking (`@Version`) on a concurrently-updated entity (e.g., inventory) with a test proving it prevents lost updates.

## Week 6 — Microservices Foundations + Spring Cloud
**📚 Learn:** when microservices are right (vs a modular monolith) — decomposition by **bounded context** (DDD), database-per-service, the costs you take on; **service discovery** (why hardcoding URLs breaks; Eureka vs K8s-native DNS); **API gateway** (Spring Cloud Gateway — routing, auth, rate limiting, transformation, CORS; gateway vs load balancer); **centralized config** (Spring Cloud Config); inter-service comms — sync (`RestClient`/`WebClient`/**OpenFeign**) vs async (messaging), trade-offs, *why sync chains are fragile*; **intro gRPC** (contract-first binary RPC between services).

**🛠️ Build:** Split the monolith into 2–3 services by bounded context (e.g., `order`, `product`, `payment`), each with its own DB. Put a Spring Cloud Gateway in front handling routing + one cross-cutting concern. Add service discovery (Eureka now; swap to K8s-native in Month 3). Wire one OpenFeign sync call between two services — then note everything that can go wrong (segue to resilience).

## Week 7 — Resilience Engineering with Resilience4j (surviving failure)
The heart of production microservices.
**📚 Learn (Resilience4j — the 2026 standard, *replaces* Hystrix):**
- **Circuit Breaker** — CLOSED → OPEN → HALF-OPEN state machine; `failureRateThreshold`, `slidingWindowSize`, `minimumNumberOfCalls`, `waitDurationInOpenState`, `permittedNumberOfCallsInHalfOpenState`; *why* it protects scarce resources (threads, connections) and stops a slow dependency cascading into a system-wide outage.
- **Retry** — exponential backoff **with jitter**, `retryExceptions` vs `ignoreExceptions`, max attempts; the critical rule: **never blindly retry non-idempotent ops (e.g., payments)** or you double-charge.
- **Rate Limiter** — protect yourself and downstreams from overload.
- **Bulkhead** — isolate resource pools (semaphore for low-latency, thread-pool for blocking calls).
- **Time Limiter** — bound latency on async calls.
- **Composition & order** — the standard decorator order (`RateLimiter → Bulkhead → TimeLimiter → CircuitBreaker → Retry`) and *why order matters*.
- **Fallbacks & graceful degradation**; **tuning from telemetry** (start conservative, tighten from real metrics — ties to observability in Month 5).

**🛠️ Build:** Wrap inter-service calls with circuit breaker + retry (backoff+jitter) + time limiter + bulkhead, each with a thoughtful fallback. Use **WireMock** to simulate a downstream timing out / 500ing and *watch the circuit breaker trip and recover* — capture the state transitions. Deliberately misconfigure a retry on a non-idempotent op, observe the double-effect, fix it with an idempotency key (Week 5) — document this (great interview story). Expose Resilience4j metrics via Actuator (visualized in Grafana in Month 5).

## Week 8 — Event-Driven Architecture with Kafka + Distributed Data Patterns
A flagship build month.
**📚 Kafka (modern systems backbone):** core model (topics, partitions, offsets, producers, consumers, **consumer groups**, replication, retention); delivery semantics (at-most/at-least/exactly-once; why at-least-once + idempotent consumers is common; idempotent producers + transactions); ordering & partition-key strategy; **schema registry** (Avro/Protobuf) + schema evolution; operations (consumer lag, rebalancing, **dead-letter topics**, poison messages, backpressure); Spring for Kafka (`KafkaTemplate`, `@KafkaListener`, error handling/retry topics).

**📚 Distributed data consistency (the hard, senior stuff):** *why ACID dies across services*; **Saga** — choreography (event-driven) vs orchestration (central coordinator), **compensating transactions**, trade-offs; **Outbox pattern** — the *correct* way to atomically update DB + publish an event (avoids the dual-write problem): write event to an outbox table in the same tx, relay to Kafka; **CQRS** — separating read/write models, when it's worth it; **idempotency & eventual consistency** tying Redis keys + Kafka redelivery + Saga together.

**🛠️ Build:** Introduce Kafka — convert a sync flow into an **event-driven** one (e.g., `OrderCreated` consumed by inventory + notification services). Implement a **Saga** for a multi-service transaction (place order → reserve inventory → process payment → confirm, with compensations on failure) via choreography (note how orchestration differs). Implement the **Outbox pattern** for transactionally-safe publishing. Make consumers **idempotent** (dedupe via idempotency keys). Add a **dead-letter topic** for poison messages.

**✅ Month 2 done when you can demonstrate:** a multi-service system (DB-per-service) behind a gateway with discovery; Resilience4j circuit breakers/retries/bulkheads/timeouts with fallbacks (and you've *seen* one trip and recover under simulated failure); PostgreSQL tuned with real indexes (EXPLAIN evidence) + Redis caching + distributed idempotency; an event-driven Kafka flow with a working **Saga**, the **Outbox pattern**, and idempotent consumers; and you can explain — from things you built — why payments can't be naively retried, why the outbox pattern exists, and choreography vs orchestration.

---

# 🟨 MONTH 3 — Linux, Docker Mastery & Kubernetes (Deployment Core Begins)

**Outcome:** You learn to *package and run* your system the way production does. By month-end the whole system runs in Kubernetes, packaged with Helm.

## Week 9 — Linux & the Command Line (the ground everything stands on)
**📚 Learn:** filesystem & FHS layout (`/etc`, `/var`, `/proc`...), navigation; text power-tools (`grep`+regex, `sed`, `awk`, `cut`, `sort`, `uniq`, `wc`, redirection, **pipes**, `tee`, `xargs`, `tail -f`); permissions/ownership (`chmod` numeric+symbolic, `chown`, `umask`, SUID/SGID, sudo); processes & resources (`ps`, `top`/`htop`, signals/`kill`, fg/bg/`nohup`, **systemd**/`systemctl`, `journalctl`, `free`/`df`/`du`); networking from CLI (`curl`/`wget`, `ss`, `dig`/`nslookup`, `ip`, ports, **ssh**+keys, `scp`/`rsync`); packages (apt/yum), env vars, `PATH`, `.bashrc`; **Bash scripting** (variables, conditionals, loops, functions, exit codes, args, `set -euo pipefail`, here-docs); **Git mastery** (trunk-based vs Git flow, interactive rebase, cherry-pick, confident conflict resolution, **reflog**, **bisect**, hooks, clean PR discipline).

**🛠️ Build:** Do everything this month from the terminal on a Linux VM (Multipass/VirtualBox or a cheap cloud instance). Write 3 useful Bash scripts (a deploy helper, a log-scanning/alerting script, an `rsync` backup). Set up SSH key auth; deploy your jar to the VM manually as a **systemd** service with `journalctl` logging — *feel* the pre-container pain you're about to solve.

## Week 10 — Docker Mastery (containerize everything)
**📚 Learn:** images vs containers; containers vs VMs (namespaces, cgroups, shared kernel); the reproducibility problem; Dockerfiles (layers + **build cache** ordering, all instructions, `.dockerignore`); **production image discipline** — **multi-stage builds** (build on full JDK, run on slim/distroless JRE — tiny, secure), **non-root user**, pinned base versions, minimal layers/attack surface, **Trivy** image scanning; runtime (volumes vs bind mounts, networking/DNS, port mapping, env/secrets, resource limits, restart policies, healthchecks, logging drivers); **Docker Compose** (whole stack: services + Postgres + Redis + Kafka, dependencies, networks, named volumes); registries (Docker Hub/ECR, tagging — **never rely on `latest` in prod**); **JVM-in-containers** gotchas (container-aware heap, ergonomics flags).

**🛠️ Build:** Production-grade **multi-stage Dockerfiles** for each service (small, non-root, pinned); scan with Trivy and fix findings. A **Docker Compose** file bringing up the *entire* system with one command (healthchecks + networking) — your new local-dev env. Push images to a registry with a sane tag scheme. Document image sizes before/after multi-stage.

## Week 11 — Kubernetes Part 1 (the production runtime)
**📚 Learn:** architecture — control plane (API server, etcd, scheduler, controller-manager) + nodes (kubelet, kube-proxy, runtime); the **declarative reconciliation** model (you declare desired state; K8s converges) — *this mental model is everything*; core workloads — **Pods** (why you rarely create them directly), ReplicaSets, **Deployments** (rolling updates, revision history, rollbacks), and when to use **StatefulSets** (stable identity/storage), DaemonSets, Jobs/CronJobs; networking — **Services** (ClusterIP/NodePort/LoadBalancer), native **service discovery + DNS** (replaces Eureka), **Ingress** (host/path routing, TLS) with an nginx ingress controller; config — **ConfigMaps** + **Secrets** (and why base64 Secrets aren't encryption); **kubectl** fluency (`get/describe/logs/exec/apply/rollout/port-forward`, contexts/namespaces, reading events to debug).

**🛠️ Build:** Spin up a local cluster (**kind**/**minikube**/**k3d**). Write Deployment + Service manifests for each service; deploy the whole system. Add **Ingress** so the gateway is reachable via hostname with path routing. Move config to **ConfigMaps** and secrets to **Secrets**; prove the app reads them. Practice `kubectl rollout` update and `rollout undo` (rollback) — *feel* zero-downtime deploys + instant rollback.

## Week 12 — Kubernetes Part 2 (operate it) + Helm
**📚 Learn:** health & self-healing — **liveness vs readiness vs startup** probes (and the real consequences of getting them wrong); resource management — **requests vs limits** (scheduling + OOM-kills), QoS classes, **autoscaling** (**HPA** on CPU/memory/custom metrics; VPA + Cluster Autoscaler concepts); reliability primitives — PodDisruptionBudgets, anti-affinity (spread replicas), namespaces, resource quotas; security — **RBAC** (roles/rolebindings/service accounts — least privilege), **network policies**, pod security standards, non-root; storage — PVs, PVCs, StorageClasses; **Helm** — charts, templates, `values.yaml`, releases, upgrades/rollbacks, *why Helm* (templating + per-env values + versioned releases); a peek at **GitOps** (Git as source of truth; full GitOps in Month 4) and the **Operator** pattern (custom controllers) conceptually.

**🛠️ Build (major):** Add **liveness/readiness/startup probes** wired to Spring Boot Actuator health. Set resource requests/limits + an **HPA**; load-test (Gatling/k6) and *watch it scale pods up/down*. Lock down with **RBAC** service accounts + a basic **network policy**. **Package the entire system as a Helm chart** with env-specific values (dev/staging/prod); deploy via `helm install/upgrade`; practice `helm rollback`. Run your stateful dependency (e.g., Postgres) as a StatefulSet with a PVC (or use a managed DB — note the trade-off).

**✅ Month 3 done when you can demonstrate:** terminal/Linux fluency (CLI-driven workflow, useful Bash scripts, confident Git incl. rebase/bisect/reflog); production multi-stage Docker images (small/non-root/scanned) + a one-command Compose stack; the entire multi-service system running in Kubernetes with Deployments/Services/Ingress/ConfigMaps/Secrets/probes/HPA/RBAC; the whole thing packaged as a **Helm chart** with per-env values, and you've done rolling updates, rollbacks, and watched autoscaling fire under load.


---

# 🟧 MONTH 4 — CI/CD, GitOps & AWS Mastery (End-to-End Deployment)

**Outcome:** Automate the *entire* path from `git push` to running-in-the-cloud, the way real product companies do — and run it on real AWS infrastructure provisioned as code. This is the full end-to-end deployment story.

## Week 13 — CI/CD Pipelines (GitHub Actions + Jenkins)
Learn **both** — Actions/GitLab CI dominate cloud-native teams; **Jenkins still powers most large/regulated enterprises** and shows up constantly in JDs.
**📚 Learn:** the pipeline mental model (CI = integrate+test+build artifact on every push; CD = deliver/deploy validated artifact); the **DORA metrics** (deployment frequency, lead time, change-failure rate, MTTR); a complete pipeline's stages (checkout → build → unit tests → static analysis/security scan → build & scan image → push → integration tests → deploy staging → smoke tests → promote prod); **GitHub Actions** (workflows/jobs/steps/runners, triggers, matrix builds, dependency caching, secrets, reusable workflows, environment approval gates); **Jenkins** (declarative `Jenkinsfile`, stages/agents, credentials, plugins, and the modern pattern — **Jenkins on Kubernetes with ephemeral agents**); **DevSecOps gates** (**SonarQube** quality+coverage, **Snyk/Trivy** dependency+image scanning, secret scanning, **SBOM** + image signing); automated deploy strategies (rolling, **blue-green**, **canary**) + auto-rollback on failed health/smoke checks.

**🛠️ Build (major):** A complete **GitHub Actions** pipeline: push → all tests → SonarQube → multi-stage image build → Trivy scan → push to registry → deploy to cluster → smoke test, with an approval gate before "prod." Replicate the core as a **Jenkins `Jenkinsfile`** (run Jenkins in a container/on K8s) so you genuinely know both. Make the build *fail* on a SonarQube quality-gate breach, then fix it. Document the pipeline with a diagram.

## Week 14 — GitOps (ArgoCD) + Progressive Delivery
**📚 Learn — the modern CD standard:** **GitOps principles** (Git as the **single source of truth** for app + infra state; declarative desired state; a controller that **continuously reconciles** the cluster to Git; **drift detection** + auto-correction; why it's more secure/auditable than push pipelines — the cluster *pulls*, no external system needs cluster creds); **ArgoCD** (Applications, sync policies manual vs automated, self-heal, the **App-of-Apps** pattern, multi-env promotion via Git); **progressive delivery with Argo Rollouts** (declarative **canary** + **blue-green** with automated analysis → promote or roll back on metrics); the **2026 reference architecture** (Actions/Jenkins for **CI** → push image + bump manifest in a Git config repo → **ArgoCD** for **CD**); secrets in GitOps (Sealed Secrets / External Secrets Operator / Vault — never plaintext in Git).

**🛠️ Build:** Install **ArgoCD**; create a Git config repo holding your Helm chart/manifests. Wire ArgoCD so deployments happen via **GitOps** (change desired state in Git → ArgoCD syncs). Demonstrate **drift detection** (manually change the cluster, watch ArgoCD revert it). Restructure CI to the modern split (CI builds+pushes image and bumps the tag in the config repo; ArgoCD deploys). Implement an **Argo Rollouts canary** for one service with an automated analysis step + rollback-on-failure demo. Handle secrets via Sealed/External Secrets.

## Week 15 — AWS Mastery Part 1 (core infra + IAM + IaC)
**📚 Learn:** **IAM foundation** (users, groups, **roles** + assume-role, identity vs resource policies, **least privilege**, instance profiles; *never hardcode credentials*); **VPC networking** (VPCs, public/private **subnets**, route tables, internet/NAT gateways, **security groups** vs NACLs, how traffic flows to a service — learn this properly, it trips most people up); **compute options & when to use each** (**EC2** + auto-scaling groups, **ECS** Fargate vs EC2, **EKS** — where your K8s skills go to production, **Lambda** serverless + cold starts); **storage/DB** (**S3** buckets/storage-classes/lifecycle/presigned URLs, **RDS** managed Postgres Multi-AZ + read replicas + backups, **DynamoDB** partition/sort keys + single-table awareness, **ElastiCache** managed Redis); **Terraform IaC** (providers, resources, variables, outputs, **state** + remote state in S3 + DynamoDB locking, modules, `plan`/`apply`/`destroy`; *why IaC* — reproducible, reviewable, versioned infra; no console-clicking).

**🛠️ Build (major):** AWS free-tier account; IAM user/role with least privilege (stop using root). **Provision infra with Terraform** (not the console): a VPC with public/private subnets, security groups, RDS Postgres, ElastiCache Redis, an S3 bucket; remote state in S3 + DynamoDB locking. Deploy a service to **EC2** manually first (to understand it), then note why you'd prefer ECS/EKS.

## Week 16 — AWS Mastery Part 2 (run your system in the cloud, end-to-end)
**📚 Learn:** container orchestration on AWS — **EKS** (your Helm charts → real cloud cluster) or **ECS Fargate**; **ECR** for images; **ALB** load balancing (+ ALB Ingress Controller on EKS); edge & delivery — **CloudFront** (CDN), **Route 53** (DNS, routing policies, health checks), **API Gateway** (managed gateway, throttling), **ACM** (TLS certs); messaging/async — **SQS**, **SNS**, EventBridge, and managed **MSK** (Kafka) if not self-managed; ops & cost — **CloudWatch** (metrics/logs/alarms/dashboards), X-Ray (tracing), and **FinOps** basics (stay on free tier; understand why cost matters at scale); reliability — Multi-AZ, ASGs, backups, shared-responsibility model.

**🛠️ Build (flagship — the end-to-end payoff):** Deploy the **entire multi-service system to AWS** on **EKS** (preferred — uses K8s/Helm) or **ECS Fargate**, fronted by an **ALB**, images in **ECR**, data in **RDS** + **ElastiCache**, DNS via **Route 53** + TLS via **ACM**. Wire your **GitOps (ArgoCD)** pipeline to deploy to this real cloud cluster: `git push` → CI builds/scans/pushes image + updates config repo → ArgoCD deploys to EKS. **This is the complete, automated, end-to-end production deployment you set out to master.** Provision *all* of it via **Terraform** (infra) + **Helm/Argo** (apps) so the whole environment is reproducible from code. Set a CloudWatch alarm on a key metric. Tear it down with `terraform destroy` to prove reproducibility (and control cost).

**✅ Month 4 done when you can demonstrate:** a complete CI pipeline in **both GitHub Actions and Jenkins** (test + SonarQube + image scan + push, with quality/security gates); **GitOps with ArgoCD** (Git source of truth, drift detection, self-heal) + a working **canary/blue-green** rollout with auto-rollback; **AWS mastery** (IAM least-privilege, VPC networking, your real system on **EKS/ECS** with **RDS/ElastiCache/S3/ALB/Route 53**, all via **Terraform**); and the headline: **`git push` → automated build, scan, deploy → live in the cloud, reproducible from code.**

---

# 🟥 MONTH 5 — Observability, SRE & Production-Grade Frontend (Closing the Loop)

**Outcome:** Add the "operate it" superpowers (observability + SRE) and a production-grade React frontend. After this you're a complete, end-to-end production full-stack engineer.

## Week 17 — Observability Part 1: Metrics & Logs
**📚 Learn — the three pillars (logs/metrics/traces):** why observability ≠ monitoring (answer *why* without shipping code); **metrics — Prometheus + Grafana** (pull model + scraping, metric types — **counter/gauge/histogram/summary**, **PromQL** basics, **Micrometer** in Spring Boot exposing app + JVM + HikariCP + Resilience4j metrics via `/actuator/prometheus`, the **four golden signals** — latency/traffic/errors/saturation — + the RED method, building **Grafana dashboards** + alert rules); **logging — ELK & Splunk** (**structured JSON logging**, log levels, **correlation/trace IDs** across services, centralized aggregation; the **ELK/EFK** stack and **Splunk** — used heavily in enterprises, know SPL search basics/dashboards/alerts; log sampling + cost).

**🛠️ Build:** Instrument all services with **Micrometer**; deploy **Prometheus + Grafana**; build dashboards for the four golden signals + JVM health + your Resilience4j circuit-breaker states. Add **structured JSON logging** with **correlation IDs** propagated across calls; ship logs to **ELK/EFK** (or Loki) and trace one request end-to-end in Kibana. Create ≥1 **alert** (error-rate or p99-latency) and trigger it deliberately.

## Week 18 — Observability Part 2: Distributed Tracing + SRE
**📚 Learn:** **distributed tracing** — traces + **spans**, **context propagation** across boundaries, sampling; **OpenTelemetry** (the vendor-neutral 2026 standard, replacing Sleuth-specific stacks), **Micrometer Tracing**, backends (**Jaeger / Grafana Tempo / Zipkin**); the unified picture (correlate logs+metrics+traces via shared IDs to debug fast); **SRE fundamentals** — **SLIs / SLOs / SLAs** and **error budgets** (how they gate releases), **SLOs-as-code** (OpenSLO); **incident response** (on-call, runbooks, severity levels, blameless postmortems, MTTR); **chaos engineering** concept (inject latency/pod-kills to prove resilience; Chaos Mesh/Litmus/Gremlin awareness); reliability patterns recap — **graceful shutdown** (drain in-flight requests on SIGTERM — matters in K8s rollouts), health checks.

**🛠️ Build:** Add **OpenTelemetry** tracing across all services; deploy **Jaeger or Tempo**; view a full distributed-trace waterfall for a multi-service request (e.g., your Saga flow). Define **SLIs/SLOs** (e.g., 99.9% of order requests < 300ms) + a Grafana **error-budget** panel. Run a basic **chaos experiment** (kill a pod / inject latency) and verify circuit breakers/retries/HPA respond — capture evidence. Implement **graceful shutdown** and confirm zero dropped requests during a rolling deploy. Write a short **runbook** for one failure scenario.

## Week 19 — Production-Grade Frontend (React, since you're full-stack)
**📚 Learn:** **TypeScript-first React** (typed props/state/hooks; why typed frontends are the production default); **component architecture & state** (composition; **server state** via TanStack Query vs **client state** via Redux Toolkit/Zustand/Context; not over-using global state; clear state boundaries); **performance that moves the needle** (**code splitting + lazy loading**, `React.memo`/`useMemo`/`useCallback` and when they *hurt*, list **virtualization**, **Suspense for streaming/progressive rendering**, bundle analysis + dependency auditing, **Core Web Vitals** — LCP/INP/CLS — measured with **real-user data**, not just Lighthouse); **client-side resilience** (loading/error/empty states, retries, optimistic updates, **error boundaries**); **frontend testing (all layers)** — **Jest + React Testing Library** (behavioral, not snapshot-only), **Playwright/Cypress** e2e, API mocking with **MSW**, accessibility testing; **frontend observability** — **OpenTelemetry in the browser** (trace context propagated browser → backend for true end-to-end traces), **Real User Monitoring**, error tracking (Sentry), Core Web Vitals reporting; **build & deploy** (Vite, env config, containerizing the frontend, serving via CDN/CloudFront, fitting it into CI/CD + GitOps).

**🛠️ Build:** Build/upgrade the capstone's **React + TypeScript** frontend consuming your APIs (typed, proper loading/error/empty states, error boundaries, TanStack Query for server state). Apply real perf work (code-split routes, lazy-load, a Suspense streaming boundary, trim the bundle; measure Core Web Vitals). Test it (RTL components + a **Playwright** e2e happy-path + an MSW-mocked test). Add **frontend OpenTelemetry** so a user action produces a trace that continues into your backend — view the *full-stack* trace (genuinely senior, impressive). Containerize the frontend and ship it through your pipeline behind CloudFront.

## Week 20 — Security Hardening, Quality Gates & Capstone Polish
**📚 Learn — production security (cross-cutting):** **OWASP Top 10** (injection, broken auth, broken access control, SSRF, security misconfig, vulnerable deps, etc. — and how you defend in a Spring/React stack); **AuthN/AuthZ done right** (OAuth2 / OpenID Connect flows, JWT validation/expiry/refresh + pitfalls, role/attribute-based access control, **Keycloak** as an IdP); **secrets management** (**HashiCorp Vault** / cloud secret managers — dynamic secrets, rotation, never-in-code/Git); **transport & service security** (TLS everywhere, **mTLS** between services, the service-mesh idea — Istio/Linkerd — conceptually); **supply-chain/pipeline security** (SAST, DAST, dependency scanning, image scanning, SBOM, image signing — enforced as pipeline gates); **data protection** (encryption at rest + in transit, PII handling).

**🛠️ Build (capstone hardening):** Secure the system end-to-end — OAuth2/OIDC via **Keycloak**, RBAC on endpoints, JWT validation at the gateway. Move all secrets to **Vault** (nothing sensitive in code/Git). Enforce security gates in the pipeline (SAST + dependency scan + image scan must pass to deploy). Run an OWASP-style self-review (e.g., OWASP ZAP) against your APIs and fix findings. **Polish the capstone:** thorough README with an architecture diagram, the full request/trace flow, every production capability called out, dashboard/trace screenshots, and a documented one-command run path. Pin it on GitHub.

**✅ Month 5 done when you can demonstrate:** full observability (Prometheus/Grafana four-golden-signals dashboards, structured logs + correlation IDs in ELK/Splunk, **OpenTelemetry distributed tracing** incl. browser-to-backend full-stack traces); SRE practices (SLIs/SLOs/error budgets, graceful shutdown, a chaos experiment proving resilience, a runbook); a production-grade **React + TypeScript** frontend (performant, tested, observable, deployed via pipeline); security hardening (OAuth2/OIDC + Keycloak, Vault-managed secrets, enforced DevSecOps gates); and a flagship, fully-deployed, observable, secured, documented system demonstrating *every* layer of production engineering.


---

## 🎓 The 5-Month Payoff — Who You Are Now

After these five months you are not "a Spring Boot developer who knows some AWS." You are an engineer who has personally:
- Built a resilient, event-driven microservices system with Saga, Outbox, idempotency, and Resilience4j.
- Containerized it, orchestrated it on Kubernetes, and packaged it with Helm.
- Automated delivery through CI/CD and GitOps (ArgoCD) with canary deploys and rollback.
- Run it on real AWS infrastructure provisioned with Terraform.
- Made it fully observable (metrics, logs, distributed tracing) and operated it with SLOs and chaos testing.
- Shipped a production-grade, observable, tested React/TypeScript frontend.
- Secured the whole thing with OAuth2/OIDC, Vault, and DevSecOps gates.

Every bullet is a true story you can tell, backed by a repo someone can open. **That** is the production god profile.

---

## 📚 Resources (Production-First, Curated)

- **Spring/Backend:** official Spring guides + docs; **Baeldung** (best practical reference); *Java Techie*, *Amigoscode*, *Daily Code Buffer*, *Concept and Coding* (YouTube); *Effective Java* (Bloch).
- **Distributed systems:** *Designing Data-Intensive Applications* (Kleppmann — the bible); *Microservices Patterns* (Richardson — Saga/Outbox/CQRS source); Resilience4j docs; Confluent Kafka tutorials.
- **Linux/Docker/K8s:** ***TechWorld with Nana*** (the best free teacher — start here); official Docker + Kubernetes docs (interactive tutorials); **KodeKloud** (hands-on labs); *The Linux Command Line* (Shotts, free); **Killercoda / Play-with-Docker / Play-with-K8s** sandboxes.
- **CI/CD & GitOps:** GitHub Actions docs; Jenkins handbook; **ArgoCD** + Argo Rollouts docs; *TechWorld with Nana* GitOps videos.
- **AWS/Terraform:** AWS Skill Builder + free tier (build, don't just watch); **Terraform** official tutorials; Adrian Cantrill's AWS courses; *freeCodeCamp* AWS (YouTube).
- **Observability/SRE:** *TechWorld with Nana* Prometheus/Grafana; **OpenTelemetry** docs; Grafana Labs tutorials; **Google SRE books** (free at sre.google/books); Splunk free training.
- **Frontend:** react.dev (excellent new docs); TypeScript handbook; TanStack Query, React Testing Library, Playwright, MSW docs; *Josh Comeau*, *Jack Herrington* (YouTube); web.dev for Core Web Vitals.
- **Security:** **OWASP Top 10** + Cheat Sheet Series; Keycloak docs; HashiCorp Vault tutorials; Snyk Learn (free).

---

## ⛔ Production-Mastery Mistakes to Avoid

1. **"Done" meaning "runs on my laptop."** Not done until containerized, deployed, observable, tested, documented.
2. **Collecting tutorials instead of building.** Watching a K8s video ≠ deploying to K8s. Every 🛠️ must be done.
3. **Trying to learn five stacks.** Go deep on one (Java/Spring + React + cloud-native ops). Depth is the differentiator.
4. **Skipping the *why*.** Knowing `@Transactional` exists ≠ explaining propagation/isolation and the self-invocation gotcha. Depth is what production (and interviews) reward.
5. **Hardcoding config/secrets.** Externalize config; Vault for secrets; never in code or Git.
6. **`ddl-auto=update` / H2-in-integration-tests / Hystrix / console-clicking infra.** Use Flyway / Testcontainers / Resilience4j / Terraform — the production-correct choices.
7. **Building services you never deploy or observe.** The whole point is end-to-end: deploy it, watch it, operate it.

---

## 🧭 One-Page Reference (File 2)

| Month | Focus | Flagship build |
|---|---|---|
| **1** | Spring Boot internals + every layer of testing | Cleanly-architected, fully-tested service |
| **2** | Advanced microservices, Resilience4j, PostgreSQL/Redis, Kafka, Saga/Outbox/CQRS | Resilient, event-driven multi-service system |
| **3** | Linux, Docker mastery, Kubernetes, Helm | Whole system running in K8s via Helm |
| **4** | CI/CD (Actions + Jenkins), GitOps (ArgoCD), AWS + Terraform | `git push` → automated build/scan/deploy → live on AWS |
| **5** | Observability + SRE, production React/TS, security | Fully observable, secured, documented capstone |

**Daily non-negotiables:** build something real → write it up in `production-notes` → commit (keep the graph green). **Definition of done:** containerized · deployed · observable · tested · documented.

**One-line strategy:** spend 5 months becoming an engineer who has personally built, deployed, and *operated* production-grade distributed full-stack systems — and prove it with one evolving, deployed, observable capstone on GitHub.

**Now go build it. 🚀**

