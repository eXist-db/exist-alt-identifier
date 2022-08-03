# Alternate Unique Identifier Library Module for eXist-db

This library module was inspired by the article at: [Moving away from UUIDs
 by Neil Madden](https://neilmadden.blog/2018/08/30/moving-away-from-uuids/)

Here is a sample XQuery

```xquery
xquery version "3.1";

import module namespace uuid = "https://exist-db.org/xquery/uuid";

uuid:secure-random()
```

It returned `twRminDVuAMHoNTXwtHuV5wS2rs` after one of the calls.