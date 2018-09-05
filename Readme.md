# spring boot ldap demo  

spring boot 2 + spring security + openldap demo


## 使用
http://localhost:8080/test/msg?id=1
用 test1 / 123456 登录 

## ldif
```

dn: ou=engineering,dc=test,dc=com
objectclass: organizationalUnit
objectclass: top
ou: engineering


dn: cn=test1,ou=engineering,dc=test,dc=com
cn: test1
givenname:: 5ZSQ
mail: test1@test.com
objectclass: inetOrgPerson
objectclass: top
sn:: 6Iqz5Y2O
uid: test1
userpassword: 123456


dn: cn=g2,ou=groups,dc=test,dc=com
cn: g2
objectclass: groupOfUniqueNames
objectclass: top
uniquemember: cn=test1,ou=engineering,dc=test,dc=com


```