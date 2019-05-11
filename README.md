# 엘라스틱 서치 공부

---

### 개발환경
 - spring boot 2.1.4
 - elasticsearch 6.5.0
 
### 기능
 - Rest API를 통해 Elasticsearch CRUD 가능.
 - Rest Docs로 

##### 도커로 엘라스틱 서치 설치하기
```bash
$ docker run -p 9200:9200 -p 9300:9300 -d -e "http.host=0.0.0.0" -e "xpack.security.enabled=false" -e "transport.host=0.0.0.0" --name es-spring-2 docker.elastic.co/elasticsearch/elasticsearch:6.5.0
```