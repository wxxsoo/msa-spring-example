# msa-spring-example
## 프로젝트 소개
Spring 기반 MSA 구축 기술 검토를 위한 예제 프로젝트입니다.
## 아키텍쳐
![image](https://user-images.githubusercontent.com/46879746/102590741-55f35200-4154-11eb-946e-76b9d0abe147.png)
## 필수 설치 사항
프로젝트를 구동하기 위해 로컬 환경에 다음 요소들의 설치가 필요합니다.
- Java 11
- Elasticsearch
- Kibana
## 기술 스택
다음의 기술들을 사용해 MSA를 구성했습니다.
- 마이크로 서비스 구성
	- Spring Boot
	- Spring Data Rest
- Api Gateway
	- Spring Cloud Gateway
- Service Discovery
	- Spring Cloud Netflix Eureka
- 로깅
	- Spring Cloud Sleuth  
	- Zipkin
	- Elasticsearch
	- Logstash
	- Kibana
- Configuration
	- Spring Cloud Config
	- Spring Cloud Bus
	- RabbitMQ
## 구성
- eureka
	- Spring Cloud Neflix 기반 Service Discovery위한 eureka server 어플리케이션
- gateway
	 - Spring Cloud Gateway기반 API Gateway 어플리케이션
- post
	 - 마이크로 서비스 1
- user
	 - 마이크로 서비스 2
- config
 	 - Configuration Server
	 - 각 어플리케이션(gateway, post, user)의 설정 정보 관리
- zipkin
	- zipkin.jar
 	- zipkin-startup.sh
		- Elasticsearch를 데이터 스토어로 지정해 zipkin.jar를 실행시키는 스크립트 수행
- server-configs
	- Git Repository 용 설정 파일 모음
- local-server-configs
	- Local 환경(피일 시스템) 용 설정 파일 모음
## 구동 순서
*[참고] mac os 로컬 환경 기준으로 실행했습니다.*

1. Elasticsearch, Kibana, RabbitMQ 실행
2. zipkin-startup.sh 실행
```bash
$ cd zipkin
$ ./zipkin-startup.sh
```
3. eureka, config, gateway, post, user 순서로 어플리케이션 각각 실행
