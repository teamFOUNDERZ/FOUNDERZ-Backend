![image](https://github.com/user-attachments/assets/2800382f-d37a-49ba-8b83-2ca095dfc231)
#### Software Future & Dream Challenge 2024, 2024 빛가람 에너지밸리 소프트웨어 작품 경진대회 출품작.- 파운더즈FOUNDERZ

## 개요
청년 창업가들이 직면하는 여러 문제를 해결하고, 성공적인 창업을 위한 자원과 지원을 제공하는 종합 플랫폼

- **개발 기간:** 2024년 5월 ~ 2024년 11월
- **개발 인원:** 백엔드 2명, 프론트엔드 2명
- **운영 상태:** 운영 종료

## Project Rule
written by **[@ori0o0p](https://github.com/ori0o0p)**

## 모듈 추가

![image](https://github.com/user-attachments/assets/2d050d32-6ce5-4ac5-9d1f-19019c13b539)

하위 모듈을 추가할 상위 모듈에서 우클릭 후 New → Module…

![image](https://github.com/user-attachments/assets/5cd58b88-1285-4634-bdcf-1b22a61b23ab)

네이밍 규칙:

루트 모듈 (루트 도메인): founderz

레벨 1 계층 별: founderz-application, founderz-domain….

레벨 2 서브 도메인 별: user-application, user-domain

레벨 3는 만들지 않습니다.

Spring Initalizr가 아닌 New Module로 생성

- [ ]  상위 모듈이 제대로 연결되어 있나요?
- [ ]  언어가 자바인가요?
- [ ]  빌드 도구가 Gradle인가요?
- [ ]  JDK 버전이 21인가요?
- [ ]  Gradle DSL이 Kotlin인가요?
- [ ]  GroupId가 com.founderz 인가요?

만약 본인이 레벨 2 모듈을 추가했다면 아래 과정을 따라야한다.

해당 모듈의 이웃하고 있는 상위 모듈 build.gradle에서 (상위: founderz-domain, 하위: user-domain)

```groovy
// founderz-domain/build.gradle
dependencies {
    api (project(":founderz-domain:user-domain"))
    // api (project(":parent-module:child-module"))
}
```

이렇게 api로 dependencies를 정의해준다.

> 왜?<br/>
> boot 모듈에서는 user-domain을 의존하는 게 아니라 founderz-domain과 같이 하나의 계층을 의존한다.<br/>
> 해당 의존성을 통해 내부 하위 모듈을 api처럼 노출하여 사용할 수 있게 지원해줘야한다.
    

## 패키지 구조 설정

`package com.founderz.auth.presentation;`

package com . founderz . 서브 도메인 . 계층 

## 계층별 의존 방향 관리

```kotlin
domain
^
application -> event
^
presentation
```

^ 는 의존 방향입니다. 절대로 반대가 되면 안됩니다. (유저 presentation이 유저 domain을 의존 불가능)

## SOLID 적용 기준

SRP: 책임을 command, query로 분리합니다.

OCP: 적용하지 않습니다.

LSP: 적용하지 않습니다.

ISP: 관심사를 command, query로 분리합니다.

DIP: 의존하는 대상이 스프링에 의해 빈으로 관리된다면, interface 또는 추상 클래스를 의존해야합니다. 

## 클래스 명명 표준

사용자에게 Http Body로 받는 요청 DTO는 ~~Form으로 작성

```java
record RegisterForm(String name, String password) {...}
```

## 계층별 의존도 관리 기준

presentation 계층에서 쓰인 RegisterForm가 application에서 쓰이면 안된다. (모든 계층에 포함되는 이야기)

- presentation 계층에서 form을 application DTO로 변경하거나 데이터를 파라미터로 넘겨야한다.

## 파라미터 표준

파라미터는 무조건 final 이여야합니다.

> 왜?<br/>
> 데이터를 항상 유효하게 유지해야하기 때문: 데이터 무결성
    

```java
// 올바르지 않는 코드
void method(String name, String password) {...}

// 올바른 코드
void method(final String name, final String password) {...}
```

## 올바른 접근 제어자 사용

일단 무조건 클래스, 메서드의 접근 제어자는 default (package-private)으로 두고, 필요할 때 수정한다.

## Assertion 방법

AssertionClass의 정적메서드를 사용해 필드에 대한 적절한 유효성 검사를 진행합니다.

> 왜?<br/>
> 데이터를 항상 유효하게 유지해야하기 때문: 데이터 무결성
    

```java
record User(String name, String password) {
    public User {
        assertArgumentNotEmpty(name, "이름 필드가 비어있습니다.");
        assertArgumentNotEmpty(password, "비밀번호 필드가 비어있습니다.");
    }
}
```

record 클래스의 경우 컴팩트 생성자를 통해 지정해줄 수 있습니다. 

> 컴팩트 생성자란?<br/>
> public User {…}<br/>
> 이런식으로 파라미터 없이 생성자를 작성하고, 유효성 검사를 할 때 주로 사용됩니다.<br/>
> 기존 클래스의 생성자처럼 `this.name = name` 을 할 필요 없이 자동으로 지정됩니다.

자주 사용되는 정규표현식 검사를 진행하려면, RegexUtils을 사용합니다.

## API 엔드포인트 경로 설계 표준

GET: **/api**/user**s**/123

외부에 db PK(long, AI)를 노출할 때는 common 모듈의 CryptoUtils 를 사용하자.

## 예외 처리 추가 방법

예외 처리는 static을 사용해 싱글톤으로 관리하지 않고 항상 new 키워드를 사용해 예외를 전파합니다.

## domain 계층 모듈에서 DB 사용 유무 관리

founderz-domain 계층에서 user-domain에 MongoDB를 추가하고 싶다면

```groovy
// founderz-domain/build.gradle
subprojects {
    val useMySQL: Boolean by extra(false)
    val useMongoDB: Boolean by extra(false)

    afterEvaluate {
        dependencies {
            implementation(project(":board-common"))

            if (useMySQL) {
                implementation("org.springframework.boot:spring-boot-starter-data-jpa")
                runtimeOnly("com.mysql:mysql-connector-j")
            }
            if (useMongoDB) {
		            // mongoDB 의존성 작성
            }
        }
    }
}
```

```groovy
// user-domain/build.gradle
extra["useMySQL"] = true
extra["useMongoDB"] = true
```

이렇게 의존성을 관리합니다.

---

## Spring Project Package Structure
```
Founderz
├─ build.gradle
founderz-application
│  ├─ agreement-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ agreement
│  │                    └─ application
│  │                       ├─ AgreementReadService.java
│  │                       ├─ AgreementWriteService.java
│  │                       └─ impl
│  │                          ├─ AgreementReadServiceImpl.java
│  │                          └─ AgreementWriteServiceImpl.java
│  ├─ auth-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ auth
│  │                    └─ application
│  │                       ├─ AuthReadService.java
│  │                       ├─ AuthWriteService.java
│  │                       ├─ dto
│  │                       │  └─ LoginDto.java
│  │                       └─ impl
│  │                          ├─ AuthReadServiceImpl.java
│  │                          └─ AuthWriteServiceImpl.java
│  ├─ build.gradle.kts
│  ├─ business-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ business
│  │                    └─ application
│  │                       ├─ BusinessReadService.java
│  │                       ├─ BusinessWriteService.java
│  │                       └─ impl
│  │                          ├─ BusinessReadServiceImpl.java
│  │                          └─ BusinessWriteServiceImpl.java
│  ├─ investment-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ investment
│  │                    └─ application
│  │                       ├─ InvestmentReadService.java
│  │                       ├─ InvestmentWriteService.java
│  │                       └─ impl
│  │                          ├─ InvestmentReadServiceImpl.java
│  │                          └─ InvestmentWriteServiceImpl.java
│  ├─ notice-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ notice
│  │                    └─ application
│  │                       ├─ NoticeReadService.java
│  │                       ├─ NoticeWriteService.java
│  │                       └─ impl
│  │                          ├─ NoticeReadServiceImpl.java
│  │                          └─ NoticeWriteServiceImpl.java
│  ├─ repayment-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ repayment
│  │                    └─ application
│  │                       ├─ RepaymentReadService.java
│  │                       ├─ RepaymentWriteService.java
│  │                       └─ impl
│  │                          ├─ RepaymentReadServiceImpl.java
│  │                          └─ RepaymentWriteServiceImpl.java
│  ├─ sector-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sector
│  │                    └─ application
│  │                       ├─ SectorReadService.java
│  │                       ├─ SectorWriteService.java
│  │                       └─ impl
│  │                          ├─ SectorReadServiceImpl.java
│  │                          └─ SectorWriteServiceImpl.java
│  ├─ sms-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sms
│  │                    └─ application
│  │                       ├─ SMSReadService.java
│  │                       └─ impl
│  │                          └─ SMSReadServiceImpl.java
│  ├─ tag-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ tag
│  │                    └─ application
│  │                       ├─ TagReadService.java
│  │                       ├─ TagWriteService.java
│  │                       └─ impl
│  │                          ├─ TagReadServiceImpl.java
│  │                          └─ TagWriteServiceImpl.java
│  ├─ user-application
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ user
│  │                    └─ application
│  │                       ├─ UserReadService.java
│  │                       └─ impl
│  │                          └─ UserReadServiceImpl.java
│  └─ userinterest-application
│     ├─ build.gradle.kts
│     └─ src
│        └─ main
│           └─ java
│              └─ com
│                 └─ founderz
│                    └─ userinterest
│                       └─ application
│                          ├─ UserInterestReadService.java
│                          ├─ UserInterestWriteService.java
│                          └─ impl
│                             ├─ UserInterestReadServiceImpl.java
│                             └─ UserInterestWriteServiceImpl.java
├─ founderz-boot
│  ├─ build.gradle.kts
│  └─ src
│     └─ main
│        ├─ java
│        │  └─ com
│        │     └─ founderz
│        │        └─ Application.java
│        └─ resources
│           └─ application.yml
├─ founderz-common
│  ├─ build.gradle.kts
│  └─ src
│     └─ main
│        └─ java
│           └─ com
│              └─ founderz
│                 ├─ common
│                 │  ├─ assertion
│                 │  │  ├─ AssertionUtils.java
│                 │  │  └─ RegexUtils.java
│                 │  ├─ crypto
│                 │  │  └─ CryptoUtils.java
│                 │  ├─ exception
│                 │  │  ├─ AccessDeniedException.java
│                 │  │  ├─ BadRequestException.java
│                 │  │  ├─ DataNotFoundException.java
│                 │  │  ├─ DuplicateException.java
│                 │  │  ├─ FounderzException.java
│                 │  │  ├─ ServerException.java
│                 │  │  └─ UnauthorizedException.java
│                 │  ├─ presentation
│                 │  │  └─ annotation
│                 │  │     └─ RequiredRoles.java
│                 │  ├─ response
│                 │  │  └─ ErrorResponse.java
│                 │  ├─ security
│                 │  │  └─ UserRole.java
│                 │  └─ vo
│                 │     ├─ ValueObject.java
│                 │     ├─ areement
│                 │     │  ├─ Address.java
│                 │     │  ├─ AgreementId.java
│                 │     │  ├─ DelinquentDamages.java
│                 │     │  ├─ DelinquentQuarter.java
│                 │     │  ├─ DepositDay.java
│                 │     │  ├─ FinallyContractPeriod.java
│                 │     │  ├─ Profit.java
│                 │     │  ├─ RepaymentDelayDay.java
│                 │     │  ├─ SecuredAgreementId.java
│                 │     │  ├─ SignatureImageUrl.java
│                 │     │  └─ SpecialContractMatters.java
│                 │     ├─ auth
│                 │     │  ├─ AccountIdentifier.java
│                 │     │  ├─ PasetoToken.java
│                 │     │  ├─ Password.java
│                 │     │  ├─ RegisterType.java
│                 │     │  └─ SecuredPassword.java
│                 │     ├─ business
│                 │     │  ├─ BusinessId.java
│                 │     │  ├─ BusinessIntroduction.java
│                 │     │  ├─ BusinessName.java
│                 │     │  ├─ InvestmentAmount.java
│                 │     │  ├─ OneLineIntroduction.java
│                 │     │  ├─ SecuredBusinessId.java
│                 │     │  ├─ Vision.java
│                 │     │  └─ WritePurpose.java
│                 │     ├─ investment
│                 │     │  ├─ Contact.java
│                 │     │  ├─ InvestmentId.java
│                 │     │  ├─ InvestmentStatus.java
│                 │     │  ├─ PreferContractPeriod.java
│                 │     │  └─ SecuredInvestmentId.java
│                 │     ├─ notice
│                 │     │  ├─ NoticeContent.java
│                 │     │  ├─ NoticeId.java
│                 │     │  ├─ NoticeType.java
│                 │     │  └─ SecuredNoticeId.java
│                 │     ├─ repayment
│                 │     │  ├─ RepaymentAmount.java
│                 │     │  ├─ RepaymentDate.java
│                 │     │  ├─ RepaymentId.java
│                 │     │  └─ SecuredRepaymentId.java
│                 │     ├─ tag
│                 │     │  ├─ SecuredTagId.java
│                 │     │  ├─ TagId.java
│                 │     │  └─ TagName.java
│                 │     └─ user
│                 │        ├─ AccountId.java
│                 │        ├─ AccountName.java
│                 │        ├─ AccountType.java
│                 │        ├─ MyMoney.java
│                 │        ├─ PhoneNumber.java
│                 │        ├─ SecuredUserId.java
│                 │        └─ UserId.java
│                 ├─ external
│                 │  └─ response
│                 │     ├─ ListResponse.java
│                 │     ├─ sector
│                 │     │  └─ SectorResponse.java
│                 │     └─ userintersest
│                 │        └─ InterestResponse.java
│                 └─ internal
│                    ├─ data
│                    │  ├─ agreement
│                    │  │  ├─ AgreementDto.java
│                    │  │  └─ AgreementWithRepaymentDto.java
│                    │  ├─ business
│                    │  │  └─ BusinessDto.java
│                    │  ├─ investment
│                    │  │  └─ InvestmentDto.java
│                    │  ├─ notice
│                    │  │  └─ NoticeDto.java
│                    │  ├─ repayment
│                    │  │  └─ RepaymentDto.java
│                    │  ├─ sector
│                    │  │  └─ SectorDto.java
│                    │  ├─ tag
│                    │  │  └─ TagDto.java
│                    │  ├─ user
│                    │  │  ├─ CurrentUserInfo.java
│                    │  │  ├─ UserDto.java
│                    │  │  └─ UserWithInterestsDto.java
│                    │  └─ userinterest
│                    │     ├─ UserInterestDto.java
│                    │     └─ UserInterestInfo.java
│                    ├─ event
│                    │  ├─ BusinessSectorAddEvent.java
│                    │  ├─ NoticeAddEvent.java
│                    │  └─ UserInterestAddEvent.java
│                    └─ function
│                       ├─ Interest
│                       │  └─ InterestReader.java
│                       ├─ business
│                       │  └─ BusinessReader.java
│                       ├─ repayment
│                       │  └─ RepaymentReader.java
│                       ├─ sector
│                       │  └─ SectorReader.java
│                       ├─ security
│                       │  ├─ CurrentUser.java
│                       │  └─ PasswordEncoder.java
│                       └─ tag
│                          └─ TagReader.java
├─ founderz-domain
│  ├─ agreement-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ agreement
│  │                    └─ domain
│  │                       ├─ AgreementDomainReader.java
│  │                       ├─ AgreementDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ AgreementDomainMapper.java
│  │                          ├─ AgreementEntity.java
│  │                          ├─ AgreementJpaRepository.java
│  │                          └─ AgreementRepository.java
│  ├─ build.gradle.kts
│  ├─ business-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ business
│  │                    └─ domain
│  │                       ├─ BusinessDomainReader.java
│  │                       ├─ BusinessDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ BusinessDomainMapper.java
│  │                          ├─ BusinessEntity.java
│  │                          ├─ BusinessJpaRepository.java
│  │                          └─ BusinessRepository.java
│  ├─ investment-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ investment
│  │                    └─ domain
│  │                       ├─ InvestmentDomainReader.java
│  │                       ├─ InvestmentDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ InvestmentDomainMapper.java
│  │                          ├─ InvestmentEntity.java
│  │                          ├─ InvestmentJpaRepository.java
│  │                          └─ InvestmentRepository.java
│  ├─ notice-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ notice
│  │                    └─ domain
│  │                       ├─ NoticeDomainReader.java
│  │                       ├─ NoticeDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ NoticeDomainMapper.java
│  │                          ├─ NoticeEntity.java
│  │                          ├─ NoticeJpaRepository.java
│  │                          └─ NoticeRepository.java
│  ├─ repayment-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ repayment
│  │                    └─ domain
│  │                       ├─ RepaymentDomainReader.java
│  │                       ├─ RepaymentDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ RepaymentDomainMapper.java
│  │                          ├─ RepaymentEntity.java
│  │                          ├─ RepaymentJpaRepository.java
│  │                          └─ RepaymentRepository.java
│  ├─ sector-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sector
│  │                    └─ domain
│  │                       ├─ SectorDomainReader.java
│  │                       ├─ SectorDomainWriter.java
│  │                       └─ presistence
│  │                          ├─ SectorDomainMapper.java
│  │                          ├─ SectorEntity.java
│  │                          ├─ SectorJpaRepository.java
│  │                          └─ SectorRepository.java
│  ├─ sms-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sms
│  │                    └─ domain
│  │                       └─ presistence
│  │                          ├─ SmsCertification.java
│  │                          ├─ SmsEntity.java
│  │                          └─ SmsRedisRepository.java
│  ├─ tag-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ tag
│  │                    └─ domain
│  │                       ├─ TagDomainReader.java
│  │                       ├─ TagDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ TagDomainMapper.java
│  │                          ├─ TagEntity.java
│  │                          ├─ TagJpaRepository.java
│  │                          └─ TagRepository.java
│  ├─ user-domain
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ user
│  │                    └─ domain
│  │                       ├─ UserDomainReader.java
│  │                       ├─ UserDomainWriter.java
│  │                       └─ persistence
│  │                          ├─ UserDomainMapper.java
│  │                          ├─ UserEntity.java
│  │                          ├─ UserJpaRepository.java
│  │                          └─ UserRepository.java
│  └─ userinterest-domain
│     ├─ build.gradle.kts
│     └─ src
│        └─ main
│           └─ java
│              └─ com
│                 └─ founderz
│                    └─ userinterest
│                       └─ domain
│                          ├─ UserInterestDomainReader.java
│                          ├─ UserInterestDomainWriter.java
│                          └─ persistence
│                             ├─ UserInterestDomainMapper.java
│                             ├─ UserInterestEntity.java
│                             ├─ UserInterestJpaRepository.java
│                             └─ UserInterestRepository.java
├─ founderz-event
│  ├─ build.gradle.kts
│  ├─ notice-event
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ notice
│  │                    └─ event
│  │                       └─ NoticeAddEventHandler.java
│  ├─ sector-event
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sector
│  │                    └─ event
│  │                       └─ SectorAddEventHandler.java
│  └─ userinterest-event
│     ├─ build.gradle.kts
│     └─ src
│        └─ main
│           └─ java
│              └─ com
│                 └─ founderz
│                    └─ userinterest
│                       └─ event
│                          └─ UserInterestAddAllEventHandler.java
├─ founderz-presentation
│  ├─ agreement-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ agreement
│  │                    └─ presentation
│  │                       ├─ AgreementReadAdapter.java
│  │                       ├─ AgreementWriteAdapter.java
│  │                       ├─ RepaymentFormMapper.java
│  │                       ├─ WriteAgreementFormMapper.java
│  │                       ├─ document
│  │                       │  ├─ AgreementReadDocumentation.java
│  │                       │  └─ AgreementWriteDocumentation.java
│  │                       ├─ form
│  │                       │  ├─ AgreementForm.java
│  │                       │  ├─ RepaymentForm.java
│  │                       │  └─ WriteAgreementForm.java
│  │                       └─ response
│  │                          └─ AgreementDetails.java
│  ├─ auth-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ auth
│  │                    └─ presentation
│  │                       ├─ AuthReadAdapter.java
│  │                       ├─ AuthWriteAdapter.java
│  │                       ├─ FormMapper.java
│  │                       ├─ document
│  │                       │  ├─ AuthReadDocumentation.java
│  │                       │  └─ AuthWriteDocumentation.java
│  │                       ├─ form
│  │                       │  ├─ LoginForm.java
│  │                       │  └─ RegisterForm.java
│  │                       └─ response
│  │                          └─ LoginResponse.java
│  ├─ build.gradle.kts
│  ├─ business-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ business
│  │                    └─ presentation
│  │                       ├─ BusinessReadAdapter.java
│  │                       ├─ BusinessWriteAdapter.java
│  │                       ├─ WriteBusinessFormMapper.java
│  │                       ├─ document
│  │                       │  ├─ BusinessReadDocumentation.java
│  │                       │  └─ BusinessWriteDocumentation.java
│  │                       ├─ form
│  │                       │  └─ WriteBusinessForm.java
│  │                       └─ response
│  │                          ├─ BusinessDetails.java
│  │                          └─ BusinessListResponse.java
│  ├─ common-presentation
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ common
│  │                    └─ presentation
│  │                       └─ annotation
│  │                          └─ WebRestAdapter.java
│  ├─ investment-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ investment
│  │                    └─ presentation
│  │                       ├─ InvestmentReadAdapter.java
│  │                       ├─ InvestmentWriteAdapter.java
│  │                       ├─ RequestInvestmentFormMapper.java
│  │                       ├─ document
│  │                       │  ├─ InvestmentReadDocumentation.java
│  │                       │  └─ InvestmentWriteDocumentation.java
│  │                       ├─ form
│  │                       │  └─ RequestInvestmentForm.java
│  │                       └─ response
│  │                          └─ InvestmentResponse.java
│  ├─ notice-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ notice
│  │                    └─ presentation
│  │                       ├─ NoticeReadAdapter.java
│  │                       ├─ NoticeResponseMapper.java
│  │                       ├─ document
│  │                       │  └─ NoticeReadDocumentation.java
│  │                       └─ response
│  │                          └─ NoticeResponse.java
│  ├─ sector-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ sector
│  │                    └─ presentation
│  │                       ├─ SectorFormMapper.java
│  │                       ├─ SectorReadAdapter.java
│  │                       ├─ SectorWriteAdapter.java
│  │                       ├─ document
│  │                       │  ├─ SectorReadDocumentation.java
│  │                       │  └─ SectorWriteDocumentation.java
│  │                       └─ form
│  │                          └─ SectorAddForm.java
│  ├─ src
│  │  └─ main
│  │     └─ java
│  │        └─ com
│  │           └─ founderz
│  │              ├─ presentation
│  │              │  ├─ HealthController.java
│  │              │  ├─ converter
│  │              │  │  ├─ PresentationConfiguration.java
│  │              │  │  └─ ToValueObjectConverterFactory.java
│  │              │  └─ exception
│  │              │     └─ ExceptionController.java
│  │              └─ swagger
│  │                 └─ SwaggerConfiguration.java
│  ├─ tag-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ tag
│  │                    └─ presentation
│  │                       ├─ TagFormMapper.java
│  │                       ├─ TagReadAdapter.java
│  │                       ├─ TagWriteAdapter.java
│  │                       ├─ document
│  │                       │  ├─ TagReadDocumentation.java
│  │                       │  └─ TagWriteDocumentation.java
│  │                       ├─ form
│  │                       │  └─ TagCreateForm.java
│  │                       └─ response
│  │                          └─ TagResponse.java
│  ├─ user-presentation
│  │  ├─ build.gradle.kts
│  │  └─ src
│  │     └─ main
│  │        └─ java
│  │           └─ com
│  │              └─ founderz
│  │                 └─ user
│  │                    └─ presentation
│  │                       ├─ UserReadAdapter.java
│  │                       ├─ UserWriteAdapter.java
│  │                       ├─ document
│  │                       │  └─ UserReadDocumentation.java
│  │                       └─ response
│  │                          └─ UserInfoResponse.java
│  └─ userinterest-presentation
│     ├─ build.gradle.kts
│     └─ src
│        └─ main
│           └─ java
│              └─ com
│                 └─ founderz
│                    └─ userinterest
│                       └─ presentation
│                          ├─ UserInterestFormMapper.java
│                          ├─ UserInterestReadAdapter.java
│                          ├─ UserInterestWriteAdapter.java
│                          ├─ document
│                          │  ├─ UserInterestReadDocumentation.java
│                          │  └─ UserInterestWriteDocumentation.java
│                          ├─ form
│                          │  └─ UserInterestAddForm.java
│                          └─ response
│                             └─ UserInterestResponse.java
├─ founderz-security
│  ├─ build.gradle.kts
│  └─ src
│     └─ main
│        ├─ java
│        │  └─ com
│        │     └─ founderz
│        │        └─ security
│        │           ├─ SecurityConfiguration.java
│        │           ├─ SecurityWebFilter.java
│        │           ├─ TokenHandler.java
│        │           ├─ TokenProperty.java
│        │           ├─ TokenUtils.java
│        │           ├─ Tokenizer.java
│        │           ├─ aspect
│        │           │  └─ RoleSecurityAspect.java
│        │           ├─ cors
│        │           │  ├─ CorsConfiguration.java
│        │           │  └─ CorsProperties.java
│        │           ├─ current
│        │           │  ├─ CurrentUserImpl.java
│        │           │  └─ CurrentUserMapper.java
│        │           ├─ entrypoint
│        │           │  └─ CustomAuthenticationEntryPoint.java
│        │           └─ password
│        │              ├─ PasswordEncoderConfiguration.java
│        │              └─ PasswordEncoderImpl.java
│        └─ resources
│           └─ application.yml
└─ settings.gradle

```
