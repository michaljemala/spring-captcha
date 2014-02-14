Spring Captcha
==============

Spring Security SimpleCaptcha integration sample.

It demonstrates a way how to introduce a CAPTCHA verification into the form logins. After 3 unsuccessful login attempts a CAPTCHA will required to be provided.

To generate CAPTCHAs the [SimpleCaptcha library](http://simplecaptcha.sourceforge.net/) is used.

How to install SimpleCaptcha to your local Maven repo
-----------------------------------------------------
```shell
mvn install:install-file -Dfile=./lib/simplecaptcha-1.2.jar -DgroupId=nl.captcha -DartifactId=simplecaptcha -Dversion=1.2 -Dpackaging=jar
```
