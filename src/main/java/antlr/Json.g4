grammar Json;

program: object | array ;

pair : key ':' value ;

object : '{' pair (',' pair)* '}' ;

array : '[' value (',' value)* ']' ;

key : STRING
    ;

value : STRING
      | NUMBER
      | 'true' | 'false'
      | 'null'
      | object
      | array
      ;

STRING : '"' [a-z0-9A-Z]+ '"';
NUMBER : [0-9]+;

WS     : [ \r\n\t]+ -> skip;