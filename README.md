# hiveql-parser
HiveQL Parser. Parse HiveQL code and print AST in JSON format if success(exit 0), else print well formed syntax error message(exit 1).

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

## Examples

```bash
$ java -jar hiveql-parser.jar <(echo "select count(*) as count, myfield from &0rz") 2>/dev/null
[1,39]: line 1:39 cannot recognize input near '&' '0rz' '<EOF>' in join source
```

```bash
$ java -jar hiveql-parser.jar <(echo "select count(*) as count, myfield from 0rz") 2>/dev/null | jq .
```
```json
{
  "startIndex": 0,
  "stopIndex": 18,
  "childIndex": -1,
  "children": [
    {
      "startIndex": 0,
      "stopIndex": 16,
      "token": {
        "type": 860,
        "line": 0,
        "charPositionInLine": -1,
        "channel": 0,
        "text": "TOK_QUERY",
        "index": -1,
        "start": 0,
        "stop": 0
      },
      "childIndex": 0,
      "children": [
        {
          "startIndex": 14,
          "stopIndex": 16,
          "token": {
            "type": 748,
            "line": 0,
            "charPositionInLine": -1,
            "channel": 0,
            "text": "TOK_FROM",
            "index": -1,
            "start": 0,
            "stop": 0
          },
          "childIndex": 0,
          "children": [
            {
              "startIndex": 16,
              "stopIndex": 16,
              "token": {
                "type": 954,
                "line": 0,
                "charPositionInLine": -1,
                "channel": 0,
                "text": "TOK_TABREF",
                "index": -1,
                "start": 0,
                "stop": 0
              },
              "childIndex": 0,
              "children": [
                {
                  "startIndex": 16,
                  "stopIndex": 16,
                  "token": {
                    "type": 953,
                    "line": 0,
                    "charPositionInLine": -1,
                    "channel": 0,
                    "text": "TOK_TABNAME",
                    "index": -1,
                    "start": 0,
                    "stop": 0
                  },
                  "childIndex": 0,
                  "children": [
                    {
                      "startIndex": 16,
                      "stopIndex": 16,
                      "token": {
                        "type": 26,
                        "line": 1,
                        "charPositionInLine": 39,
                        "channel": 0,
                        "index": 16,
                        "start": 39,
                        "stop": 41
                      },
                      "childIndex": 0,
                      "children": [],
                      "toString": "0rz",
                      "toStringTree": "0rz"
                    }
                  ],
                  "toString": "TOK_TABNAME",
                  "toStringTree": "(tok_tabname 0rz)"
                }
              ],
              "toString": "TOK_TABREF",
              "toStringTree": "(tok_tabref (tok_tabname 0rz))"
            }
          ],
          "toString": "TOK_FROM",
          "toStringTree": "(tok_from (tok_tabref (tok_tabname 0rz)))"
        },
        {
          "startIndex": -1,
          "stopIndex": 12,
          "token": {
            "type": 772,
            "line": 0,
            "charPositionInLine": -1,
            "channel": 0,
            "text": "TOK_INSERT",
            "index": -1,
            "start": 0,
            "stop": 0
          },
          "childIndex": 1,
          "children": [
            {
              "startIndex": -1,
              "stopIndex": -1,
              "token": {
                "type": 726,
                "line": 0,
                "charPositionInLine": -1,
                "channel": 0,
                "text": "TOK_DESTINATION",
                "index": -1,
                "start": 0,
                "stop": 0
              },
              "childIndex": 0,
              "children": [
                {
                  "startIndex": -1,
                  "stopIndex": -1,
                  "token": {
                    "type": 727,
                    "line": 0,
                    "charPositionInLine": -1,
                    "channel": 0,
                    "text": "TOK_DIR",
                    "index": -1,
                    "start": 0,
                    "stop": 0
                  },
                  "childIndex": 0,
                  "children": [
                    {
                      "startIndex": -1,
                      "stopIndex": -1,
                      "token": {
                        "type": 963,
                        "line": 0,
                        "charPositionInLine": -1,
                        "channel": 0,
                        "text": "TOK_TMP_FILE",
                        "index": -1,
                        "start": 0,
                        "stop": 0
                      },
                      "childIndex": 0,
                      "children": [],
                      "toString": "TOK_TMP_FILE",
                      "toStringTree": "tok_tmp_file"
                    }
                  ],
                  "toString": "TOK_DIR",
                  "toStringTree": "(tok_dir tok_tmp_file)"
                }
              ],
              "toString": "TOK_DESTINATION",
              "toStringTree": "(tok_destination (tok_dir tok_tmp_file))"
            },
            {
              "startIndex": 0,
              "stopIndex": 12,
              "token": {
                "type": 878,
                "line": 0,
                "charPositionInLine": -1,
                "channel": 0,
                "text": "TOK_SELECT",
                "index": -1,
                "start": 0,
                "stop": 0
              },
              "childIndex": 1,
              "children": [
                {
                  "startIndex": 2,
                  "stopIndex": 9,
                  "token": {
                    "type": 880,
                    "line": 0,
                    "charPositionInLine": -1,
                    "channel": 0,
                    "text": "TOK_SELEXPR",
                    "index": -1,
                    "start": 0,
                    "stop": 0
                  },
                  "childIndex": 0,
                  "children": [
                    {
                      "startIndex": 2,
                      "stopIndex": 5,
                      "token": {
                        "type": 752,
                        "line": 0,
                        "charPositionInLine": -1,
                        "channel": 0,
                        "text": "TOK_FUNCTIONSTAR",
                        "index": -1,
                        "start": 0,
                        "stop": 0
                      },
                      "childIndex": 0,
                      "children": [
                        {
                          "startIndex": 2,
                          "stopIndex": 2,
                          "token": {
                            "type": 26,
                            "line": 1,
                            "charPositionInLine": 7,
                            "channel": 0,
                            "index": 2,
                            "start": 7,
                            "stop": 11
                          },
                          "childIndex": 0,
                          "children": [],
                          "toString": "count",
                          "toStringTree": "count"
                        }
                      ],
                      "toString": "TOK_FUNCTIONSTAR",
                      "toStringTree": "(tok_functionstar count)"
                    },
                    {
                      "startIndex": 9,
                      "stopIndex": 9,
                      "token": {
                        "type": 26,
                        "line": 1,
                        "charPositionInLine": 19,
                        "channel": 0,
                        "index": 9,
                        "start": 19,
                        "stop": 23
                      },
                      "childIndex": 1,
                      "children": [],
                      "toString": "count",
                      "toStringTree": "count"
                    }
                  ],
                  "toString": "TOK_SELEXPR",
                  "toStringTree": "(tok_selexpr (tok_functionstar count) count)"
                },
                {
                  "startIndex": 12,
                  "stopIndex": 12,
                  "token": {
                    "type": 880,
                    "line": 0,
                    "charPositionInLine": -1,
                    "channel": 0,
                    "text": "TOK_SELEXPR",
                    "index": -1,
                    "start": 0,
                    "stop": 0
                  },
                  "childIndex": 1,
                  "children": [
                    {
                      "startIndex": 12,
                      "stopIndex": 12,
                      "token": {
                        "type": 950,
                        "line": 0,
                        "charPositionInLine": -1,
                        "channel": 0,
                        "text": "TOK_TABLE_OR_COL",
                        "index": -1,
                        "start": 0,
                        "stop": 0
                      },
                      "childIndex": 0,
                      "children": [
                        {
                          "startIndex": 12,
                          "stopIndex": 12,
                          "token": {
                            "type": 26,
                            "line": 1,
                            "charPositionInLine": 26,
                            "channel": 0,
                            "index": 12,
                            "start": 26,
                            "stop": 32
                          },
                          "childIndex": 0,
                          "children": [],
                          "toString": "myfield",
                          "toStringTree": "myfield"
                        }
                      ],
                      "toString": "TOK_TABLE_OR_COL",
                      "toStringTree": "(tok_table_or_col myfield)"
                    }
                  ],
                  "toString": "TOK_SELEXPR",
                  "toStringTree": "(tok_selexpr (tok_table_or_col myfield))"
                }
              ],
              "toString": "TOK_SELECT",
              "toStringTree": "(tok_select (tok_selexpr (tok_functionstar count) count) (tok_selexpr (tok_table_or_col myfield)))"
            }
          ],
          "toString": "TOK_INSERT",
          "toStringTree": "(tok_insert (tok_destination (tok_dir tok_tmp_file)) (tok_select (tok_selexpr (tok_functionstar count) count) (tok_selexpr (tok_table_or_col myfield))))"
        }
      ],
      "toString": "TOK_QUERY",
      "toStringTree": "(tok_query (tok_from (tok_tabref (tok_tabname 0rz))) (tok_insert (tok_destination (tok_dir tok_tmp_file)) (tok_select (tok_selexpr (tok_functionstar count) count) (tok_selexpr (tok_table_or_col myfield)))))"
    },
    {
      "startIndex": 18,
      "stopIndex": 18,
      "token": {
        "type": -1,
        "line": 2,
        "charPositionInLine": 0,
        "channel": 0,
        "index": 18,
        "start": 43,
        "stop": 43
      },
      "childIndex": 1,
      "children": [],
      "toString": "<EOF>",
      "toStringTree": "<eof>"
    }
  ],
  "toString": "nil",
  "toStringTree": "(tok_query (tok_from (tok_tabref (tok_tabname 0rz))) (tok_insert (tok_destination (tok_dir tok_tmp_file)) (tok_select (tok_selexpr (tok_functionstar count) count) (tok_selexpr (tok_table_or_col myfield))))) <eof>"
}
```
