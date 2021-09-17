# BankingApplicationBE
- This is a simple banking application
## To connect to Oracle SQL Developer database
- Input *username* and *password* for these keys in *src/main/resources/application.properties* file
```
spring.datasource.username=
spring.datasource.password=
```
## Limitations
- This banking application assumes that one user can only have 1 account
- Funds in the account are only available via inter-account transfer within the same bank or deposit upon account creation
## Extra
- The source codes populates the database tables on the first run. However, the following lines (lines 48 to 50 in *BankingApplication.java*) should be commented after the first run
```
consumePostRestApis(template, map1);
consumePostRestApis(template, map2);
consumePostRestApis(template, map3);
```
