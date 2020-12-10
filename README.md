# msa-spring-example
## 프로젝트 소개
Spring 기반 MSA 구축 기술 검토를 위한 예제 프로젝트입니다.
## 아키텍쳐
![msa_arch_20201210 011](https://user-images.githubusercontent.com/46879746/101721530-851e1980-3aeb-11eb-998c-4df1e5d8596b.jpeg)
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
	- Spring Cloud Eureka
- 로그 트레이싱
	- Spring Cloud Sleuth  
	- Zipkin
	- Elasticsearch
	- Kibana
## 구성
- eureka
	- Spring Cloud Neflix 기반 Service Discovery위한 eureka server 어플리케이션
- gateway
	 - Spring Cloud Gateway기반 API Gateway 어플리케이션
	 - Eureka Client
	 - Zipkin Client(Slueth)
 - post
	 - 마이크로 서비스 1
	 - Eureka Client
	 - Zipkin Client(Slueth)
 - user
	 - 마이크로 서비스 2
	 - Eureka Client
	 - Zipkin Client(Slueth)
- 그 외
	 - zipkin-startup.sh
	 	- Elasticsearch를 데이터 스토어로 지정해 zipkin.jar를 실행시키는 스크립트 수행
## 구동 순서
*[참고] mac os 로컬 환경 기준으로 실행했습니다.*

1. Elasticsearch 실행
```bash 
$ elasticsearch
```
2. Kibana 실행
```bash 
$ kibana
```
3. zipkin-startup.sh
```bash 
$ zipkin-startup.sh
```
4. eureka, gateway, post, user 어플리케이션 각각 실행
