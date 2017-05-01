# hiveql-parser
HiveQL Parser. Parse HiveQL code and print AST in JSON format if success, else print well formed syntax error message.

## Build

```bash
$ mvn package
```

To build standalone jar, use:
```bash
$ mvn clean compile assembly:single
```

## Run

```bash
$ javar -jar /path/to/hiveql-parser.jar /path/to/your-code.sql
```
