# FILE 3 — The Interview Prep Kit (Land the Offer)

> **Purpose:** Everything you need to *convert* your skills into offers — DSA/LeetCode, Core Java, Spring framework, LLD, HLD/system design, React/frontend, behavioral, and resume. Run this **after (or overlapping the tail of) File 2's production months**, and **while still employed** at Cognizant (your salary is your leverage).
>
> **Your edge:** Because you'll have *built and operated* real production systems (File 2), system-design and Spring/Java-theory rounds become "let me tell you how I did this," not memorized theory. The one thing production work does *not* cover is **DSA** — the algorithmic screen that filters out most applicants first. So **DSA is the top priority of this kit.**
>
> **Timeline:** budget ~2–3 months of focused prep alongside your job, overlapping with applications. Smart move: do ~30 min/day of DSA *during* the production months so this phase is shorter.

---

## The Interview Reality (what to optimize for)

The product-company funnel for your level (detailed in File 1) tests, in order: (1) **DSA** — the big filter; (2) **LLD/machine coding** — clean OOP under time; (3) **HLD/system design** — intro level for juniors; (4) **Java + framework theory**; (5) **behavioral** (STAR). This kit prepares each. Two truths to internalize:

- **DSA is the gatekeeper, not the goal.** A coding screen eliminates 60–80% of applicants before anyone reads your resume. You must clear it — but it alone doesn't get you hired.
- **Patterns beat volume.** People who "did 500 problems" routinely fail easy interview questions because they memorized solutions, not patterns. Target ~250–300 problems organized around **~18 patterns**, each drilled until you recognize it within 2 minutes of reading a new problem.

---

# 1) DSA / LeetCode — The Daily Spine

### Method
Pattern-first. For each pattern: watch one explainer (Striver/NeetCode/Aditya Verma for DP), then solve 8–12 problems easy→medium, peeking at the solution only after ~25 min stuck. Then move on. **The 3-pass rule:** Pass 1 solve · Pass 2 (next day) resolve from memory · Pass 3 (a week later) solve in <15 min. **Track every problem** in a sheet: Problem | # | Pattern | Difficulty | Date | Pass 1/2/3 | Time | Notes.

### Language for DSA
Use **Java** (your strength) — it's fully accepted at all product companies. Know the workhorse APIs cold: `HashMap`/`HashSet`, `ArrayList`, `ArrayDeque` (stack/queue), `PriorityQueue` (heap), `TreeMap`/`TreeSet`, `Collections`/`Arrays` utilities, `StringBuilder`.

### The ~18 Patterns (tick when you recognize them instantly)
- [ ] **1. Hashing / frequency counting** — "store what I've seen" for O(1) lookup (Two Sum, Group Anagrams, Subarray Sum Equals K)
- [ ] **2. Two Pointers** — pairs/triplets/partitioning on sorted data (3Sum, Container With Most Water, Valid Palindrome)
- [ ] **3. Sliding Window** — contiguous subarray/substring (Longest Substring Without Repeating, Min Window Substring, Max Subarray via Kadane)
- [ ] **4. Binary Search** — sorted data *and* "binary search on the answer" (Search Rotated Array, Koko Eating Bananas)
- [ ] **5. Prefix Sum** — O(1) range queries (Range Sum, Product of Array Except Self, Pivot Index)
- [ ] **6. Fast & Slow Pointers** — cycle detection, middle (Linked List Cycle, Middle of List, Happy Number)
- [ ] **7. Linked List manipulation** — reversal/merge/reorder (Reverse List, Merge Two Sorted, Reorder, Copy with Random Pointer)
- [ ] **8. Stack (incl. monotonic)** — matching, next-greater (Valid Parentheses, Min Stack, Daily Temperatures, Largest Rectangle in Histogram)
- [ ] **9. Queue / BFS** — level-order, unweighted shortest path
- [ ] **10. Tree DFS** — traversals, path problems, LCA (Max Depth, Diameter, Path Sum, LCA, Validate BST)
- [ ] **11. Tree BFS** — level-order, right-side view, width (Level Order, Right Side View)
- [ ] **12. Heap / Top-K** — k-largest/smallest, stream median via two heaps (Kth Largest, Top K Frequent, Find Median from Data Stream, Task Scheduler)
- [ ] **13. Graph traversal (BFS/DFS)** — islands, connected components, clone (Number of Islands, Clone Graph, Pacific Atlantic)
- [ ] **14. Topological Sort** — dependency ordering, DAG cycle detection (Course Schedule I & II)
- [ ] **15. Union-Find (Disjoint Set)** — connectivity (Number of Connected Components, Redundant Connection)
- [ ] **16. Dynamic Programming (1-D & 2-D)** — state/recurrence/base case (Climbing Stairs, House Robber, Coin Change, LCS, Edit Distance, 0/1 Knapsack, Unique Paths)
- [ ] **17. Backtracking** — subsets/permutations/combinations/N-Queens/word search (Subsets, Permutations, Combination Sum, Word Search)
- [ ] **18. Trie** — prefix trees (Implement Trie, Word Search II, Add and Search Word)

**Bonus:** Greedy, **Intervals** (merge/insert — common at scheduling-heavy firms like Amazon/Bloomberg), Bit Manipulation, Matrix traversal. **Highest-ROI four if ever short on time:** Hashing, Two Pointers, BFS/DFS, DP.

### Problem sources (curated, don't sprawl)
- **Striver's A2Z + SDE sheets** (takeUforward) — primary, structured backbone.
- **NeetCode 150** (neetcode.io) — curated, pattern-organized, great videos.
- **LeetCode** — primary practice; use **company tags** for *recent* (last ~6 months) questions when you have a scheduled interview. Company question lists are recycled but emphasis shifts, so weight recent data.
- **Blind 75** — a tighter starter list if time is very short.

### Suggested rhythm
~2–3 patterns/week with daily problems. By ~8 weeks: all patterns covered, ~200+ solved, pattern recognition in <2 min. Remaining weeks: revision passes + company-tagged problems for scheduled interviews + timed mocks. **Two weeks before any interview, the top ~25 problems for that company should feel automatic.**

### Interview execution (graded as heavily as the solution)
- **Think out loud.** Narrate your approach before coding; interviewers grade your thought process and communication.
- **Clarify first** (input constraints, edge cases), state brute force, then optimize ("can I do better?"), discuss **time/space complexity** fluently (companies like Google push hard on this).
- **Practice timed** (mediums in ~40 min) and do **mock interviews** on **Pramp / interviewing.io** to practice talking while coding.

ROADMAP_EOF
echo "File 3 part 1 created."
---

# 2) Low-Level Design (LLD) / Machine Coding

For your experience level this is **heavily tested**. Your production OOP + design-pattern work (File 2) makes it much easier — here you sharpen it for the interview format: given a spec + minimal features, produce clean, working, extensible OOP code in **60–90 minutes**.

### The four patterns that cover ~90% of LLD interviews
**Strategy, State, Observer, Factory.** Master these deeply first, then the rest.

### Concepts to be fluent in
- **SOLID principles** — applied, not memorized: spot a violation in code and fix it.
- **OOP for design** — composition over inheritance, programming to interfaces, encapsulation of behavior, has-a vs is-a.
- **Design patterns:**
  - *Creational:* Singleton (thread-safe variants), Factory Method, Abstract Factory, Builder, Prototype.
  - *Structural:* Adapter, Decorator, Facade, Composite, Proxy.
  - *Behavioral:* **Strategy**, **Observer**, **State**, Command, Template Method, Iterator, Chain of Responsibility.
- **UML for interviews** — class diagrams (association/aggregation/composition/inheritance) + sequence diagrams, enough to communicate a design on a whiteboard.
- **DRY, KISS, YAGNI**; handling **concurrency and edge cases** in your design (what breaks if this fails? if two things happen at once?).

### The framework for any LLD problem
Clarify scope/constraints/edge cases → identify entities/classes → define interfaces → choose patterns → code the core flow → handle edge cases & concurrency → discuss extensions. (A well-designed *incomplete* solution beats a fully-coded mess.)

### Problems to design + code (do most; time yourself at 75 min)
- [ ] **Parking Lot** (the canonical one — pricing via Strategy)
- [ ] **Vending Machine** (State pattern)
- [ ] **Elevator System** (state machine + dispatch Strategy: SCAN/FCFS) — incl. the "multiple elevators" follow-up
- [ ] **Tic-Tac-Toe / Snake & Ladder** (game state, turns)
- [ ] **Splitwise** (expense split: equal/exact/percentage Strategies)
- [ ] **Logging Framework** (Chain of Responsibility for log levels)
- [ ] **Notification Service** (Observer + Strategy for email/SMS/push channels)
- [ ] **Library Management System**
- [ ] **LRU / LFU Cache** (also a famous DSA problem — doubly linked list + hash map)
- [ ] **Rate Limiter** (token/leaky bucket)
- [ ] **Hotel / Movie Booking** (concurrency on seats, pricing via Decorator, conflict detection)
- [ ] **Chess** · **Meeting Room Scheduler** · **In-memory Key-Value store** · **Pub/Sub message queue**

### Resources
- **Refactoring.Guru** (best free design-patterns reference, with diagrams) · `ashishps1/awesome-low-level-design` (GitHub) · workat.tech machine-coding · *Head First Design Patterns* (book) · *Concept and Coding* (YouTube — Java LLD).

---

# 3) High-Level Design (HLD) / System Design

Increasingly expected even at 1–3 YOE. **This is your strongest area thanks to File 2** — you've *operated* caching, sharding, queues, load balancing, and resilience, so speak from real experience and reference your capstone.

### The framework (use it every time)
Clarify **functional + non-functional requirements** → **back-of-envelope estimation** (QPS, storage, bandwidth, memory) → **API design** → **high-level architecture** → **data model** → **deep-dive 1–2 components** → **identify bottlenecks** → **discuss trade-offs** → **summarize**. Start simple; evolve (don't jump to microservices/sharding on slide one). Justify every choice ("Redis because we need sub-ms reads and the data is rebuildable from the DB"). Anticipate failure ("what breaks if X dies?").

### Concepts to consolidate (you've touched most in production)
Horizontal vs vertical scaling; **stateless services**; **load balancing** (L4/L7, round-robin/least-connections/consistent hashing, Nginx/HAProxy/ALB); **caching** layers + **invalidation** + eviction (cache-aside/write-through; Redis/Memcached/CDN); **SQL vs NoSQL** trade-offs; **replication** (read replicas); **sharding/partitioning** (shard keys, hotspots, consistent hashing); **CAP / PACELC** and strong vs eventual consistency (payments → strong; feeds → eventual); **CDN**; **message queues & event-driven** (Kafka/RabbitMQ/SQS, pub/sub, fanout); **API gateway**; **rate limiting** (token/leaky bucket, sliding window); **circuit breakers**; **idempotency**; estimation math; the four golden signals (observability).

### Designs to practice (start simple → build up)
- [ ] **Foundational:** URL Shortener (TinyURL) · Rate Limiter · Pastebin · Key-Value store (like Redis)
- [ ] **Core:** Twitter/Instagram **news feed** (fanout push vs pull, celebrity problem) · **WhatsApp/chat** (websockets, delivery, presence, NoSQL) · YouTube/Netflix (storage + streaming + CDN) · **Uber** (geospatial + matching) · Notification system at scale · Search autocomplete (Trie + ranking) · Web crawler · Dropbox/Drive (chunking, sync)
- [ ] **Advanced:** **Payment system** (strong consistency — *you built one!*) · Distributed job scheduler · Google Docs (collab/OT) · Ticketing/BookMyShow (seat concurrency) · CDN · Kafka-like message queue

### Resources
- ***System Design Interview* Vol 1 & 2 — Alex Xu** (the standard) · **ByteByteGo** (Xu's site/YouTube — visual, current) · ***Gaurav Sen*** (YouTube — excellent explanations) · `donnemartin/system-design-primer` (GitHub, free) · *Designing Data-Intensive Applications* (Kleppmann — deep, long-term gold, also a File 2 resource).

---

# 4) Core Java — Theory for Rapid Recall

You'll learn most of this *by doing* in File 2. This section sharpens it for fast interview recall.

- **OOP & principles:** the four pillars applied, **SOLID**, `equals`/`hashCode` contract (override one → override both, and why), immutability and how to design an immutable class, generics (type erasure, bounded wildcards, PECS), checked vs unchecked exceptions, `Optional` proper use.
- **Collections internals (interview gold):** `ArrayList` (dynamic array, amortized growth) vs `LinkedList`; **`HashMap` internals** — buckets, hashing, load factor, **treeification** (Java 8+, red-black tree at threshold 8), collision handling, resizing; `HashSet` (backed by HashMap); `LinkedHashMap` (access-order → LRU); `TreeMap`/`TreeSet` (red-black, O(log n)); `ConcurrentHashMap` (how it achieves concurrency); fail-fast vs fail-safe iterators, `ConcurrentModificationException`; Comparable vs Comparator.
- **JVM:** memory areas (heap, stack, metaspace, PC, native), object vs primitive storage, **garbage collection** (generational; G1/ZGC; what triggers GC; basic tuning — *you saw this in containers*), class loading, JIT, `StackOverflowError` vs `OutOfMemoryError`, the Integer cache (-128..127) gotcha.
- **Concurrency:** thread lifecycle, `Runnable` vs `Thread`, `start()` vs `run()`, **`synchronized`** (monitors), **`volatile`** (visibility, not atomicity) and when it's insufficient, the **Java Memory Model** + happens-before, `wait`/`notify`, deadlock (four conditions + prevention), `ThreadLocal`; **utilities:** `ExecutorService` + thread pools, `Callable`/`Future`, **`CompletableFuture`** (async composition), concurrent collections, `ReentrantLock`/`ReadWriteLock`, `Semaphore`/`CountDownLatch`, atomics + CAS.
- **Java 8+:** lambdas, functional interfaces (`Function`/`Predicate`/`Supplier`/`Consumer`), method references, **Streams** (map/filter/reduce/collect/`groupingBy`/`flatMap`, intermediate vs terminal, lazy eval, parallel-stream pitfalls), `Optional` (`orElse` vs `orElseGet`). **Modern Java (17/21):** records, sealed classes, pattern matching, **virtual threads** (Project Loom) — know what they are and why they matter.
- **Strings:** immutability + why (security/hashing/thread-safety), string pool/interning, `String` vs `StringBuilder` vs `StringBuffer`.

**Resources:** *Effective Java* (Bloch), *Java Concurrency in Practice* (Goetz — concurrency chapters), Baeldung, *Concept and Coding* (YouTube).

---

# 5) Spring Framework — Theory for Rapid Recall

Again, mostly consolidation of what you build in File 2 — sharpened for interviews.

- **Core / IoC / DI:** the container & ApplicationContext, **bean lifecycle** (full phase order), **`BeanPostProcessor`** as the AOP hook, bean scopes + thread-safety, **constructor vs field injection** (why constructor wins).
- **AOP:** JDK dynamic vs CGLIB proxies, advice types, why `@Transactional`/`@Async` are proxy-based and the **self-invocation gotcha**.
- **Auto-configuration:** how `@SpringBootApplication` decomposes, the `@Conditional` family, what a starter is.
- **Spring MVC:** the `DispatcherServlet` request lifecycle, `@RestController`, filters vs interceptors, `@ControllerAdvice` global error handling.
- **Spring Data JPA / Hibernate:** the **N+1 problem** (+3 fixes), lazy vs eager + `LazyInitializationException`, **`@Transactional` propagation + isolation levels** (and the anomalies they prevent), persistence context + dirty checking + entity states, first/second-level cache, `save` vs `saveAndFlush`.
- **Spring Security:** auth vs authz, the filter chain, OAuth2/OIDC/JWT, method security.
- **Spring Cloud / microservices:** service discovery, API gateway, config server, **Resilience4j** patterns (circuit breaker/retry/bulkhead/rate-limiter/time-limiter), inter-service comms (OpenFeign), distributed tracing.
- **Scenario questions** (common at your level): "how do two microservices communicate without exposing public endpoints?" (service discovery, internal load balancers, API gateways, secure internal routing — *not* hardcoded URLs); how you handle distributed transactions (Saga/Outbox); how you make an operation idempotent. *All things you implemented in File 2 — answer from your capstone.*

**Resources:** Baeldung (Spring), official Spring docs, *Java Techie* / *Concept and Coding* (YouTube).

---

# 6) React / Frontend — Interview Prep (since you're full-stack)

If you apply for full-stack or frontend-leaning roles, expect a frontend round. File 2's production-React work covers this; here's the interview framing.

- **JavaScript/TypeScript fundamentals:** closures, `this`, prototypes, the event loop, promises/async-await, hoisting, `var`/`let`/`const`, ES6+ features; TypeScript types/generics/interfaces.
- **React core:** components, props vs state, the **hooks** (`useState`/`useEffect`/`useMemo`/`useCallback`/`useRef`/`useContext`/`useReducer`), the rules of hooks, the **virtual DOM & reconciliation**, keys, controlled vs uncontrolled components, lifting state, the component lifecycle.
- **Performance:** re-render causes and prevention (`memo`/`useMemo`/`useCallback` — and when they *hurt*), **code splitting/lazy loading**, list **virtualization**, **Suspense/streaming**, **Core Web Vitals** (LCP/INP/CLS).
- **State management:** local vs global; **server state (TanStack Query)** vs **client state (Redux Toolkit/Zustand/Context)**; not over-using global state.
- **Patterns & architecture:** composition, custom hooks, error boundaries, render props/HOCs (awareness), folder/state-boundary conventions.
- **Frontend system design (if asked):** designing a scalable component architecture / a dashboard / an autocomplete — modular structure, data fetching, caching, accessibility, performance at scale.
- **Testing:** Jest + React Testing Library (behavioral), Playwright/Cypress (e2e), MSW (API mocking).
- **CSS/markup basics:** flexbox/grid, responsive design, accessibility (a11y), semantic HTML.

**Resources:** react.dev, TypeScript handbook, *Josh Comeau* / *Jack Herrington* (YouTube), "JavaScript: The Good Parts" concepts, common React-interview-questions compilations.

---

# 7) Behavioral (STAR) — Your Capstone Is a Goldmine

Most candidates give generic answers; you'll have *real, technical* stories from your production capstone and Cognizant project that very few can match.

- **Method:** STAR — Situation, Task, Action, Result (quantify the result).
- **Prepare 6–8 adaptable stories:** ownership end-to-end (your capstone), a hard production/debugging problem (e.g., the N+1 fix, the circuit-breaker tuning, the idempotency double-charge fix), learning something fast, a failure + lesson, working under deadline, disagreeing constructively, a proud achievement, collaboration across a team.
- **Company-specific:** for **Amazon**, map stories to the **Leadership Principles** (Ownership, Bias for Action, Customer Obsession, Dive Deep) — they're tested even inside coding rounds. For others, study their values/engineering blog.
- **Have 2–3 thoughtful questions** ready for each interviewer.

---

# 8) Resume & LinkedIn (Beat the First Filter)

(See File 1 §10 for negotiation; this is the document itself.)

- **One page.** Sections: Summary, Skills, Experience, Projects, Education.
- **Quantify everything:** "Built event-driven order system on Kafka handling ~X orders/day; cut p95 latency 40% with Redis caching; deployed to EKS via GitOps with canary releases + automated rollback; full observability via Prometheus/Grafana + OpenTelemetry tracing."
- **Reframe Cognizant work in product language** — what *you* built, owned, improved (not "support and maintenance"). Use action verbs + metrics.
- **Feature the capstone prominently** with a GitHub link and a one-line impact — most candidates can't show anything close to a deployed, observable, multi-service system.
- **ATS keywords** mirrored from each target JD: Java, Spring Boot, Microservices, Kafka, Docker, Kubernetes, AWS, Terraform, CI/CD, GitOps, observability, REST, SQL, Redis, etc. Tailor per application; don't mass-blast one generic resume (portals flag it).
- **LinkedIn:** keyword-rich headline, "Open to Work" (recruiters-only), pinned capstone, occasional technical post for inbound recruiter interest.

---

# 📅 The Prep Schedule (Putting It Together)

Run alongside your job, overlapping the tail of File 2 and your applications. A workable shape (~10–12 weeks; compresses if you did daily DSA reps during File 2):

- **Weeks 1–8 — DSA core (daily) + LLD (weekends).** ~2–3 DSA patterns/week (3-pass tracked) → ~200+ problems by week 8. Weekends: design + code 1–2 LLD problems, building toward the four key patterns and the canonical problems.
- **Weeks 5–10 — HLD (overlap).** 2–3 designs/week using the framework, narrating trade-offs; lean on your capstone. Consolidate Core Java + Spring theory notes (fast, since you built it) and React interview notes if applicable.
- **Weeks 8–12 — Mocks + applications + revision.** DSA revision passes (top ~75 sub-15-min), LLD/HLD/behavioral mocks (Pramp/interviewing.io), company-tagged problems for scheduled interviews, finalize resume/LinkedIn, send referral requests, apply across the tiered list (File 1), interview.
- **Per scheduled interview:** company-specific prep — recent (last ~6 months) tagged problems, their tech stack/engineering blog, their values for behavioral, 2–3 questions to ask.

### ✅ Interview-ready when you can demonstrate:
- [ ] ~250–300 DSA problems solved; top ~75 are sub-15-minute reflexes; you recognize any pattern in <2 minutes and narrate while coding.
- [ ] An unseen **LLD** problem designed + coded in ~75 min with the right patterns; **Strategy/State/Observer/Factory** second nature.
- [ ] An **HLD** design in ~40 min with the framework, narrating trade-offs and referencing your real capstone.
- [ ] **Core Java + Spring theory** sharp for rapid recall (mostly recall, thanks to File 2).
- [ ] **React/frontend** interview-ready (if targeting full-stack roles).
- [ ] **6–8 STAR stories** anchored in real work; resume + LinkedIn optimized; referral requests out; tiered pipeline active.

---

## ⛔ Interview-Prep Mistakes to Avoid

1. **Grinding 500 random problems.** Master ~18 patterns; recognition beats memorization.
2. **Skipping system design** because "I only have 1 year." LLD is near-certain; intro HLD is common. Don't gift away a round you could prepare for (and one you're *strong* in, thanks to File 2).
3. **Preparing silently.** Practice **out loud** and do mock interviews — communication is graded as heavily as the code.
4. **Memorizing behavioral answers.** Use real STAR stories from your capstone and Cognizant work.
5. **Preparing without a deadline.** Set an application date and apply regardless — interview pressure shows you what to fix.
6. **Only targeting FAANG / only using portals.** Cast a tiered net (unicorns + GCCs) and use **referrals** (File 1).
7. **Ignoring complexity analysis.** Be fluent in time/space trade-offs; top companies push on "can you do better?"

---

### Bottom line for File 3
Your production mastery (File 2) makes the *hard, senior-flavored* parts of interviews — system design, Spring/Java depth, real stories — genuinely easy. This kit closes the one gap that production work doesn't (DSA), and packages everything for the funnel. **Drill patterns daily, practice out loud, lean on your capstone, apply via referrals while employed, and negotiate hard. That's the offer.**

