# Testing

Run automated tests with `mvn test`. “Not run” manual rows are intentionally not presented as passed; complete them during your own evaluation session.

| Test ID | Feature | Input | Expected Result | Actual Result | Status |
|---|---|---|---|---|---|
| T01 | Add student | Valid unique record | Stored and retrievable | Matches expectation in JUnit | Automated pass |
| T02 | Duplicate student | Existing ID | `DuplicateStudentException` | Matches expectation in JUnit | Automated pass |
| T03 | Email validation | `not-an-email` | Rejected | Matches expectation in JUnit | Automated pass |
| T04 | Marks validation | Assignment 21 | Rejected | Matches expectation in JUnit | Automated pass |
| T05 | Student search | Partial mixed-case name | Matching student | Matches expectation in JUnit | Automated pass |
| T06 | Field safety | Name containing comma | Rejected | Matches expectation in JUnit | Automated pass |
| T07 | Grade boundaries | 90, 89.99, 70, 40, 39.99 | A+, A, B+, D, F | Matches expectation in JUnit | Automated pass |
| T08 | Attendance calculation | 30 of 40 | 75% | Matches expectation in JUnit | Automated pass |
| T09 | Invalid attendance | 11 of 10 | Rejected | Matches expectation in JUnit | Automated pass |
| T10 | File persistence | Add then recreate repository | Student reloads | Matches expectation in JUnit | Automated pass |
| T11 | Duplicate enrollment | Same pair twice in CLI | Friendly error | Not run | Manual pending |
| T12 | Low attendance report | Student below 75% | Student listed | Not run | Manual pending |
| T13 | Course creation | Valid unique course | Course saved | Not run | Manual pending |
| T14 | Invalid menu input | `abc`, then valid number | Error and retry | Not run | Manual pending |

Automated tests use JUnit 5 and temporary directories, so they do not modify sample data. A successful `mvn test` run is the authoritative current result; update manual rows only after personally executing them.
