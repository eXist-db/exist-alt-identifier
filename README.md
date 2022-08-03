# Alternate Unique Identifier Library Module for eXist-db


## ULID — Universally Unique Lexicographically Sortable Identifier

UUIDs are usually quite nice to use as random IDs. Most people including 
me would simply use a UUID v4 as a way to generate random IDs. But UUIDs 
v4 is just plain randomness. There is no way to tell if a uuid-a > uuid-b 
or the vice versa. That is when I discovered ULID. ULID stands for 
Universally unique Lexicographically sortable IDentifiers. ULID ensures 
that the IDs can be monotonically ordered and can be sorted even when 
generated within a millisecond. There are ²⁸⁰ possible ids within a 
millisecond.

```xquery
xquery version "3.1";

import module namespace altid = "https://exist-db.org/xquery/altid";

altid:ulid()
```

## From SecureRandom

This library function was inspired by the article at: [Moving away from UUIDs
 by Neil Madden](https://neilmadden.blog/2018/08/30/moving-away-from-uuids/)

Here is a sample XQuery

```xquery
xquery version "3.1";

import module namespace altid = "https://exist-db.org/xquery/altid";

altid:secure-random()
```

It returned `twRminDVuAMHoNTXwtHuV5wS2rs` after one of the calls.