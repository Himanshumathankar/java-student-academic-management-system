# Architecture

## Layered flow

```text
Console UI -> Service Layer -> Repository Layer -> CSV Storage
```

`ConsoleMenu` owns prompting, retrying numeric input, and display. It does not calculate grades or manipulate files. The service classes represent use cases and validate references. `StudentRepository` demonstrates interface-based abstraction; its file implementation and `AcademicRepository` load records into collections and persist mutations.

The `model` package contains state and domain behavior. `Person` supplies common identity fields, while `Student` overrides its polymorphic display method. `AcademicRecord` owns marks and attendance invariants. The `utility` package supplies reusable validation, grading, and I/O. Domain-specific exceptions travel upward and are converted into readable errors at the UI boundary.

## Design decisions

Java 17 was chosen as a stable LTS version. Maven standardizes the lifecycle. CSV keeps the project inspectable and deployable without infrastructure. A map is used for unique student/course lookup, a set models unique enrollment pairs, and lists support ordering and reporting. The service/repository boundary keeps business operations independent of console input and makes unit tests straightforward.

## Persistence and reliability

Files are created automatically. `FileInputStream`/`BufferedReader` load UTF-8 rows; `FileOutputStream`/`BufferedWriter` write them. Writes first target a sibling temporary file, then replace the destination atomically when the file system supports it. Try-with-resources closes every stream.

Deleting a student or course also removes related enrollment and academic records. The current CSV grammar intentionally rejects commas/newlines inside fields rather than hiding a third-party CSV dependency.
