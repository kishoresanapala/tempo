# calculator
A simple calculator exposed as Rest API, built with Java 8 using Spring Boot.

## Requirement
Install Java 8 JDK.

## Run
Run SimpleCalculatorApplication as main in eclipse or any java IDE.

After that the application can be accessed using the base url *http://localhost:8080/tempo/calculator*

## CURL Command for add numbers

curl -X POST \
  http://localhost:8080/tempo/calculator/addNum \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"firstNumber": 6,
"secondNumber": 2
}'

## CURL Command for subtract numbers

curl -X POST \
  http://localhost:8080/tempo/calculator/subtractNum \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"firstNumber": 6,
"secondNumber": 2
}'


## CURL Command for multiply numbers

curl -X POST \
  http://localhost:8080/tempo/calculator/multiplyNum \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"firstNumber": 6,
"secondNumber": 2
}'

## CURL Command for divide numbers

curl -X POST \
  http://localhost:8080/tempo/calculator/divideNum \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"firstNumber": 6,
"secondNumber": 2
}'


## Unit testcase can be run using following command

mvn clean install
