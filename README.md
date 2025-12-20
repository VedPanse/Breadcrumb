# Breadcrumb  
## A Disaster-Response Movement Evidence System  
*Kotlin Multiplatform Contest Submission*

---

## Overview

**Breadcrumb** is a disaster-response sensing layer that passively records short-lived human movement trails on personal devices and makes them available to first responders when GPS, networks, and communication fail.

Breadcrumb treats **human movement as evidence**, not as live location data. Survivors do not actively use the app; their devices act as temporary, privacy-preserving “black boxes” of movement that responders can query during search and rescue operations.

---

## Problem Statement

In major disasters (earthquakes, building collapses, floods, fires):

- GPS becomes unreliable or unavailable.
- Cellular and internet connectivity is fragmented or absent.
- Survivors may be unconscious, trapped, or unable to communicate.
- Search and rescue teams often lack actionable information about where people moved before becoming immobilized.

Today’s tools rely on:
- Last-known GPS location (often inaccurate indoors or underground),
- Voice calls or SOS features (which assume connectivity and conscious users),
- Manual, random, or intuition-based search patterns.

There is a gap between **total isolation** and **live communication** where valuable information exists but is lost.

---

## Core Insight

Even when networks and GPS fail, **human movement still leaves structure**:
- steps,
- turns,
- direction changes,
- sudden stops.

Breadcrumb captures this structure and preserves it briefly, allowing rescuers to follow *where someone walked* rather than guessing *where they might be*.

---

## Who Uses Breadcrumb

### Primary Users: First Responders
- Urban search and rescue teams
- Firefighters
- Disaster relief workers

They use Breadcrumb to:
- Identify whether a person passed through an area
- Follow a movement trail that ends near rubble or obstruction
- Prioritize search zones based on recent human movement

### Passive Participants: Survivors
- Survivors do not interact with the app during an emergency.
- Their phones passively record movement when disaster mode is active.
- No active reporting, messaging, or configuration is required.

---

## What Breadcrumb Is Not

- Not a live tracking system
- Not a messaging or mesh chat application
- Not a GPS replacement
- Not a consumer safety or fitness app
- Not a social or crowdsourced platform

Breadcrumb intentionally limits scope to avoid misuse and overclaiming.

---

## How Breadcrumb Works (High-Level)

1. **Activation**
   - Disaster mode is triggered manually or via system-level emergency conditions.
   - Movement recording begins automatically.

2. **Movement Capture**
   - The device records:
     - step counts,
     - orientation changes,
     - relative displacement.
   - No continuous GPS tracking is required.

3. **Trail Construction**
   - Movement data is converted into a relative path.
   - The path represents how a person moved through space, not their absolute coordinates.

4. **Trail Compression and Decay**
   - Trails are simplified and compressed to reduce noise.
   - Each trail has a time-to-live and expires automatically.

5. **Responder Access**
   - Responders entering an area can query nearby devices.
   - Trails are displayed as directional paths with confidence indicators.

---

## Privacy and Safety by Design

Breadcrumb is designed to minimize misuse and protect individuals:

- No identity data is stored or transmitted.
- No continuous tracking outside disaster mode.
- Trails expire automatically and cannot persist indefinitely.
- Data is local-first and shared only during rescue operations.
- Survivors are not required to opt in during emergencies.

---

## Why Breadcrumb Is Not a Gimmick

Breadcrumb aligns with how real rescue work already happens:

- Rescuers look for physical traces (footprints, disturbed debris).
- Breadcrumb digitizes this intuition using sensors people already carry.
- It provides directional evidence without claiming certainty.

Breadcrumb does not replace human judgment; it reduces uncertainty.

---

## Why Kotlin Multiplatform Is Essential

Breadcrumb’s core complexity lies in **shared logic**, not UI.

### Shared Kotlin Logic (commonMain)

- Step detection and filtering
- Dead-reckoning and relative path estimation
- Trail compression algorithms
- Confidence scoring
- Expiry and decay rules
- Data models and serialization

This logic is identical across platforms and implemented once.

### Platform-Specific Code

- Sensor adapters (accelerometer, gyroscope, step counter)
- Permission handling
- Minimal UI rendering for responders

This results in a very high percentage of shared Kotlin code, directly aligning with Kotlin Multiplatform’s strengths.

---

## Alignment with Kotlin Coding Conventions

Breadcrumb is designed with idiomatic Kotlin practices:

- Immutable data classes
- Clear module boundaries
- Pure transformation pipelines
- Explicit state modeling
- Minimal side effects
- Consistent naming and formatting per official conventions

---

## Minimal Viable Product (MVP)

The MVP focuses on one clear, useful outcome:

- Record a single movement trail
- Identify the last known stopping point
- Display the trail direction and confidence to a responder

This ensures the project remains focused, credible, and demonstrable.

---

## Novelty and Impact

Breadcrumb reframes disaster response by introducing a new primitive:

> **Movement as emergency evidence**

This concept is simple, intuitive, and not commonly encountered in existing tools. It addresses a real operational gap without requiring new infrastructure or behavior changes.

---

## Conclusion

Breadcrumb is a humanitarian, infrastructure-level system that:

- Works when communication fails
- Respects privacy by design
- Leverages shared Kotlin logic across platforms
- Provides rescuers with actionable evidence, not guesses

It is intentionally constrained, technically rigorous, and aligned with Kotlin Multiplatform’s core philosophy.

---

