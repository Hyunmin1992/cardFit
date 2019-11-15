# cardFit이란?
### -> card + benefit의 합성어로 자신이 사용하는 카드의 혜택을 검색하고 자신의 라이프스타일에 맞지 않다면 추천받을 수 있는 웹사이트

**1. Getting Started** <br>
  - 개인 로컬 PC에서 test해보는 방법
    - cardFit/src/main/java/com/cardfit/project/config/ELConfiguration.java 파일의 IP주소를 localhost로 바꿔주세요. <br>
    - 메인 웹 페이지 시작시 별도의 로그인은 없지만 성별과 나이를 체크해줘야만 서비스 이용이 가능합니다. <br>
      * 별도의 로그인 페이지를 만들지 않은 이유 : 단순히 검색 서비스만 이용하고 싶은데 회원가입을 해야하는 경우 사용자들이 개인정보수집에 대한 거부감이 있을 수 있다고 생각했습니다. <br>
      * 성별과 나이는 왜 체크를 하는지? : 서비스 이용자들에게 로그인 기능을 없앤 대신 이용자들의 성향을 분석하기 위해 일종의 설문조사 방식으로 접근했습니다. 성별과 나이에 따른 검색 통계를 내어 연령대와 남녀들이 선호한 카드 혜택을 분석하고 가장 인기가 많은 카드의 혜택이 무엇인지 알아보고자 했습니다. 


**2. 개발기간 & 개발배경 & Insight** <br>
  * 개발기간 : _19.10.09 ~ 19.10.23 (15일)_ <br>
  * 개발배경 : 평소에 내가 쓰는 체크카드의 혜택을 몰라 현명한 소비를 할 수 없었고, 나만의 생활패턴을 반영한 카드를 찾고자 했습니다. <br>
  * Insight : 체크카드 상품을 선택할 때 남녀노소 구별없이 어떤 혜택이 가장 공통적으로 많은지, 남녀의 성비에 따른 선호 혜택은 무엇인지, 연령대에 따른 선호 혜택은 무엇인지 cardFit을 이용하는 사람들로 하여금 적재되는 데이터로 분석해보고 싶었습니다. 

**3. 팀 구성** <br>
  * Front-end : 박현민 <br>
  * Back-end : 송시찬, 이현준 <br>
  * PM : 송평현 <br>

**4. Architecture** <br>
  * Spring MVC Pattern
  
**5. Skill Set** <br>
  * Front-end : Javascript, HTML, CSS, Bootstrap    
  * Back-end : Java(Spring Boot)    
  * DB : ELK (ElasticSearch v7.0.0)   
  * Data Source : 신한카드, 우리카드, IBK 기업카드   
  * Library : Lombok, json-simple   
  * Visualization : R Studio  
  * Environment : Eclipse (Maven)

