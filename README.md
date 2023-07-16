# five-star-backend
five star backend repo

## project
- team blogging service

## 기술 스택
- Java 11
- SpringBoot 2.7.13
- Gradle
- MySQL 8.0.33
- Spring data jpa
- Swagger 3.0

## Infra
- AWS EC2
- Docker
- GitHub Actions(CD)

## 프로젝트 설명

## Trouble Shooting
- EC2 인스턴스 MySQL Timezone utc 저장 이슈
  - application default system -> TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
