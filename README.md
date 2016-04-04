# server-test

this project test the features of some java servers which are compatible for ring.

현재 테스트되는 서버들.

1. jetty
2. http-kit
3. undertow
4. immutant

immutant는 내부적으로 undertow를 사용하나 인코딩은 자체적으로 수행한 바이트스트림을 undertow에 보내기 때문에 동작 방식이 다르다.

# Usage

## 한글 인코딩 테스트

### 1. Http Response의 Content-Type 헤더에 지정한 charset으로 Response가 인코딩되는지 확인.

확인하는 방법

1. 서버 구동
소스코드에서 테스트하기 원하는 서버를 커멘트를 풀고 명령창에서 lein run을 한다.

2. 브라우저에서 요청 보내기.

      * 크롬에서 다음의 url로 요청을 보낸다.

      http://localhost:3001/?euc-kr

      http://localhost:3001/?utf-8

3. 브라우저창에서 '한글'이 잘 보이면 서버가 잘 처리한 것.

### 2. 헤더에 charset이 지정되지 않은 Http Request가 올 때, 서버가 요청을 처리하는 디폴트 인코딩이 ISO-8859-1인지를 확인.

확인하는 방법

1. 서버 구동
  소스코드에서 테스트하기 원하는 서버를 커멘트를 풀고 명령창에서 lein run을 한다.

2. 브라우저에서 요청 보내기.

    * 크롬과 IE에서 다음의 url로 요청을 보낸다.

    http://localhost:3001/?가

3. 서버를 실행시킨 명령창에 여러가지 변환 스트링중에서 한글 '가'가 보이면 서버가 잘 처리한 것.


# License

Copyright © 2016 NoBody

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
