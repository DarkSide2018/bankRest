# bankRest
restWithGradle

you need Java 8

1. ./gradlew war appRun

2. go to http://localhost:8085/bankRestApp

|HTTP METHOD	| PATH	| USAGE |
| -----------| ------ | ------  |
|GET	 | /account?accountID={accountID}	| get account by id |
|POST | /bank?fromAccount={accountID}&toAccount={accountID}&currency={currencyCode}&amount={amount}	| transaction between 2 user accounts |
