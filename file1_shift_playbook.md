# FILE 1 — Your Shift Playbook: Cognizant GenC → Product Company

> **You:** GenC at Cognizant, joined 13 Nov, ~7 months in, freshly allocated to a project, ₹4 LPA. Target: switch at ~1 year of experience to a product company at 15–20 LPA.
>
> **What this file is:** Everything about the *transition itself* — the current market, real packages, what companies ask, what skills are in demand, where and how to apply, the full interview funnel, and the exit mechanics at Cognizant (resignation steps, notice-period reduction/buyout, and exactly which documents to collect). The two other files cover *what to learn* (production skills) and *interview prep*. This file is the strategy and logistics around the move.

> ⚠️ **One disclaimer up front:** company HR policies, bond/agreement terms, and notice rules change and vary by band, contract, and location. Everything here reflects what's widely reported by Cognizant employees as of 2026, but **your offer letter and your HR are the source of truth.** Read your own offer letter's notice clause before you do anything, and confirm specifics with your HRBP.

---

## 1) Reality Check — Is This Switch Realistic at ~1 Year?

Short answer: **yes, but with eyes open.** Here's the honest framing the market data supports.

- The salary gap is real and large. A service-company engineer at junior level earns ₹4–7 LPA; the *same person*, well-prepared, lands meaningfully higher at a product company. Internal appraisals give ~8–15% a year; a single well-executed switch produces a 50–100%+ jump. That math is why the effort is worth it.
- **But the bar is higher, and it's mostly about preparation, not pedigree.** Product companies use a coding/DSA screen as the first filter that eliminates the majority of applicants before anyone reads your resume. Most service-company engineers apply with zero preparation for that, get rejected in round one, and wrongly conclude they "aren't good enough." The problem is almost always *preparation strategy*, not potential.
- **At ~1 year of experience you are, in market terms, close to a fresher with a job.** You will often be evaluated like a strong fresher/junior: heavy on DSA and fundamentals, lighter on deep system design (though LLD/machine-coding and intro HLD do come up). That's actually good news — the junior bar is more about raw problem-solving and fundamentals you can drill than about years of architardware experience.
- **Targeting 15–20 LPA at ~1 YOE is ambitious but achievable** for a genuinely strong candidate, especially via product unicorns, fintechs, and global capability centers (GCCs) rather than only FAANG. It is *not* a default outcome — it's the reward for real preparation plus a portfolio that proves you can build production software.

**The single most repeated piece of advice from people who've done it:** prepare *while employed*, never resign to "study full-time," and apply broadly with referrals. Your Cognizant salary is your leverage — it lets you reject low offers and negotiate.

---

## 2) The Market in 2026 — Demand, Packages, and Who's Hiring

### Is Java/backend still in demand?
Strongly yes. Java consistently ranks in the global top three languages, the overwhelming majority of large enterprises run core systems on it, and Spring Boot is by a wide margin the most common requirement in Java backend job descriptions. Backend, cloud-native, and microservices skills are described as a rising, durable demand across startups, fintech, e-commerce, healthcare, and enterprises. So your chosen stack (Java + Spring Boot + microservices + cloud) is exactly where the demand is — you're not betting on a niche.

### What's specifically "hot" / premium in 2026
From current hiring data and roadmaps, the skills that command a premium on top of core Java are: **Spring Boot + microservices experience, Java on Kubernetes, cloud (AWS/GCP/Azure) with containers and CI/CD, Kafka/event-driven systems, observability, and the ability to integrate AI/LLM APIs into existing systems.** Modern JDs increasingly list CI/CD, Kubernetes, Docker, cloud, SQL/NoSQL, data structures, and system-design awareness right alongside Java. Java 17/21 (LTS) is the expected baseline now, not Java 8.

### Realistic package bands (India, 2026)
Treat these as *orientation*, not guarantees — actual numbers depend on the company tier, your interview performance, and negotiation. Broad pattern reported across the market:

- **Service companies (TCS/Infosys/Wipro/Cognizant), junior:** ~₹4–7 LPA.
- **Same experience at product unicorns / fintechs (Razorpay, Swiggy, PhonePe, CRED, Zerodha, etc.):** frequently in the **~₹18–28 LPA** band for solid mid-level engineers; juniors land lower but still well above service-company pay.
- **FAANG/MAANG and top GCCs:** higher still, often **~₹25–45 LPA** total comp including stock and bonus for stronger mid-level profiles.
- **For your specific stage (~1 YOE):** a realistic, *well-prepared* target is the **~12–20 LPA** range depending on company tier; the upper end (or beyond) is reachable at unicorns/GCCs if you interview exceptionally and negotiate well. Don't anchor on a single number — anchor on "a large multiple of ₹4 LPA," and let competing offers push it up.

> A grounding caveat seen repeatedly in the data: the high numbers are for **engineers with strong, demonstrable skills** — not for the average candidate who applied with no preparation. The bar is higher for a reason. Your job over the next several months is to *become* the strong-skills candidate. (That's what Files 2 and 3 are for.)

### Where the jobs actually are (tiered target list)
Don't put all your hope in FAANG — it's the most competitive and lowest-probability tier. Spread your applications:

- **Tier A — high-probability, strong pay, friendlier bar (great first targets):** Razorpay, PhonePe, Meesho, CRED, Groww, Zerodha, Swiggy, Zomato, Nykaa, Postman, Hasura, BrowserStack, Zoho, Freshworks, Chargebee, Urban Company, and dozens of funded startups. Many pay 15–30 LPA with better culture and faster growth than FAANG.
- **Tier B — mid-tier product & GCCs (global capability centers in India):** Atlassian, Adobe, Intuit, PayPal, Walmart Global Tech, Salesforce, Cisco, VMware, SAP, Visa, American Express (engineering), Expedia, Goldman (engineering). Stable, strong pay, structured interviews.
- **Tier C — FAANG/MAANG:** Google, Microsoft, Amazon, Apple. Apply, prepare hard, but treat as upside, not your plan.

---

## 3) Real Transition Stories — What People Who Did It Say

Patterns distilled from engineers who've made the service→product jump (and from those who advise it). These aren't quotes; they're the consistent themes:

- **They self-taught aggressively from free resources and built real projects.** A recurring story: someone in support/service taught themselves everything from scratch, struggled with confidence midway, pushed through, and became a top performer at a product company. The lesson they repeat: *don't give up early; the resources are abundant; consistency beats talent.*
- **They followed structured creator content, not random tutorials.** Commonly cited free learning paths for Indian engineers: **"Concept and Coding"** (YouTube) for Java + Spring Boot + LLD/HLD, **Striver / takeUforward** and **NeetCode** for DSA, and **Gaurav Sen / ByteByteGo** for system design. The pattern is: master fundamentals deeply, then LLD/HLD, then practice interviews.
- **They prepared while employed and used offers as leverage.** Nobody who advises this recommends quitting first. They line up a written offer, *then* resign — and use competing offers to negotiate.
- **They emphasized projects + GitHub.** Strong projects and a visible GitHub portfolio repeatedly help service-company candidates get shortlisted despite "support/maintenance"-sounding job descriptions. This is precisely why File 2's plan centers on building one deployable, production-grade capstone you can show.
- **They reframed their resume.** "Worked on support and maintenance of a Java application for a US client" gets ignored; the same person rewriting it around what *they built, owned, and improved* (with quantified impact) gets callbacks.
- **They expected the DSA wall and trained for it.** The ones who failed usually skipped DSA or system design; the ones who succeeded drilled patterns and did mock interviews until they could solve mediums in ~40 minutes and narrate their thinking.

---

## 4) What Companies Actually Ask (The Interview Funnel)

Product-company hiring for your level typically runs through these stages. Knowing the funnel lets you prepare the *right* things (detailed in File 3).

1. **Resume/ATS screen.** Automated keyword filter + recruiter glance. Most applications die here — beat it with quantified bullets, the right keywords, and (above all) **referrals**.
2. **Online coding assessment (the big filter).** 1–3 DSA problems, timed, often on HackerRank/Codility/company platform. This eliminates 60–80% of applicants. **Non-negotiable to clear.**
3. **Technical/DSA interview round(s).** Live coding with an interviewer — they grade your *thought process and communication* as much as the solution. Practice talking while coding.
4. **LLD / machine-coding round (very common at your level).** Design clean OOP code (e.g., parking lot, Splitwise) in 60–90 minutes using design patterns and SOLID. Real-world, scenario-based questions ("how do two microservices communicate without exposing endpoints?" — service discovery, gateways, etc.) show up here too.
5. **System design / HLD (intro level for juniors).** Increasingly expected even at 1–3 YOE; you don't need deep mastery, but you must reason about scale, caching, databases, queues, and trade-offs. (Your production work from File 2 makes this genuinely easy.)
6. **Hiring manager + behavioral (STAR).** Ownership, conflict, failure, learning, leadership stories. At Amazon specifically, Leadership Principles are tested even inside coding rounds.
7. **HR / offer / negotiation.**

**What they're really testing across all of it:** (a) problem-solving via DSA, (b) ability to write clean, extensible OOP code, (c) ability to reason about scalable systems, (d) communication, and (e) culture fit. Files 2 and 3 build every one of these.


---

## 5) Where & How to Apply (Beyond the Black Hole)

Applying through "Easy Apply" on a job portal with a generic resume is the lowest-yield strategy that exists. Here's what actually works:

- **Referrals are the highest-leverage channel — most senior/mid roles in India are filled via referrals and networking, not portal listings.** A single referral can jump you past thousands of applicants in the automated pile. Action: list 20 "dream companies," find Cognizant ex-colleagues, college seniors/alumni, and 2nd-degree LinkedIn connections working there, and ask politely for a referral with your resume + a 2-line pitch. Aim for *two* referrals per target company.
- **Apply on the company's own careers page**, not only aggregators — and do it within ~48 hours of finding a role, then send a short personalized LinkedIn note to a recruiter or hiring manager signaling genuine interest.
- **Quality over spray-and-pray.** Mass-applying to 100+ roles with the same resume gets you flagged as low-quality by portal algorithms and burns you out. Tailor the resume's top section and keywords to each role/JD.
- **Build a magnet, not just a fishing line.** Optimize LinkedIn (keyword-rich headline, "Open to Work" set to recruiters-only, pinned capstone project), and post the occasional technical insight — visible builders get inbound recruiter interest. Your GitHub capstone (File 2) is the centerpiece.
- **Best portals/sources for India:** company career pages, LinkedIn, Naukri, Instahyre, Cutshort, Wellfound (startups), and referral communities. Track everything (company, role, date, referral, stage) in a sheet.

---

## 6) Timing the Move — When to Resign vs. When to Apply

This is the part people get wrong and pay for. The golden rules:

1. **Start applying and interviewing while fully employed.** Do *not* resign to free up time. You'll burn savings, panic, and accept a worse offer than your leverage deserves. Prepare in evenings/weekends (Files 2 and 3), then interview while still drawing your Cognizant salary.
2. **Only resign after you have a written, signed offer letter in hand** — not a verbal "we'll send it," not an email saying you cleared rounds. Signed offer, with the start date and comp in writing.
3. **Account for the notice period in your start-date negotiation.** Cognizant's notice for recent joiners is widely reported as **90 days** (see §7). Your new employer will ask your notice period; be honest, and negotiate a joining date that fits (most product companies can wait 60–90 days for the right candidate, and many offer buyout — see §8).
4. **Don't tell your manager you're looking until you have the offer.** Resignation conversations should happen *after* you're committed and protected.
5. **Mind your project allocation.** You've just been allocated to a project. Being "billable" makes early release harder (your project may resist losing you for revenue reasons — see §8). Factor this into timing; it's often easier to negotiate release between projects or early in an allocation than mid-critical-delivery.

---

## 7) Cognizant's Notice Period — What to Expect

> Confirm against *your* offer letter; this is the widely-reported norm, not legal advice.

- **Standard notice for employees who joined after ~January 2021 is 90 days; those who joined earlier had 60 days.** Since you joined recently (this past November), assume **90 days** unless your offer letter says otherwise. Some accounts mention band-wise variation (entry-level sometimes effectively shorter, managers 90), but the safe planning assumption for you is 90 days.
- The 90-day notice applies **both ways** — if the company initiates separation it also gives notice; when *you* resign and you're needed, they generally hold you to the full period and can be reluctant to shorten it.
- **You are paid your full salary during the notice period** while you serve it.
- The resignation is initiated through Cognizant's internal HR system (commonly via the **PeopleSoft / OneCognizant** portal and an official email to your manager), followed by clearance forms and an exit interview.

**Practical implication:** plan for up to 3 months between "I sign the new offer" and "I start the new job," unless you secure early release or a buyout (next section). Communicate this notice length to your prospective employer *during* offer discussions so the start date is realistic.

---

## 8) How to Get an Early Exit / Reduce the Notice Period

This is one of your specific questions, so here's the full picture of what's actually possible — and the honest constraints.

### The mechanisms that exist
- **Buyout ("notice pay in lieu of notice").** If your offer letter's notice clause includes wording like *"or payment in lieu of notice,"* you can typically buy out the unserved days — either you pay, or (commonly in tech) **your new employer buys out your notice** by paying Cognizant for the unserved period. Ask the new company's recruiter *during negotiation*: "Do you offer notice-period buyout?" Many product firms (e.g., large tech and finance) do; some have strict no-buyout policies, so confirm.
  - Typical buyout math in India uses a 30-day denominator: **Buyout = (Monthly Gross or CTC ÷ 30) × unserved-notice-days.** Whether it's on *gross* or *full CTC* depends on the contract — check yours, since CTC-based recovery is higher.
- **Early release approval.** Even without buyout, you can request early release. This generally needs **manager + skip-level (often "D"/"D+" level) approval**, routed *through your manager* — so the path is: convince your project manager and home manager, who escalate for approval. Persistence matters; people report needing daily follow-ups.
- **Adjusting leave balance.** You may be able to offset some notice days against accrued leave — ask HR.

### The honest constraints (why it's often hard)
- **If you're billable on a live project, Cognizant frequently resists early release**, citing revenue loss, and may insist on serving the full period "until a replacement is found." Multiple employees report being denied early release even after attempting buyout, with HR deferring to the project manager. This is the single biggest obstacle, and it applies to you because you're now allocated.
- Approval is **discretionary**, not a right (unless your contract's "in lieu of" clause makes buyout contractual — then push that hard with HR).

### How to maximize your odds (the playbook)
1. **Re-read your offer letter's notice clause now.** If it says "or payment in lieu," you have a contractual buyout lever — use it explicitly with HR.
2. **Get your resignation acceptance in writing immediately** (an accepted resignation email) so the notice can't be *extended* on you.
3. **Negotiate the new company's start date generously** as your baseline (assume 90 days), so early release becomes a bonus, not a dependency. Ask the new employer about buyout *before* you sign.
4. **Make release easy for them:** offer a clean handover — document your work, train a replacement, finish critical deliverables. Frame it positively and professionally. Managers grant 2–4 weeks (sometimes more) of early release far more readily when you reduce their pain.
5. **Follow up persistently and politely** with your project manager and home manager; escalate to HRBP. Keep everything in email.
6. **Time it well** — pushing for release between projects or early in an allocation is easier than mid-critical-delivery.
7. **Never abscond / no-show.** Walking out without serving notice or without a written release is "absconding" — it risks your relieving/experience letters and a clean background verification (BGV), which your *new* product company will run. Not worth it. Protect your paperwork.

---

## 9) Documents to Collect from HR (Critical for BGV at the New Company)

Your product-company offer will be subject to **background verification (BGV)**, and missing documents are a real risk. Collect and safely store *digital copies of everything* — ideally before and right after your last working day, because chasing ex-employer documents later is painful.

**Get from Cognizant (during/after exit):**
- **Resignation acceptance letter** (the email/letter confirming they accepted your resignation).
- **Relieving letter** (confirms your joining and last working day) — issued on completion of exit formalities; usually available on/after LWD via the HR/ex-employee portal.
- **Experience / service certificate** (confirms name, employee ID, designation, dates of employment). Note: at Cognizant this is sometimes separate from the relieving letter, and the **roles-and-responsibilities letter** typically must be *requested* (commonly via an internal "eLetter" app — you draft it, your manager/HCM approves, then HR issues it, often a few days post-LWD). Request it explicitly; some new employers ask for it.
- **Full & Final (F&F) settlement statement** (final dues, leave encashment, notice/recovery adjustments).
- **Form 16 / tax documents** for the financial year(s) worked.
- **Payslips** — keep your last several months (commonly the last 3) at minimum; ideally all of them.
- **Offer letter / appointment letter** and any **appraisal/salary-revision letters** (these show your current package for BGV and negotiation).

**Also keep (you should already have these):**
- **Bank statements** for the last ~3–6 months (salary credits — used in BGV).
- **Your employee ID and official Cognizant email exit confirmation.**
- **PF (Provident Fund) details / UAN** — for transfer/withdrawal later.
- **National Skills Registry / NASSCOM ID** if you were enrolled (some new employers ask you to register/verify here).

**Process tips:**
- You typically retain **portal access to download payslips, the relieving letter, etc.** after exit — but download and back them up immediately; access can lapse.
- Return IT assets (laptop) per the documented process (you can often courier it if you've relocated — confirm with HR) and **keep the asset-return acknowledgment**.
- Complete the **clearance forms and exit interview** — these gate your relieving letter and F&F.
- If any document is delayed or wording is disputed, escalate via HRBP in writing and keep records; if urgently needed for the new employer, ask for an **interim/employment-confirmation letter**.

---

## 10) Negotiating the Offer (Capturing the Jump)

Where you actually turn "an offer" into "15–20 LPA":

- **Wait for the written offer before negotiating.** Negotiating on a verbal is weak.
- **Avoid revealing your ₹4 LPA first if you can.** It anchors the offer low. Deflect: *"I'd like to understand the role and scope first; I'm confident we can reach a fair, market-aligned number."* If pressed, give an **expectation range based on market research**, not your current salary.
- **Always counter.** A large majority of Indian employers expect negotiation; the first offer is rarely the best. Counter politely with a specific number (commonly ~15–25% above the offer), justified by your skills, your portfolio, and market data.
- **Use competing offers as leverage** — which is exactly why you keep multiple processes running in parallel.
- **Evaluate total compensation,** not just base: fixed + variable/bonus + joining bonus + ESOPs/RSUs. A startup's lower base may carry meaningful equity; a GCC's higher base may have less.
- **Get the final number in writing before you resign** from Cognizant.

---

## 11) Your Step-by-Step Shift Timeline (Putting It Together)

A realistic sequence for your situation (the *learning* that fills the early months is in Files 2 and 3):

1. **Now → next several months (while employed):** Build production skills + portfolio (File 2) and grind interview prep (File 3). Don't tell anyone at work. Quietly optimize resume + LinkedIn + GitHub.
2. **~2–3 months before you want to switch:** Start applying via referrals and company pages. Begin interviewing. Each interview sharpens you.
3. **On clearing rounds:** Negotiate hard; ask about **buyout**; get the **written, signed offer** with a realistic start date (assume up to 90 days notice).
4. **Only then:** Resign through the Cognizant portal + manager email. Get **resignation acceptance in writing** immediately.
5. **During notice:** Pursue **early release / buyout** (offer a clean handover), serve professionally, and **collect every document** in §9. Don't abscond.
6. **Before LWD:** Return assets (keep acknowledgment), complete clearance + exit interview, download all payslips/letters from the portal.
7. **Join the new company:** Cooperate fully with **BGV** using your collected documents. Transfer PF.

---

## 12) The Mistakes That Cost People (Shift-Specific)

1. **Resigning before having a signed offer.** Never. Offer in hand first.
2. **Quitting to "prepare full-time."** Burns savings and leverage; prepare while employed.
3. **Telling your manager you're job-hunting early.** Wait until you have the offer.
4. **Promising the new employer an unrealistic start date** (e.g., 30 days when notice is 90). Be honest; negotiate; explore buyout.
5. **Absconding / no-showing to dodge notice.** Risks relieving/experience letters and a clean BGV — which the product company *will* run. Protect your paperwork.
6. **Not collecting documents before access lapses.** Download everything immediately around LWD.
7. **Revealing current salary first / not negotiating.** Anchors you low and leaves money on the table.
8. **Only applying via portals, only targeting FAANG.** Use referrals; cast a tiered net across unicorns and GCCs.
9. **Applying with a "support/maintenance" resume.** Reframe around what you built and owned, with numbers.
10. **Skipping DSA/system-design prep** because you have a job. The screen doesn't care about your job; it cares whether you can solve the problem.

---

### Bottom line for File 1
The switch from Cognizant GenC at ~1 year to a product company at a much higher package is **realistic if — and only if — you prepare seriously while employed, build a portfolio that proves you can ship production software, apply via referrals across a tiered company list, and handle the exit cleanly** (signed offer first, negotiate buyout, collect every document, never abscond). The market wants your stack; the gating factor is your preparation and your paperwork discipline. Files 2 and 3 make you the candidate who clears the bar.

